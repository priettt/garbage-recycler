package com.unicen.garbage.domain.entities;

public class Recycling {
    private String bottles;
    private String tetrabriks;
    private String glass;
    private String paperboard;
    private String cans;
    private String date;

    public String getBottles() {
        return bottles;
    }

    public void setBottles(String bottles) {
        this.bottles = bottles;
    }

    public String getTetrabriks() {
        return tetrabriks;
    }

    public void setTetrabriks(String tetrabriks) {
        this.tetrabriks = tetrabriks;
    }

    public String getGlass() {
        return glass;
    }

    public void setGlass(String glass) {
        this.glass = glass;
    }

    public String getPaperboard() {
        return paperboard;
    }

    public void setPaperboard(String paperboard) {
        this.paperboard = paperboard;
    }

    public String getCans() {
        return cans;
    }

    public void setCans(String cans) {
        this.cans = cans;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Recycling(String bottles, String tetrabriks, String glass, String paperboard, String cans, String date) {
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
