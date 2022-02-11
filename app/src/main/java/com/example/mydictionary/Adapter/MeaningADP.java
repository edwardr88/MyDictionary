package com.example.mydictionary.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mydictionary.Models.Meanings;
import com.example.mydictionary.R;
import com.example.mydictionary.ViewHolders.MeaningVH;

import java.util.List;

public class MeaningADP extends RecyclerView.Adapter<MeaningVH>{

    private Context ctx;
    private List<Meanings> meaningsList;

    public MeaningADP(Context ctx, List<Meanings> meaningsList) {
        this.ctx = ctx;
        this.meaningsList = meaningsList;
    }

    @NonNull
    @Override
    public MeaningVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MeaningVH(LayoutInflater.from(ctx).inflate(R.layout.list_meanings, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MeaningVH holder, int position) {
        holder.txtSpeech.setText("Parts of Speech: " + meaningsList.get(position).getPartOfSpeech());
        holder.rvDefinition.setHasFixedSize(true);
        holder.rvDefinition.setLayoutManager(new GridLayoutManager(ctx, 1));

        DefinitionADP definitionADP = new DefinitionADP(ctx, meaningsList.get(position).getDefinitions());
        holder.rvDefinition.setAdapter(definitionADP);

    }

    @Override
    public int getItemCount() {
        return meaningsList.size();
    }
}
