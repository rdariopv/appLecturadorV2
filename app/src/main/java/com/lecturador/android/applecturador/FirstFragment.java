package com.lecturador.android.applecturador;

import android.app.ProgressDialog;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.navigation.fragment.NavHostFragment;

import com.lecturador.android.applecturador.databinding.FragmentFirstBinding;
import com.lecturador.android.comunicacion.SyncBsDpw;
import com.lecturador.android.comunicacion.SyncBsHpw;
import com.lecturador.android.dblecturador.BsDpw;
import com.lecturador.android.dblecturador.BsEnw;
import com.lecturador.android.dblecturador.BsHpw;
import com.lecturador.android.dblecturador.BsObw;
import com.lecturador.android.dblecturador.BsTaw;
import com.lecturador.android.dblecturador.LtCnf;
import com.lecturador.android.zebra.BluetoothDeviceArrayAdapter;
import com.lecturador.android.zebra.MyZebra;
import com.zebra.sdk.comm.BluetoothConnection;
import com.zebra.sdk.comm.Connection;
import com.zebra.sdk.comm.ConnectionException;
import com.zebra.sdk.printer.PrinterLanguage;
import com.zebra.sdk.printer.PrinterStatus;
import com.zebra.sdk.printer.SGD;
import com.zebra.sdk.printer.ZebraPrinter;
import com.zebra.sdk.printer.ZebraPrinterFactory;
import com.zebra.sdk.printer.ZebraPrinterLanguageUnknownException;
import com.zebra.sdk.util.internal.SGDUtilities;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.Set;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;

    public FirstFragment() {
    }

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {

        binding = FragmentFirstBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        iniciarlizarVariables(view);
      //  binding.buttonFirst.setOnClickListener(new View.OnClickListener() {
      //      @Override
      //      public void onClick(View view) {
      // NavHostFragment.findNavController(FirstFragment.this)
      //                  .navigate(R.id.action_FirstFragment_to_SecondFragment);
      //      }
      //  });

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
    private BluetoothDeviceArrayAdapter adpPrinters;
    /* access modifiers changed from: private */
    public String bluetoothAddress;
    private Button btnSendPrint;
    private LtCnf config;
    private EditText etLecturaP;
    /* access modifiers changed from: private */
    public BsHpw loitemLecturacion;
    ZebraPrinter printer = null;
    private Spinner spObsP;
    private Switch swNmedP;
    private TextView tvDescCodigoP;
    private TextView tvDescPeriodoP;
    private TextView tvNombreSP;
    private TextView tvNumeP;



    public void iniciarlizarVariables(View view) {
        this.tvDescCodigoP = (TextView) view.findViewById(R.id.tvDescCodigoP);
        this.tvNombreSP = (TextView) view.findViewById(R.id.tvNombreSP);
        this.tvDescPeriodoP = (TextView) view.findViewById(R.id.tvDescPeriodoP);
        this.etLecturaP = (EditText) view.findViewById(R.id.etLecturaP);
        this.swNmedP = (Switch) view.findViewById(R.id.swNmedP);
        this.tvNumeP = (TextView) view.findViewById(R.id.tvNumeP);
        this.btnSendPrint = (Button) view.findViewById(R.id.btnSendPrint);
        this.loitemLecturacion = (BsHpw) getActivity().getIntent().getExtras().getSerializable("item");
        EditText editText = this.etLecturaP;
        editText.setText(this.loitemLecturacion.getLact() + "");
        LinkedList<BsObw> listObw = new BsObw().listarBsObw();
        this.config = new LtCnf();
        this.config.obtenerCnf(1);
        AdpObw adpObw = new AdpObw(getContext(), listObw);
        this.spObsP = (Spinner) view.findViewById(R.id.spObsP);
        this.spObsP.setAdapter(adpObw);
        this.spObsP.setSelection(adpObw.getIndexbyId(0));
        TextView textView = this.tvDescCodigoP;
        textView.setText(this.loitemLecturacion.getCodf() + "");
        BsEnw enw = new BsEnw();
        enw.ObtenerBsEnw();
        TextView textView2 = this.tvDescPeriodoP;
        textView2.setText(enw.getAnio() + " - " + enw.getDmes());
        if (this.loitemLecturacion.getNmed() == 0) {
            this.swNmedP.setChecked(false);
        } else {
            this.swNmedP.setChecked(true);
            this.tvNumeP.setText(this.loitemLecturacion.getNume().trim());
        }
        this.swNmedP.setEnabled(false);
        this.tvNombreSP.setText(this.loitemLecturacion.getNomb());
        this.btnSendPrint.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                registrarLecturacion();
            }
        });
    }


    private void registrarLecturacion() {

        int idMedidor = Integer.valueOf(tvDescCodigoP.getText().toString());
        //  int idPeriodo = Integer.valueOf(tvDescCodigo.getText().toString());
        int nhpf = loitemLecturacion.getNhpf();

        BsObw obs = (BsObw) spObsP.getAdapter().getItem(spObsP.getSelectedItemPosition());
        int cobs = obs.getCodo();
        loitemLecturacion.setCobs(cobs);
        loitemLecturacion.guardarObservacion();

        if (cobs == 0) {
            int lectura;
            try {
                lectura = Integer.valueOf(etLecturaP.getText().toString());
            } catch (Exception e) {
                lectura = 0;
            }
            double consumo = 0;
            if (loitemLecturacion.getNmed() == 0) {
                lectura = loitemLecturacion.getLant();
                BsTaw taw = new BsTaw();
                taw = taw.obtenerTarifaDesde(loitemLecturacion.getAnio(), loitemLecturacion.getMesf(), loitemLecturacion.getNhpc(), loitemLecturacion.getNcat(), 0);
                consumo = taw.getHast();

            } else {
                consumo = lectura - loitemLecturacion.getLant();
            }

            if (consumo < 0) {
                Toast.makeText(getContext(), "Consumo Negativo, Digite Nuevamente la lectura", Toast.LENGTH_LONG).show();
            } else {
                loitemLecturacion.setLact(lectura);
                loitemLecturacion.setStat(-100);   // marcamos como lecturado
                loitemLecturacion.guardarLecturaActual();

                Double importeConsumo = loitemLecturacion.calcularConsumo(nhpf,loitemLecturacion, getContext());
                loitemLecturacion.setImco(importeConsumo);
                loitemLecturacion.guardarImporteConsumo();

                if (config.isCnfGpsA()) {
                    loitemLecturacion.setLati(MenuPrincipal.gps.Latitud + "");
                    loitemLecturacion.setLong(MenuPrincipal.gps.Longitud + "");
                    loitemLecturacion.registrarUbicacion();
                }

                //aqui calcular alcantarilla
                double imptAlct = loitemLecturacion.calcularAlcantarilla(loitemLecturacion.getNhpf(), importeConsumo, loitemLecturacion);

                loitemLecturacion.recuperacionInversion(loitemLecturacion.getNhpf(), importeConsumo + imptAlct, loitemLecturacion);
                // calcula descuento de ley NHPC=7050
                Log.e("RealizarLecturacion", "inicia calcularDescuentoLey NHPF=" + loitemLecturacion.getNhpf());
                loitemLecturacion.calcularDescuentoLey(loitemLecturacion.getNhpf(),loitemLecturacion);

                loitemLecturacion.calcularCovid(loitemLecturacion.getNhpf(),importeConsumo + imptAlct,loitemLecturacion);
                //calcular otros conceptos BSDpwStad=1
                Log.e("RealizarLecturacion", "inicia registrarOtrosConceptos NHPF=" + loitemLecturacion.getNhpf());
                loitemLecturacion.registrarOtrosConceptos(loitemLecturacion);

                //registrarTotal
                loitemLecturacion.registrarTotal(loitemLecturacion.getNhpf());

               //escribirAviso();
                if (config.isCnfOnly()) {
                    try {
                        new sincronizarConsumo().execute();
                    } catch (Exception e) {
                    }

                }
                if (config.isPrintOnline()) {
                    try {
                        new enviarImprimir().execute();
                    } catch (Exception e) {
                        //Toast.makeText(getApplicationContext(),"Verifique la impresora o dispositivos vinculados", Toast.LENGTH_LONG).show();
                        Toast.makeText(getActivity().getWindow().getContext(), e.getMessage(), Toast.LENGTH_LONG).show();
                    }

                }
                Toast.makeText(getActivity().getWindow().getContext(), "Registro Satisfactorio", Toast.LENGTH_LONG).show();
            }
        } else {
            loitemLecturacion.setLact(0);
            loitemLecturacion.setStat(-100);  // marcamos como lecturado
            loitemLecturacion.guardarLecturaActual();
           // escribirAviso();
        }


    }




    private boolean isBluetoothPrinter(BluetoothDevice bluetoothDevice) {
        return bluetoothDevice.getBluetoothClass().getMajorDeviceClass() == 1536 || bluetoothDevice.getBluetoothClass().getMajorDeviceClass() == 7936;
    }

    /* access modifiers changed from: private */
    public ArrayList<BluetoothDevice> getPairedPrinters() {
        Set<BluetoothDevice> pairedDevices = BluetoothAdapter.getDefaultAdapter().getBondedDevices();
        ArrayList<BluetoothDevice> pairedDevicesList = new ArrayList<>();
        for (BluetoothDevice device : pairedDevices) {
            if (isBluetoothPrinter(device)) {
                pairedDevicesList.add(device);
            }
        }
        return pairedDevicesList;
    }

    /* access modifiers changed from: private */
    public void connectAndPrint(Connection conn) {
        try {
            conn.open();
            String GET = SGD.GET("device.unique_id", conn);
            if (findPrinterStatus(conn)) {
                conn.write((InputStream) new ByteArrayInputStream(getConfigLabel(conn)));
            }
            conn.close();
        } catch (Exception e) {
            displayToast("ERROR: Unable to connect to Printer");
        }
    }

    private boolean findPrinterStatus(Connection conn) {
        try {
            PrinterStatus currentStatus = ZebraPrinterFactory.getInstance(conn).getCurrentStatus();
            Boolean b1 = Boolean.valueOf(currentStatus.isHeadOpen);
            boolean b2 = currentStatus.isPaperOut;
            if (!b1.booleanValue() && !b2) {
                return true;
            }
            return false;
        } catch (Exception e) {
            Log.e("Reimprimir", "findPrinterStatus:" + e.getMessage());
            e.printStackTrace();
            return true;
        }
    }

    public void displayToast(final String message) {
        new Thread(new Runnable() {
            public void run() {
                Toast toast = Toast.makeText(FirstFragment.this.getContext(), message, Toast.LENGTH_LONG);
                toast.setGravity(17, 0, 0);
                toast.show();
            }
        }).start();
    }

    public void onStart() {
        super.onStart();
    }

    public void onStop() {
        super.onStop();
    }


    public class enviarImprimir extends AsyncTask<String, Integer, Boolean> {
        ProgressDialog pd = new ProgressDialog(getActivity().getWindow().getContext());
        private ZebraPrinter printer;

        @Override
        protected void onPreExecute() {
            pd.setTitle("Imprimiendo");
            pd.setMessage("Enviando datos para imprimir");
            // pd.setProgress(0);
            pd.setIndeterminate(false);
            pd.show();
            // super.onPreExecute();
        }

        @Override
        protected Boolean doInBackground(String... strings) {

            bluetoothAddress = getPairedPrinters().get(0).getAddress();
            // BluetoothDevice bt= getPairedPrinters().get(0);
            try{
                BluetoothConnection conn = new BluetoothConnection(bluetoothAddress);
                connectAndPrint(conn);
            }catch (Exception e){
                pd.setMessage(e.getMessage());
            }

            return true;
        }

        @Override
        protected void onPostExecute(Boolean aBoolean) {
            pd.dismiss();
            // super.onPostExecute(aBoolean);
        }
    }

    private byte[] getConfigLabel(Connection conn) throws ConnectionException {
        byte[] configLabel = null;
        try {
            this.printer = ZebraPrinterFactory.getInstance(conn);
        } catch (ZebraPrinterLanguageUnknownException | ConnectionException e) {
            String name = getClass().getName();
            Log.e(name, "error al obtener la instancia de la impresora e= " + e.getMessage());
            Toast.makeText(getContext(), "al crear el printer = ZebraPrinterFactory.getInstance(conn); sucede un ERROR " + e.toString(),Toast.LENGTH_LONG ).show();
        }
        PrinterLanguage printerLanguage = this.printer.getPrinterControlLanguage();
        SGD.SET(SGDUtilities.DEVICE_LANGUAGES, "zpl", conn);
        LtCnf cnf = new LtCnf();
        if (!cnf.obtenerCnf(1)) {
            return null;
        }
        if (printerLanguage == PrinterLanguage.ZPL) {
            if (cnf.getCnfNpri() == 1) {
                configLabel = new MyZebra().printZPLVertical1(this.loitemLecturacion).toString().getBytes();
            }
            if (cnf.getCnfNpri() == 2) {
                configLabel = new MyZebra().printZPLHorizontalZQ520(this.loitemLecturacion).toString().getBytes();
            }
            if (cnf.getCnfNpri() == 3) {
                configLabel = new MyZebra().printZPLVertical2(this.loitemLecturacion).toString().getBytes();
            }
            if (cnf.getCnfNpri() == 4) {
                return new MyZebra().printZPLHorizontalZQ320(this.loitemLecturacion).toString().getBytes();
            }
            return configLabel;
        } else if (printerLanguage == PrinterLanguage.CPCL && cnf.getCnfNpri() == 0) {
            return new MyZebra().imprimirLaPortenha(this.loitemLecturacion).toString().getBytes();
        } else {
            return null;
        }
    }
    public class sincronizarConsumo extends AsyncTask<String, Integer, Boolean> {
        @Override
        protected void onPreExecute() {
            //        super.onPreExecute();
        }

        @Override
        protected Boolean doInBackground(String... strings) {
            SyncBsHpw shpw = new SyncBsHpw();
            int liNhpf = loitemLecturacion.getNhpf();
            int lact = loitemLecturacion.getLact();
            int cons = loitemLecturacion.getCons();
            Date fecha = new Date();
            int imco = (int) loitemLecturacion.getImco();
            int cobs = loitemLecturacion.getCobs();
            int stad = loitemLecturacion.getStad();
            String latitud= loitemLecturacion.getLati();
            String longitud= loitemLecturacion.getLong();
            BsDpw dpw = new BsDpw();
            dpw.obtenerDpw(loitemLecturacion.getNhpf(), loitemLecturacion.getNhpc());
            int nofn = 1;
            int result = shpw.SyncActualizarAvisoHead(liNhpf, lact, cons, fecha, imco, cobs, stad,latitud, longitud, nofn, "appMovil");
            if (result == 1) {
                SyncBsDpw sdpw = new SyncBsDpw();
                int result2 = sdpw.SyncActualizarAvisoDetalle(loitemLecturacion.getNhpf(), loitemLecturacion.getNhpc(),
                        (int) dpw.getCant(), dpw.getPuni(), (int) dpw.getImpt());
                if (result2 == 1) {
                    loitemLecturacion.actualizarEstado(3); // estado lecturado
                }
            }

            return null;
        }

        @Override
        protected void onPostExecute(Boolean aBoolean) {
//            super.onPostExecute(aBoolean);
        }

        @Override
        protected void onCancelled(Boolean aBoolean) {
            //          super.onCancelled(aBoolean);
        }

    }

}