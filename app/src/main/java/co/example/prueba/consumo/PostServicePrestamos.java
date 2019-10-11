package co.example.prueba.consumo;

import java.util.List;

import co.example.prueba.pojos.PojoPrestamo;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface PostServicePrestamos {

        String API_ROUTE = "webresources/siess1.jpa.entidades.prestamo";

        @GET(API_ROUTE)
        Call<List<PojoPrestamo>> getPost();

    @POST(API_ROUTE)
    Call<PojoPrestamo> crearPrestamo(@Body PojoPrestamo prestamo);

}

