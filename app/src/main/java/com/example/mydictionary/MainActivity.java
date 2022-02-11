package com.example.mydictionary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mydictionary.Adapter.MeaningADP;
import com.example.mydictionary.Adapter.PhoneticsADP;
import com.example.mydictionary.Models.APIRps;

public class MainActivity extends AppCompatActivity {

    SearchView searchView;
    TextView txtWord;
    RecyclerView rvPhonetics;
    RecyclerView rvMeans;
    ProgressDialog progressDialog;
    PhoneticsADP phoneticsADP;
    MeaningADP meaningADP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        searchView = findViewById(R.id.searchView);
        txtWord = findViewById(R.id.txtWord);
        rvPhonetics = findViewById(R.id.rvPhonetics);
        rvMeans = findViewById(R.id.rvMeans);
        progressDialog = new ProgressDialog(this);

        progressDialog.setTitle("Load...");
        progressDialog.show();
        ReqManager reqManager = new ReqManager(MainActivity.this);
        reqManager.getWordMeans(listener, "Hello");

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                progressDialog.setTitle("Fetching for " + s);
                progressDialog.show();
                ReqManager reqManager = new ReqManager(MainActivity.this);
                reqManager.getWordMeans(listener, s);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                return false;
            }
        });
    }

    private final OnFetchListener listener = new OnFetchListener() {
        @Override
        public void onFetch(APIRps apiRps, String msg) {
            progressDialog.dismiss();
            if(apiRps == null){
                Toast.makeText(MainActivity.this, "No Data Here..", Toast.LENGTH_SHORT).show();
                return;
            }
            showData(apiRps);
        }

        @Override
        public void onError(String msg) {
            progressDialog.dismiss();
            Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
        }
    };

    private void showData(APIRps apiRps) {
        txtWord.setText("Word: " + apiRps.getWord());
        rvPhonetics.setHasFixedSize(true);
        rvPhonetics.setLayoutManager(new GridLayoutManager(this, 1));
        phoneticsADP = new PhoneticsADP(this, apiRps.getPhonetics());
        rvPhonetics.setAdapter(phoneticsADP);

        rvMeans.setHasFixedSize(true);
        rvMeans.setLayoutManager(new GridLayoutManager(this, 1));
        meaningADP = new MeaningADP(this, apiRps.getMeanings());
        rvMeans.setAdapter(meaningADP);

    }

}