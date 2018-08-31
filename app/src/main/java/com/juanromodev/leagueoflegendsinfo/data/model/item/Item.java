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

    public Item(String name, String description, String plaintext, String[] from, String[] into,
                Image image, Gold gold) {
        this.name = name;
        this.description = description;
        this.plaintext = plaintext;
        this.from = from;
        this.into = into;
        this.image = image;
        this.gold = gold;
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
