package com.matheus.gotapiindiano;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class InitialActivity extends AppCompatActivity {

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
    public void clickLivros(View view){
        startActivity(new Intent(InitialActivity.this, MainActivity.class));
    }
}
