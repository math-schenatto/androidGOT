package com.matheus.gotapiindiano;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.ListPopupWindow;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.support.v7.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.matheus.gotapiindiano.adapter.CasaAdapter;
import com.matheus.gotapiindiano.model.Casa;
import com.matheus.gotapiindiano.network.LivroInterfaceGDS;
import com.matheus.gotapiindiano.network.RetrofitClientLivro;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CasaActivity extends AppCompatActivity {
    SearchView searchView;
    private CasaAdapter adapter;
    private RecyclerView recyclerView;
    List<Casa> listaDeCasas = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_casa);

        // criando retrofit interface
        LivroInterfaceGDS service = RetrofitClientLivro.getRetrofitInstanceLivro().create(LivroInterfaceGDS.class);
        Call<List<Casa>>  call = service.getAllHouses(1,50);
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
        listaDeCasas = casaList;
        recyclerView = findViewById(R.id.customRecyclerCasa);
        adapter = new CasaAdapter(this, casaList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(CasaActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.searchfile,menu);
        final MenuItem mayActionMenuItem = menu.findItem(R.id.search);

        searchView = (SearchView) mayActionMenuItem.getActionView();
        //changeSearchViewTextColor(searchView);
        ((EditText) searchView.findViewById(android.support.v7.appcompat.R.id.search_src_text)).setHintTextColor(getResources().getColor(R.color.colorWhite));
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                if(!searchView.isIconified()){
                    searchView.setIconified(true);
                }
                mayActionMenuItem.collapseActionView();

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                final List<Casa> filteredmodelist = filter(listaDeCasas, newText);

                adapter.setfilter(filteredmodelist);
                return true;
            }
        });

        return true;
    }

    private List<Casa> filter(List<Casa> p1, String query){
        query=query.toLowerCase();
        final List<Casa> filteredModelList = new ArrayList<>();
        for (Casa model:p1){
            final String text = model.getName().toLowerCase();
            if(text.startsWith(query)){
                filteredModelList.add(model);

            }
        }
        return filteredModelList;
    }

    private void changeSearchViewTextColor(View view){
        if (view != null){
            if(view instanceof TextView){
                ((TextView)view).setTextColor(Color.WHITE);
                return;
            } else if (view instanceof ViewGroup){
                ViewGroup viewGroup = (ViewGroup) view;
                for (int i=0; i<viewGroup.getChildCount();i++){
                    changeSearchViewTextColor(viewGroup.getChildAt(i));
                }

            }
        }
    }
}
