package co.example.prueba;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.Notification;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;
import java.util.List;

import co.example.prueba.consumo.Equipo;
import co.example.prueba.consumo.PostService;
import co.example.prueba.consumo.Usuario;
import co.example.prueba.utils.Utils;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Inicio extends AppCompatActivity {


    ArrayList<String> titles = new ArrayList<>();
    ArrayAdapter arrayAdapter ;

    Button boton, botonRe;
    EditText nombreU, pass;
    String  nombre, cont;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);


        inicializarViews();

        getSupportActionBar().hide();


    }

    public void inicializarViews() {
        nombreU =  findViewById(R.id.edtNombreUsuario);
        pass =findViewById(R.id.edtPass);
        boton = findViewById(R.id.btnAcep);

            nombre = nombreU.getText().toString();
           cont = pass.getText().toString();

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                getUsuarios(nombreU.getText().toString(), pass.getText().toString());


            }
        });

    }
    private void getUsuarios (String nombre, String pass) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.75.199.38:8083/siessPro-1.0.0/")
                .addConverterFactory(GsonConverterFactory.create()).build();


        PostService postService = retrofit.create(PostService.class);

        Call<Usuario> call = postService.getUsuarios(nombre, pass);

        call.enqueue(new Callback<Usuario>() {
            @Override
            public void onResponse(Call<Usuario> call, Response<Usuario> response) {
                Usuario user = response.body();
                    if (!user.getNombreusuario().equals("admin")){
                       Toast.makeText(Inicio.this, "Bienvenido"+user.getNombreusuario(), Toast.LENGTH_SHORT).show();
                       Intent intent = new Intent( Inicio.this, Contenedor2.class);
                       startActivity(intent);
                    }else if(user.getNombreusuario().equals("admin")) {
                        Intent intent = new Intent( Inicio.this, Contenedor.class);
                        startActivity(intent);
                        //Toast.makeText(Inicio.this, "Verifique sus datos", Toast.LENGTH_SHORT).show();
                    }

            }

            @Override
            public void onFailure(Call<Usuario> call, Throwable t) {
                Toast.makeText(Inicio.this, "Datos Invalidos", Toast.LENGTH_SHORT).show();
            }
        });
    }

}