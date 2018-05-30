package yanick.com.proyectofauna.androidfauna;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

import yanick.com.proyectofauna.androidfauna.OpenHelper.OperecionesSQLite;
import yanick.com.proyectofauna.androidfauna.modelo.Animal;
import yanick.com.proyectofauna.androidfauna.modelo.Clase;
import yanick.com.proyectofauna.androidfauna.modelo.DAOs.DAOAnimal;
import yanick.com.proyectofauna.androidfauna.modelo.DAOs.DAOClase;
import yanick.com.proyectofauna.androidfauna.modelo.DAOs.DAOOrden;
import yanick.com.proyectofauna.androidfauna.modelo.Division;
import yanick.com.proyectofauna.androidfauna.modelo.Orden;
import yanick.com.proyectofauna.androidfauna.modelo.contract.ContractClase;
import yanick.com.proyectofauna.androidfauna.modelo.listas.ListaClase;
import yanick.com.proyectofauna.androidfauna.modelo.listas.ListaDivision;

public class CapturarActivity extends AppCompatActivity {


    private Spinner sp_Division;
    private Spinner sp_Clase ;
    private Spinner sp_Orden;

    private ArrayAdapter<Division> divisionArrayAdapter;
    private ArrayAdapter<Clase> claseArrayAdapter ;
    private ArrayAdapter<Orden> ordenArrayAdapter;



    private ListaDivision listaDivision;
    private ListaClase listaClase;



    private DAOClase daoClase;
    private DAOOrden daoOrden;
    private DAOAnimal daoAnimal;


    private Button btn_guardar;



    private EditText txt_nombre;
    private EditText txt_descrip;
    private EditText txt_longitud;
    private EditText txt_latitud;
    private EditText txt_pais;


    //h






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_capturar);

        cargarOBJvistas();

        btn_guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                obtenerDatos();

            }
        });


        listaClase = new ListaClase(this);
        listaDivision = new ListaDivision(this);


        daoClase = new DAOClase(this);
        daoOrden = new DAOOrden(this);
        daoAnimal = new DAOAnimal(this);



        divisionArrayAdapter = new ArrayAdapter<Division>(this,android.R.layout.simple_spinner_item,listaDivision.getListadivision());
        divisionArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_Division.setAdapter(divisionArrayAdapter);
        sp_Division.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {



                BuscarClase(((Division) adapterView.getItemAtPosition(i)).getId(),sp_Clase,claseArrayAdapter,daoClase);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });





    }



    public void cargarOBJvistas(){

        sp_Division = (Spinner) findViewById(R.id.spDiv);
        sp_Clase = (Spinner) findViewById(R.id.spClase);
        sp_Orden = (Spinner) findViewById(R.id.spOrden);



        btn_guardar = (Button) findViewById(R.id.btnAgregar);

        txt_nombre = (EditText) findViewById(R.id.edtAnimal);
        txt_descrip = (EditText) findViewById(R.id.edtDescrip);
        txt_latitud = (EditText) findViewById(R.id.edtLat);
        txt_longitud = (EditText) findViewById(R.id.edtLon);
        txt_pais = (EditText) findViewById(R.id.edtPais);


    }



    private void obtenerDatos() {

        Animal x = new Animal();

        x.setNombre(txt_nombre.getText().toString());
        x.setDescripcion(txt_descrip.getText().toString());
        x.setLongitud(txt_longitud.getText().toString());
        x.setLatitud(txt_latitud.getText().toString());
        x.setPais(txt_pais.getText().toString());

        x.setId_division(((Division) sp_Division.getSelectedItem()).getId());
        x.setId_clase(((Clase) sp_Clase.getSelectedItem()).getId());

        String msj = daoAnimal.insertar(ContractClase.Animal.TABLA, x);
        if(!msj.isEmpty()){
            Toast.makeText(getApplicationContext(),"Se INSERTO EL ANIMAL = " + daoAnimal.mostrarbyID(msj).getNombre(),Toast.LENGTH_LONG).show();
        }




    }


    public <T> void BuscarClase(String id, Spinner sp, ArrayAdapter<T> adapter, OperecionesSQLite<T> operaciones){


        //Toast.makeText(getApplicationContext(),daoClase.buscar(id_division).toString(),Toast.LENGTH_LONG).show();
       String xx =  operaciones.buscar(id).toString();

        //Log.i("DATOOO XXX", xx.equals("[]") ? "lol":"fuck");
        final boolean isVacio = xx.equals("[]") ? true:false;
        ArrayList<String> a = new ArrayList<>();
        String[] b = operaciones.getClass().getName().toString().split("\\.");
        a.addAll(Arrays.asList(b));

        final String _classNombre = a.get(a.size() -1);
        Log.i("CLASE NAME",a.get(a.size() -1) );








        if(isVacio){
            Log.i("DATOOO PUTO", daoClase.buscar(id).toString());
            sp.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, new String[]{"NO APLICA"}));
            sp.setEnabled(false);

        }else{

            adapter = new ArrayAdapter<T>(this,android.R.layout.simple_spinner_item,operaciones.buscar(id));
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

            sp.setAdapter(adapter);
            sp.setEnabled(true);

        }

        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(!isVacio){

                    switch (_classNombre){
                        case "DAOClase":
                            BuscarClase(((Clase) adapterView.getItemAtPosition(i)).getId(),sp_Orden,ordenArrayAdapter,daoOrden);
                    }

                    //BuscarClase(((T) adapterView.getItemAtPosition(i)).getId(),sp_Clase,claseArrayAdapter,daoClase);
                    //Toast.makeText(getApplicationContext(),"POS = "+((Clase) adapterView.getItemAtPosition(i)).get_id()+" ID SELECCIONADO = "+((Clase) adapterView.getItemAtPosition(i)).getId(),Toast.LENGTH_LONG).show();

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });




    }
}
