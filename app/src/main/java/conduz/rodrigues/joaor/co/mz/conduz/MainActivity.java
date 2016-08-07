package conduz.rodrigues.joaor.co.mz.conduz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import conduz.rodrigues.joaor.co.mz.conduz.activity.HomeActivity;
import conduz.rodrigues.joaor.co.mz.conduz.activity.LoginActivity;

public class MainActivity extends AppCompatActivity {


    private View.OnClickListener buttonEntrarListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            entrar();
        }
    };

    private View.OnClickListener buttonIniciarListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            iniciar();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        Button buttonEntrar = (Button) findViewById(R.id.bt_tenho_conta);
        Button buttonIniciar = (Button) findViewById(R.id.bt_iniciar);

        buttonEntrar.setOnClickListener(buttonEntrarListener);
        buttonIniciar.setOnClickListener(buttonIniciarListener);
    }

    private void entrar (){
        Intent intent = new Intent(this,LoginActivity.class);
        startActivity(intent);
    }

    private void iniciar (){
        Intent intent = new Intent(this,HomeActivity.class);
        startActivity(intent);
    }
}
