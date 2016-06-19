package conduz.rodrigues.joaor.co.mz.conduz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    private View.OnClickListener buttonEntrarListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            entrar();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        Button buttonEntrar = (Button) findViewById(R.id.bt_tenho_conta);

        buttonEntrar.setOnClickListener(buttonEntrarListener);
    }

    private void entrar (){
        Intent intent = new Intent(this,LoginActivity.class);
        startActivity(intent);
    }
}
