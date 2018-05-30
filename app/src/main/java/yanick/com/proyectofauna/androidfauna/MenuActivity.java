package yanick.com.proyectofauna.androidfauna;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);


        CardView BOTONCONSULTAR = (CardView) findViewById(R.id.btnconsultar);
        CardView BOTONCAPTURAR = (CardView) findViewById(R.id.btncapturar);



        BOTONCONSULTAR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Listar = new Intent(MenuActivity.this,ConsultarActivity.class);
                startActivity(Listar);
            }
        });

        BOTONCAPTURAR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Buscar = new Intent(MenuActivity.this, CapturarActivity.class);
                startActivity(Buscar);
            }
        });






    }
}
