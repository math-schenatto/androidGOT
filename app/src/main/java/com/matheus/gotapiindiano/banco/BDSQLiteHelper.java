package com.matheus.gotapiindiano.banco;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;


import com.matheus.gotapiindiano.InitialActivity;
import com.matheus.gotapiindiano.model.Livro;

import java.util.ArrayList;


public class BDSQLiteHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "LivroDB";
    private static final String TABELA_LIVROS = "livros";

    private static final String ID = "id";
    private static final String URL = "url";
    private static final String NAME = "name";
    private static final String ISBN = "isbn";
    private static final String COUNTRY = "country";
    private static final String PUBLISHER = "publisher";
    private static final String MEDIATYPE = "mediatype";
    private static final String RELEASED = "released";
    private static final String NUMBEROFPAGES = "numberofpages";

    private static final String[] COLUNAS = {
            ID,
            URL,
            NAME,
            ISBN,
            COUNTRY,
            PUBLISHER,
            MEDIATYPE,
            RELEASED,
            NUMBEROFPAGES};

    public BDSQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE livros ("+
                "id INTEGER PRIMARY KEY AUTOINCREMENT,"+
                "url TEXT,"+
                "name TEXT,"+
                "isbn TEXT,"+
                "country TEXT,"+
                "publisher TEXT,"+
                "mediatype TEXT,"+
                "released TEXT,"+
                "numberofpages INTEGER)";
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS livros");
        this.onCreate(db);
    }

    public void addLivro(Livro livro) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(URL, livro.getUrl());
        values.put(NAME, livro.getName());
        values.put(ISBN, livro.getIsbn());
        values.put(PUBLISHER, livro.getPublisher());
        values.put(COUNTRY, livro.getCountry());
        values.put(MEDIATYPE, livro.getMediaType());
        values.put(RELEASED, livro.getReleased());
        values.put(NUMBEROFPAGES, new Integer(livro.getNumberOfPages()));
        db.insert(TABELA_LIVROS, null, values);
        db.close();
    }

    public Livro getLivro(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABELA_LIVROS,
                COLUNAS,
                " id = ?",
                new String[] { String.valueOf(id) },
                null,
                null,
                null,
                null);
        if (cursor == null) {
            return null;
        } else {
            cursor.moveToFirst();
            Livro livro = cursorToLivro(cursor);
            return livro;
        }
    }

    private Livro cursorToLivro(Cursor cursor) {
        Livro livro = new Livro();
        livro.setId(Integer.parseInt(cursor.getString(0)));
        livro.setUrl(cursor.getString(1));
        livro.setName(cursor.getString(2));
        livro.setIsbn(cursor.getString(3));
        livro.setCountry(cursor.getString(4));
        livro.setPublisher(cursor.getString(5));
        livro.setMediaType(cursor.getString(6));
        livro.setReleased(cursor.getString(7));
        livro.setNumberOfPages(Integer.parseInt(cursor.getString(8)));
        return livro;
    }

    public ArrayList<Livro> getAllLivros() {
        ArrayList<Livro> listaLivros = new ArrayList<Livro>();
        String query = "SELECT * FROM " + TABELA_LIVROS;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        if (cursor.moveToFirst()) {
            do {
                Livro livro = cursorToLivro(cursor);
                listaLivros.add(livro);
            } while (cursor.moveToNext());
        }
        return listaLivros;
    }

    public int updateLivro(Livro livro) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(URL, livro.getUrl());
        values.put(NAME, livro.getName());
        values.put(ISBN, livro.getIsbn());
        values.put(PUBLISHER, livro.getPublisher());
        values.put(COUNTRY, livro.getCountry());
        values.put(MEDIATYPE, livro.getMediaType());
        values.put(RELEASED, livro.getReleased());
        values.put(NUMBEROFPAGES, new Integer(livro.getNumberOfPages()));

        int i = db.update(TABELA_LIVROS, //tabela
                values, // valores
                ID+" = ?", // colunas para comparar
                new String[] { String.valueOf(livro.getId()) }); //parâmetros
        db.close();
        return i; // número de linhas modificadas
    }

    public int deleteLivro(Livro livro) {
        SQLiteDatabase db = this.getWritableDatabase();
        int i = db.delete(TABELA_LIVROS, //tabela
                ID+" = ?", // colunas para comparar
                new String[] { String.valueOf(livro.getId()) });
        db.close();
        return i; // número de linhas excluídas
    }
}
