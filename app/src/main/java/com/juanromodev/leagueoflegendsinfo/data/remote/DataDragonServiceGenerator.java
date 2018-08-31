package com.juanromodev.leagueoflegendsinfo.data.remote;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DataDragonServiceGenerator {

    private static final String DATA_DRAGON_BASE_URL = "https://ddragon.leagueoflegends.com";

    private static Retrofit.Builder builder =
            new Retrofit.Builder()
                    .baseUrl(DATA_DRAGON_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create());

    private static Retrofit retrofit;

    private static OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

    private static HttpLoggingInterceptor httpLoggingInterceptor =
            new HttpLoggingInterceptor()
                    .setLevel(HttpLoggingInterceptor.Level.BODY);

    public static <S> S createService(Class<S> serviceClass) {
        if (!httpClient.interceptors().contains(httpLoggingInterceptor)) {
            httpClient.addInterceptor(httpLoggingInterceptor);

            builder.client(httpClient.build());
            retrofit = builder.build();
        }

        return retrofit.create(serviceClass);
    }
}
