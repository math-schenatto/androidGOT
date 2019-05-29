package com.matheus.gotapiindiano;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.matheus.gotapiindiano.banco.BDSQLiteHelperCasa;
import com.matheus.gotapiindiano.model.Casa;


public class EditarCasaActivity extends AppCompatActivity {

    private BDSQLiteHelperCasa bd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_casa);
        Intent intent = getIntent();
        final int id = intent.getIntExtra("ID", 0);
        bd = new BDSQLiteHelperCasa(this);
        Casa casa = bd.getCasa(id);

        final EditText url = (EditText) findViewById(R.id.etURL );
        final EditText name = (EditText) findViewById(R.id.etName );
        final EditText region = (EditText) findViewById(R.id.etRegion );
        final EditText coatOfArms = (EditText) findViewById(R.id.etcoatOfArms );
        final EditText words = (EditText) findViewById(R.id.etwords );
        final EditText currentLord = (EditText) findViewById(R.id.etcurrentLord );
        final EditText heir = (EditText) findViewById(R.id.etheir );
        final EditText overlord = (EditText) findViewById(R.id.etoverlord );

        url.setText(casa.getUrl());
        name.setText(casa.getName());
        region.setText(casa.getRegion());
        coatOfArms.setText(casa.getCoatOfArms());
        words.setText(casa.getWords());
        currentLord.setText(casa.getCurrentLord());
        heir.setText(casa.getHeir());
        overlord.setText(casa.getOverlord());

        final Button alterar = (Button) findViewById(R.id.btnAlterar);
        alterar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Casa casa = new Casa();
                casa.setId(id);
                casa.setUrl(url.getText().toString());
                casa.setName(name.getText().toString());
                casa.setRegion(region.getText().toString());
                casa.setCoatOfArms(coatOfArms.getText().toString());
                casa.setWords(words.getText().toString());
                casa.setCurrentLord(currentLord.getText().toString());
                casa.setHeir(heir.getText().toString());
                casa.setOverlord(overlord.getText().toString());
                bd.updateCasa(casa);
                Intent intent = new Intent(EditarCasaActivity.this, CasaActivity.class);
                startActivity(intent);
            }
        });

        final Button remover = (Button) findViewById(R.id.btnRemover);
        remover.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                new AlertDialog.Builder(EditarCasaActivity.this)
                        .setTitle(R.string.confirmar_exclusao)
                        .setMessage(R.string.quer_mesmo_apagar)
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {

                            public void onClick(DialogInterface dialog, int whichButton) {
                                Casa casa = new Casa();
                                casa.setId(id);
                                bd.deleteCasa(casa);
                                Intent intent = new Intent(EditarCasaActivity.this, CasaActivity.class);
                                startActivity(intent);
                            }
                        })
                        .setNegativeButton(android.R.string.no, null).show();
            }
        });
    }
}
