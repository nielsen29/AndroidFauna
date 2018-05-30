package yanick.com.proyectofauna.androidfauna;

import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import yanick.com.proyectofauna.androidfauna.OpenHelper.SQLite_OpenHelper;

public class LoginActivity extends AppCompatActivity {

    TextView tvRegistrese;
    Button btnIngresar;

    SQLite_OpenHelper helper=new SQLite_OpenHelper(this,"TBREGISTROUSER",null,1);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        tvRegistrese=(TextView)findViewById(R.id.tvRegistrese);

        tvRegistrese.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), RegistroUserActivity.class);
                startActivity(i);
            }
        });

        btnIngresar=(Button)findViewById(R.id.btnIngresar);
        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText txtusu = (EditText) findViewById(R.id.txtUsuario);
                EditText txtpas = (EditText) findViewById(R.id.txtPassword);

                try {
                    Cursor cursor = helper.ConsultarUsuPas(txtusu.getText().toString(), txtpas.getText().toString());

                    if(cursor.getCount()>0){
                        Intent i = new Intent(getApplicationContext(), MenuActivity.class);
                        startActivity(i);
                    }else{
                        Toast.makeText(getApplicationContext(),"Usuario y/o Password Incorrectos.",Toast.LENGTH_LONG).show();
                        Intent i = new Intent(getApplicationContext(), MenuActivity.class);
                        startActivity(i);
                    }
                    txtusu.setText("");
                    txtpas.setText("");
                    txtusu.findFocus();

                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }
        });

    }
}