package com.matheus.gotapiindiano.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClientLivro {

    private static Retrofit retrofit;
    private static final String BASE_URL = "https://www.anapioficeandfire.com/api/";

    public static Retrofit getRetrofitInstanceLivro(){
        if (retrofit == null){
            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit;
    }
}
