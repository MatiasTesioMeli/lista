package com.example.mtesio.meliapp.listadeitems;

import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mtesio.meliapp.R;

import java.util.List;

public class CustomListAdapter extends RecyclerView.Adapter<CustomListAdapter.ListViewHolder>{

    private List<Item> items;

    public CustomListAdapter(List<Item> items){
        this.items = items;
    }


    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        ConstraintLayout layout = (ConstraintLayout) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_view, parent, false);

        return new ListViewHolder(layout);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder listViewHolder, int position) {
        final Item item = items.get(position);
        listViewHolder.descripcion.setText(item.getDescription());
        listViewHolder.precio.setText(item.getPrice());
        listViewHolder.image.setImageDrawable(item.getImage());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    static class ListViewHolder extends RecyclerView.ViewHolder {

        TextView descripcion;
        TextView precio;
        ImageView image;

        public ListViewHolder(ConstraintLayout layout) {
            super(layout);
            this.descripcion = layout.findViewById(R.id.description);
            this.precio = layout.findViewById(R.id.price);;
            this.image = layout.findViewById(R.id.image);;

        }
    }
}
