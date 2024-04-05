package com.example.calculote;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.io.Serializable;

public class ResultActivity extends AppCompatActivity {
    TextView normalResultTextView, bundleResultTextView, textView2;
    Button backButton;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        normalResultTextView = findViewById(R.id.normalResultTextView);
        bundleResultTextView = findViewById(R.id.bundleResultTextView);
        textView2 = findViewById(R.id.textView2);
        backButton = findViewById(R.id.backButton);

        Serializable serializable = getIntent().getSerializableExtra("serialized_data");
        if (serializable != null && serializable instanceof ResultData) {
            ResultData resultData = (ResultData) serializable;

            double result = resultData.getResult();
            String operation = resultData.getOperationType();

            normalResultTextView.setText("Resultado Normal: " + result);
            bundleResultTextView.setText("Resultado Bundle: " + result);

            // Mostrar el resultado de Fibonacci o Factorial si la operación es "Fibonacci" o "Factorial"
            if (operation.equals("Fibonacci")) {
                normalResultTextView.setText("Resultado Normal (Fibonacci): " + (int)result);
                bundleResultTextView.setText("Resultado Bundle (Fibonacci): " + (int)result);
            } else if (operation.equals("Factorial")) {
                normalResultTextView.setText("Resultado Normal (Factorial): " + (int)result);
                bundleResultTextView.setText("Resultado Bundle (Factorial): " + (int)result);
            }
        }

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
