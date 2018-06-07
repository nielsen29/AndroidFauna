package yanick.com.proyectofauna.androidfauna.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import yanick.com.proyectofauna.androidfauna.R;
import yanick.com.proyectofauna.androidfauna.modelo.Animal;

/**
 * Created by GITCE on 06/07/18.
 */

public class AdapterAnimal extends RecyclerView.Adapter<AdapterAnimal.MyViewHolder> {


    private ArrayList<Animal> lista;

    public AdapterAnimal(ArrayList<Animal> lista) {
        this.lista = lista;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_animal,parent,false);


        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.textNombre.setText(lista.get(position).getNombre());
        holder.txtlog.setText(lista.get(position).getLongitud());
        holder.txtLat.setText(lista.get(position).getLatitud());
        holder.txtP.setText(lista.get(position).getPais());

    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {


        ImageView img;
        TextView textNombre;
        TextView txtlog;
        TextView txtLat;
        TextView txtP;


        public MyViewHolder(View itemView) {
            super(itemView);
            textNombre = (TextView) itemView.findViewById(R.id.txtNombre);
            txtLat = (TextView) itemView.findViewById(R.id.txtLat);
            txtlog = (TextView) itemView.findViewById(R.id.txtLogi);
            txtP = (TextView) itemView.findViewById(R.id.txtP);

        }
    }
}
