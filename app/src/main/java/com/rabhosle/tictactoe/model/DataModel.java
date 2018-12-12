package com.rabhosle.tictactoe.model;

/**
 * Created by rabhosle on 12/12/2018.
 */

public class DataModel {

    public String text;
    public int index;
    public String color;
    public boolean isPlayed;

    public DataModel(String text, int index, String color, boolean isPlayed) {
        this.text = text;
        this.index = index;
        this.color = color;
        this.isPlayed = isPlayed;
    }
}
