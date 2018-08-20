package diaz.bruno.petagram;

import android.content.Intent;
import android.speech.RecognizerIntent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements CustomItemClickListener {

    private ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;
    private CustomItemClickListener listener;
    private MascotaAdaptador adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // soporte actionbar

        android.support.v7.widget.Toolbar miActionBar = (android.support.v7.widget.Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);

        // traigo a objeto recyclerview
        listaMascotas = (RecyclerView) findViewById(R.id.rvMascotas);
        // defino orientacion de recyclerviw
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(llm);
        //inicializo lista de mascotas
        inicializarListaMascotas();
        // inicializo adaptador
        inicializarAdaptador();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_opciones, menu);
        return true;
    }

    // seleccion de elemento de menu
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
//            case R.id.mAbout:
////                break;
////
            case R.id.mSettings:
                break;

            case R.id.mFavorites:
                Intent intent = new Intent(this, Favorites.class);
                startActivity(intent);
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    public void inicializarAdaptador(){
        adaptador = new MascotaAdaptador(mascotas);
        listaMascotas.setAdapter(adaptador);
        adaptador.setClickListener(this);


    }

    public void inicializarListaMascotas() {
        mascotas = new ArrayList<Mascota>();

        mascotas.add(new Mascota(R.drawable.puppy1, "Oso", 2));
        mascotas.add(new Mascota(R.drawable.puppy2, "Milton", 5));
        mascotas.add(new Mascota(R.drawable.puppy3, "Blacky", 4));
        mascotas.add(new Mascota(R.drawable.puppy2, "Lucky", 1));
        mascotas.add(new Mascota(R.drawable.puppy4, "Tom", 6));
    }


    @Override
    public void likeClicked(View v, int position) {

        // sumo like y actualizo el valor en adaptador
        mascotas.get(position).setLikes( mascotas.get(position).getLikes() + 1);
        adaptador.notifyDataSetChanged();
    }
}
