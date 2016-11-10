package com.example.marcelo.inventario;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText et1,et2;
    private Cursor fila;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1= (EditText) findViewById(R.id.txtUsuario);
        et2= (EditText) findViewById(R.id.txtContraseña);
    }

    public void ingresar(View v) {
        DBHelper admin = new DBHelper(this, "instituto", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();
        String usuario = et1.getText().toString();
        String contrasena = et2.getText().toString();
        fila = db.rawQuery("select usuario,contrasena from usuarios where usuario='" + usuario + "' and contrasena='" + contrasena + "'", null);

        if (fila.moveToFirst()) {
            String usua = fila.getString(0);
            String pass = fila.getString(1);
            if (usuario.equals(usua) && contrasena.equals(pass)) {
                Intent ven = new Intent(this, Inicio.class);
                startActivity(ven);
                et1.setText("");
                et2.setText("");
            }

        }
    }

    public void registro(View v){
        Intent ven=new Intent(this,Registro.class);
        startActivity(ven);

    }

    public void salir(View v){
        finish();
    }
}
