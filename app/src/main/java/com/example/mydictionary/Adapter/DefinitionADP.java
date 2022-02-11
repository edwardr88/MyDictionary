package com.example.mydictionary.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mydictionary.Models.Definition;
import com.example.mydictionary.R;
import com.example.mydictionary.ViewHolders.DefinitionVH;

import java.util.List;

public class DefinitionADP extends RecyclerView.Adapter<DefinitionVH>{

    private Context ctx;
    private List<Definition> definitionList;

    public DefinitionADP(Context ctx, List<Definition> definitionList) {
        this.ctx = ctx;
        this.definitionList = definitionList;
    }

    @NonNull
    @Override
    public DefinitionVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new DefinitionVH(LayoutInflater.from(ctx).inflate(R.layout.list_definition, parent, false));

    }

    @Override
    public void onBindViewHolder(@NonNull DefinitionVH holder, int position) {
        holder.txtDefinition.setText("Translate: " + definitionList.get(position).getDefinition());
        holder.txtExample.setText("Example: " + definitionList.get(position).getExample());
        StringBuilder synonyms = new StringBuilder();
        StringBuilder antonyms = new StringBuilder();

        synonyms.append(definitionList.get(position).getSynonyms());
        antonyms.append(definitionList.get(position).getAntonyms());

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
