package com.example.mydictionary.ViewHolders;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mydictionary.R;

public class MeaningVH extends RecyclerView.ViewHolder{

    public TextView txtSpeech;
    public RecyclerView rvDefinition;

    public MeaningVH(@NonNull View itemView) {
        super(itemView);

        txtSpeech = itemView.findViewById(R.id.txtSpeech);
        rvDefinition = itemView.findViewById(R.id.rvDefinition);

    }
}
