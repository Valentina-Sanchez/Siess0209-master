package co.example.prueba.consumo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PostService {

    String API_ROUTE = "webresources/siess1.jpa.entidades.equipo/equipos";
    String API_ROUTE_EquiposDisp = "webresources/siess1.jpa.entidades.equipo/equiposDisponibles";

        @GET(API_ROUTE)
        Call<List<Post>> getPost();

        @GET(API_ROUTE_EquiposDisp)
        Call<List<Post>> getEquiposDis();

    }

