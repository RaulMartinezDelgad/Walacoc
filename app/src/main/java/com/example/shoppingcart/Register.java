package com.example.shoppingcart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.shoppingcart.views.MainActivity;

public class Register extends AppCompatActivity {

    private EditText emailSignUp , usernameSignUp , passwordSignUp;
    private Button signUpButton;
    private DBHelper myDB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        emailSignUp = findViewById(R.id.signupemail);
        usernameSignUp = findViewById(R.id.signupusername);
        passwordSignUp = findViewById(R.id.siguppassword);

        signUpButton = findViewById(R.id.signupbutton);

        myDB = new DBHelper(this);
        insertUser();

    }

    private void insertUser(){
        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!emailSignUp.getText().toString().isEmpty() && !usernameSignUp.getText().toString().isEmpty() && !passwordSignUp.getText().toString().isEmpty()){
                    boolean var = myDB.registerUser(usernameSignUp.getText().toString() , emailSignUp.getText().toString() , passwordSignUp.getText().toString());
                    if(var){
                        Toast.makeText(Register.this, "Usuario Registrado Correctamente !!", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(Register.this , MainActivity.class));
                    }
                }
                else
                    Toast.makeText(Register.this, "Rellena todos los campos!!", Toast.LENGTH_SHORT).show();
            }
        });
    }

}