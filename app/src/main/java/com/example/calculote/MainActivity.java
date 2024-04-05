package com.example.calculote;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import java.io.Serializable;


public class MainActivity extends AppCompatActivity implements Serializable {

    EditText operand1EditText, operand2EditText, numberEditText;
    double operand1, operand2;
    String operation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        operand1EditText = findViewById(R.id.operand1_edit_text);
        operand2EditText = findViewById(R.id.operand2_edit_text);
        numberEditText = findViewById(R.id.number_edit_text);
    }

    public void performOperation(View view) {
        if (operand1EditText.getText().toString().isEmpty() ||
                operand2EditText.getText().toString().isEmpty()) {
            // Mostrar mensaje de error si no se ingresaron operandos válidos
            // Aquí puedes agregar un Toast o un Snackbar para mostrar el mensaje al usuario
            return;
        }

        operand1 = Double.parseDouble(operand1EditText.getText().toString());
        operand2 = Double.parseDouble(operand2EditText.getText().toString());

        // Determinar la operación según el botón presionado
        if (view.getId() == R.id.add_button) {
            operation = "+";
        } else if (view.getId() == R.id.subtract_button) {
            operation = "-";
        } else if (view.getId() == R.id.multiply_button) {
            operation = "*";
        } else if (view.getId() == R.id.divide_button) {
            operation = "/";
        }

        // Realizar la operación matemática
        double result = calculateResult(operand1, operand2, operation);

        // Crear un objeto ResultData y pasarlo mediante Intent serializado
        ResultData resultData = new ResultData(result, operation);
        Intent intent = new Intent(this, ResultActivity.class);
        intent.putExtra("serialized_data", resultData);
        startActivity(intent);

        // Crear un Bundle para pasar datos a la actividad de resultados
        Bundle bundle = new Bundle();
        bundle.putDouble("result", result);
        bundle.putString("operation", operation);
        // Agregar el Bundle al Intent
        intent.putExtras(bundle);
        // Iniciar la actividad de resultados
        startActivity(intent);


    }

    public void calculateFibonacci(View view) {
        if (numberEditText.getText().toString().isEmpty()) {
            // Mostrar mensaje de error si no se ingresó un número válido
            // Aquí puedes agregar un Toast o un Snackbar para mostrar el mensaje al usuario
            return;
        }

        int n = Integer.parseInt(numberEditText.getText().toString());
        int result = fibonacci(n);

        ResultData resultData = new ResultData(result, "Fibonacci");
        Intent intent = new Intent(this, ResultActivity.class);
        intent.putExtra("serialized_data", resultData);
        startActivity(intent);

    }

    public void calculateFactorial(View view) {
        if (numberEditText.getText().toString().isEmpty()) {
            // Mostrar mensaje de error si no se ingresó un número válido
            // Aquí puedes agregar un Toast o un Snackbar para mostrar el mensaje al usuario
            return;
        }

        int n = Integer.parseInt(numberEditText.getText().toString());
        int result = factorial(n);


        ResultData resultData = new ResultData(result, "Factorial");
        Intent intent = new Intent(this, ResultActivity.class);
        intent.putExtra("serialized_data", resultData);
        startActivity(intent);
    }

    private double calculateResult(double operand1, double operand2, String operation) {
        switch (operation) {
            case "+":
                return operand1 + operand2;
            case "-":
                return operand1 - operand2;
            case "*":
                return operand1 * operand2;
            case "/":
                if (operand2 == 0) {

                    return 0; // Por ejemplo, retornar 0 como resultado
                }
                return operand1 / operand2;
            default:
                return 0;
        }
    }

    private int fibonacci(int n) {
        if (n <= 1)
            return n;
        else
            return fibonacci(n - 1) + fibonacci(n - 2);
    }

    private int factorial(int n) {
        if (n == 0)
            return 1;
        else
            return n * factorial(n - 1);
    }
}
