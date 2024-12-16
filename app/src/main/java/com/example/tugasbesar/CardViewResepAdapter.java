package com.example.tugasbesar;

import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class CardViewResepAdapter extends RecyclerView.Adapter<CardViewResepAdapter.CardViewViewHolder> {
    private ArrayList<Resep> listResep;
    private Context context;

    CardViewResepAdapter(ArrayList<Resep> list) {
        this.context = context;
        this.listResep = list;

    }


    @NonNull
    @Override
    public CardViewViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cardview_resep, parent, false);
        return new CardViewViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final CardViewViewHolder holder, int position) {
        final Resep hero = listResep.get(position);

        Glide.with(holder.itemView.getContext())
                .load(hero.getPhoto())
                .apply(new RequestOptions().override(350, 550))
                .into(holder.imgPhoto);

        holder.tvName.setText(hero.getName());
        holder.tvDetail.setText(hero.getDetail());

        holder.btnFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Call the interface method to handle button click
                onFavoriteButtonClick(hero.getName());
            }
        });

        holder.btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle share button click
                Toast.makeText(context, "Share " + hero.getName(), Toast.LENGTH_SHORT).show();
            }
        });

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle item click
                Toast.makeText(context, "Kamu memilih " + hero.getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return listResep.size();
    }

    // Interface to handle favorite button clicks
    public interface OnFavoriteButtonClickListener {
        void onFavoriteButtonClick(String resepName);
    }

    private OnFavoriteButtonClickListener mListener;

    // Method to set the listener
    public void setOnFavoriteButtonClickListener(OnFavoriteButtonClickListener listener) {
        this.mListener = listener;
    }

    class CardViewViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView tvName, tvDetail;
        Button btnFavorite, btnShare;

        CardViewViewHolder(View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
            tvName = itemView.findViewById(R.id.tv_item_name);
            tvDetail = itemView.findViewById(R.id.tv_item_detail);
            btnFavorite = itemView.findViewById(R.id.btn_set_favorite);
            btnShare = itemView.findViewById(R.id.btn_set_share);

            // Set click listener for the entire item if needed
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    openResepActivity(listResep.get(getAdapterPosition()).getName());
                }
            });
        }
    }

    // Method to handle favorite button click
    private void onFavoriteButtonClick(String resepName) {
        if (mListener != null) {
            mListener.onFavoriteButtonClick(resepName);
        }
    }

    private void openResepActivity(String recipeName) {
        Intent intent;
        switch (recipeName) {
            case "Rendang":
                intent = new Intent(context, Resep1.class);
                break;
            case "Sate":
                intent = new Intent(context, Resep2.class);
                break;
            case "Rawon":
                intent = new Intent(context, Resep3.class);
                break;
            case "Steak Ayam":
                intent = new Intent(context, Resep4.class);
                break;
            case "Ayam Geprek":
                intent = new Intent(context, Resep5.class);
                break;
            case "Ayam Kecap":
                intent = new Intent(context, Resep6.class);
                break;
            case "Ayam Teriaki":
                intent = new Intent(context, Resep7.class);
                break;
            case "Puding Coklat":
                intent = new Intent(context, Resep8.class);
                break;
            case "Es Krim":
                intent = new Intent(context, Resep9.class);
                break;
                // Add cases for other recipes
            default:
                intent = new Intent(context, ResepActivity.class);
                break;
        }
        intent.putExtra(ResepActivity.RECIPE_NAME_EXTRA, recipeName);
        context.startActivity(intent);
    }
}