package co.example.prueba.consumo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface PostService {

    String API_ROUTE = "webresources/siess1.jpa.entidades.equipo/equipos";
    String API_ROUTE_EquiposDisp = "webresources/siess1.jpa.entidades.equipo/equiposDisponibles";
    String API_ROUTE_USUARIOS = "webresources/siess1.jpa.entidades.usuario/usuarios/{non}/{con}";

        @GET(API_ROUTE)
        Call<List<Equipo>> getPost();

        @GET(API_ROUTE_EquiposDisp)
        Call<List<Equipo>> getEquiposDis();

        @GET(API_ROUTE_USUARIOS)
        Call<Usuario> getUsuarios(@Path("non") String groupId, @Path("con") String groupPass);
    }

