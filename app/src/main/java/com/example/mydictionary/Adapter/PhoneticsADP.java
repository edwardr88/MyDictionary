package com.example.mydictionary.Adapter;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaParser;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mydictionary.Models.Phonetics;
import com.example.mydictionary.R;
import com.example.mydictionary.ViewHolders.PhoneticVH;

import java.util.List;

public class PhoneticsADP extends RecyclerView.Adapter<PhoneticVH>{
    private Context ctx;
    private List<Phonetics> phoneticList;

    public PhoneticsADP(Context ctx, List<Phonetics> phoneticList) {
        this.ctx = ctx;
        this.phoneticList = phoneticList;
    }

    @NonNull
    @Override
    public PhoneticVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PhoneticVH(LayoutInflater.from(ctx).inflate(R.layout.list_items, parent, false));

    }

    @Override
    public void onBindViewHolder(@NonNull PhoneticVH holder, int position) {
        holder.txtPhonetic.setText(phoneticList.get(position).getTxtDic());
        holder.buttonAudio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MediaPlayer mediaPlayer = new MediaPlayer();
                try {
                    mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
                    mediaPlayer.setDataSource("https:" + phoneticList.get(position).getAudioDic());
                    mediaPlayer.prepare();
                    mediaPlayer.start();
                } catch (Exception e){
                    e.printStackTrace();
                    Toast.makeText(ctx, "Cannot Play Audio", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return phoneticList.size();
    }
}
