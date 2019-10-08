package co.example.prueba;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class DetallePrestamo extends AppCompatActivity {

    ImageView imageView;
    TextView codigo, fechaSolicitud, fechaSalida ,fechaDevolucion, estado, ficha, municipio, responsable , obser;
    ListView listView ;
    static final int REQUEST_IMAGE_CAPTURE = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_prestamo);

        imageView=findViewById(R.id.im);
        codigo = findViewById(R.id.cod);
        fechaSolicitud = findViewById(R.id.feSol);
        fechaSalida = findViewById(R.id.feSal);
        fechaDevolucion = findViewById(R.id.feDe);
        estado = findViewById(R.id.ESTADO);
        ficha= findViewById(R.id.ficha);
        municipio=findViewById(R.id.muni);
        responsable=findViewById(R.id.resp);
        obser=findViewById(R.id.ob);

        int i =0;

        codigo.setText(Prestamos.prestamos.get(i).getCodigo().toString());
        fechaSolicitud.setText( Prestamos.prestamos.get(i).getFechasolicitud());
        fechaSalida.setText(Prestamos.prestamos.get(i).getFechasalida().toString());
        fechaDevolucion.setText(Prestamos.prestamos.get(i).getFechadevolucion().toString());
        estado.setText(Prestamos.prestamos.get(i).getEstado()+"");
        obser.setText(Prestamos.prestamos.get(i).getObservacion());
        ficha.setText(Prestamos.prestamos.get(i).getFk_ficha().toString());
        municipio.setText(Prestamos.prestamos.get(i).getFk_municipio().toString());
        responsable.setText(Prestamos.prestamos.get(i).getFk_responsable().toString() +" " +
                Prestamos.prestamos.get(i).getFk_responsable().toString());

        Bundle datos = this.getIntent().getExtras();
        String codigo= datos.getString("codigo","0");
        String fechaSol = datos.getString("fechaSol", "0" );
        String fechaSal = datos.getString("fechaSal","0");
        String fechaDe = datos.getString("fechaDe","0");
        String estado = datos.getString("estado","0");
        String obser = datos.getString("observacion", "0");
        String ficha = datos.getString("ficha","0");
        String municipio = datos.getString("municipio","0");
        String responsable = datos.getString("responsable","0");

    }
    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            imageView.setImageBitmap(imageBitmap);
        }
    }

    public void onTomarFoto(View view){
        dispatchTakePictureIntent();
    }

}
