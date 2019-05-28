package com.matheus.gotapiindiano;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.matheus.gotapiindiano.banco.BDSQLiteHelper;
import com.matheus.gotapiindiano.model.Livro;


public class EditarLivroActivity extends AppCompatActivity {

    private BDSQLiteHelper bd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_livro);
        Intent intent = getIntent();
        final int id = intent.getIntExtra("ID", 0);
        bd = new BDSQLiteHelper(this);
        Livro livro = bd.getLivro(id);

        final EditText url = (EditText) findViewById(R.id.etURL );
        final EditText name = (EditText) findViewById(R.id.etName );
        final EditText isbn = (EditText) findViewById(R.id.etIsbn );
        final EditText country = (EditText) findViewById(R.id.etCountry );
        final EditText publisher = (EditText) findViewById(R.id.etPublisher );
        final EditText mediatype = (EditText) findViewById(R.id.etMediaType );
        final EditText released = (EditText) findViewById(R.id.etReleased );
        final EditText numberofpages = (EditText) findViewById(R.id.etNumberOfPages );

        url.setText(livro.getUrl());
        name.setText(livro.getName());
        isbn.setText(livro.getIsbn());
        country.setText(livro.getCountry());
        publisher.setText(livro.getPublisher());
        mediatype.setText(livro.getMediaType());
        released.setText(livro.getReleased());
        numberofpages.setText(String.valueOf(livro.getNumberOfPages()));

        final Button alterar = (Button) findViewById(R.id.btnAlterar);
        alterar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Livro livro = new Livro();
                livro.setId(id);

                livro.setUrl(url.getText().toString());
                livro.setName(name.getText().toString());
                livro.setIsbn(isbn.getText().toString());
                livro.setCountry(country.getText().toString());
                livro.setPublisher(publisher.getText().toString());
                livro.setMediaType(mediatype.getText().toString());
                livro.setReleased(released.getText().toString());
                livro.setNumberOfPages(Integer.parseInt(numberofpages.getText().toString()));
                bd.updateLivro(livro);
                Intent intent = new Intent(EditarLivroActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        final Button remover = (Button) findViewById(R.id.btnRemover);
        remover.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                new AlertDialog.Builder(EditarLivroActivity.this)
                        .setTitle(R.string.confirmar_exclusao)
                        .setMessage(R.string.quer_mesmo_apagar)
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {

                            public void onClick(DialogInterface dialog, int whichButton) {
                                Livro livro = new Livro();
                                livro.setId(id);
                                bd.deleteLivro(livro);
                                Intent intent = new Intent(EditarLivroActivity.this, MainActivity.class);
                                startActivity(intent);
                            }
                        })
                        .setNegativeButton(android.R.string.no, null).show();
            }
        });
    }
}
