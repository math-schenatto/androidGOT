package com.matheus.gotapiindiano;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.matheus.gotapiindiano.adapter.LivroAdapter;
import com.matheus.gotapiindiano.model.Livro;
import com.matheus.gotapiindiano.network.LivroInterfaceGDS;
import com.matheus.gotapiindiano.network.RetrofitClientLivro;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private LivroAdapter adapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // CRIANDO RETROFIT INTERFACE
        LivroInterfaceGDS service = RetrofitClientLivro.getRetrofitInstanceLivro().create(LivroInterfaceGDS.class);
        Call<List<Livro>> call = service.getAllBooks(1, 8);
        call.enqueue(new Callback<List<Livro>>() {
            @Override
            public void onResponse(Call<List<Livro>> call, Response<List<Livro>> response) {
                generateDataList(response.body());
            }

            @Override
            public void onFailure(Call<List<Livro>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });
    }
        private void generateDataList(List<Livro> livroList){
            recyclerView = findViewById(R.id.customRecyclerView);
            adapter = new LivroAdapter(this, livroList);
            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
            recyclerView.setLayoutManager(layoutManager);
            recyclerView.setAdapter(adapter);
        }



}
