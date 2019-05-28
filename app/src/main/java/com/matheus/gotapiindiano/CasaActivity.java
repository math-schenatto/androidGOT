package com.matheus.gotapiindiano;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.ListPopupWindow;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.matheus.gotapiindiano.adapter.CasaAdapter;
import com.matheus.gotapiindiano.model.Casa;
import com.matheus.gotapiindiano.network.LivroInterfaceGDS;
import com.matheus.gotapiindiano.network.RetrofitClientLivro;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CasaActivity extends AppCompatActivity {

    private CasaAdapter adapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_casa);

        // criando retrofit interface
        LivroInterfaceGDS service = RetrofitClientLivro.getRetrofitInstanceLivro().create(LivroInterfaceGDS.class);
        Call<List<Casa>> call = service.getAllHouses(1,50);
        call.enqueue(new Callback<List<Casa>>() {
            @Override
            public void onResponse(Call<List<Casa>> call, Response<List<Casa>> response) {
                generateDataList(response.body());
            }

            @Override
            public void onFailure(Call<List<Casa>> call, Throwable t) {
                Toast.makeText(CasaActivity.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void generateDataList(List<Casa> casaList){
        recyclerView = findViewById(R.id.customRecyclerCasa);
        adapter = new CasaAdapter(this, casaList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(CasaActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }
}
