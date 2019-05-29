package com.matheus.gotapiindiano.banco;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.matheus.gotapiindiano.model.Personagem;

import java.util.ArrayList;


public class BDSQLiteHelperPersonagem extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "PersonagemDB";
    private static final String TABELA_PERSONAGENS = "personagens";
    private static final String ID = "id";
    private static final String URL = "url";
    private static final String NAME = "name";
    private static final String GENDER = "gender";
    private static final String CULTURE = "culture";
    private static final String BORN = "born";
    private static final String DIED = "died";
    private static final String FATHER = "father";
    private static final String MOTHER = "mother";
    private static final String SPOUSE = "spouse";


    private static final String[] COLUNAS = {
            ID,
            URL,
            NAME,
            GENDER,
            CULTURE,
            BORN,
            DIED,
            FATHER,
            MOTHER,
            SPOUSE,
    };

    public BDSQLiteHelperPersonagem(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE personagens (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "url TEXT," +
                "name TEXT," +
                "gender TEXT," +
                "culture TEXT," +
                "born TEXT," +
                "died TEXT," +
                "father TEXT," +
                "mother TEXT," +
                "spouse TEXT)";
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS personagens");
        this.onCreate(db);
    }

    public void addPersonagem(Personagem personagem) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(URL, personagem.getUrl());
        values.put(NAME, personagem.getName());
        values.put(GENDER, personagem.getGender());
        values.put(CULTURE, personagem.getCulture());
        values.put(BORN, personagem.getBorn());
        values.put(DIED, personagem.getDied());
        values.put(FATHER, personagem.getFather());
        values.put(MOTHER, personagem.getMother());
        values.put(SPOUSE, personagem.getSpouse());
        db.insert(TABELA_PERSONAGENS, null, values);
        db.close();
    }

    public Personagem getPersonagem(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABELA_PERSONAGENS,
                COLUNAS,
                " id = ?",
                new String[]{String.valueOf(id)},
                null,
                null,
                null,
                null);
        if (cursor == null) {
            return null;
        } else {
            cursor.moveToFirst();
            Personagem personagem = cursorToPersonagem(cursor);
            return personagem;
        }
    }

    private Personagem cursorToPersonagem(Cursor cursor) {
        Personagem personagem = new Personagem();
        personagem.setId(Integer.parseInt(cursor.getString(0)));
        personagem.setUrl(cursor.getString(1));
        personagem.setName(cursor.getString(2));
        personagem.setGender(cursor.getString(3));
        personagem.setCulture(cursor.getString(4));
        personagem.setBorn(cursor.getString(5));
        personagem.setDied(cursor.getString(6));
        personagem.setFather(cursor.getString(7));
        personagem.setMother(cursor.getString(8));
        personagem.setSpouse(cursor.getString(9));
        return personagem;
    }

    public ArrayList<Personagem> getAllPersonagems() {
        ArrayList<Personagem> listaPersonagems = new ArrayList<Personagem>();
        String query = "SELECT * FROM " + TABELA_PERSONAGENS;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        if (cursor.moveToFirst()) {
            do {
                Personagem personagem = cursorToPersonagem(cursor);
                listaPersonagems.add(personagem);
            } while (cursor.moveToNext());
        }
        return listaPersonagems;
    }

    public int updatePersonagem(Personagem personagem) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(URL, personagem.getUrl());
        values.put(NAME, personagem.getName());
        values.put(GENDER, personagem.getGender());
        values.put(CULTURE, personagem.getCulture());
        values.put(BORN, personagem.getBorn());
        values.put(DIED, personagem.getDied());
        values.put(FATHER, personagem.getFather());
        values.put(MOTHER, personagem.getMother());
        values.put(SPOUSE, personagem.getSpouse());

        int i = db.update(TABELA_PERSONAGENS, //tabela
                values, // valores
                ID + " = ?", // colunas para comparar
                new String[]{String.valueOf(personagem.getId())}); //parâmetros
        db.close();
        return i; // número de linhas modificadas
    }

    public int deletePersonagem(Personagem personagem) {
        SQLiteDatabase db = this.getWritableDatabase();
        int i = db.delete(TABELA_PERSONAGENS, //tabela
                ID + " = ?", // colunas para comparar
                new String[]{String.valueOf(personagem.getId())});
        db.close();
        return i; // número de linhas excluídas
    }
}
