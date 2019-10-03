package co.example.prueba;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import co.example.prueba.fragments.FragmentEquipos;
import co.example.prueba.fragments.FragmentEquiposDis;

public class Contenedor extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    FragmentEquipos fragmentEquipos = new FragmentEquipos();
    FragmentEquiposDis fragmentEquiposDis = new FragmentEquiposDis();
    FrameLayout frameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contenedor);

        bottomNavigationView = findViewById(R.id.container_nav);
        frameLayout = findViewById(R.id.contenedor);

        getSupportFragmentManager().beginTransaction().replace(R.id.contenedor,fragmentEquiposDis)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).commit();

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                switch (menuItem.getItemId()){
                    case R.id.menu_equipos:
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.contenedor,fragmentEquipos)
                                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                                .commit();
                        menuItem.setChecked(true);
                        break;
                    case R.id.menu_notificaciones:
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.contenedor,fragmentEquiposDis)
                                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                                .commit();
                        menuItem.setChecked(true);
                        break;
                }

                return false;
            }
        });

    }
}
