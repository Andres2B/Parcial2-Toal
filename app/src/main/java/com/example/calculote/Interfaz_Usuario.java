package com.example.calculote;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

import java.io.Serializable;

public class Interfaz_Usuario extends AppCompatActivity implements Serializable {

    Button button, button2, button3, button4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interfaz_usuario);

        button = findViewById(R.id.button);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);

        if (button.callOnClick()) {

        } else if (button2.callOnClick()) {
            operation = "-";
        } else if (button3.callOnClick()) {
            operation = "*";
        } else if (button4.callOnClick()) {
            operation = "/";
        }

    }
}