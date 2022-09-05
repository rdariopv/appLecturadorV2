package com.lecturador.android.applecturador;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
//import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
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
            //lanzarDialogBusquedaCliente();
            otroDialogo();
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

    public void otroDialogo() {
        View textEntryView = LayoutInflater.from(this).inflate(R.layout.dialog_search, (ViewGroup) null);
        final EditText etCodf = (EditText) textEntryView.findViewById(R.id.etCodf);
        final EditText etNcnt = (EditText) textEntryView.findViewById(R.id.etNcnt);
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle((CharSequence) "Buscar cliente:").setView(textEntryView).setPositiveButton((CharSequence) "Aceptar", (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                String Ncnt1 = etNcnt.getText().toString();
                String Codf1 = etCodf.getText().toString();
                int liNcnt = 0;
                int liCodf = 0;
                if (!Ncnt1.isEmpty()) {
                    liNcnt = Integer.valueOf(Ncnt1).intValue();
                } else if (!Codf1.isEmpty()) {
                    liCodf = Integer.valueOf(Codf1).intValue();
                }
                ListaMedidores.this.buscarOtroCliente(liNcnt, liCodf);
            }
        }).setNegativeButton((CharSequence) "Cancelar", (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                dialog.dismiss();
            }
        });
        alert.show();
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

    public void buscarOtroCliente(int liNcnt, int liCodf) {
        BsHpw itemLecturacion = new BsHpw();
        Intent intent = new Intent(this, EditarLectura.class);
      //  startActivity(intent);
      // return;

        boolean existe = false;
        if (liNcnt != 0) {
            existe = itemLecturacion.obtenerBsHpwByCodFijo(liNcnt);
        } else if (liCodf != 0) {
            existe = itemLecturacion.obtenerBsHpwByCodUbicacion(liCodf);
        }
        if (existe) {
            intent.putExtra("item", itemLecturacion);
            startActivity(intent);
            return;
        }
        Snackbar.make(findViewById(android.R.id.content), (CharSequence) "SOCIO NO ENCONTRADO.", 0).show();
    }

}
