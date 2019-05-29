package com.matheus.gotapiindiano;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import com.matheus.gotapiindiano.banco.BDSQLiteHelperPersonagem;
import com.matheus.gotapiindiano.model.Personagem;


public class AdicionarPersonagemActivity extends AppCompatActivity {

    private BDSQLiteHelperPersonagem bd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adicionar_personagem);
        bd = new BDSQLiteHelperPersonagem(this);
        final EditText url = (EditText) findViewById(R.id.adURL);
        final EditText name = (EditText) findViewById(R.id.adName);
        final EditText gender = (EditText) findViewById(R.id.adGender);
        final EditText culture = (EditText) findViewById(R.id.adCulture);
        final EditText born = (EditText) findViewById(R.id.adBorn);
        final EditText died = (EditText) findViewById(R.id.adDied);
        final EditText father = (EditText) findViewById(R.id.adFather);
        final EditText mother = (EditText) findViewById(R.id.adMother);
        final EditText spouse = (EditText) findViewById(R.id.adSpouse);
      
        Button novo = (Button) findViewById(R.id.btnAdd);
        novo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Personagem personagem = new Personagem();
                personagem.setUrl(url .getText().toString());
                personagem.setName(name .getText().toString());
                personagem.setGender(gender .getText().toString());
                personagem.setCulture(culture .getText().toString());
                personagem.setBorn(born .getText().toString());
                personagem.setDied(died .getText().toString());
                personagem.setFather(father .getText().toString());
                personagem.setMother(mother .getText().toString());
                personagem.setSpouse(spouse .getText().toString());
                bd.addPersonagem(personagem) ;
                Intent intent = new Intent(AdicionarPersonagemActivity.this,PersonagemActivity.class);
                startActivity(intent);
            }
        });
    }
}
