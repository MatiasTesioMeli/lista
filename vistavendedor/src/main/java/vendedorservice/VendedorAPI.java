package vendedorservice;

import com.example.vistavendedor.VendedorModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface VendedorAPI {
    @GET("users/{id}")
    Call<VendedorModel> getItem(@Path("id") String id);
}
