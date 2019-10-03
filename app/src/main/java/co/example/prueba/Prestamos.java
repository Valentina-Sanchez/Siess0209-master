package co.example.prueba;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import co.example.prueba.consumo.Prestamo;
import co.example.prueba.consumo.PostServicePrestamos;
import co.example.prueba.modelo.Ficha;
import co.example.prueba.modelo.Municipio;
import co.example.prueba.modelo.Responsable;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Prestamos extends AppCompatActivity {

    ListView list;
    ArrayList <String> titles = new ArrayList<>();
    public static ArrayList<Prestamo> prestamos = new ArrayList<>();
    ArrayList<Ficha> fichas = new ArrayList<>();
    ArrayList<Municipio> municipios = new ArrayList<>();
    ArrayList<Responsable> responsables = new ArrayList<>();
    ArrayAdapter arrayAdapter;

    List<Ficha> fichasList = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prestamos);

        arrayAdapter = new ArrayAdapter(Prestamos.this,android.R.layout.simple_list_item_1,titles);
        list = findViewById(R.id.listaPrestamo);

        list.setAdapter(arrayAdapter);


        getPosts();

        //getPostsFicha();



        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(Prestamos.this, DetallePrestamo.class);
                intent.putExtra("codigo", prestamos.get(i).getCodigo());
                intent.putExtra("fechaSol", prestamos.get(i).getFechasolicitud());
                intent.putExtra("fechaSal", prestamos.get(i).getFechasalida());
                intent.putExtra("fechaDe", prestamos.get(i).getFechadevolucion());
                intent.putExtra("estado", prestamos.get(i).getEstado());
                intent.putExtra("observacion", prestamos.get(i).getObservacion());
                intent.putExtra("ficha",prestamos.get(i).getFk_ficha().getCodigo());
                intent.putExtra("municipio", prestamos.get(i).getFk_municipio()+"");
                intent.putExtra("responsable", prestamos.get(i).getFk_responsable()+"");
                startActivity(intent);
            }
        });

    }

    private void getPosts () {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.75.199.103:8083/siessPro-1.0.0/")
                .addConverterFactory(GsonConverterFactory.create()).build();


        PostServicePrestamos postService = retrofit.create(PostServicePrestamos.class);

        Call<List<Prestamo>> call = postService.getPost();

        call.enqueue(new Callback<List<Prestamo>>() {
            @Override
            public void onResponse(Call<List<Prestamo>> call, Response<List<Prestamo>> response) {
                for (Prestamo prestamo : response.body()) {
                    titles.add(prestamo.getFechadevolucion());
                    fichas.add(prestamo.getFk_ficha());
                    municipios.add(prestamo.getFk_municipio());
                    responsables.add(prestamo.getFk_responsable());
                    prestamos.add(prestamo);

                }
                arrayAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<Prestamo>> call, Throwable t) {
                Log.d("ERROR", t+" ");
            }
        });
    }


  /*  private void getPostsFicha () {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.75.199.83:8085/siessPro-1.0.0/")
                .addConverterFactory(GsonConverterFactory.create()).build();


        PostServicePrestamos postService = retrofit.create(PostServicePrestamos.class);

        Call<List<Ficha>> call = postService.getPostFicha();

        call.enqueue(new Callback<List<Ficha>>() {
            @Override
            public void onResponse(Call<List<Ficha>> call, Response<List<Ficha>> response) {

            }

            @Override
            public void onFailure(Call<List<Ficha>> call, Throwable t) {

            }
        });
    } */
}
