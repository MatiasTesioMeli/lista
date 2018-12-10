package com.example.mtesio.meliapp.item;

import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.mtesio.meliapp.R;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

public class CustomItemAdapter extends RecyclerView.Adapter<CustomItemAdapter.ItemViewHolder> {
    private List<ItemImages> items;

    public CustomItemAdapter(List<ItemImages> items){
        this.items = items;
    }

    @NonNull
    @Override
    public CustomItemAdapter.ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        ConstraintLayout layout = (ConstraintLayout) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.image_item, parent, false);

        return new CustomItemAdapter.ItemViewHolder(layout);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomItemAdapter.ItemViewHolder listViewHolder, int position) {
        final ItemImages item = items.get(position);
        Uri imageUri = Uri.parse(item.getUri());
        listViewHolder.image.setImageURI(imageUri);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    static class ItemViewHolder extends RecyclerView.ViewHolder {

        SimpleDraweeView image;

        public ItemViewHolder(ConstraintLayout layout) {
            super(layout);
            this.image = layout.findViewById(R.id.image);
        }
    }
}
