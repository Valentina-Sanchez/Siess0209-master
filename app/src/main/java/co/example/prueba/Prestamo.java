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

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class Prestamo extends AppCompatActivity {
    EditText fecha;
    Calendar calendario = Calendar.getInstance();
    Spinner spinner, municipio, ficha, responsable;
    Button btnAceptar;


    @Override
    protected void onCreate(@Nullable  Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prestamo);
            getSupportActionBar().hide();
        spinner = (Spinner) findViewById(R.id.spinner);
        municipio = (Spinner) findViewById(R.id.spinnermu);
        ficha = (Spinner) findViewById(R.id.spinnerfi);
        responsable = (Spinner) findViewById(R.id.spinnerres);

        String[] pro = {"Proceso","Prestamo","Reserva"};
        String[] muni = {"Municipio","Rosas","Piendamo","Caloto","Silvia"};
        String[] fi = {"Ficha","1613314","1584548","1542123","1612245"};
        String[] res = {"Responsable","Armando Casas","Camila Muñoz","Victor Segovia","Juan Diego Sanchez"};



        spinner.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, pro));
        municipio.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, muni));
        ficha.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, fi));
        responsable.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, res));

        btnAceptar= findViewById(R.id.btnAceptarP);

        btnAceptar.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Prestamo.this, Inicio2.class);
                startActivity(intent);
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
        String formatoDeFecha = "MM/dd/yy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(formatoDeFecha, Locale.US);

        fecha.setText(sdf.format(calendario.getTime()));
    }

}
