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


    public void registrarLecturacion() {
        int lectura;
        int lectura2;
        double consumo;
        int i;
        int intValue = Integer.valueOf(this.tvDescCodigoP.getText().toString()).intValue();
        int nhpf = this.loitemLecturacion.getNhpf();
        int cobs = ((BsObw) this.spObsP.getAdapter().getItem(this.spObsP.getSelectedItemPosition())).getCodo();
        this.loitemLecturacion.setCobs(cobs);
        this.loitemLecturacion.guardarObservacion();
        if (cobs == 0) {
            try {
                lectura = Integer.valueOf(this.etLecturaP.getText().toString()).intValue();
            } catch (Exception e) {
                lectura = 0;
            }
            if (this.loitemLecturacion.getNmed() == 0) {
                int lectura3 = this.loitemLecturacion.getLant();
                consumo = (double) new BsTaw().obtenerTarifaDesde(this.loitemLecturacion.getAnio(), this.loitemLecturacion.getMesf(), this.loitemLecturacion.getNhpc(), this.loitemLecturacion.getNcat(), 0).getHast();
                lectura2 = lectura3;
            } else {
                consumo = (double) (lectura - this.loitemLecturacion.getLant());
                lectura2 = lectura;
            }
            if (consumo < 0.0d) {
                Toast.makeText(getContext(), "Consumo Negativo, Digite Nuevamente la lectura",Toast.LENGTH_LONG ).show();
                return;
            }
            this.loitemLecturacion.setLact(lectura2);
            this.loitemLecturacion.setStat(-100);
            this.loitemLecturacion.guardarLecturaActual();
            BsHpw bsHpw = this.loitemLecturacion;
            Double importeConsumo = bsHpw.calcularConsumo(nhpf, bsHpw, getContext());
            this.loitemLecturacion.setImco(importeConsumo.doubleValue());
            this.loitemLecturacion.guardarImporteConsumo();
            if (this.config.isCnfGpsA()) {
                BsHpw bsHpw2 = this.loitemLecturacion;
                bsHpw2.setLati(MenuPrincipal.gps.Latitud + "");
                BsHpw bsHpw3 = this.loitemLecturacion;
                bsHpw3.setLong(MenuPrincipal.gps.Longitud + "");
                this.loitemLecturacion.registrarUbicacion();
            }
            BsHpw bsHpw4 = this.loitemLecturacion;
            double imptAlct = bsHpw4.calcularAlcantarilla(bsHpw4.getNhpf(), importeConsumo.doubleValue(), this.loitemLecturacion);
            BsHpw bsHpw5 = this.loitemLecturacion;
            double d = consumo;
            bsHpw5.recuperacionInversion(bsHpw5.getNhpf(), importeConsumo.doubleValue() + imptAlct, this.loitemLecturacion);
            Log.e("RealizarLecturacion", "inicia calcularDescuentoLey NHPF=" + this.loitemLecturacion.getNhpf());
            BsHpw bsHpw6 = this.loitemLecturacion;
            double calcularDescuentoLey = bsHpw6.calcularDescuentoLey(bsHpw6.getNhpf(), this.loitemLecturacion);
            BsHpw bsHpw7 = this.loitemLecturacion;
            int i2 = lectura2;
            double calcularCovid = bsHpw7.calcularCovid(bsHpw7.getNhpf(), importeConsumo.doubleValue() + imptAlct, this.loitemLecturacion);
            Log.e("RealizarLecturacion", "inicia registrarOtrosConceptos NHPF=" + this.loitemLecturacion.getNhpf());
            BsHpw bsHpw8 = this.loitemLecturacion;
            bsHpw8.registrarOtrosConceptos(bsHpw8);
            BsHpw bsHpw9 = this.loitemLecturacion;
            bsHpw9.registrarTotal(bsHpw9.getNhpf());
         //   escribirAviso();
            if (this.config.isCnfOnly()) {
                try {
                    new sincronizarConsumo().execute(new String[0]);
                } catch (Exception e2) {
                }
            }
            if (this.config.isPrintOnline()) {
                try {
                    new enviarImprimir().execute(new String[0]);
                    i = 1;
                } catch (Exception e3) {
                    i = 1;
                    Toast.makeText(getContext(), e3.getMessage(), Toast.LENGTH_LONG).show();
                }
            } else {
                i = 1;
            }
            Toast.makeText(getContext(), "Registro Satisfactorio", Toast.LENGTH_LONG).show();
            return;
        }
        this.loitemLecturacion.setLact(0);
        this.loitemLecturacion.setStat(-100);
        this.loitemLecturacion.guardarLecturaActual();
        //escribirAviso();
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

        /* renamed from: pd */
        ProgressDialog f48pd = new ProgressDialog(getActivity().getWindow().getContext());
        private ZebraPrinter printer;

        public enviarImprimir() {
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            this.f48pd.setTitle("Imprimiendo");
            this.f48pd.setMessage("Enviando datos para imprimir");
            this.f48pd.setIndeterminate(false);
            this.f48pd.show();
        }

        /* access modifiers changed from: protected */
        public Boolean doInBackground(String... strings) {
            FirstFragment editarLectura = FirstFragment.this;
            String unused = editarLectura.bluetoothAddress = ((BluetoothDevice) editarLectura.getPairedPrinters().get(0)).getAddress();
            FirstFragment.this.connectAndPrint(new BluetoothConnection(FirstFragment.this.bluetoothAddress));
            return true;
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(Boolean aBoolean) {
            this.f48pd.dismiss();
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
        public sincronizarConsumo() {
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
        }

        /* access modifiers changed from: protected */
        public Boolean doInBackground(String... strings) {
            SyncBsHpw shpw = new SyncBsHpw();
            int liNhpf = FirstFragment.this.loitemLecturacion.getNhpf();
            int lact = FirstFragment.this.loitemLecturacion.getLact();
            int cons = FirstFragment.this.loitemLecturacion.getCons();
            Date fecha = new Date();
            int imco = (int) FirstFragment.this.loitemLecturacion.getImco();
            int cobs = FirstFragment.this.loitemLecturacion.getCobs();
            int stad = FirstFragment.this.loitemLecturacion.getStad();
            String latitud = FirstFragment.this.loitemLecturacion.getLati();
            String longitud = FirstFragment.this.loitemLecturacion.getLong();
            BsDpw dpw = new BsDpw();
            dpw.obtenerDpw(FirstFragment.this.loitemLecturacion.getNhpf(), FirstFragment.this.loitemLecturacion.getNhpc());
            BsDpw dpw2 = dpw;
            int i = imco;
            if (shpw.SyncActualizarAvisoHead(liNhpf, lact, cons, fecha, imco, cobs, stad, latitud, longitud, 1, "appMovil") != 1) {
                return null;
            }
            if (new SyncBsDpw().SyncActualizarAvisoDetalle(FirstFragment.this.loitemLecturacion.getNhpf(), FirstFragment.this.loitemLecturacion.getNhpc(), (int) dpw2.getCant(), dpw2.getPuni(), (double) ((int) dpw2.getImpt())) != 1) {
                return null;
            }
            FirstFragment.this.loitemLecturacion.actualizarEstado(3);
            return null;
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(Boolean aBoolean) {
        }

        /* access modifiers changed from: protected */
        public void onCancelled(Boolean aBoolean) {
        }
    }


}