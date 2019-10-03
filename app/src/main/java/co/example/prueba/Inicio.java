package co.example.prueba;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.Notification;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Inicio extends AppCompatActivity {

    Button boton, botonRe;
    EditText usuario, con;

    String nombreAd = "Admin" , nomUs = "User";
    String conn = "admin", conn2= "user";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);


        inicializarViews();

        getSupportActionBar().hide();

    }

    public void inicializarViews() {
        usuario = (EditText) findViewById(R.id.nom);
        con = (EditText) findViewById(R.id.pas);
        boton = (Button) findViewById(R.id.btnAcep);


        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (usuario.getText().toString().equals(nombreAd) && con.getText().toString().equals(conn)) {
                    Toast.makeText(Inicio.this, "Bienvenido" + nombreAd, Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Inicio.this, Contenedor.class);
                    startActivity(intent);
                } else if (usuario.getText().toString().equals(nomUs) && con.getText().toString().equals(conn2)) {
                    Toast.makeText(Inicio.this, "Bienvenido" + nomUs, Toast.LENGTH_SHORT).show();
                    Intent in = new Intent(Inicio.this, Prestamos.class);
                    startActivity(in);
                } else {
                    Toast.makeText(Inicio.this, "Verifique sus datos", Toast.LENGTH_SHORT).show();

                }
            }
        });

        botonRe=findViewById(R.id.btnReg);

      /*  botonRe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Inicio.this, Registro.class);
                startActivity(intent);
            }
        });
*/
    }

}