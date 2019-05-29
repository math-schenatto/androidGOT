package com.matheus.gotapiindiano;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import com.matheus.gotapiindiano.banco.BDSQLiteHelperCasa;
import com.matheus.gotapiindiano.model.Casa;


public class AdicionarCasaActivity extends AppCompatActivity {

    private BDSQLiteHelperCasa bd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adicionar_casa);
        bd = new BDSQLiteHelperCasa(this);

        final EditText url = (EditText) findViewById(R.id.adURL );
        final EditText name = (EditText) findViewById(R.id.adName );
        final EditText region = (EditText) findViewById(R.id.adRegion );
        final EditText coatOfArms = (EditText) findViewById(R.id.adcoatOfArms );
        final EditText words = (EditText) findViewById(R.id.adwords );
        final EditText currentLord = (EditText) findViewById(R.id.adcurrentLord );
        final EditText heir = (EditText) findViewById(R.id.adheir );
        final EditText overlord = (EditText) findViewById(R.id.adoverlord );

        Button novo = (Button) findViewById(R.id.btnAdd);
        novo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Casa casa = new Casa();
                casa.setUrl(url.getText().toString());
                casa.setName(name.getText().toString());
                casa.setRegion(region.getText().toString());
                casa.setCoatOfArms(coatOfArms.getText().toString());
                casa.setWords(words.getText().toString());
                casa.setCurrentLord(currentLord.getText().toString());
                casa.setHeir(heir.getText().toString());
                casa.setOverlord(overlord.getText().toString());

                bd.addCasa(casa);
                Intent intent = new Intent(AdicionarCasaActivity.this,CasaActivity.class);
                startActivity(intent);
            }
        });
    }
}
