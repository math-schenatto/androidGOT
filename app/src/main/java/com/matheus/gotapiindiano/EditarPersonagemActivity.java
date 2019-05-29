package com.matheus.gotapiindiano;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.matheus.gotapiindiano.banco.BDSQLiteHelperPersonagem;
import com.matheus.gotapiindiano.model.Personagem;


public class EditarPersonagemActivity extends AppCompatActivity {

    private BDSQLiteHelperPersonagem bd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_personagem);
        Intent intent = getIntent();
        final int id = intent.getIntExtra("ID", 0);
        bd = new BDSQLiteHelperPersonagem(this);
        Personagem personagem = bd.getPersonagem(id);

        final EditText url = (EditText) findViewById(R.id.etURL);
        final EditText name = (EditText) findViewById(R.id.etName);
        final EditText gender = (EditText) findViewById(R.id.etGender);
        final EditText culture = (EditText) findViewById(R.id.etCulture);
        final EditText born = (EditText) findViewById(R.id.etBorn);
        final EditText died = (EditText) findViewById(R.id.etDied);
        final EditText father = (EditText) findViewById(R.id.etFather);
        final EditText mother = (EditText) findViewById(R.id.etMother);
        final EditText spouse = (EditText) findViewById(R.id.etSpouse);

        url.setText(personagem.getUrl());
        name.setText(personagem.getName());
        gender.setText(personagem.getGender());
        culture.setText(personagem.getCulture());
        born.setText(personagem.getBorn());
        died.setText(personagem.getDied());
        father.setText(personagem.getFather());
        mother.setText(personagem.getMother());
        spouse.setText(personagem.getSpouse());

        final Button alterar = (Button) findViewById(R.id.btnAlterar);
        alterar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Personagem personagem = new Personagem();
                personagem.setId(id);
                personagem.setUrl(url.getText().toString());
                personagem.setName(name.getText().toString());
                personagem.setGender(gender.getText().toString());
                personagem.setCulture(culture.getText().toString());
                personagem.setBorn(born.getText().toString());
                personagem.setDied(died.getText().toString());
                personagem.setFather(father.getText().toString());
                personagem.setMother(mother.getText().toString());
                personagem.setSpouse(spouse.getText().toString());

                bd.updatePersonagem(personagem);
                Intent intent = new Intent(EditarPersonagemActivity.this, PersonagemActivity.class);
                startActivity(intent);
            }
        });

        final Button remover = (Button) findViewById(R.id.btnRemover);
        remover.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                new AlertDialog.Builder(EditarPersonagemActivity.this)
                        .setTitle(R.string.confirmar_exclusao)
                        .setMessage(R.string.quer_mesmo_apagar)
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {

                            public void onClick(DialogInterface dialog, int whichButton) {
                                Personagem personagem = new Personagem();
                                personagem.setId(id);
                                bd.deletePersonagem(personagem);
                                Intent intent = new Intent(EditarPersonagemActivity.this, PersonagemActivity.class);
                                startActivity(intent);
                            }
                        })
                        .setNegativeButton(android.R.string.no, null).show();
            }
        });
    }
}
