package com.juanromodev.leagueoflegendsinfo.data.remote;

import com.juanromodev.leagueoflegendsinfo.data.remote.response.ItemResponse;
import com.juanromodev.leagueoflegendsinfo.data.remote.response.RealmResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface DataDragonClient {

    @GET("/realms/{serverCode}.json")
    Call<RealmResponse> getRealm(
            @Path("serverCode") String serverCode
    );

    @GET("/cdn/{dataDragonVersion}/data/{locale}/item.json")
    Call<ItemResponse> getItems(
            @Path("dataDragonVersion") String dataDragonVersion,
            @Path("locale") String locale
    );
}
