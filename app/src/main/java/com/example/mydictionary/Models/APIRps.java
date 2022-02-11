package com.example.mydictionary.Models;

import java.util.List;

public class APIRps {
    String word = "";
    List<Phonetics> phonetics = null;
    List<Means> meanings = null;

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public List<Phonetics> getPhonetics() {
        return phonetics;
    }

    public void setPhonetics(List<Phonetics> phonetics) {
        this.phonetics = phonetics;
    }

    public List<Means> getMeanings() {
        return meanings;
    }

    public void setMeanings(List<Means> meanings) {
        this.meanings = meanings;
    }
}
