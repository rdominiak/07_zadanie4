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
            if(waliduj()){
                liczBMI();
            }
        });

    }

    private boolean waliduj(){
        String waga = String.valueOf(inputWaga.getText());
        String wzrost = String.valueOf(inputWzrost.getText());
        if (waga.isEmpty()){
            textWynik.setText("Pole waga jest puste");
            return false;
        }
        if (wzrost.isEmpty()){
            textWynik.setText("Pole wzrost jest puste");
            return false;
        }
        if (Integer.parseInt(waga) < 1){
            textWynik.setText("Waga musi być większa od 0");
            return false;
        }
        if (Integer.parseInt(wzrost) < 1){
            textWynik.setText("Wzrost musi być większy od 0");
            return false;
        }
        if (Integer.parseInt(wzrost) > 300){
            textWynik.setText("Wzrost musi być mniejszy od 300");
        }
        if (radioGroup.getCheckedRadioButtonId() == -1) {
            textWynik.setText("Nie zaznaczono płci");
            return false;
        }
        return true;
    }

    private void liczBMI(){
        double waga = Double.parseDouble(String.valueOf(inputWaga.getText()));
        double wzrost = Double.parseDouble(String.valueOf(inputWzrost.getText())) / 100;
        double BMI = waga / (wzrost * wzrost);
        textWynik.setText("BMI: " + BMI);
    }

}