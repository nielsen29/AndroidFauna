package yanick.com.proyectofauna.androidfauna;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;

import yanick.com.proyectofauna.androidfauna.OpenHelper.DBhelper;
import yanick.com.proyectofauna.androidfauna.adapters.AdapterAnimal;
import yanick.com.proyectofauna.androidfauna.modelo.Animal;
import yanick.com.proyectofauna.androidfauna.modelo.DAOs.DAOAnimal;

public class ConsultarActivity extends AppCompatActivity {


    ArrayList<Animal> listaAnimal;
    RecyclerView recyclerViewAnimales;

    DBhelper conn;

    private DAOAnimal daoAnimal;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultar);

        daoAnimal = new DAOAnimal(getApplicationContext());


        //conn = new DBhelper(getApplicationContext(),"faunadb",null,1);

        listaAnimal = new ArrayList<>();
        Log.i("CACA", "SOY NUEVO");

       recyclerViewAnimales = (RecyclerView) findViewById(R.id.recyclerViewAnimal);
       recyclerViewAnimales.setLayoutManager(new LinearLayoutManager(this));
       recyclerViewAnimales.setAdapter(new AdapterAnimal(daoAnimal.mostrar()));




        //consultarListaAnimal();

    }

    private void consultarListaAnimal() {
        SQLiteDatabase db = conn.getReadableDatabase();

        Animal animal =null;

        //Cursor cursor = db.rawQuery("SELECT * FROM" );


    }
}
