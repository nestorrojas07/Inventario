package com.example.marcelo.inventario;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import static com.example.marcelo.inventario.ToDoDbHelper.*;
public class ingresarDatos extends AppCompatActivity {

    private GridView gridViewTareas;
    private CursorAdapter adapter;
    private String[] projection = {TAREA_NOMBRE, TAREA_TIPO, TAREA_VALOR, TAREA_STOCK, TAREA_FECHA_CREACION};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingresar_datos);

    }

    public void guardarProducto(View view){
        //recuperacion valores de controles
        String Nombre = ((EditText)findViewById(R.id.Nombre)).getText().toString();
        String Tipo = ((EditText)findViewById(R.id.Tipo)).getText().toString();
        int Valor = Integer.parseInt(((EditText) findViewById(R.id.Valor)).getText().toString());
        int Stock = Integer.parseInt(((EditText) findViewById(R.id.Stock)).getText().toString());

        //codigo SQLite
        ToDoDbHelper toDoDbHelper = new ToDoDbHelper(this);
        SQLiteDatabase db = toDoDbHelper.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(TAREA_NOMBRE, Nombre);
        cv.put(TAREA_TIPO, Tipo);
        cv.put(TAREA_VALOR, Valor);
        cv.put(TAREA_STOCK, Stock);


        //nombre de la tabla, nullhack, valores
        db.insert(TAREA_TABLE, null, cv);

        //notifica la creacion con un TOAST
        Toast.makeText(this, "Producto Guardado",Toast.LENGTH_LONG).show();

        Intent intent = new Intent(this, Inicio.class);
        startActivity(intent);
    }


}
