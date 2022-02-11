package com.example.mydictionary.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mydictionary.Models.Means;
import com.example.mydictionary.R;
import com.example.mydictionary.ViewHolders.MeaningVH;

import java.util.List;

public class MeaningADP extends RecyclerView.Adapter<MeaningVH>{

    private Context ctx;
    private List<Means> meansList;

    public MeaningADP(Context ctx, List<Means> meansList) {
        this.ctx = ctx;
        this.meansList = meansList;
    }

    @NonNull
    @Override
    public MeaningVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MeaningVH(LayoutInflater.from(ctx).inflate(R.layout.list_meanings, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MeaningVH holder, int position) {
        holder.txtSpeech.setText("Parts of Speech: " + meansList.get(position).getPartOfSpeech());
        holder.rvDefinition.setHasFixedSize(true);
        holder.rvDefinition.setLayoutManager(new GridLayoutManager(ctx, 1));

        DefinitionADP definitionADP = new DefinitionADP(ctx, meansList.get(position).getDefinitions());
        holder.rvDefinition.setAdapter(definitionADP);

    }

    @Override
    public int getItemCount() {
        return meansList.size();
    }
}
