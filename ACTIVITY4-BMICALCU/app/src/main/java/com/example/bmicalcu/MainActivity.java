package com.example.bmicalcu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    EditText height, weight, fullname;
    TextView result, result2, fullnameResult;
    Button btnCalculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        height = (EditText) findViewById(R.id.height);
        weight = (EditText) findViewById(R.id.weight);
        fullname = (EditText) findViewById(R.id.fullname);
        result = (TextView) findViewById(R.id.result);
        result2 = (TextView) findViewById(R.id.result2);
        fullnameResult = (TextView) findViewById(R.id.fullnameResult);
        btnCalculate = (Button) findViewById(R.id.btnCalculate);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                calculateBMI();
            }

        });
    }

    private void calculateBMI() {
        String heightStr = height.getText().toString();
        String weightStr = weight.getText().toString();
        String fullnameStr = fullname.getText().toString();

        if (TextUtils.isEmpty(heightStr)) {
            height.setError("Please enter your weight");
            height.requestFocus();
            return;
        }

        if (TextUtils.isEmpty(weightStr)) {
            weight.setError("Please enter your height");
            weight.requestFocus();
            return;
        }

        if (heightStr != null && !"".equals(heightStr) && weightStr != null && !"".equals(weightStr)) {
            float heightValue = Float.parseFloat(heightStr) / 100;
            float weightValue = Float.parseFloat(weightStr);


            float bmi = weightValue / (heightValue * heightValue);
            NumberFormat nf = NumberFormat.getInstance();
            nf.setMaximumFractionDigits(2);
            fullnameResult.setText("NAME: " + fullnameStr);
            result.setText(String.valueOf(nf.format(bmi)));

        }

    }


}



