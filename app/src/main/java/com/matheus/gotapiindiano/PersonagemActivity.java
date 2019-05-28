package com.matheus.gotapiindiano;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.matheus.gotapiindiano.adapter.PersonagemAdapter;
import com.matheus.gotapiindiano.model.Personagem;
import com.matheus.gotapiindiano.network.LivroInterfaceGDS;
import com.matheus.gotapiindiano.network.RetrofitClientLivro;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PersonagemActivity extends AppCompatActivity {

    private PersonagemAdapter adapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personagem);

        //criando retrofit instance

        LivroInterfaceGDS service = RetrofitClientLivro.getRetrofitInstanceLivro().create(LivroInterfaceGDS.class);
        Call<List<Personagem>> call = service.getAllCharacters(4,40);
        call.enqueue(new Callback<List<Personagem>>() {
            @Override
            public void onResponse(Call<List<Personagem>> call, Response<List<Personagem>> response) {
                generateDataList(response.body());
            }

            @Override
            public void onFailure(Call<List<Personagem>> call, Throwable t) {
                Toast.makeText(PersonagemActivity.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void generateDataList(List<Personagem> personagemList){
        recyclerView = findViewById(R.id.customRecyclerPersonagem);
        adapter = new PersonagemAdapter(this, personagemList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(PersonagemActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }
}
