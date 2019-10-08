package co.example.prueba.consumo;

import java.util.List;

import co.example.prueba.modelo.Ficha;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface PostServicePrestamos {

        String API_ROUTE = "webresources/siess1.jpa.entidades.prestamo";

        @GET(API_ROUTE)
        Call<List<PojoPrestamo>> getPost();

    @POST("webresources/siess1.jpa.entidades.prestamo")
    Call<PojoPrestamo> crearPrestamo(PojoPrestamo prestamo);

}

