package com.example.mtesio.meliapp.item;

import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mtesio.meliapp.R;
import com.facebook.drawee.view.SimpleDraweeView;
import com.rbrooks.indefinitepagerindicator.IndefinitePagerIndicator;

public class ItemActivity extends AppCompatActivity implements ItemView {

    private ItemPresenter itemPresenter;
    private final String ITEM_ID = "item_id";
    private final String MELI_LINK = "meli_link";
    private TextView titulo;
    private TextView cantidad;
    private SimpleDraweeView mercadopago;
    private TextView precio;
    private TextView descripcion;
    private Button comprar;
    private String id_item;
    private RecyclerView fotos;
    private IndefinitePagerIndicator indefinitePagerIndicator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);

        Intent in= getIntent();
        Bundle b = in.getExtras();

        if(b!=null) {
            id_item =(String) b.get(ITEM_ID);
        }

        fotos = findViewById(R.id.imagenes_item);
        titulo = findViewById(R.id.titulo_item);
        cantidad = findViewById(R.id.cantidad_item);
        mercadopago = findViewById(R.id.mercadopago_item);
        precio = findViewById(R.id.precio_item);
        descripcion = findViewById(R.id.descripcion_item);
        comprar = findViewById(R.id.comprar_item);
        indefinitePagerIndicator = findViewById(R.id.rec_indicator);

        comprar.setOnClickListener(comprarListener);

        itemPresenter = new ItemPresenter(this, new ItemModel());
    }

    @Override
    protected void onResume() {
        super.onResume();
        itemPresenter.onResume(id_item);
    }

    public void showError(String msj){
        Toast.makeText(this, msj,
                Toast.LENGTH_LONG).show();
    }

    @Override
    public void setItems(ItemModel item) {
        fotos.setAdapter(new CustomItemAdapter(item.getImages()));
        try{
            indefinitePagerIndicator.attachToRecyclerView(fotos);
        }catch (Exception e){

        }
        try {
            SnapHelper snapHelper = new LinearSnapHelper();
            snapHelper.attachToRecyclerView(fotos);
        } catch (IllegalStateException e) {
            // Do nothing
        }
        titulo.setText(item.getTitulo());
        cantidad.setText("Cantidad: " + item.getCantidadDisponible());
        precio.setText(item.getPrecio() + " " + item.getCurrency());
        descripcion.setText(item.getDescripcion());

        if(item.getMercadopago().equals("true"))
            mercadopago.setImageURI("https://site-images.similarcdn.com/url?url=https%3A%2F%2Flh3.googleusercontent.com%2FrEtHsU_Trf5BksFgHZqbwTf3poOhQXv55TZr5XWb316Q4lY2A5g1ypsU0OJ554jtCmc%3Ds180&h=66a2ce4574fc7ef5ef82b2fc51c39157a587a4e8099c0dca74b3df16106fe8c7");
        else
            mercadopago.setImageURI("https://upload.wikimedia.org/wikipedia/commons/thumb/a/ac/Old_Visa_Logo.svg/1048px-Old_Visa_Logo.svg.png");
    }

    public void navigateToNextPage(String meliLink){
        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(meliLink));
        startActivity(i);
    }

    private View.OnClickListener comprarListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
                itemPresenter.navigate();
        }
    };
}
