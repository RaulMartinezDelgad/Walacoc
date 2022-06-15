package com.example.shoppingcart.views;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.shoppingcart.Bienvenido;
import com.example.shoppingcart.DBHelper;
import com.example.shoppingcart.R;
import com.example.shoppingcart.Register;

public class MainActivity extends AppCompatActivity {

    private EditText loginUsername , loginPassword;
    private Button loginButton, registrar;
    private ImageButton instragram, twitter, facebook, yt;
    private DBHelper myDb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginUsername = findViewById(R.id.loginusername);
        loginPassword = findViewById(R.id.loginpassword);
        loginButton = findViewById(R.id.loginbutton);
        registrar = findViewById(R.id.registrar);
        instragram = findViewById(R.id.Instragram);
        twitter = findViewById(R.id.Twitter);
        facebook = findViewById(R.id.Facebook);
        yt = findViewById(R.id.YouTube);

        myDb = new DBHelper(this);

        loginUser();

        //OnClick al boton de Registrar
        registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this , Register.class));
            }
        });

        //OnClick al boton de Instagram
        instragram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://www.instagram.com/raumd02/");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        //OnClick al boton de Twitter
        twitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://twitter.com/Raumd02");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        //OnClick al boton de Facebook
        facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://www.facebook.com/raul.martinezdelgado.3726");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        //OnClick al boton de YouTube
        yt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://www.youtube.com/channel/UCKciol0shGssggvd2N106zg");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

    }

    //OnClick al boton de Login
    private void loginUser(){
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean var = myDb.checkUser(loginUsername.getText().toString() , loginPassword.getText().toString());
                if (var){
                    Toast.makeText(MainActivity.this, "Logueado correctamente!!", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(MainActivity.this , Bienvenido.class));
                    finish();
                }else{
                    Toast.makeText(MainActivity.this, "Logueado fallido!!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}