package co.example.prueba.fragments;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import co.example.prueba.DetallePrestamo;
import co.example.prueba.R;
import co.example.prueba.pojos.PojoPrestamo;
import co.example.prueba.consumo.PostServicePrestamos;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentMisPrestamos extends Fragment {

    ListView listar;
    ArrayList<String> titles = new ArrayList<>();
    ArrayAdapter arrayAdapter ;
    ListView list;
    public static ArrayList<PojoPrestamo> prestamos = new ArrayList<>();
    public FragmentMisPrestamos() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fragment_mis_prestamos, container, false);

        arrayAdapter = new ArrayAdapter( view.getContext(), android.R.layout.simple_list_item_1,titles);
        listar = view.findViewById(R.id.listaMisPrestamos);

        listar.setAdapter(arrayAdapter);


        getPosts();

        listar.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getContext(), DetallePrestamo.class);
                intent.putExtra("codigo", prestamos.get(i).getCodigo());
                intent.putExtra("fechaSol", prestamos.get(i).getFechasolicitud());
                intent.putExtra("fechaSal", prestamos.get(i).getFechasalida());
                intent.putExtra("fechaDe", prestamos.get(i).getFechadevolucion());
                intent.putExtra("estado", prestamos.get(i).getEstado());
                intent.putExtra("observacion", prestamos.get(i).getObservacion());
                intent.putExtra("ficha",prestamos.get(i).getFkFicha().toString());
                intent.putExtra("municipio", prestamos.get(i).getFkMunicipio()+"");
                intent.putExtra("responsable", prestamos.get(i).getFkResponsable()+"");
                startActivity(intent);
            }
        });
        return view;
    }
    private void getPosts () {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.75.199.38:8083/siessPro-1.0.0/")
                .addConverterFactory(GsonConverterFactory.create()).build();


        PostServicePrestamos postService = retrofit.create(PostServicePrestamos.class);

        Call<List<PojoPrestamo>> call = postService.getPost();

        call.enqueue(new Callback<List<PojoPrestamo>>() {
            @Override
            public void onResponse(Call<List<PojoPrestamo>> call, Response<List<PojoPrestamo>> response) {
                for (PojoPrestamo prestamo : response.body()) {
                    titles.add(prestamo.getFechadevolucion().toString());
                 /*   fichas.add(prestamo.getFk_ficha());
                    municipios.add(prestamo.getFk_municipio());
                    responsables.add(prestamo.getFk_responsable());
                    prestamos.add(prestamo); */

                }
                arrayAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<PojoPrestamo>> call, Throwable t) {
                Log.d("ERROR", t+" ");
            }
        });
    }

}
