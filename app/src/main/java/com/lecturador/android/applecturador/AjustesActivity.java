package com.lecturador.android.applecturador;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

import com.lecturador.android.dblecturador.LtCnf;

public class AjustesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajustes);
        inicializarVariables();
    }

    // <editor-fold defaultstate="collapsed" desc="Codigo Adicionado">
    private EditText etUrlFU;
    private Button btnAceptarFU;
    private Switch swOnlineFU;
    private Switch swPrint;
    private Switch swGpsA;
    private Spinner spPrinter;
    public void inicializarVariables() {


        etUrlFU = (EditText) findViewById(R.id.etUrlFU);
        btnAceptarFU = (Button) findViewById(R.id.btnAceptarFU);
        swOnlineFU= (Switch) findViewById(R.id.swOnlineFU);
        swPrint= (Switch)findViewById(R.id.swPrint) ;
        swGpsA= (Switch)findViewById(R.id.swGpsA) ;
        spPrinter=(Spinner) findViewById(R.id.spPrinter);


        String[] test=new String[]{"Vertical1 HP ","Vertical2 HG", "Horizontal ZQ520","Vertical3 HG", "Horizontal HM ZQ320"};
        ArrayAdapter<String> adpPrinter= new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,test);
        spPrinter.setAdapter(adpPrinter);
        LtCnf cnf = new LtCnf();
        boolean existe = cnf.obtenerCnf(1);
        if (existe) {
            etUrlFU.setText(cnf.getCnfwUrl());
            swOnlineFU.setChecked(cnf.isCnfOnly());
            swPrint.setChecked(cnf.isPrintOnline());
            swGpsA.setChecked(cnf.isCnfGpsA());
            spPrinter.setSelection(cnf.getCnfNpri());


        }

       swGpsA.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
           @Override
           public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
               if(b){
                   //activar gps
                   MenuPrincipal.gps.verificarGpsActivo();
               }
           }
       });

        btnAceptarFU.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registrarCnf();
            }
        });

    }

    public void registrarCnf() {
        try {
            String url = etUrlFU.getText().toString();
            int online =  (swOnlineFU.isChecked()) ? 1 : 0;

            int printOnline =  (swPrint.isChecked()) ? 1 : 0;
            boolean GpsA = swGpsA.isChecked();

            if (url == "") {
                Toast.makeText(this, "Ingrese la URL del servicio WEB", Toast.LENGTH_SHORT).show();
            }

            int printer =spPrinter.getSelectedItemPosition();
            Log.e("AjustesACtivity","la impresora seleccionada es ="+printer);

            LtCnf cnf = new LtCnf();

            cnf.registrar(1, url,online,printOnline , GpsA, printer);
            Toast.makeText(this, "Se Registro AJUSTES Correctamente", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    // </editor-fold>
}
