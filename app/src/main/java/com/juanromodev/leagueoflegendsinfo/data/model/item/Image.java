package com.juanromodev.leagueoflegendsinfo.data.model.item;

public class Image {

    private String full;
    private String sprite;
    private String group;
    private int x;
    private int y;
    private int w;
    private int h;

    public Image() {

    }

    public Image(String full, String sprite, String group, int x, int y, int w, int h) {
        this.full = full;
        this.sprite = sprite;
        this.group = group;
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }

    public String getFull() {
        return full;
    }

    public String getSprite() {
        return sprite;
    }

    public String getGroup() {
        return group;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getW() {
        return w;
    }

    public int getH() {
        return h;
    }
}
