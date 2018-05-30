package yanick.com.proyectofauna.androidfauna;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import yanick.com.proyectofauna.androidfauna.OpenHelper.SQLite_OpenHelper;

public class RegistroUserActivity extends AppCompatActivity {

    Button btnGrabarUsu;
    EditText txtNomUsu, txtDisUsu, txtCorUsu, txtPasUsu;

    TextView tviniciarsesion;


    SQLite_OpenHelper helper=new SQLite_OpenHelper(this,"TBREGISTROUSER",null,1);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_user);

        btnGrabarUsu=(Button)findViewById(R.id.btnRegistrarUsu);
        txtNomUsu=(EditText)findViewById(R.id.txtNomUsu);
        txtDisUsu=(EditText)findViewById(R.id.txtDisUsu);
        txtCorUsu=(EditText)findViewById(R.id.txtCorUsu);
        txtPasUsu=(EditText)findViewById(R.id.txtPasUsu);


        btnGrabarUsu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                helper.abrir();
                helper.insertarReg(String.valueOf(txtNomUsu.getText()),
                        String.valueOf(txtDisUsu.getText()),
                        String.valueOf(txtCorUsu.getText()),
                        String.valueOf(txtPasUsu.getText()));
                helper.cerrar();

                Toast.makeText(getApplicationContext(), "Registro Almacenado con Exito"
                        ,Toast.LENGTH_LONG).show();

            }
        });




        tviniciarsesion=(TextView)findViewById(R.id.tviniciarsesion);

        tviniciarsesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(i);


            }
        });


    }




}
