package co.example.prueba.fragments;


import android.app.DatePickerDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import co.example.prueba.R;
import co.example.prueba.pojos.FkFicha;
import co.example.prueba.pojos.FkMunicipio;
import co.example.prueba.pojos.FkResponsable;
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
public class FragmentHacerPrestamo extends Fragment {

    ListView list;
    ArrayList<String> titles = new ArrayList<>();
    ArrayAdapter arrayAdapter ;
    EditText fecha;
    TextView codigo, responsable,obs, ficha, fede;
    Calendar calendario = Calendar.getInstance();
    Button btnAceptar;
    Integer estado;
    boolean bandera;

    Spinner spin ;
    int fechaSolicitud, fechaDevolucion, fechaSalida;

    PojoPrestamo prestamo = new PojoPrestamo();


    public FragmentHacerPrestamo() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
                             View view = inflater.inflate(R.layout.fragment_fragment_hacer_prestamo, container, false);



        btnAceptar= view.findViewById(R.id.btnAceptarP);
        codigo= view.findViewById(R.id.codigoPrestamo);
        responsable= view.findViewById(R.id.responsable);
        spin = view.findViewById(R.id.spin);
        obs= view.findViewById(R.id.txt);
        ficha= view.findViewById(R.id.ficha);
        fede= view.findViewById(R.id.calen1);


        estado = 0;
        fechaSolicitud = (int) (new Date().getTime()/1000);

        Calendar currentDate = Calendar.getInstance();
        final int years = currentDate.get(Calendar.YEAR);
        final int months = currentDate.get(Calendar.MONTH);
        int days = currentDate.get(Calendar.DAY_OF_MONTH);

        String fechaCompleta = years+""+months+""+days;
        final int fechaS = Integer.parseInt(fechaCompleta);
        bandera = false;



        spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spin.getSelectedItemPosition();

        btnAceptar.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                prestamo.setCodigo(codigo.getText().toString());
                prestamo.setFechasolicitud(fechaSolicitud);
                prestamo.setFechasalida(fechaS);
                prestamo.setFechadevolucion(fechaS);
                prestamo.setEstado(estado);
                prestamo.setObservacion(obs.getText().toString());
                prestamo.setFkFicha(new FkFicha(1));
                prestamo.setFkMunicipio(new FkMunicipio(363));
                prestamo.setFkResponsable(new FkResponsable( 1));
                prestamo.setCreadopor(2);

                if (fede != null){
                    bandera=true;
                }

                if(bandera == false){
                    Toast.makeText(getContext(), "Seleccione Fecha", Toast.LENGTH_SHORT).show();
                } else{

                    postPrestamo(prestamo);
                }


            }

        });
        fede.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(getContext(), date, calendario
                        .get(Calendar.YEAR), calendario.get(Calendar.MONTH),
                        calendario.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        fecha =  view.findViewById(R.id.calen);
        fecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DatePickerDialog(getContext(), date, calendario
                        .get(Calendar.YEAR), calendario.get(Calendar.MONTH),
                        calendario.get(Calendar.DAY_OF_MONTH)).show();
            }
        });


        return view;
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
                .baseUrl("http://10.75.199.38:8083/siessPro-1.0.0/")
                .addConverterFactory(GsonConverterFactory.create()).build();


        PostServicePrestamos postServicePrestamos = retrofit.create(PostServicePrestamos.class);

        Call<PojoPrestamo> call = postServicePrestamos.crearPrestamo(prestamo);

        call.enqueue(new Callback<PojoPrestamo>() {
            @Override
            public void onResponse(Call<PojoPrestamo> call, Response<PojoPrestamo> response) {
                Toast.makeText(getContext(), "Prestamo Realizado", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onFailure(Call<PojoPrestamo> call, Throwable t) {

            }
        });
    }


}
