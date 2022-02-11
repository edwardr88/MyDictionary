package com.example.mydictionary.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mydictionary.Models.Definitions;
import com.example.mydictionary.R;
import com.example.mydictionary.ViewHolders.DefinitionVH;

import java.util.List;

public class DefinitionADP extends RecyclerView.Adapter<DefinitionVH>{

    private Context ctx;
    private List<Definitions> definitionsList;

    public DefinitionADP(Context ctx, List<Definitions> definitionsList) {
        this.ctx = ctx;
        this.definitionsList = definitionsList;
    }

    @NonNull
    @Override
    public DefinitionVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new DefinitionVH(LayoutInflater.from(ctx).inflate(R.layout.list_definition, parent, false));

    }

    @Override
    public void onBindViewHolder(@NonNull DefinitionVH holder, int position) {
        holder.txtDefinition.setText("Translate: " + definitionsList.get(position).getDefinition());
        holder.txtExample.setText("Example: " + definitionsList.get(position).getExample());
        StringBuilder synonyms = new StringBuilder();
        StringBuilder antonyms = new StringBuilder();

        synonyms.append(definitionsList.get(position).getSynonyms());
        antonyms.append(definitionsList.get(position).getAntonyms());

        holder.txtSynonyms.setText(synonyms);
        holder.txtAntonyms.setText(antonyms);

        holder.txtSynonyms.setSelected(true);
        holder.txtAntonyms.setSelected(true);
    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
