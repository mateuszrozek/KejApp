package com.example.kejapp.utils;

public class Deck {

    private int id;
    private int totalQuays;
    private int freeQuays;
    private boolean isFree;

    public Deck(int id, int totalQuays) {
        this.id = id;
        this.totalQuays = totalQuays;
        freeQuays = totalQuays;
        isFree = true;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTotalQuays() {
        return totalQuays;
    }

    public void setTotalQuays(int totalQuays) {
        this.totalQuays = totalQuays;
    }

    public int getFreeQuays() {
        return freeQuays;
    }

    public void setFreeQuays(int freeQuays) {
        this.freeQuays = freeQuays;
    }

    public boolean isFree() {
        return isFree;
    }

    public void setFree(boolean free) {
        isFree = free;
    }
}
