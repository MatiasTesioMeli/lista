package com.example.vistavendedor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class VendedorActivity extends AppCompatActivity implements VendedorView{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vendedor);
    }
}
