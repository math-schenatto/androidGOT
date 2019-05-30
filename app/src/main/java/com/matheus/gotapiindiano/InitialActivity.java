package com.matheus.gotapiindiano;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.matheus.gotapiindiano.adapter.LivroAdapter;
import com.matheus.gotapiindiano.banco.BDSQLiteHelper;
import com.matheus.gotapiindiano.banco.BDSQLiteHelperCasa;
import com.matheus.gotapiindiano.banco.BDSQLiteHelperPersonagem;
import com.matheus.gotapiindiano.model.Casa;
import com.matheus.gotapiindiano.model.Livro;
import com.matheus.gotapiindiano.model.Personagem;
import com.matheus.gotapiindiano.network.LivroInterfaceGDS;
import com.matheus.gotapiindiano.network.RetrofitClientLivro;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class InitialActivity extends AppCompatActivity {
    private BDSQLiteHelper bdl;
    private BDSQLiteHelperCasa bdc;
    private BDSQLiteHelperPersonagem bdp;
    ArrayList<Livro> listaLivros;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_initial);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btnPersonagens)
    public void clickPersonagens(View view){
        startActivity(new Intent(InitialActivity.this, PersonagemActivity.class));
    }
    @OnClick(R.id.btnCasas)
    public void clickCasas(View view){
        startActivity(new Intent(InitialActivity.this, CasaActivity.class));
    }
    @OnClick(R.id.btnLivros)
    public void clickLivros(View view) {
        startActivity(new Intent(InitialActivity.this, MainActivity.class));
    }
    @OnClick(R.id.btnDownload)
    public void clickDownload(View view){
        Toast.makeText(
                InitialActivity.this,
                "Carregando...",
                Toast.LENGTH_SHORT).show();
        bdl = new BDSQLiteHelper(InitialActivity.this);
        bdc = new BDSQLiteHelperCasa(InitialActivity.this);
        bdp = new BDSQLiteHelperPersonagem(InitialActivity.this);

        LivroInterfaceGDS service = RetrofitClientLivro.getRetrofitInstanceLivro().create(LivroInterfaceGDS.class);
        Call<List<Livro>> calllivro = service.getAllBooks(1, 8);
        Call<List<Personagem>> callpersonagem = service.getAllCharacters(4,40);
        Call<List<Casa>> callcasa = service.getAllHouses(1, 50);

        calllivro.enqueue(new Callback<List<Livro>>() {
            @Override
            public void onResponse(Call<List<Livro>> call, Response<List<Livro>> response) {

                for (Livro model:response.body()){
                    bdl.addLivro(model);
                }
                Toast.makeText(
                        InitialActivity.this,
                        "Download de livros concluido.",
                        Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onFailure(Call<List<Livro>> call, Throwable t) {
                Toast.makeText(
                        InitialActivity.this,
                        "Você está offline.",
                        Toast.LENGTH_SHORT).show();
            }
        });

        callcasa.enqueue(new Callback<List<Casa>>() {
            @Override
            public void onResponse(Call<List<Casa>> call, Response<List<Casa>> response) {

                for (Casa model:response.body()){
                    bdc.addCasa(model);
                }
                Toast.makeText(
                        InitialActivity.this,
                        "Download de casas concluido.",
                        Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onFailure(Call<List<Casa>> call, Throwable t) {
                Toast.makeText(
                        InitialActivity.this,
                        "Você está offline.",
                        Toast.LENGTH_SHORT).show();
            }
        });

        callpersonagem.enqueue(new Callback<List<Personagem>>() {
            @Override
            public void onResponse(Call<List<Personagem>> call, Response<List<Personagem>> response) {

                for (Personagem model:response.body()){
                    bdp.addPersonagem(model);
                }
                Toast.makeText(
                        InitialActivity.this,
                        "Download de personagens concluido.",
                        Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onFailure(Call<List<Personagem>> call, Throwable t) {
                Toast.makeText(
                        InitialActivity.this,
                        "Você está offline.",
                        Toast.LENGTH_SHORT).show();
            }
        });


    }
    @OnClick(R.id.btnExcluir)
    public void clickExcluir(View view){
        bdl = new BDSQLiteHelper(InitialActivity.this);
        bdc = new BDSQLiteHelperCasa(InitialActivity.this);
        bdp = new BDSQLiteHelperPersonagem(InitialActivity.this);

        ArrayList<Livro> livroList = bdl.getAllLivros();
        for (Livro model:livroList) {
            bdl.deleteLivro(model);

        }
        ArrayList<Casa> casaList = bdc.getAllCasas();
        for (Casa model:casaList) {
            bdc.deleteCasa(model);

        }
        ArrayList<Personagem> personagemList = bdp.getAllPersonagems();
        for (Personagem model:personagemList) {
            bdp.deletePersonagem(model);

        }

        Toast.makeText(
                InitialActivity.this,
                "Todos os registros foram excluidos.",
                Toast.LENGTH_SHORT).show();
    }
}
