package com.example.marcelo.inventario;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Inicio extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);


        Button btn = (Button) findViewById(R.id.btn1);
        btn.setOnCreateContextMenuListener(this);

        Button btnSalir = (Button)findViewById(R.id.btnSalir);
        btnSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(RESULT_OK);
                finish();
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        CreateMenu(menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return MenuChoice(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View view,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, view, menuInfo);
        CreateMenu(menu);
    }


    @Override
    public boolean onContextItemSelected(MenuItem item) {
        return MenuChoice(item);
    }

    private void CreateMenu(Menu menu) {

        menu.setQwertyMode(true);
        MenuItem mnu1 = menu.add(0, 0, 0, "Ingreso de Datos");
        {
            mnu1.setAlphabeticShortcut('a');

        }
        MenuItem mnu2 = menu.add(0, 1, 1, "Modificar Datos");
        {
            mnu2.setAlphabeticShortcut('b');

        }
        MenuItem mnu3 = menu.add(0, 2, 2, "Eliminar Datos");
        {
            mnu3.setAlphabeticShortcut('c');

        }
        MenuItem mnu4 = menu.add(0, 3, 3, "Listar Datos");
        {
            mnu4.setAlphabeticShortcut('d');

        }

    }
    private boolean MenuChoice(MenuItem item) {
        switch (item.getItemId()) {
            case 0:
                Toast.makeText(this, "Has elegido Ingresar de datos", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(this, ingresarDatos.class);
                startActivity(intent);
                return true;
            case 1:
                Toast.makeText(this, "Has elegido Modificar datos", Toast.LENGTH_LONG).show();
                Intent intent2 = new Intent(this, ingresarDatos.class);
                startActivity(intent2);
                return true;
            case 2:
                Toast.makeText(this, "Has elegido Eliminar datos", Toast.LENGTH_LONG).show();
                Intent intent3 = new Intent(this, ingresarDatos.class);
                startActivity(intent3);
                return true;
            case 3:
                Toast.makeText(this, "Has elegido Listar datos", Toast.LENGTH_LONG).show();
                Intent intent4 = new Intent(this, ingresarDatos.class);
                startActivity(intent4);
                return true;
        }
        return false;
    }

}