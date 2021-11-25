package com.tutor.capacitacion2510am;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DatabaseActivity extends AppCompatActivity {
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("productos");
EditText etnombre,etdescripcion,etprecio;
Button boton_agregar ,boton_listar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database);
        etnombre = findViewById(R.id.etnombre);
        etdescripcion=findViewById(R.id.etdescripcion);
        etprecio = findViewById(R.id.etprecio);
        boton_agregar = findViewById(R.id.boton_agregar);
        boton_listar = findViewById(R.id.button_listar);

        boton_agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre=etnombre.getText().toString();
                String descripcion=etdescripcion.getText().toString();
                String precio = etprecio.getText().toString();

                Producto producto = new Producto(nombre,descripcion,precio);

                myRef.push().setValue(producto);

            }
        });


        boton_listar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent i = new Intent(DatabaseActivity.this, ListarProductos.class);
               startActivity(i);

            }
        });

    }
}