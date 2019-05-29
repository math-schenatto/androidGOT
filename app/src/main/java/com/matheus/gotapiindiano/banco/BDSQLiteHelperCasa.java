package com.matheus.gotapiindiano.banco;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.matheus.gotapiindiano.model.Casa;

import java.util.ArrayList;


public class BDSQLiteHelperCasa extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "CasaDB";
    private static final String TABELA_CASAS = "casas";
    private static final String ID = "id";
    private static final String URL = "url";
    private static final String NAME = "name";
    private static final String REGION = "region";
    private static final String COATOFARMS = "coatOfArms";
    private static final String WORDS = "words";
    private static final String CURRENTLORD = "currentLord";
    private static final String HEIR = "heir";
    private static final String OVERLORD = "overlord";
    private static final String FOUNDED = "founded";
    private static final String FOUNDER = "founder";
    private static final String DIEDOUT = "diedOut";


    private static final String[] COLUNAS = {
            ID,
            URL,
            NAME,
            REGION,
            COATOFARMS,
            WORDS,
            CURRENTLORD,
            HEIR,
            OVERLORD,
            FOUNDED,
            FOUNDER,
            DIEDOUT
    };

    public BDSQLiteHelperCasa(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE casas (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "url TEXT," +
                "name TEXT," +
                "region TEXT," +
                "coatOfArms TEXT," +
                "words TEXT," +
                "currentLord TEXT," +
                "heir TEXT," +
                "overlord TEXT," +
                "founded TEXT," +
                "founder TEXT," +
                "diedOut TEXT)";
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS casas");
        this.onCreate(db);
    }

    public void addCasa(Casa casa) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(URL, casa.getUrl());
        values.put(NAME, casa.getName());
        values.put(REGION, casa.getRegion());
        values.put(COATOFARMS, casa.getCoatOfArms());
        values.put(WORDS, casa.getWords());
        values.put(CURRENTLORD, casa.getCurrentLord());
        values.put(HEIR, casa.getHeir());
        values.put(OVERLORD, casa.getOverlord());
        values.put(FOUNDED, casa.getFounded());
        values.put(FOUNDER, casa.getFounder());
        values.put(DIEDOUT, casa.getDiedOut());
        db.insert(TABELA_CASAS, null, values);
        db.close();
    }

    public Casa getCasa(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABELA_CASAS,
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
            Casa casa = cursorToCasa(cursor);
            return casa;
        }
    }

    private Casa cursorToCasa(Cursor cursor) {
        Casa casa = new Casa();
        casa.setId(Integer.parseInt(cursor.getString(0)));
        casa.setUrl(cursor.getString(1));
        casa.setName(cursor.getString(2));
        casa.setRegion(cursor.getString(3));
        casa.setCoatOfArms(cursor.getString(4));
        casa.setWords(cursor.getString(5));
        casa.setCurrentLord(cursor.getString(6));
        casa.setHeir(cursor.getString(7));
        casa.setOverlord(cursor.getString(8));
        casa.setFounded(cursor.getString(9));
        casa.setFounder(cursor.getString(10));
        casa.setDiedOut(cursor.getString(11));
        return casa;
    }

    public ArrayList<Casa> getAllCasas() {
        ArrayList<Casa> listaCasas = new ArrayList<Casa>();
        String query = "SELECT * FROM " + TABELA_CASAS;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        if (cursor.moveToFirst()) {
            do {
                Casa casa = cursorToCasa(cursor);
                listaCasas.add(casa);
            } while (cursor.moveToNext());
        }
        return listaCasas;
    }

    public int updateCasa(Casa casa) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(URL, casa.getUrl());
        values.put(NAME, casa.getName());
        values.put(REGION, casa.getRegion());
        values.put(COATOFARMS, casa.getCoatOfArms());
        values.put(WORDS, casa.getWords());
        values.put(CURRENTLORD, casa.getCurrentLord());
        values.put(HEIR, casa.getHeir());
        values.put(OVERLORD, casa.getOverlord());
        values.put(FOUNDED, casa.getFounded());
        values.put(FOUNDER, casa.getFounded());
        values.put(DIEDOUT, casa.getDiedOut());

        int i = db.update(TABELA_CASAS, //tabela
                values, // valores
                ID + " = ?", // colunas para comparar
                new String[]{String.valueOf(casa.getId())}); //parâmetros
        db.close();
        return i; // número de linhas modificadas
    }

    public int deleteCasa(Casa casa) {
        SQLiteDatabase db = this.getWritableDatabase();
        int i = db.delete(TABELA_CASAS, //tabela
                ID + " = ?", // colunas para comparar
                new String[]{String.valueOf(casa.getId())});
        db.close();
        return i; // número de linhas excluídas
    }
}
