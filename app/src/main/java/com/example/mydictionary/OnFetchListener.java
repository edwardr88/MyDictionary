package com.example.mydictionary;

import com.example.mydictionary.Models.APIRps;

public interface OnFetchListener {
    void onFetch(APIRps apiRps, String msg);
    void onError(String msg);
}
