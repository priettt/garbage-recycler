package com.unicen.garbage.domain.entities;

import android.support.annotation.NonNull;

public class Recycling {
    private String bottles;
    private String tetrabriks;
    private String glass;
    private String paperboard;
    private String cans;
    private String date;

    @NonNull
    public String getBottles() {
        return bottles == null ? "" : bottles;
    }

    @NonNull
    public String getTetrabriks() {
        return tetrabriks == null ? "" : tetrabriks;
    }

    @NonNull
    public String getGlass() {
        return glass == null ? "" : glass;
    }

    @NonNull
    public String getPaperboard() {
        return paperboard == null ? "" : paperboard;
    }

    @NonNull
    public String getCans() {
        return cans == null ? "" : cans;
    }

    @NonNull
    public String getDate() {
        return date == null ? "" : date;
    }

    public Recycling(@NonNull String bottles, @NonNull String tetrabriks, @NonNull String glass, @NonNull String paperboard,
                     @NonNull String cans, @NonNull String date) {
        this.bottles = bottles;
        this.tetrabriks = tetrabriks;
        this.glass = glass;
        this.paperboard = paperboard;
        this.cans = cans;
        this.date = date;
    }

    public String getRecyclingString() {
        return "Bottles: " + bottles + ". Tetrabriks: " + tetrabriks + ". Glass: " + glass + ". Paperboard: " + paperboard
                + ". Cans: " + cans + ".";
    }
}
