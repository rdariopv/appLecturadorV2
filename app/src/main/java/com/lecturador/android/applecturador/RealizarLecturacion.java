package com.lecturador.android.applecturador;

import android.Manifest;
import android.app.ProgressDialog;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothClass;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
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
import com.zebra.sdk.printer.SGD;
import com.zebra.sdk.printer.ZebraPrinter;
import com.zebra.sdk.printer.ZebraPrinterFactory;
import com.zebra.sdk.printer.ZebraPrinterLanguageUnknownException;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;


public class RealizarLecturacion extends AppCompatActivity {


    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_realizarlecturacion);
        inicializarVariables();

    }

    //@Override
    //public boolean onCreateOptionsMenu(Menu menu) {
    //    // Inflate the menu; this adds items to the action bar if it is present.
    //    getMenuInflater().inflate(R.menu.menu_realizarlecturacion, menu);
    //    return true;
    //}

    //@Override
    //public boolean onOptionsItemSelected(MenuItem item) {
    //    // Handle action bar item clicks here. The action bar will
    //    // automatically handle clicks on the Home/Up button, so long
    //    // as you specify a parent activity in AndroidManifest.xml.
    //    int id = item.getItemId();
    //    //noinspection SimplifiableIfStatement
    //    if (id == R.id.action_settings) {
    //        return true;
    //    }
    //    return super.onOptionsItemSelected(item);
    //}


    private TextView tvDescCodigo;
    private TextView tvNombreS;
    private TextView tvDescPeriodo;
    private EditText etLectura;
    private EditText etNombreSocioLect;
    private Button btnSendLecturacion;
    private BsHpw loitemLecturacion;
    private LtCnf config;
    private boolean reprint;
    private Switch swNmed;
    private TextView tvNume;


    private Spinner spObs;

    public void inicializarVariables() {
        tvDescCodigo = (TextView) findViewById(R.id.tvDescCodigo);
        tvNombreS = (TextView) findViewById(R.id.tvNombreS);
        tvDescPeriodo = (TextView) findViewById(R.id.tvDescPeriodo);
        etLectura = (EditText) findViewById(R.id.etLectura);
        tvNume = (TextView) findViewById(R.id.tvNume);

        btnSendLecturacion = (Button) findViewById(R.id.btnSendLecturacion);
        swNmed = (Switch) findViewById(R.id.swNmed);

        BsObw obw = new BsObw();
        LinkedList<BsObw> listObw = obw.listarBsObw();

        config = new LtCnf();
        config.obtenerCnf(1);

        AdpObw adpObw = new AdpObw(this, listObw);

        spObs = (Spinner) findViewById(R.id.spObs);
        spObs.setAdapter(adpObw);
        spObs.setSelection(0);


        // reprint = false;
        loitemLecturacion = (BsHpw) getIntent().getExtras().getSerializable("item");
        // if (getIntent().getExtras().containsKey("reprint")) {
        //     reprint = (boolean) getIntent().getExtras().getSerializable("reprint");
        // }
//
        // if (reprint) {
        //     etLectura.setText(loitemLecturacion.getLact() + "");
        // }

        tvDescCodigo.setText(loitemLecturacion.getCodf() + "");
        BsEnw enw = new BsEnw();
        enw.ObtenerBsEnw();
        tvDescPeriodo.setText(enw.getAnio() + " - " + enw.getDmes());

        if (loitemLecturacion.getNmed() == 0) {
            this.swNmed.setChecked(false);
        } else {
            this.swNmed.setChecked(true);
            this.tvNume.setText(loitemLecturacion.getNume().trim());
        }
        this.swNmed.setEnabled(false);

        //etLectura.setText(loitemLecturacion.getLact() + "");
        tvNombreS.setText(loitemLecturacion.getNomb());

        btnSendLecturacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registrarLecturacion();
            }
        });
    }

    private static final String[] REQUIRED_SDK_PERMISSIONS = new String[]{

            Manifest.permission.INTERNET,
            Manifest.permission.ACCESS_NETWORK_STATE,
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.ACCESS_COARSE_LOCATION,
            Manifest.permission.BLUETOOTH_ADMIN,
            Manifest.permission.BLUETOOTH,
            Manifest.permission.SYSTEM_ALERT_WINDOW,
            Manifest.permission.ACCESS_LOCATION_EXTRA_COMMANDS};
    public static final int REQUEST_CODE_ASK_PERMISSIONS = 1;

    public void configBlueTooth() {

        //----------------------------------------------------------------------------------------

        final List<String> missingPermissions = new ArrayList<>();
        for (final String permission : REQUIRED_SDK_PERMISSIONS) {
            final int result = ContextCompat.checkSelfPermission(this, permission);
            if (result != PackageManager.PERMISSION_GRANTED) {
                missingPermissions.add(permission);
            }
        }
        if (!missingPermissions.isEmpty()) {
// request all missing permissions
            final String[] permissions = missingPermissions
                    .toArray(new String[missingPermissions.size()]);
            ActivityCompat.requestPermissions(this, permissions, REQUEST_CODE_ASK_PERMISSIONS);
        } else {
            final int[] grantResults = new int[REQUIRED_SDK_PERMISSIONS.length];
            Arrays.fill(grantResults, PackageManager.PERMISSION_GRANTED);
            onRequestPermissionsResult(REQUEST_CODE_ASK_PERMISSIONS, REQUIRED_SDK_PERMISSIONS,
                    grantResults);
        }

        //----------------------------------------------------------------------------------------

    }

    private void registrarLecturacion() {

        int idMedidor = Integer.valueOf(tvDescCodigo.getText().toString());
        //  int idPeriodo = Integer.valueOf(tvDescCodigo.getText().toString());
        int nhpf = loitemLecturacion.getNhpf();

        BsObw obs = (BsObw) spObs.getAdapter().getItem(spObs.getSelectedItemPosition());
        int cobs = obs.getCodo();
        loitemLecturacion.setCobs(cobs);
        loitemLecturacion.guardarObservacion();

        if (cobs == 0) {
            int lectura;
            try {
                lectura = Integer.valueOf(etLectura.getText().toString());
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
                Toast.makeText(RealizarLecturacion.this, "Consumo Negativo, Digite Nuevamente la lectura", Toast.LENGTH_LONG).show();
            } else {
                loitemLecturacion.setLact(lectura);
                loitemLecturacion.setStat(-100);   // marcamos como lecturado
                loitemLecturacion.guardarLecturaActual();

                Double importeConsumo = calcularConsumo(nhpf);
                loitemLecturacion.setImco(importeConsumo);
                loitemLecturacion.guardarImporteConsumo();

                if (config.isCnfGpsA()) {
                    loitemLecturacion.setLati(MenuPrincipal.gps.Latitud + "");
                    loitemLecturacion.setLong(MenuPrincipal.gps.Longitud + "");
                    loitemLecturacion.registrarUbicacion();
                }

                //aqui calcular alcantarilla
                double imptAlct = calcularAlcantarilla(loitemLecturacion.getNhpf(), loitemLecturacion.getImco());

                recuperacionInversion(loitemLecturacion.getNhpf(), loitemLecturacion.getImco() + imptAlct);
                // calcula descuento de ley NHPC=7050
                Log.e("RealizarLecturacion", "inicia calcularDescuentoLey NHPF=" + loitemLecturacion.getNhpf());
                calcularDescuentoLey(loitemLecturacion.getNhpf());

                calcularTarifaDignidad(loitemLecturacion.getNhpf());

                calcularCovid(loitemLecturacion.getNhpf(),importeConsumo + imptAlct,loitemLecturacion);
                //calcular otros conceptos BSDpwStad=1
                Log.e("RealizarLecturacion", "inicia registrarOtrosConceptos NHPF=" + loitemLecturacion.getNhpf());
                registrarOtrosConceptos();

                //registrarTotal
                loitemLecturacion.registrarTotal(loitemLecturacion.getNhpf());

                escribirAviso();
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
                        Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();
                    }

                }
                Toast.makeText(getApplicationContext(), "Registro Satisfactorio", Toast.LENGTH_LONG).show();
            }
        } else {
            loitemLecturacion.setLact(0);
            loitemLecturacion.setStat(-100);  // marcamos como lecturado
            loitemLecturacion.guardarLecturaActual();
            escribirAviso();
        }


    }

    public double calcularCovid(int nhpf, double imptConsumoyAlcantarilla, BsHpw loitemLecturacion) {
        BsHpw hpw = new BsHpw();
        BsTaw taw = new BsTaw();
        hpw.obtenerBsHpw(nhpf);
        BsDpw dpw = new BsDpw();
        dpw.obtenerDpw(hpw.getNhpf(), 7101);
        double lfImporte = 0.0d;
        if (dpw.getNhpc() != 0) {
            List<BsTaw> listTaw = taw.obtenerTarifa(loitemLecturacion.getAnio(), loitemLecturacion.getMesf(), 7101, loitemLecturacion.getNcat());
            for (BsTaw tar:listTaw) {
                double val1 = tar.getVal1();
                int cmon = tar.getCmon();
                String fiva = tar.getFiva().trim();
                String vafa = tar.getVafa().trim();
                if (cmon == 2) {
                    val1 *= dpw.getTcam();
                }
                char lfiva = fiva.charAt(0);
                char lvafa = vafa.charAt(0);
                BsHpw hpw2 = hpw;
                if ('F' == lfiva && 'F' == lvafa) {
                    lfImporte = imptConsumoyAlcantarilla * (val1 / 100.0d);
                } else if ('F' == lfiva && 'V' == lvafa) {
                    lfImporte = val1;
                }
                hpw = hpw2;
            }

            double ldImpt =  new BigDecimal(lfImporte).setScale(2, RoundingMode.HALF_EVEN).doubleValue();
            lfImporte= ldImpt;
            dpw.setPuni(lfImporte);
            dpw.registrarPrecioUnitario();
            dpw.setImpt(lfImporte);
            dpw.registrarImporte();
        }
        return lfImporte;
    }

    public void escribirAviso() {
        StringBuilder sb = new StringBuilder();
        MyZebra myZebra = new MyZebra();
        sb.append(myZebra.printZPLHorizontalZQ520(loitemLecturacion));
        try {
            String url = Environment.getExternalStorageDirectory().getAbsolutePath();
            File myFile = new File(url + "/avsCobranza" + loitemLecturacion.getNhpf() + ".txt");
            myFile.createNewFile();
            FileOutputStream fOut = new FileOutputStream(myFile);
            OutputStreamWriter myOutWriter = new OutputStreamWriter(fOut);
            myOutWriter.append(sb.toString());
            myOutWriter.close();
            fOut.close();
        } catch (Exception e) {
            Log.e("ERRR", "Could not create file", e);
        }


    }

    public void dataTxt() {
        StringBuilder sb = new StringBuilder();

        try {
            SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
            String lsFtra =df.format(new Date());
            String url = Environment.getExternalStorageDirectory().getAbsolutePath();
            File myFile = new File(url + "/logAvsCobranza" + loitemLecturacion.getNhpf()+"_" +lsFtra+ ".txt");
            Gson gson = new Gson();
            String json = gson.toJson(loitemLecturacion);

            myFile.createNewFile();
            FileOutputStream fOut = new FileOutputStream(myFile);
            OutputStreamWriter myOutWriter = new OutputStreamWriter(fOut);
            myOutWriter.append(sb.toString());
            myOutWriter.close();
            fOut.close();
        } catch (Exception e) {
            Log.e("ERRR", "Could not create file", e);
        }


    }

    public void listarMedidores() {
        finish();
        Intent intent = new Intent(this, ListaMedidores.class);
        startActivity(intent);
    }

    public Double calcularConsumo(int nhpf) {
        BsHpw hpw = new BsHpw();
        hpw.obtenerBsHpw(nhpf);
        BsDpw dpw = new BsDpw();
        dpw.obtenerDpw(loitemLecturacion.getNhpf(), loitemLecturacion.getNhpc());

        double consumo = 0;
        if (loitemLecturacion.getNmed() == 0) {
            BsTaw taw = new BsTaw();
            taw = taw.obtenerTarifaDesde(loitemLecturacion.getAnio(), loitemLecturacion.getMesf(), loitemLecturacion.getNhpc(), loitemLecturacion.getNcat(), 0);
            consumo = taw.getHast();
        } else {
            consumo = loitemLecturacion.getLact() - loitemLecturacion.getLant();
        }

        if (consumo < 0) {
            Toast.makeText(RealizarLecturacion.this, "Consumo Negativo, Digite Nuevamente la lectura", Toast.LENGTH_LONG).show();
        }
        loitemLecturacion.setCons((int) consumo);
        loitemLecturacion.guardarConsumo();
        double importe = 0;
        //calcConsumo(consumo);

        if (consumo == 0) {
            //consumo = 1;
            dpw.setCant(1);
        } else {
            dpw.setCant(consumo);
        }
        dpw.registrarCantidad();

        // si no tiene medidor tomar el consumo= taw.hasta
        // si no tiene medidor lectura=0


        Double rango = 0.0;
        Double aux = 0.0;

        BsTaw taw = new BsTaw();
        aux = consumo;

        LinkedList<BsTaw> tarifas = taw.obtenerTarifa(loitemLecturacion.getAnio(), loitemLecturacion.getMesf(),
                loitemLecturacion.getNhpc(), loitemLecturacion.getNcat());
        for (BsTaw tar : tarifas) {
            int desde = tar.getDesd();
            int hasta = tar.getHast();

            //if (loitemLecturacion.getNmed() == 0) {
            //    consumo = hasta;
            //}

            double val1 = tar.getVal1();
            int cmon = tar.getCmon();
            double tcam = dpw.getTcam();
            String fiva = tar.getFiva().trim();
            String vafa = tar.getVafa().trim();

            //if (desde == 0) { // consumo minimo

            //    // aqui hay que meter

            //    if (consumo <= hasta) {
            //        rango = consumo;
            //        importe = importe + AnalisisImporte(rango, val1, cmon,
            //                tcam, fiva, vafa);

            //        double precioUnitario = importe / dpw.getCant();
            //        dpw.setPuni(precioUnitario);
            //        dpw.registrarPrecioUnitario();
            //        dpw.setImpt(importe);
            //        dpw.registrarImporte();

            //        return importe;
            //    } else {
            //        rango = hasta - desde + 0.0;
            //    }
            //} else {
            //    if (consumo >= hasta) {
            //        rango = hasta - desde + 1.0;
            //    } else {
            //        rango = aux;
            //    }
            //}

            if (desde != 0) {

                if (consumo >=  hasta) {
                    rango =  hasta - desde + 1.0;
                } else {
                    rango = aux;
                }
            } else if (consumo <=  hasta) {
                int i = hasta;

                importe = importe + AnalisisImporte(consumo, val1, cmon, tcam, fiva, vafa);
                dpw.setPuni(importe / dpw.getCant());
                dpw.registrarPrecioUnitario();
                dpw.setImpt(importe);
                dpw.registrarImporte();
                return importe;
            } else {
                rango = hasta - desde +0.0;
            }
            importe = importe  + AnalisisImporte(rango, val1, cmon, tcam, fiva, vafa);
            aux = aux - rango;
        }

        double precioUnitario = importe / dpw.getCant();
        dpw.setPuni(precioUnitario);
        dpw.registrarPrecioUnitario();
        dpw.setImpt(importe);
        dpw.registrarImporte();
        return importe;
    }

    public double calcConsumo(double consumo) {
        BsTaw taw = new BsTaw();
        LinkedList<BsTaw> tarifas = taw.obtenerTarifa(loitemLecturacion.getAnio(), loitemLecturacion.getMesf(),
                loitemLecturacion.getNhpc(), loitemLecturacion.getNcat());

        BsDpw dpw = new BsDpw();
        dpw.obtenerDpw(loitemLecturacion.getNhpf(), loitemLecturacion.getNhpc());

        Double rango = 0.0;
        Double liConAux = consumo;
        double importe = 0.0;
        for (BsTaw tar : tarifas) {
            int desde = tar.getDesd();
            int hasta = tar.getHast();
            double val1 = tar.getVal1();
            int cmon = tar.getCmon();
            double tcam = dpw.getTcam();
            String fiva = tar.getFiva().trim();
            String vafa = tar.getVafa().trim();
            if (desde == 0) { // consumo minimo
                if (consumo < hasta) {
                    rango = consumo;
                    importe = importe + AnalisisImporte(rango, val1, cmon,
                            tcam, fiva, vafa);
                    return importe;
                } else {
                    rango = hasta - desde + 0.0;
                }
            } else {
                if (consumo >= hasta) {
                    rango = hasta - desde + 1.0;
                } else {
                    rango = liConAux;
                }
            }
            double aimpt = AnalisisImporte(rango, val1, cmon, tcam, fiva, vafa);
            importe = importe + aimpt;
            liConAux = liConAux - rango;
        }
        return importe;
    }
    public void calcularDescuentoLey(int nhpf) {
        BsHpw hpw = new BsHpw();
        hpw.obtenerBsHpw(nhpf);
        BsDpw dpw = new BsDpw();
        dpw.obtenerDpw(hpw.getNhpf(), 7050);

        double dctoLey = 0;
        if (dpw.getNhpc() != 0) {
            BsTaw taw = new BsTaw();
            BsTaw tarifa = taw.obtenerTarifaDesde(hpw.getAnio(), hpw.getMesf(), 7050, hpw.getNcat(), 0);

            if (tarifa.getNhpc() == 7050) {

                int liMinLey = tarifa.getHast();

                BsTaw tarifaMin = taw.obtenerTarifaDesde(hpw.getAnio(), hpw.getMesf(),
                        hpw.getNhpc(), hpw.getNcat(), 0);
                int liMinConsumo = tarifaMin.getHast();

                //'1.2. si el consumo enviado es menor al minimo consumido -> queda con el valor minimo
                if (hpw.getCons() <= liMinConsumo) {
                    liMinLey = liMinConsumo;
                } else {
                    // ' si es mayor analizamos y es menor al minimo descto ley le ponemos el consumo enviado
                    if (hpw.getCons() < liMinLey) {
                        liMinLey = loitemLecturacion.getCons();
                    }
                }

                double lfImpConMin = calcConsumo(liMinLey);
                double lfRecuInv = 0;//recuperacionInversionDeLey(nhpf, lfImpConMin); // para otras empresas
                double lfAlcan = calcularAlcantarillaDeLey(nhpf, lfImpConMin + lfRecuInv);  // para otras empresas

                LinkedList<BsTaw> listTarifas = taw.obtenerTarifa(hpw.getAnio(), hpw.getMesf(), 7050, hpw.getNcat());

                for (BsTaw tar : listTarifas) {
                    int desde = tar.getDesd();
                    int hasta = tar.getHast();
                    double val1 = tar.getVal1();
                    int cmon = tar.getCmon();
                    double tcam = dpw.getTcam();
                    String fiva = tar.getFiva().trim();
                    String vafa = tar.getVafa().trim();

                    if (liMinLey >= desde && liMinLey <= hasta) {

                        char lfiva = fiva.charAt(0);
                        char lvafa = vafa.charAt(0);
                        if ('V' == lvafa) { // NO interesa el consumo
                            if (cmon == 1) { // si es bolivianos
                                dctoLey = dctoLey + val1;
                            } else {  // es Dolares
                                dctoLey = dctoLey + (val1 * tcam);
                            }
                        } else {
                            dctoLey = dctoLey + (lfImpConMin + lfRecuInv + lfAlcan) * (val1 / 100);
                        }
                    }
                }

                dpw.setCant(1);
                dpw.registrarCantidad();

                double ldImpt =  new BigDecimal(dctoLey).setScale(2, RoundingMode.HALF_EVEN).doubleValue();
                double precioUnitario = ldImpt;
                dpw.setPuni(precioUnitario);
                dpw.registrarPrecioUnitario();

                double ldImpt1 =  new BigDecimal(dctoLey).setScale(2, RoundingMode.HALF_EVEN).doubleValue();
                 dctoLey= ldImpt1;
                dpw.setImpt(dctoLey);
                dpw.registrarImporte();
            }

        }
    }

    public void calcularTarifaDignidad(int nhpf ) {

        BsHpw hpw = new BsHpw();
        hpw.obtenerBsHpw(nhpf);
        BsDpw dpw = new BsDpw();
        dpw.obtenerDpw(hpw.getNhpf(), 7055);
        double lfImporte=0;

            double liCant = loitemLecturacion.getCons();
            double lfConsumo = loitemLecturacion.getImco();

            BsTaw taw = new BsTaw();
            LinkedList<BsTaw> listTarifas = taw.obtenerTarifa(loitemLecturacion.getAnio(), loitemLecturacion.getMesf(), 7055, loitemLecturacion.getNcat());
            for (BsTaw tar : listTarifas) {
                int desde = tar.getDesd();
                int hasta = tar.getHast();
                double val1 = tar.getVal1();
                double lfTcam = dpw.getTcam();
                int cmon = tar.getCmon();
                String vafa = tar.getVafa().trim();
                char lvafa = vafa.charAt(0);
                // cambio 12 oct 2023 licant por lfConsumo
                if (liCant >= desde && liCant <= hasta) {
                    if ('V' == lvafa) { // SI interesa el consumo
                        // ultimos cambios fecha 20sept2023
                         if (cmon == 1) {   //  '--- bolivianos
                              lfImporte =lfImporte+ val1;
                         }else{     //'--- Dolares
                             lfImporte =lfImporte+ val1 * lfTcam;
                         }
                    } else {
                        lfImporte = lfConsumo * val1 / 100;
                    }
                }
            }
            if(lfImporte!=0){
                lfImporte = new BigDecimal(lfImporte).setScale(2, RoundingMode.HALF_EVEN).doubleValue();
                dpw.setPuni(lfImporte);
                dpw.registrarPrecioUnitario();
                dpw.setImpt(lfImporte);
                dpw.registrarImporte();
            }
    }

    public double calcularAlcantarilla(int nhpf, double importeConsumo) {
        BsHpw hpw = new BsHpw();
        hpw.obtenerBsHpw(nhpf);
        BsDpw dpw = new BsDpw();
        dpw.obtenerDpw(hpw.getNhpf(), 7004);
        double lfImporte = 0;
        if (dpw.getNhpc() != 0) {
            double ldAlcantarilla = 0;

            BsTaw taw = new BsTaw();
            LinkedList<BsTaw> listTarifas = taw.obtenerTarifa(loitemLecturacion.getAnio(), loitemLecturacion.getMesf(), 7004, loitemLecturacion.getNcat());

            for (BsTaw tar : listTarifas) {
                int desde = tar.getDesd();
                int hasta = tar.getHast();
                double val1 = tar.getVal1();
                int cmon = tar.getCmon();

                String fiva = tar.getFiva().trim();
                String vafa = tar.getVafa().trim();

                if (cmon == 2) {  // en dolares convertir a bolivianos
                    val1 = val1 * dpw.getTcam();
                }

                char lfiva = fiva.charAt(0);
                char lvafa = vafa.charAt(0);
                if ('F' == lfiva && 'F' == lvafa) { // NO interesa el consumo
                    lfImporte = importeConsumo * (val1 / 100);
                } else if ('F' == lfiva && 'V' == lvafa) { // SI interesa el consumo
                    lfImporte = val1;
                }
            }

            // redondeados a 2 decimales
            double ldImpt =  new BigDecimal(lfImporte).setScale(2, RoundingMode.HALF_EVEN).doubleValue();
            lfImporte=ldImpt;
            dpw.setPuni(lfImporte);
            dpw.registrarPrecioUnitario();

            dpw.setImpt(lfImporte);
            dpw.registrarImporte();

        }


        return lfImporte;
    }

    public double calcularAlcantarillaDeLey(int nhpf, double importeConsumo) {
        BsHpw hpw = new BsHpw();
        hpw.obtenerBsHpw(nhpf);
        BsDpw dpw = new BsDpw();
        dpw.obtenerDpw(hpw.getNhpf(), 7004);
        double lfImporte = 0;
        if (dpw.getNhpc() != 0) {
            double ldAlcantarilla = 0;

            BsTaw taw = new BsTaw();
            LinkedList<BsTaw> listTarifas = taw.obtenerTarifa(loitemLecturacion.getAnio(), loitemLecturacion.getMesf(), 7004, loitemLecturacion.getNcat());

            for (BsTaw tar : listTarifas) {
                int desde = tar.getDesd();
                int hasta = tar.getHast();
                double val1 = tar.getVal1();
                int cmon = tar.getCmon();

                String fiva = tar.getFiva().trim();
                String vafa = tar.getVafa().trim();

                if (cmon == 2) {  // en dolares convertir a bolivianos
                    val1 = val1 * dpw.getTcam();
                }

                char lfiva = fiva.charAt(0);
                char lvafa = vafa.charAt(0);
                if ('F' == lfiva && 'F' == lvafa) { // NO interesa el consumo
                    lfImporte = importeConsumo * (val1 / 100);
                } else if ('F' == lfiva && 'V' == lvafa) { // SI interesa el consumo
                    lfImporte = val1;
                }
            }
        }


        return lfImporte;
    }

    public double recuperacionInversion(int nhpf, double importeConsumo) {

        BsHpw hpw = new BsHpw();
        hpw.obtenerBsHpw(nhpf);
        BsDpw dpw = new BsDpw();
        dpw.obtenerDpw(hpw.getNhpf(), 7080);
        if (dpw.getNhpc() != 0) {
            BsTaw taw = new BsTaw();
            LinkedList<BsTaw> listTarifas = taw.obtenerTarifa(loitemLecturacion.getAnio(), loitemLecturacion.getMesf(), 7080, loitemLecturacion.getNcat());

            double lfImporte = 0;

            for (BsTaw tar : listTarifas) {
                int desde = tar.getDesd();
                int hasta = tar.getHast();
                double val1 = tar.getVal1();
                int cmon = tar.getCmon();

                String fiva = tar.getFiva().trim();
                String vafa = tar.getVafa().trim();

                if (cmon == 2) {  // en dolares convertir a bolivianos
                    val1 = val1 * dpw.getTcam();
                }

                char lfiva = fiva.charAt(0);
                char lvafa = vafa.charAt(0);
                if ('F' == lfiva && 'F' == lvafa) { // NO interesa el consumo
                    lfImporte = importeConsumo * (val1 / 100);
                }

                if ('F' == lfiva && 'V' == lvafa) { // SI interesa el consumo
                    lfImporte = val1;
                }
                if ('V' == lfiva && 'V' == lvafa) { // SI interesa el consumo
                    lfImporte = hpw.getCons() * val1;
                }
            }

            double ldImptMora =  new BigDecimal(lfImporte).setScale(2, RoundingMode.HALF_EVEN).doubleValue();
            lfImporte=ldImptMora;
            dpw.setPuni(lfImporte);
            dpw.registrarPrecioUnitario();

            dpw.setImpt(lfImporte);
            dpw.registrarImporte();

        }

        return 0;
    }

    public double recuperacionInversionDeLey(int nhpf, double importeConsumo) {

        BsHpw hpw = new BsHpw();
        hpw.obtenerBsHpw(nhpf);
        BsDpw dpw = new BsDpw();
        dpw.obtenerDpw(hpw.getNhpf(), 7080);
        double lfImporte = 0;
        if (dpw.getNhpc() != 0) {
            BsTaw taw = new BsTaw();
            LinkedList<BsTaw> listTarifas = taw.obtenerTarifa(loitemLecturacion.getAnio(), loitemLecturacion.getMesf(), 7080, loitemLecturacion.getNcat());

            for (BsTaw tar : listTarifas) {
                int desde = tar.getDesd();
                int hasta = tar.getHast();
                double val1 = tar.getVal1();
                int cmon = tar.getCmon();

                String fiva = tar.getFiva().trim();
                String vafa = tar.getVafa().trim();

                if (cmon == 2) {  // en dolares convertir a bolivianos
                    val1 = val1 * dpw.getTcam();
                }

                char lfiva = fiva.charAt(0);
                char lvafa = vafa.charAt(0);
                if ('F' == lfiva && 'F' == lvafa) { // NO interesa el consumo
                    lfImporte = importeConsumo * (val1 / 100);
                }

                if ('F' == lfiva && 'V' == lvafa) { // SI interesa el consumo
                    lfImporte = val1;
                }
                if ('V' == lfiva && 'V' == lvafa) { // SI interesa el consumo
                    lfImporte = hpw.getCons() * val1;
                }
            }


        }

        return lfImporte;
    }

    public void registrarOtrosConceptos() {

        BsDpw detalle = new BsDpw();

        LinkedList<BsDpw> listDtl = detalle.obtenerOtrosDetalles(loitemLecturacion.getNhpf(), loitemLecturacion.getNcat());
        for (BsDpw dpw : listDtl) {

            dpw.setCant(1);
            dpw.registrarCantidad();

            double lfImporte = calcularOtrosImportes(dpw.getNhpc(), dpw.getTcam(), loitemLecturacion.getCons());
            dpw.setImpt(lfImporte);
            dpw.registrarImporte();

            double precioUnitario = lfImporte;
            dpw.setPuni(precioUnitario);
            dpw.registrarPrecioUnitario();
        }
    }

    public double calcularOtrosImportes(int liNhpc, double lfTcam, double lfConsumo) {

        BsTaw taw = new BsTaw();
        LinkedList<BsTaw> listTarifas = taw.obtenerTarifa(loitemLecturacion.getAnio(), loitemLecturacion.getMesf(), liNhpc, loitemLecturacion.getNcat());
        double lfImporte = 0;

        for (BsTaw tar : listTarifas) {
            int desde = tar.getDesd();
            int hasta = tar.getHast();
            double val1 = tar.getVal1();
            int cmon = tar.getCmon();
            String fiva = tar.getFiva().trim();
            String vafa = tar.getVafa().trim();
            if (cmon == 2) {  // en dolares convertir a bolivianos
                val1 = val1 * lfTcam;
            }
            char lfiva = fiva.charAt(0);
            char lvafa = vafa.charAt(0);
            if ('F' == lfiva && 'V' == lvafa) { // No interesa el consumo
                lfImporte = val1;
            }
            if ('V' == lfiva && 'V' == lvafa) { // SI interesa el consumo
                //lfImporte = lfImporte * (val1 / 100);
                //lfImporte =  new BigDecimal(lfImporte).setScale(2, RoundingMode.HALF_EVEN).doubleValue();
                lfImporte = lfConsumo * val1;
            }
            if ('F' == lfiva && 'F' == lvafa) { // NO interesa el consumo
                lfImporte = lfConsumo * (val1 / 100);
            }
        }
        lfImporte =  new BigDecimal(lfImporte).setScale(2, RoundingMode.HALF_EVEN).doubleValue();
        return lfImporte;
    }

    public Double AnalisisImporte(Double consumo, Double valor, int cmon, Double tcam, String fiva, String vafa) {
        Double importe = -1.0;
        if (cmon == 2) {  // en dolares convertir a bolivianos
            valor = valor * tcam;
        }
        char lfiva = fiva.charAt(0);
        char lvafa = vafa.charAt(0);
        if ('F' == lfiva && 'V' == lvafa) { // NO interesa el consumo
            importe = valor;
        } else if ('V' == lfiva && 'V' == lvafa) { // SI interesa el consumo
            importe = consumo * valor;
        } else if (lfiva == 'F' && lvafa == 'F') {  //'--- No interesa el consumo interesa el Importe que viene
            importe = importe * (valor / 100);
            importe =  new BigDecimal(importe).setScale(2, RoundingMode.HALF_EVEN).doubleValue();
        }


        return importe;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.e("RealizarLecturacion", " se ejecuta onActivityResult  = ");
        if (requestCode == 1) {
            Log.e("RealizarLecturacion", " si el requestCode==1 ??   requestCode=" + requestCode);

            Log.e("RealizarLecturacion", " si el resultCode==RESULT_OK ??   resultCode=" + resultCode);
            if (resultCode == RESULT_OK) {
                String lsLectura = data.getStringExtra("ldLectura");
                Log.e("RealizarLecturacion", " onActivityResult  con el valor = " + lsLectura);
                if (lsLectura != "" && lsLectura != null) {
                    // int liLectuta= Integer.valueOf(lsLectura);
                    // this.loitemLecturacion.getMiLecturacion().setLectura(liLectuta);
                    // this.loitemLecturacion.getMiLecturacion().setIdtipo(125);
                    // this.etLectura.setText(lsLectura);
                }
            }
        } else {
            Log.e("RealizarLecturacion", " si el requestCode==1 ??   requestCode=" + requestCode);

        }
    }

    //region para IMPRESORA
    private BluetoothDeviceArrayAdapter adpPrinters;
    private String bluetoothAddress;
    // The request code used in ActivityCompat.requestPermissions()
// and returned in the Activity's onRequestPermissionsResult()


    private boolean isBluetoothPrinter(BluetoothDevice bluetoothDevice) {
        return bluetoothDevice.getBluetoothClass().getMajorDeviceClass() == BluetoothClass.Device.Major.IMAGING
                || bluetoothDevice.getBluetoothClass().getMajorDeviceClass() == BluetoothClass.Device.Major.UNCATEGORIZED;


    }

    private ArrayList<BluetoothDevice> getPairedPrinters() {
        BluetoothAdapter mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();

        Set<BluetoothDevice> pairedDevices = mBluetoothAdapter.getBondedDevices();
        ArrayList<BluetoothDevice> pairedDevicesList = new ArrayList<BluetoothDevice>();
        for (BluetoothDevice device : pairedDevices) {
            if (isBluetoothPrinter(device))
                pairedDevicesList.add(device);
        }
        return pairedDevicesList;
    }

    private void connectAndPrint(Connection conn) {
        try {
           // if(conn.isConnected()){
                conn.open();
                String printerName = SGD.GET("device.unique_id", conn);
                if (findPrinterStatus(conn)) {
                    byte[] configLabel = getConfigLabel(conn);
                    //connection.write(configLabel);
                    ByteArrayInputStream bis = new ByteArrayInputStream(configLabel);

                    conn.write(bis);
                    //ZebraPrinterFactory.getInstance(conn).printConfigurationLabel();
                    //   stopSearching(printerName);
                }
                // Thread.sleep(500);
                conn.close();
           // }
           // else{
           //     Snackbar.make(this.getWindow().getDecorView(),"No es posible conectarse con la impresora", Snackbar.LENGTH_LONG).show();
           // }


        } catch (Exception e) {
            displayToast("ERROR: Unable to connect to Printer");
            e.printStackTrace();
            //  stopSearching(null);
        }
    }

    private boolean findPrinterStatus(final Connection conn) {
        try {
            if (ZebraPrinterFactory.getInstance(conn).getCurrentStatus().isHeadOpen) {
                displayToast("ERROR: Printer Head is Open");
                return false;
            } else if (ZebraPrinterFactory.getInstance(conn).getCurrentStatus().isPaperOut) {
                displayToast("ERROR: No Media Detected");
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true; // Returns if neither of the above error states is found
    }


    public void displayToast(final String message) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                Toast toast;
                toast = Toast.makeText(RealizarLecturacion.this, message, Toast.LENGTH_LONG);
                toast.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.CENTER_VERTICAL, 0, 0);
                toast.show();
            }
        }).start();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.

    }

    @Override
    public void onStop() {
        super.onStop();

    }

    public class enviarImprimir extends AsyncTask<String, Integer, Boolean> {
        ProgressDialog pd = new ProgressDialog(RealizarLecturacion.this);
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

    ZebraPrinter printer = null;

    private byte[] getConfigLabel(Connection conn) {
        byte[] configLabel = null;
        try {
            try {
                printer = ZebraPrinterFactory.getInstance(conn);
            } catch (ZebraPrinterLanguageUnknownException e) {
                Log.e(this.getClass().getName(), "error al obtener la instancia de la impresora e= " + e.getMessage());
                Toast.makeText(this, "al crear el printer = ZebraPrinterFactory.getInstance(conn); sucede un ERROR " + e.toString(), Toast.LENGTH_SHORT).show();
            }

            PrinterLanguage printerLanguage = printer.getPrinterControlLanguage();
            SGD.SET("device.languages", "zpl", conn);

            LtCnf cnf= new LtCnf();
          boolean existe=  cnf.obtenerCnf(1);
            if(existe){
                if (printerLanguage == PrinterLanguage.ZPL) {
                    // configLabel = "^XA^FO17,16^GB379,371,8^FS^FT65,255^A0N,135,134^FDZPL NO PROGRAMADO^FS^XZ".getBytes();
                    // configLabel = etToPrint.getText().toString().getBytes();

                    if (cnf.getCnfNpri() == 1) {
                        MyZebra myZebra = new MyZebra();
                        StringBuilder sb = myZebra.printZPLVertical1(loitemLecturacion);
                        configLabel = sb.toString().getBytes();
                    }
                    if (cnf.getCnfNpri() == 2) {
                        MyZebra myZebra = new MyZebra();
                        StringBuilder sb = myZebra.printZPLHorizontalZQ520(loitemLecturacion);
                        configLabel = sb.toString().getBytes();
                    }
                    if (cnf.getCnfNpri() == 3) {
                        MyZebra myZebra = new MyZebra();
                        StringBuilder sb = myZebra.printZPLVertical2(loitemLecturacion);
                        configLabel = sb.toString().getBytes();
                    }

                    if (cnf.getCnfNpri() == 4) {
                        MyZebra myZebra = new MyZebra();
                        StringBuilder sb = myZebra.printZPLHorizontalZQ320(loitemLecturacion) ;
                        configLabel = sb.toString().getBytes();
                    }
                    //  StringBuilder sb = myZebra.printZPL(loitemLecturacion);


                } else if (printerLanguage == PrinterLanguage.CPCL) {
                    //  String cpclConfigLabel = "! 0 200 200 406 1\r\n" + "ON-FEED IGNORE\r\n" + "BOX 20 20 380 380 8\r\n" + "T 0 6 137 177 " + etToPrint.getText().toString() + "\r\n" + "PRINT\r\n";
                    if(cnf.getCnfNpri()==0){
                        MyZebra myZebra = new MyZebra();
                        StringBuilder sb = myZebra.imprimirLaPortenha(loitemLecturacion);
                        configLabel = sb.toString().getBytes();
                    }

                }
            }

        } catch (ConnectionException e) {
            Toast.makeText(this, "aqui sucede un error " + e.toString(), Toast.LENGTH_SHORT).show();
        }
        return configLabel;
    }


// endregion

    //region Sinronizacion en linea
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
    //endregion
}
