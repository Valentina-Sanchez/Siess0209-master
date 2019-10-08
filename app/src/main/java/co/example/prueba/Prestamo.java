package co.example.prueba;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import co.example.prueba.consumo.PojoPrestamo;
import co.example.prueba.consumo.PostService;
import co.example.prueba.consumo.PostServicePrestamos;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Prestamo extends AppCompatActivity {
    EditText fecha;
    TextView codigo, responsable, municipio,obs, ficha, fede;
    Calendar calendario = Calendar.getInstance();
    Button btnAceptar;
    short estado;
    Date fechaSolicitud;

    PojoPrestamo prestamo = new PojoPrestamo();


    @Override
    protected void onCreate(@Nullable  Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prestamo);
            getSupportActionBar().hide();


        btnAceptar= findViewById(R.id.btnAceptarP);
        codigo=findViewById(R.id.codigoPrestamo);
        responsable=findViewById(R.id.responsable);
        municipio= findViewById(R.id.municipio);
        obs=findViewById(R.id.txt);
        ficha=findViewById(R.id.ficha);
        fede=findViewById(R.id.calen1);


        estado = 0;
        fechaSolicitud= new Date();

        btnAceptar.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                prestamo.setCodigo(codigo.getText().toString());
                prestamo.setFechasolicitud(fechaSolicitud.toString());
                prestamo.setFechasalida(fecha.getText().toString());
                prestamo.setFechadevolucion(fede.getText().toString());
                prestamo.setObservacion(obs.getText().toString());
                prestamo.setFk_ficha(ficha.getText().toString());
                prestamo.setEstado(estado);
                prestamo.setFk_municipio(municipio.getText().toString());
                prestamo.setFk_responsable(responsable.getText().toString());



                postPrestamo(prestamo);
            }

        });
        fede.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(Prestamo.this, date, calendario
                        .get(Calendar.YEAR), calendario.get(Calendar.MONTH),
                        calendario.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        fecha = findViewById(R.id.calen);
        fecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DatePickerDialog(Prestamo.this, date, calendario
                        .get(Calendar.YEAR), calendario.get(Calendar.MONTH),
                        calendario.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
    }

    DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear,
                              int dayOfMonth) {
            // TODO Auto-generated method stub
            calendario.set(Calendar.YEAR, year);
            calendario.set(Calendar.MONTH, monthOfYear);
            calendario.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            actualizarInput();
        }

    };

    private void actualizarInput() {
        String formatoDeFecha = "MM/dd/yy";
        SimpleDateFormat sdf = new SimpleDateFormat(formatoDeFecha, Locale.US);

        fecha.setText(sdf.format(calendario.getTime()));
        fede.setText(sdf.format(calendario.getTime()));
    }

    public void postPrestamo(PojoPrestamo prestamo){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.75.199.51:8083/siessPro-1.0.0/")
                .addConverterFactory(GsonConverterFactory.create()).build();


        PostServicePrestamos postServicePrestamos = retrofit.create(PostServicePrestamos.class);

        Call<PojoPrestamo> call = postServicePrestamos.crearPrestamo(prestamo);

        call.enqueue(new Callback<PojoPrestamo>() {
            @Override
            public void onResponse(Call<PojoPrestamo> call, Response<PojoPrestamo> response) {
                Toast.makeText(Prestamo.this, "Prestamo Realizado", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onFailure(Call<PojoPrestamo> call, Throwable t) {

            }
        });
    }

}
