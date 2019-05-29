package com.matheus.gotapiindiano;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.matheus.gotapiindiano.adapter.PersonagemAdapter;

import com.matheus.gotapiindiano.banco.BDSQLiteHelperPersonagem;
import com.matheus.gotapiindiano.model.Personagem;
import com.matheus.gotapiindiano.network.LivroInterfaceGDS;
import com.matheus.gotapiindiano.network.RetrofitClientLivro;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PersonagemActivity extends AppCompatActivity {

    private PersonagemAdapter adapter;
    private RecyclerView recyclerView;
    private BDSQLiteHelperPersonagem bd;

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
                generateDataListOnline(response.body());
            }

            @Override
            public void onFailure(Call<List<Personagem>> call, Throwable t) {
                Toast.makeText(
                        PersonagemActivity.this,
                        "Você está offline. Mostrando registros salvos em banco.",
                        Toast.LENGTH_SHORT).show();
                generateDataListOffline();

            }
        });
    }
    private void generateDataListOffline() {

        bd = new BDSQLiteHelperPersonagem(PersonagemActivity.this);
        recyclerView = findViewById(R.id.customRecyclerPersonagem);
        final ArrayList<Personagem> personagemList = bd.getAllPersonagems();
        adapter = new PersonagemAdapter(this, personagemList);
        adapter.setOnItemClickListener(new PersonagemAdapter.ClickListener() {
            @Override
            public void onItemClick(int position, View v) {
                Intent intent = new Intent(PersonagemActivity.this, EditarPersonagemActivity.class);
                intent.putExtra("ID", personagemList.get(position).getId());
                startActivity(intent);
                Log.d("a", "onItemClick position: " + position);
            }

            @Override
            public void onItemLongClick(int position, View v) {
                Log.d("a", "onItemLongClick pos = " + position);
            }});
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(PersonagemActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PersonagemActivity.this, AdicionarPersonagemActivity.class);
                startActivity(intent);
            }
        });

    }
    private void generateDataListOnline(List<Personagem> personagemList){
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.hide();
        recyclerView = findViewById(R.id.customRecyclerPersonagem);
        adapter = new PersonagemAdapter(this, personagemList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(PersonagemActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }
}
