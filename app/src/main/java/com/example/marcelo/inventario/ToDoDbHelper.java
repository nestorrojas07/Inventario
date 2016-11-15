package com.example.marcelo.inventario;

/**
 * Created by marchelo on 13-11-2016.
 */
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class ToDoDbHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "todo.db";

    public static final String TAREA_TABLE = "producto";

    public static final String TAREA_ID = "id";
    public static final String TAREA_NOMBRE = "nombre";
    public static final String TAREA_TIPO = "tipo";
    public static final String TAREA_VALOR = "valor";
    public static final String TAREA_STOCK = "stock";
    public static final String TAREA_FECHA_CREACION = "fecha_creacion";

    public ToDoDbHelper(Context context) {

        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = "CREATE TABLE producto( id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT\n" +
                "\t,  nombre TEXT NOT NULL, tipo TEXT NOT NULL, valor INT DEFAULT 1\n" +
                "\t, stock INT DEFAULT 1, fecha_creacion DEFAULT CURRENT_TIMESTAMP\n" +
                ");";
        sqLiteDatabase.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion
            , int newVersion) {
        // código necesario para modificar la estructura en caso
        // que se hayan realizado modificaciones en el esquema
    }
    public ArrayList llenar_lv(){
        ArrayList<String> lista = new ArrayList<>();
        SQLiteDatabase database = this.getWritableDatabase();
        String q = "SELECT * FROM producto";
        Cursor registros = database.rawQuery(q,null);
        if(registros.moveToFirst()){
            do{
                lista.add(registros.getString(1));
            }while(registros.moveToNext());
        }
        return lista;

    }
}
