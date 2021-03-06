package com.iavariav.learnjsonstunting.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.iavariav.learnjsonstunting.DetailActivity;
import com.iavariav.learnjsonstunting.R;
import com.iavariav.learnjsonstunting.model.StuntingModel;

import java.util.List;

public class StuntingAdapter extends RecyclerView.Adapter<StuntingAdapter.TrainingViewHolder> {

    private Context context;
    private List<StuntingModel> StuntingModels;

    public StuntingAdapter(Context context, List<StuntingModel> StuntingModels) {
        this.context = context;
        this.StuntingModels = StuntingModels;
    }

    @NonNull
    @Override
    public TrainingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_stunting, parent, false);
        return new TrainingViewHolder(view);
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onBindViewHolder(@NonNull TrainingViewHolder holder, int position) {
        holder.tvTitle.setText(StuntingModels.get(position).getJudul());
        holder.tvJenis.setText(StuntingModels.get(position).getJenis());

        Glide.with(context)
                .load(StuntingModels.get(position).getGambar())
                .error(R.drawable.ic_dashboard_black_24dp)
                .override(512, 512)
                .into(holder.ivListItem);

        holder.cv.setOnClickListener(v -> {
            Intent intent = new Intent(context, DetailActivity.class);
            intent.putExtra("TITLE", StuntingModels.get(position).getJudul());
            intent.putExtra("JENIS", StuntingModels.get(position).getJenis());
            intent.putExtra("URL_IMAGE", StuntingModels.get(position).getGambar());
            intent.putExtra("ISI", StuntingModels.get(position).getIsi());
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return StuntingModels.size();
    }
    public class TrainingViewHolder extends RecyclerView.ViewHolder {
        private ImageView ivListItem;
        private TextView tvTitle;
        private TextView tvJenis;
        private CardView cv;

        public TrainingViewHolder(@NonNull View itemView) {
            super(itemView);
            ivListItem = itemView.findViewById(R.id.iv_list_item);
            tvTitle = itemView.findViewById(R.id.tv_title);
            tvJenis = itemView.findViewById(R.id.tv_jenis);
            cv = itemView.findViewById(R.id.cv);
        }
    }
}
