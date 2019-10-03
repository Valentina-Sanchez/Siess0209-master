package co.example.prueba.consumo;

import java.util.List;

import co.example.prueba.modelo.Ficha;
import retrofit2.Call;
import retrofit2.http.GET;

public interface PostServicePrestamos {

        String API_ROUTE = "webresources/siess1.jpa.entidades.prestamo";
        String API_ROUTE_FICHA = "webresources/siess1.jpa.entidades.ficha";

        @GET(API_ROUTE)
        Call<List<Prestamo>> getPost();

      /*  @GET(API_ROUTE_FICHA)
        Call<List<Ficha>> getPostFicha();*/

    }

