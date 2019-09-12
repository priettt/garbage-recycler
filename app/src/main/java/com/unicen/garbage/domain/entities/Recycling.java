package com.unicen.garbage.domain.entities;

import androidx.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Recycling {
    @SerializedName("bottles") @Expose private Integer bottles;
    @SerializedName("tetrabriks") @Expose private Integer tetrabriks;
    @SerializedName("cans") @Expose private Integer cans;
    @SerializedName("paperboard") @Expose private Integer paperboard;
    @SerializedName("glass") @Expose private Integer glass;
    @SerializedName("username") @Expose private String username;
    @SerializedName("date") @Expose private String date;

    public Recycling(Integer bottles, Integer tetrabriks, Integer cans, Integer paperboard, Integer glass, String username, String date) {
        this.bottles = bottles;
        this.tetrabriks = tetrabriks;
        this.cans = cans;
        this.paperboard = paperboard;
        this.glass = glass;
        this.username = username;
        this.date = date;
    }

    public Integer getBottles() {
        return bottles;
    }

    public void setBottles(Integer bottles) {
        this.bottles = bottles;
    }

    public Integer getTetrabriks() {
        return tetrabriks;
    }

    public void setTetrabriks(Integer tetrabriks) {
        this.tetrabriks = tetrabriks;
    }

    public Integer getCans() {
        return cans;
    }

    public void setCans(Integer cans) {
        this.cans = cans;
    }

    public Integer getPaperboard() {
        return paperboard;
    }

    public void setPaperboard(Integer paperboard) {
        this.paperboard = paperboard;
    }

    public Integer getGlass() {
        return glass;
    }

    public void setGlass(Integer glass) {
        this.glass = glass;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @NonNull
    @Override
    public String toString() {
        return "Bottles: " + bottles + ". Tetrabriks: " + tetrabriks + ". Glass: " + glass + ". Paperboard: " + paperboard
                + ". Cans: " + cans + ".";
    }
}
