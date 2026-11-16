package com.example.a07_zadanie4;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText inputWaga, inputWzrost;
    private RadioGroup radioGroup;

    private Button btnSubmit;

    private TextView textWynik;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        inputWaga = findViewById(R.id.TextWaga);
        inputWzrost = findViewById(R.id.TextWzrost);
        radioGroup = findViewById(R.id.radioGroup);
        btnSubmit = findViewById(R.id.button);
        textWynik = findViewById(R.id.textWynik);

        btnSubmit.setOnClickListener(v -> {

        });

    }

    private boolean waliduj(){
        String waga = String.valueOf(inputWaga.getText());
        String wzrost = String.valueOf(inputWzrost.getText());
        if (waga.isEmpty()){
            textWynik.setText("Pole waga jest pusta");
            return false;
        }
        return true;
    }

}