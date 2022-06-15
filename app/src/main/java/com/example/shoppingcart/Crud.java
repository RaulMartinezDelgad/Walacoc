package com.example.shoppingcart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Crud extends AppCompatActivity {

    private EditText et_id, et_marca, et_precio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crud);

        et_id = (EditText) findViewById(R.id.txt_id);
        et_marca = (EditText) findViewById(R.id.txt_marca);
        et_precio= (EditText) findViewById(R.id.txt_precio);
    }

    public void Registrar(View view){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administracion", null, 1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();

        String id = et_id.getText().toString();
        String marca = et_marca.getText().toString();
        String precio = et_precio.getText().toString();

        if(!id.isEmpty() && !marca.isEmpty() && !precio.isEmpty() ){
            ContentValues registro = new ContentValues();
            registro.put("id", id);
            registro.put("marca", marca);
            registro.put("precio", precio);

            BaseDeDatos.insert("articulos", null, registro);

            BaseDeDatos.close();
            et_id.setText("");
            et_marca.setText("");
            et_precio.setText("");

            Toast.makeText(this, "Objeto añadido", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Rellena todos los campos", Toast.LENGTH_SHORT).show();
        }
    }

    public void Buscar(View view){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administracion", null, 1);
        SQLiteDatabase BaseDeDatabase = admin.getWritableDatabase();

        String id = et_id.getText().toString();

        if(!id.isEmpty()){
            Cursor fila = BaseDeDatabase.rawQuery
                    ("select marca, precio from articulos where id ="+ id, null);

            if(fila.moveToFirst()){
                et_marca.setText(fila.getString(0));
                et_precio.setText(fila.getString(1));

                BaseDeDatabase.close();
            }else{
                Toast.makeText(this,"No existe ese objeto", Toast.LENGTH_SHORT).show();
                BaseDeDatabase.close();
            }
        }else{
            Toast.makeText(this,"Debes de introducir el id", Toast.LENGTH_SHORT).show();
        }
    }

    public void Eliminar(View view){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper
                (this, "administracion", null, 1);
        SQLiteDatabase BaseDatabase = admin.getWritableDatabase();

        String id = et_id.getText().toString();
        if(!id.isEmpty()) {

            int cantidad = BaseDatabase.delete("articulos", "id=" +id, null);
            BaseDatabase.close();

            et_id.setText("");
            et_marca.setText("");
            et_precio.setText("");

            if(cantidad == 1){
                Toast.makeText(this, "Objeto eliminado", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(this, "No existe ese objeto", Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(this, "Introduce el id para eliminar el objeto", Toast.LENGTH_SHORT).show();
        }
    }

    public void Modificar(View view ){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper
                (this, "administracion", null, 1);
        SQLiteDatabase BaseDatabase = admin.getWritableDatabase();

        String id = et_id.getText().toString();
        String marca = et_marca.getText().toString();
        String precio = et_precio.getText().toString();

        if(!id.isEmpty() && !marca.isEmpty() && !precio.isEmpty()){

            ContentValues registro = new ContentValues();
            registro.put("id", id);
            registro.put("marca", marca);
            registro.put("precio", precio);

            int cantidad = BaseDatabase.update("articulos", registro, "id=" + id, null);
            BaseDatabase.close();

            if(cantidad == 1){
                Toast.makeText(this, "Objeto modificado", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(this, "No existe ese objeto", Toast.LENGTH_SHORT).show();
            }

        }else {
            Toast.makeText(this, "Introduce el id para modificar el objeto", Toast.LENGTH_SHORT).show();
        }
    }
}