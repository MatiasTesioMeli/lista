package com.example.vistavendedor;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearSnapHelper;
import android.support.v7.widget.SnapHelper;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.mercadolibre.android.ui.widgets.MeliSnackbar;

public class VendedorActivity extends AppCompatActivity implements VendedorView{

    private final String SELLER_ID = "seller_id";
    private VendedorPresenter vendedorPresenter;
    private TextView nickname;
    private TextView country;
    private TextView completadas;
    private TextView canceladas;
    private TextView totales;
    private SimpleDraweeView city;
    private TextView state;
    private String stringUri;
    private Button permalink;
    private ImageView star1;
    private ImageView star2;
    private ImageView star3;
    private ImageView star4;
    private ImageView star5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vendedor);

        Intent intent = getIntent();
        Uri data = intent.getData();

        if(data != null) {
            stringUri = data.getLastPathSegment();
        }else{
            stringUri = "";
        }

        vendedorPresenter = new VendedorPresenter(this, new VendedorModel());

        nickname = findViewById(R.id.nickname);
        permalink = findViewById(R.id.permalink);
        country = findViewById(R.id.country);
        city = findViewById(R.id.city);
        state = findViewById(R.id.state);

        star1 = findViewById(R.id.star1);
        star2 = findViewById(R.id.star2);
        star3 = findViewById(R.id.star3);
        star4 = findViewById(R.id.star4);
        star5 = findViewById(R.id.star5);
        canceladas = findViewById(R.id.canceladas);
        completadas = findViewById(R.id.completadas);
        totales = findViewById(R.id.totales);

        if(!stringUri.isEmpty() && stringUri != null && stringUri!= ""){
            vendedorPresenter.onResume(stringUri);
        }
    }

    @Override
    protected void onDestroy() {
        vendedorPresenter.onDestroy();
        super.onDestroy();
    }

    public void showError(){
        //Toast.makeText(this, "Request on failure", Toast.LENGTH_LONG).show();
        MeliSnackbar.make(nickname, "Request on failure", 3000, MeliSnackbar.Type.ERROR)
                .show();
    }

    @Override
    public void setItems(VendedorModel vendedor) {
        nickname.setText(vendedor.getNickname());
        permalink.setOnClickListener(vendedorListener);
        country.setText(vendedor.getCountry());
        canceladas.setText(vendedor.getSellerReputation().getTransactions().getCancelled());
        completadas.setText(vendedor.getSellerReputation().getTransactions().getCompleted());
        totales.setText(vendedor.getSellerReputation().getTransactions().getTotal());
        if(vendedor.getStatus().getStatus().equals("active"))
            city.setImageURI("https://www.formacionmach.es/wp-content/uploads/2017/03/check-verde.png");
        else
            city.setImageURI("https://banner2.kisspng.com/20180330/lqe/kisspng-american-red-cross-international-red-cross-and-red-wrong-5abe45618fd573.4063686415224190415892.jpg");

        state.setText(vendedor.getAddress().getCity() + "-" + vendedor.getAddress().getState());

        if(vendedor.getSellerReputation().getLevel().startsWith("5")){
            star1.setImageDrawable(getResources().getDrawable(R.drawable.filledstar));
            star2.setImageDrawable(getResources().getDrawable(R.drawable.filledstar));
            star3.setImageDrawable(getResources().getDrawable(R.drawable.filledstar));
            star4.setImageDrawable(getResources().getDrawable(R.drawable.filledstar));
            star5.setImageDrawable(getResources().getDrawable(R.drawable.filledstar));
        }

        if(vendedor.getSellerReputation().getLevel().startsWith("4")){
            star1.setImageDrawable(getResources().getDrawable(R.drawable.filledstar));
            star2.setImageDrawable(getResources().getDrawable(R.drawable.filledstar));
            star3.setImageDrawable(getResources().getDrawable(R.drawable.filledstar));
            star4.setImageDrawable(getResources().getDrawable(R.drawable.filledstar));
        }

        if(vendedor.getSellerReputation().getLevel().startsWith("3")){
            star1.setImageDrawable(getResources().getDrawable(R.drawable.filledstar));
            star2.setImageDrawable(getResources().getDrawable(R.drawable.filledstar));
            star3.setImageDrawable(getResources().getDrawable(R.drawable.filledstar));
        }

        if(vendedor.getSellerReputation().getLevel().startsWith("2")){
            star1.setImageDrawable(getResources().getDrawable(R.drawable.filledstar));
            star2.setImageDrawable(getResources().getDrawable(R.drawable.filledstar));
        }

        if(vendedor.getSellerReputation().getLevel().startsWith("1")){
            star1.setImageDrawable(getResources().getDrawable(R.drawable.filledstar));
        }
    }

    private View.OnClickListener vendedorListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            vendedorPresenter.navigate("meli-vendedor");
        }
    };

    public void navigateToNextPage(String meliLink){
        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(meliLink));
        startActivity(i);
    }
}
