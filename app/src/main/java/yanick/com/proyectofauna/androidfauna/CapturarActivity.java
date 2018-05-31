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
import yanick.com.proyectofauna.androidfauna.modelo.DAOs.DAOEspecie;
import yanick.com.proyectofauna.androidfauna.modelo.DAOs.DAOFamilia;
import yanick.com.proyectofauna.androidfauna.modelo.DAOs.DAOGenero;
import yanick.com.proyectofauna.androidfauna.modelo.DAOs.DAOOrden;
import yanick.com.proyectofauna.androidfauna.modelo.Division;
import yanick.com.proyectofauna.androidfauna.modelo.Especie;
import yanick.com.proyectofauna.androidfauna.modelo.Familia;
import yanick.com.proyectofauna.androidfauna.modelo.Genero;
import yanick.com.proyectofauna.androidfauna.modelo.Orden;
import yanick.com.proyectofauna.androidfauna.modelo.contract.ContractClase;
import yanick.com.proyectofauna.androidfauna.modelo.listas.ListaClase;
import yanick.com.proyectofauna.androidfauna.modelo.listas.ListaDivision;

public class CapturarActivity extends AppCompatActivity {


    private Spinner sp_Division;
    private Spinner sp_Clase ;
    private Spinner sp_Orden;
    private Spinner sp_Familia;
    private Spinner sp_Genero;
    private Spinner sp_Especie;

    private ArrayAdapter<Division> divisionArrayAdapter;
    private ArrayAdapter<Clase> claseArrayAdapter ;
    private ArrayAdapter<Orden> ordenArrayAdapter;
    private ArrayAdapter<Familia> familiaArrayAdapter;
    private ArrayAdapter<Genero> generoArrayAdapter;
    private ArrayAdapter<Especie> especieArrayAdapter;



    private ListaDivision listaDivision;
    private ListaClase listaClase;



    private DAOClase daoClase;
    private DAOOrden daoOrden;
    private DAOFamilia daoFamilia;
    private DAOGenero daoGenero;
    private DAOEspecie daoEspecie;
    private DAOAnimal daoAnimal;



    private Button btn_guardar;



    private EditText txt_nombre;
    private EditText txt_descrip;
    private EditText txt_longitud;
    private EditText txt_latitud;
    private EditText txt_pais;


    //h


    private ArrayList<Animal> listaAnimales;





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

        listaAnimales = new ArrayList<>();


        daoClase = new DAOClase(this);
        daoOrden = new DAOOrden(this);
        daoFamilia = new DAOFamilia(this);
        daoGenero = new DAOGenero(this);
        daoEspecie = new DAOEspecie(this);
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

        listaAnimales.addAll(daoAnimal.mostrar());
        if(!listaAnimales.isEmpty()){
            Toast.makeText(getApplicationContext(), "CANTIDAD DE ANIMALES REGISTRADOS = "+String.valueOf(listaAnimales.size()),Toast.LENGTH_LONG).show();
        }





    }



    public void cargarOBJvistas(){

        sp_Division = (Spinner) findViewById(R.id.spDiv);
        sp_Clase = (Spinner) findViewById(R.id.spClase);
        sp_Orden = (Spinner) findViewById(R.id.spOrden);
        sp_Familia = (Spinner) findViewById(R.id.spFamilia);
        sp_Genero = (Spinner) findViewById(R.id.spGenero);
        sp_Especie = (Spinner) findViewById(R.id.spEspecie);



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
        x.setId_orden(((Orden)sp_Orden.getSelectedItem()).getId());
        x.setId_familia(((Familia)sp_Familia.getSelectedItem()).getId());
        x.setId_genero(((Genero)sp_Genero.getSelectedItem()).getId());
        x.setId_especie(((Especie)sp_Especie.getSelectedItem()).getId());


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
                            break;

                        case "DAOOrden":
                            BuscarClase(((Orden) adapterView.getItemAtPosition(i)).getId(),sp_Familia,familiaArrayAdapter,daoFamilia);
                            break;

                        case "DAOFamilia":
                            BuscarClase(((Familia) adapterView.getItemAtPosition(i)).getId(),sp_Genero,
                                    generoArrayAdapter,daoGenero);
                            break;

                        case "DAOGenero":
                            BuscarClase(((Genero) adapterView.getItemAtPosition(i)).getId(),sp_Especie,
                                    especieArrayAdapter,daoEspecie);
                            break;

                        default:
                            break;


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
