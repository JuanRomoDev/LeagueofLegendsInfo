package com.juanromodev.leagueoflegendsinfo.data.remote;

import com.juanromodev.leagueoflegendsinfo.data.remote.response.ItemResponse;
import com.juanromodev.leagueoflegendsinfo.data.remote.response.RealmResponse;

import io.reactivex.Single;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface DataDragonClient {

    String DATA_DRAGON_BASE_URL = "https://ddragon.leagueoflegends.com";

    @GET("/realms/{serverCode}.json")
    Single<RealmResponse> getRealm(
            @Path("serverCode") String serverCode
    );

    @GET("/cdn/{dataDragonVersion}/data/{locale}/item.json")
    Single<ItemResponse> getItems(
            @Path("dataDragonVersion") String dataDragonVersion,
            @Path("locale") String locale
    );

    class Factory {

        public static DataDragonClient getDataDragonClient() {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(DATA_DRAGON_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();

            return retrofit.create(DataDragonClient.class);
        }
    }
}
