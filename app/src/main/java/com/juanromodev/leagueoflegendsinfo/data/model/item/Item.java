package com.juanromodev.leagueoflegendsinfo.data.model.item;

public class Item {

    private String name;
    private String description;
    private String plaintext;
    private String[] from;
    private String[] into;
    private Image image;
    private Gold gold;

    public Item() {

    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getPlaintext() {
        return plaintext;
    }

    public String[] getFrom() {
        return from;
    }

    public String[] getInto() {
        return into;
    }

    public Image getImage() {
        return image;
    }

    public Gold getGold() {
        return gold;
    }
}
