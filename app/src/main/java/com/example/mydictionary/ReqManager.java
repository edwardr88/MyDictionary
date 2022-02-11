package com.example.mydictionary;

import android.content.Context;
import android.widget.Toast;

import com.example.mydictionary.Models.APIRps;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

public class ReqManager {
    Context context;

    Retrofit retrofit = new Retrofit.Builder().baseUrl("https://api.dictionaryapi.dev/api/v2/")
            .addConverterFactory(GsonConverterFactory.create()).build();

    public ReqManager(Context context) {
        this.context = context;
    }

    public void getWordMeans(OnFetchListener fetchListener, String word){
        CallDic callDic = retrofit.create(CallDic.class);
        Call<List<APIRps>> call = callDic.callMeans(word);
        try {
            call.enqueue(new Callback<List<APIRps>>() {
                @Override
                public void onResponse(Call<List<APIRps>> call, Response<List<APIRps>> response) {
                    if(!response.isSuccessful()){
                        Toast.makeText(context, "Error!", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    fetchListener.onFetch(response.body().get(0), response.message());
                }

                @Override
                public void onFailure(Call<List<APIRps>> call, Throwable t) {
                    fetchListener.onError("Failed");
                }
            });
        } catch (Exception e){
            e.printStackTrace();
            Toast.makeText(context, "There's An Error!", Toast.LENGTH_SHORT).show();
        }
    }

    public interface CallDic {
        @GET("entries/en/{word}")
        Call<List<APIRps>> callMeans(
                @Path("word") String word
        );

    }

}
