package com.example.mtesio.meliapp.listadeitems;

import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mtesio.meliapp.R;
import com.facebook.drawee.view.SimpleDraweeView;

public class CustomListAdapter extends RecyclerView.Adapter<CustomListAdapter.ListViewHolder>{

    private ListaDeItems items;
    private ListaDeItemsActivity.ItemListener listener;

    public CustomListAdapter(ListaDeItems items,  ListaDeItemsActivity.ItemListener listener){
        this.items = items;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        ConstraintLayout layout = (ConstraintLayout) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_view, parent, false);

        return new ListViewHolder(layout, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder listViewHolder, int position) {
        final Item item = items.getList().get(position);
        Uri imageUri = Uri.parse(item.getImage());
        listViewHolder.descripcion.setText(item.getDescription());
        listViewHolder.precio.setText("Precio: " + item.getPrice());
        listViewHolder.image.setImageURI(imageUri);

        listViewHolder.layout.setOnClickListener(v -> listener.onClick(item.getId()));


        //For gifs
       /* DraweeController controller = Fresco.newDraweeControllerBuilder()
                .setUri(imageUri)
                .setAutoPlayAnimations(true)
                .build();
        listViewHolder.image.setController(controller);*/
    }

    @Override
    public int getItemCount() {
        return items.getList().size();
    }

    static class ListViewHolder extends RecyclerView.ViewHolder {

        TextView descripcion;
        TextView precio;
        SimpleDraweeView image;
        ConstraintLayout layout;

        public ListViewHolder(ConstraintLayout layout, ListaDeItemsActivity.ItemListener listener) {
            super(layout);
            this.descripcion = layout.findViewById(R.id.description);
            this.precio = layout.findViewById(R.id.price);
            this.image = layout.findViewById(R.id.image);
            this.layout = layout;
        }
    }
}
