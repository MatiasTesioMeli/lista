package com.example.mtesio.meliapp.Login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mtesio.meliapp.R;
import com.example.mtesio.meliapp.listadeitems.ListaDeItemsActivity;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class LoginActivity extends AppCompatActivity implements LoginView{

    private EditText username;
    private EditText password;
    private Button signIn;
    private LoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        signIn = findViewById(R.id.sign_in_button);

        signIn.setOnClickListener(buttonListener);

        loginPresenter = new LoginPresenter(this, new User());

    }

    @Override
    protected void onDestroy() {
        loginPresenter.onDestroy();
        super.onDestroy();
    }

    private View.OnClickListener buttonListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(!areFieldsEmpty()){
                loginPresenter.navigate();
            }

        }
    };

    public void navigateToNextPage(){
        startActivity(new Intent(this, ListaDeItemsActivity.class));
        finish();
    }

    public boolean areFieldsEmpty(){
        return username.getText().toString().isEmpty() && password.getText().toString().isEmpty();
    }

    public String getUsername(){
        return username.getText().toString();
    }

    public String getPassword(){
        return password.getText().toString();
    }


    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onPassUserDataEvent(User.LogAuthFinishedEvent event) {
        Toast.makeText(this, "Llego el bus event",
                Toast.LENGTH_LONG).show();
    };
}
