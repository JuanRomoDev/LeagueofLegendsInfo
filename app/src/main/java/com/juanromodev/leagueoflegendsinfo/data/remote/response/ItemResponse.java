package com.juanromodev.leagueoflegendsinfo.data.remote.response;

import com.google.gson.annotations.SerializedName;
import com.juanromodev.leagueoflegendsinfo.data.model.item.Item;

import java.util.Map;

public class ItemResponse {

    @SerializedName("data")
    private Map<String, Item> items;

    public ItemResponse() {

    }

    public Map<String, Item> getItems() {
        return items;
    }
}
