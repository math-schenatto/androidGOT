package com.matheus.gotapiindiano.network;

import com.matheus.gotapiindiano.model.Livro;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface LivroInterfaceGDS {

    @GET("books/")
    Call<List<Livro>> getAllBooks(@Query("page") int page, @Query("pageSize")int pageSize);
}
