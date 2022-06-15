package com.example.shoppingcart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class Bienvenido extends AppCompatActivity {


    ImageButton crud,tienda, audiBoton, toyotaBoton, fordBoton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bienvenido);

        crud= findViewById(R.id.crud);
        tienda= findViewById(R.id.tienda);
        audiBoton = findViewById(R.id.audiBoton);
        toyotaBoton = findViewById(R.id.toyotaBoton);
        fordBoton = findViewById(R.id.fordBoton);

        //OnClick al boton de Instagram
        audiBoton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://www.audi.es/es/web/es.html");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        //OnClick al boton de Twitter
        toyotaBoton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://www.toyota.es/");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        //OnClick al boton de Facebook
        fordBoton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://www.ford.es/");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
    }

    public void Crud(View view){
        Intent crud = new Intent(this, Crud.class);
        startActivity(crud);
    }

    public void Tienda(View view){
        Intent tienda = new Intent(this, MenuTienda.class);
        startActivity(tienda);
    }
}