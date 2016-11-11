package com.example.marcelo.inventario;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ingresarDatos extends AppCompatActivity {

    EditText miNombre;

    Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingresar_datos);

        miNombre = (EditText)findViewById(R.id.Nombre);





    }



//    public void onClick(View v) {
//        Intent intent = new Intent(this, Main2Activity.class);
//        intent.putExtra("nombre", miNombre.getText().toString());
//        startActivity(intent);
//    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_ingresar_datos, menu);
//        return true;
//    }
}
