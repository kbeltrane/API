package com.example.apirestful;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONException;
import java.util.HashMap;
import java.util.Map;

import webservice.Asynchtask;
import webservice.WebService;

public class MainActivity extends AppCompatActivity implements Asynchtask {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void btlogin(View view) {
        Map<String, String> datos = new HashMap<String, String>();
        //String Url="https://revistas.uteq.edu.ec/ws/login.php?usr=cristian&pass=cristian123";
        EditText txtusuario = findViewById(R.id.idusuario);
        EditText txtpassword = findViewById(R.id.idpassword);
        String usuario;
        String password;
        usuario = txtusuario.getText().toString();
        password = txtpassword.getText().toString();
        WebService ws= new WebService("https://revistas.uteq.edu.ec/ws/login.php?usr="+usuario+"&pass="+password, datos, MainActivity.this, MainActivity.this);
        ws.execute("GET");

    }

    @Override
    public void processFinish(String result) throws JSONException {

        if(result.equals("Login Correcto")){
            Intent intent = new Intent(MainActivity.this,MainActivity3.class);
            startActivity(intent);
        }else{
            TextView txtsaludo = findViewById(R.id.txtmensaje);
            txtsaludo.setText("Responde Servicio  "+ result);
        }

    }
}