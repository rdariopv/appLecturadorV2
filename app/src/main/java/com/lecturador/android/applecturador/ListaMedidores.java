package com.lecturador.android.applecturador;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.design.widget.Snackbar;
//import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.InputType;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.lecturador.android.dblecturador.BsHpw;
import com.lecturador.android.dblecturador.LtCnf;
import com.lecturador.android.negocio.ItemLecturacion;


public class ListaMedidores extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listamedidores);

        inicializarVariables();
    }


   @Override
   public boolean onCreateOptionsMenu(Menu menu) {
       // Inflate the menu; this adds items to the action bar if it is present.
       getMenuInflater().inflate(R.menu.menu_listamedidores, menu);
       return true;
   }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.reimprimir) {
            lanzarDialogBusquedaCliente();
            //Toast.makeText(this,"En desarrollo",Toast.LENGTH_LONG ).show();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onPause() {
        this.adpListHpw.notifyDataSetChanged();
        super.onPause();
    }

    // private AdapterLecturaciones adapterLecturaciones;
    private AdpSocioMedidor adpListHpw;
    private ListView lvLecturaciones;

    public void inicializarVariables()
    {
        BsHpw hpw = new BsHpw();
       // this.adapterLecturaciones= new AdapterLecturaciones(this);
        this.adpListHpw= new AdpSocioMedidor(this,hpw.listarNoLecturadosBsHpw());
        lvLecturaciones= (ListView)findViewById(R.id.lvLecturaciones);
        lvLecturaciones.setAdapter(this.adpListHpw);

        lvLecturaciones.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int posicion, long idLecturacion) {
                Toast.makeText(getApplicationContext(),"se presiono el item con posc="+posicion+"  con id= "+idLecturacion+" ",Toast.LENGTH_LONG).show();
              //  ItemLecturacion item = adapterLecturaciones.getItem(posicion);
                BsHpw item = adpListHpw.getItem(posicion);
                lanzarRealizarLecturacion(item);
            }
        });
    }

    public void lanzarRealizarLecturacion(BsHpw itemLecturacion)
    {
       // finish();
        Intent intent= new Intent(this,RealizarLecturacion.class);
        intent.putExtra("item",   itemLecturacion);
        // intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
        startActivity(intent);
    }

    public void lanzarDialogBusquedaCliente() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(this.getWindow().getContext());

        LtCnf cnf= new LtCnf();
        cnf.obtenerCnf(1);
        final EditText etNroContrato = new EditText(this);
        etNroContrato.setInputType(InputType.TYPE_CLASS_NUMBER);
        builder.setView(etNroContrato);
        builder.setTitle("LECTURADOR");
        builder.setMessage("Digite Codigo de ubicacion" );
        builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
               String Ncnt1= etNroContrato.getText().toString();
                buscarCliente(Integer.valueOf(Ncnt1));
            }
        });
        builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });

        builder.create();
        builder.show();
    }

    public void buscarCliente(int NroContrato){
        Intent intent= new Intent(this,ReImprimir.class);
        BsHpw itemLecturacion= new BsHpw();
        boolean existe= itemLecturacion.obtenerBsHpwByNroContrato(NroContrato);
       if (existe) {
           intent.putExtra("item", itemLecturacion);
           startActivity(intent);
       }else{
           Snackbar.make(findViewById(android.R.id.content),"SOCIO NO ENCONTRADO.",Snackbar.LENGTH_LONG).show();
       }

    }

}
