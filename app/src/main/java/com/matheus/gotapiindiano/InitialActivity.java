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
import com.matheus.gotapiindiano.model.Casa;
import com.matheus.gotapiindiano.model.Livro;
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
    private BDSQLiteHelper bd;
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
        bd = new BDSQLiteHelper(InitialActivity.this);
        // CRIANDO RETROFIT INTERFACE
        LivroInterfaceGDS service = RetrofitClientLivro.getRetrofitInstanceLivro().create(LivroInterfaceGDS.class);
        Call<List<Livro>> call = service.getAllBooks(1, 8);

        call.enqueue(new Callback<List<Livro>>() {
            @Override
            public void onResponse(Call<List<Livro>> call, Response<List<Livro>> response) {

                for (Livro model:response.body()){
                    bd.addLivro(model);
                }
                Toast.makeText(
                        InitialActivity.this,
                        "Download concluido.",
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


    }
    @OnClick(R.id.btnExcluir)
    public void clickExcluir(View view){
        bd = new BDSQLiteHelper(InitialActivity.this);
        ArrayList<Livro> livroList = bd.getAllLivros();
        for (Livro model:livroList) {
            bd.deleteLivro(model);

        }
    }
}
