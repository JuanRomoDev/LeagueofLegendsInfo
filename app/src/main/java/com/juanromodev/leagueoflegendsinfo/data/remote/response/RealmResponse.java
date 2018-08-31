package com.juanromodev.leagueoflegendsinfo.data.remote.response;

import com.google.gson.annotations.SerializedName;

public class RealmResponse {

    @SerializedName("dd")
    private String dataDragonVersion;
    @SerializedName("l")
    private String locale;

    public RealmResponse() {

    }

    public String getDataDragonVersion() {
        return dataDragonVersion;
    }

    public String getLocale() {
        return locale;
    }
}
