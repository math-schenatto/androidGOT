package com.matheus.gotapiindiano;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import com.matheus.gotapiindiano.banco.BDSQLiteHelper;
import com.matheus.gotapiindiano.model.Livro;


public class AdicionarLivroActivity extends AppCompatActivity {

    private BDSQLiteHelper bd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adicionar_livro);
        bd = new BDSQLiteHelper(this);

        final EditText url = (EditText) findViewById(R.id.adURL );
        final EditText name = (EditText) findViewById(R.id.adName );
        final EditText isbn = (EditText) findViewById(R.id.adIsbn );
        final EditText country = (EditText) findViewById(R.id.adCountry );
        final EditText publisher = (EditText) findViewById(R.id.adPublisher );
        final EditText mediatype = (EditText) findViewById(R.id.adMediaType );
        final EditText released = (EditText) findViewById(R.id.adReleased );
        final EditText numberofpages = (EditText) findViewById(R.id.adNumberOfPages );

        Button novo = (Button) findViewById(R.id.btnAdd);
        novo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Livro livro = new Livro();
                livro.setUrl(url.getText().toString());
                livro.setName(name.getText().toString());
                livro.setIsbn(isbn.getText().toString());
                livro.setCountry(country.getText().toString());
                livro.setPublisher(publisher.getText().toString());
                livro.setMediaType(mediatype.getText().toString());
                livro.setReleased(released.getText().toString());
                livro.setNumberOfPages(Integer.parseInt(numberofpages.getText().toString()));
                bd.addLivro(livro);
                Intent intent = new Intent(AdicionarLivroActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
