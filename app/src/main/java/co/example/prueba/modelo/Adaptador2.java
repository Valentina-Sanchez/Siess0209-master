package co.example.prueba.modelo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import co.example.prueba.R;

public class Adaptador2 extends RecyclerView.Adapter<Adaptador2.viewHolderItem> {

    ArrayList <Item> lista2;

    public Adaptador2(ArrayList<Item> lista2) {

        this.lista2 = lista2;
    }

    @NonNull
    @Override
    public Adaptador2.viewHolderItem onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item2,null,false);

        return new Adaptador2.viewHolderItem(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adaptador2.viewHolderItem holder, int position) {

        Item itemModel = lista2.get(position);
        Picasso.get().load(itemModel.getFoto()).into(Adaptador2.viewHolderItem.ima);
        holder.nom.setText(lista2.get(position).getNombre());
        holder.des.setText(lista2.get(position).getDescripcion());


    }

    @Override
    public int getItemCount() {
        return lista2.size();
    }

    public static class viewHolderItem extends RecyclerView.ViewHolder {

        public static ImageView ima;
        TextView nom, des;

        public viewHolderItem(@NonNull View itemView) {
            super(itemView);

            nom= itemView.findViewById(R.id.nob);
            des=itemView.findViewById(R.id.des);
            ima=itemView.findViewById(R.id.img);


        }

    }
}
