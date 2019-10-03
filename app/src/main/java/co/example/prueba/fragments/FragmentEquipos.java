package co.example.prueba.fragments;


import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import co.example.prueba.R;
import co.example.prueba.consumo.Post;
import co.example.prueba.consumo.PostService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentEquipos extends Fragment {
    ListView list;
    ArrayList<String> titles = new ArrayList<>();
    ArrayAdapter arrayAdapter ;

    public FragmentEquipos() {

    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_fragment_equipos, container, false);

        arrayAdapter = new ArrayAdapter( view.getContext(), android.R.layout.simple_list_item_1,titles);
        list = view.findViewById(R.id.list);

        list.setAdapter(arrayAdapter);

        getPosts();
        return view;
    }

    private void getPosts () {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.75.199.103:8083/siessPro-1.0.0/")
                .addConverterFactory(GsonConverterFactory.create()).build();


        PostService postService = retrofit.create(PostService.class);

        Call<List<Post>> call = postService.getPost();

        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                for (Post post : response.body()) {
                    titles.add(post.getNombre());
                }
                arrayAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                Log.d("ERROR", t+" ");
            }
        });
    }

}
