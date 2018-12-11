package vendedorservice;

import com.example.vistavendedor.VendedorModel;

import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class VendedorService {

    private static final String BASE_URL = "https://api.mercadolibre.com/";
    private static VendedorService instance;
    private static VendedorAPI iItemMeliService;

    private VendedorService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        iItemMeliService = retrofit.create(VendedorAPI.class);
    }

    public static VendedorService getInstance(){
        if(instance == null){
            instance = new VendedorService();
        }

        return instance;
    }

    public void getItem(String query, Callback<VendedorModel> callback){
        iItemMeliService.getItem(query).enqueue(callback);
    }
}




