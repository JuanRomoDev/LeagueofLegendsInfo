package com.juanromodev.leagueoflegendsinfo.data.remote.response;

import com.juanromodev.leagueoflegendsinfo.data.model.item.Item;

import java.util.Map;

public class ItemResponse {

    private Map<String, Item> data;

    public ItemResponse() {

    }

    public Map<String, Item> getData() {
        return data;
    }
}
