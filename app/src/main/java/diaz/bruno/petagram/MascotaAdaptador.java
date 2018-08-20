package diaz.bruno.petagram;


import android.content.Context;
import android.content.Intent;
import android.net.sip.SipSession;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.view.menu.MenuView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder>{

    private  ArrayList<Mascota> mascotas;
    private CustomItemClickListener clickListener;

    public MascotaAdaptador(ArrayList<Mascota> mascotas) {
        this.mascotas = mascotas;
    }

    public void setClickListener(CustomItemClickListener clickListener)
    {
        this.clickListener = clickListener;
    }

    @NonNull
    @Override
    public MascotaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, final int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascotas, parent, false);

        return new MascotaViewHolder(v);
    }


    @Override
    public void onBindViewHolder(@NonNull MascotaViewHolder mascotaViewHolder, int position) {   // obtiene objeto para reciclaje
        final Mascota mascota = mascotas.get(position);
        mascotaViewHolder.imgFoto.setImageResource(mascota.getFoto());
        mascotaViewHolder.tvLikes.setText(Integer.toString(mascota.getLikes()));
        mascotaViewHolder.tvNombre.setText(mascota.getNombre());

    }

    @Override
    public int getItemCount() {         // cantidad de elemento de la lista
        return mascotas.size();
    }




    public class MascotaViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private ImageView imgFoto;
        private TextView tvNombre;
        private ImageView imgHueso1;
        private TextView tvLikes;

        public MascotaViewHolder(final View itemView) {
            super(itemView);

            imgFoto = (ImageView) itemView.findViewById(R.id.imgFoto);
            tvNombre = (TextView) itemView.findViewById(R.id.tvNombre);
            imgHueso1 = (ImageView) itemView.findViewById(R.id.imgHueso1);
            tvLikes = (TextView) itemView.findViewById(R.id.tvLikes);

//            itemView.setOnClickListener(this);
//            tvLikes.bringToFront();
            imgHueso1.setOnClickListener(this);

    }

        @Override
        public void onClick(View view) {
           if( clickListener != null)
           {
               clickListener.likeClicked(view,getAdapterPosition());
           }
        }
    }
}