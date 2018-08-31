package com.juanromodev.leagueoflegendsinfo.data.model.item;

public class Gold {

    private int base;
    private int total;
    private int sell;
    private boolean purchasable;

    public Gold() {

    }

    public Gold(int base, int total, int sell, boolean purchasable) {
        this.base = base;
        this.total = total;
        this.sell = sell;
        this.purchasable = purchasable;
    }

    public int getBase() {
        return base;
    }

    public int getTotal() {
        return total;
    }

    public int getSell() {
        return sell;
    }

    public boolean isPurchasable() {
        return purchasable;
    }
}
