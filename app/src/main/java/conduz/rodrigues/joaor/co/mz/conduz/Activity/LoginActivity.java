package conduz.rodrigues.joaor.co.mz.conduz.activity;

import android.content.Intent;
import android.os.Bundle;;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import conduz.rodrigues.joaor.co.mz.conduz.R;

public class LoginActivity extends AppCompatActivity {

    private Button buttonEntrar;
    private Button buttonGoogle;
    private Button buttonFacebook;
    private EditText editTextUsername;
    private EditText editTextPassword;
    private TextView textViewForgotPassword;
    private TextView textViewNewAccount;

    private View.OnClickListener newAccountClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            newAccount();
        }
    };

    private View.OnClickListener buttonEntrarOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            entrar();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        init();
    }

    private void init(){
        textViewNewAccount = (TextView) findViewById(R.id.tv_new_account);
        textViewForgotPassword = (TextView) findViewById(R.id.tv_forgot_password);
        buttonEntrar = (Button) findViewById(R.id.bt_entrar);
        buttonFacebook = (Button) findViewById(R.id.facebook);
        buttonGoogle = (Button) findViewById(R.id.google);
        editTextPassword = (EditText) findViewById(R.id.et_password);
        editTextUsername = (EditText)findViewById(R.id.et_username);

        textViewNewAccount.setOnClickListener(newAccountClickListener);
        buttonEntrar.setOnClickListener(buttonEntrarOnClickListener);
    }

    private void newAccount (){
        Intent intent = new Intent(this,RegisterActivity.class);
        startActivity(intent);
    }

    private void entrar (){
        Intent intent = new Intent(this,HomeActivity.class);
        startActivity(intent);
    }

}
