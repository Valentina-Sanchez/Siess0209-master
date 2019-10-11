package co.example.prueba;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import co.example.prueba.fragments.FragmentHacerPrestamo;
import co.example.prueba.fragments.FragmentMisPrestamos;

public class Contenedor2 extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    FragmentHacerPrestamo fragmentHacerPrestamo = new FragmentHacerPrestamo();
    FragmentMisPrestamos fragmentMisPrestamos = new FragmentMisPrestamos();
    FrameLayout frameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contenedor2);

        bottomNavigationView = findViewById(R.id.container_nav);
        frameLayout = findViewById(R.id.contenedor2);

        getSupportFragmentManager().beginTransaction().replace(R.id.contenedor2,fragmentHacerPrestamo)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).commit();

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                switch (menuItem.getItemId()){
                    case R.id.realizarPrestamo:
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.contenedor2,fragmentHacerPrestamo)
                                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                                .commit();
                        menuItem.setChecked(true);
                        break;
                    case R.id.misPrestamos:
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.contenedor2,fragmentMisPrestamos)
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
