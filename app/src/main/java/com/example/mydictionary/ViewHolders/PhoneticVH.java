package com.example.mydictionary.ViewHolders;

import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mydictionary.R;

public class PhoneticVH extends RecyclerView.ViewHolder{

    public TextView txtPhonetic;
    public ImageButton buttonAudio;

    public PhoneticVH(@NonNull View itemView) {
        super(itemView);

        txtPhonetic = itemView.findViewById(R.id.txtPhonetic);
        buttonAudio = itemView.findViewById(R.id.buttonAudio);

    }
}
