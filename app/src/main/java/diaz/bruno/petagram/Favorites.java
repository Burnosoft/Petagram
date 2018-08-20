package diaz.bruno.petagram;
import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;


public class Favorites extends AppCompatActivity{

    private ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotasFav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.favorites_layout);

        android.support.v7.widget.Toolbar miActionBar = (android.support.v7.widget.Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);
        if(getSupportActionBar()!=null)
        {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
//        miActionBar.setDisplayUseLogoEnabled(false);
//        miActionBar.setDisplayHomeAsUpEnabled(true);
//        miActionBar.setHomeButtonEnabled(true);
        //setSupportActionBar(miActionBar);


        // traigo a objeto recyclerview
        listaMascotasFav = (RecyclerView) findViewById(R.id.rvMascotas);
        // defino orientacion de recyclerviw
        LinearLayoutManager llm2 = new LinearLayoutManager(this);

        llm2.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotasFav.setLayoutManager(llm2);
        //inicializo lista de mascotas
        inicializarListaMascotasFav();
        // inicializo adaptador

        inicializarAdaptador();
    }


    private void inicializarAdaptador() {
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas);
        listaMascotasFav.setAdapter(adaptador);
    }

    private void inicializarListaMascotasFav() {
        mascotas = new ArrayList<Mascota>();

        mascotas.add(new Mascota(R.drawable.puppy4, "Tom", 6));
        mascotas.add(new Mascota(R.drawable.puppy2, "Milton", 5));
        mascotas.add(new Mascota(R.drawable.puppy3, "Blacky", 4));
        mascotas.add(new Mascota(R.drawable.puppy1, "Oso", 2));
        mascotas.add(new Mascota(R.drawable.puppy2, "Lucky", 1));

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
//                Intent intent = new Intent(this, MainActivity.class);
//                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//                startActivity(intent);
                finish();
                break;
            // Something else
        }
        return super.onOptionsItemSelected(item);
    }

}
