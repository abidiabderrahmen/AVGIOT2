package com.example.abdou.calculmoy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
   EditText devm,devw,bd,resip,vhdl,soc,test_L,sec_I,ang,pfa,droit;
   Button Calcul;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        devm=findViewById(R.id.Dev_m);
        devw=findViewById(R.id.Dev_w);
        bd = findViewById(R.id.bd);
        resip = findViewById(R.id.res_ip);
        vhdl = findViewById(R.id.vhdl);
        soc = findViewById(R.id.soc);
        test_L = findViewById(R.id.test);
        sec_I = findViewById(R.id.sec_inf);
        ang = findViewById(R.id.ang);
        pfa = findViewById(R.id.pfa);
        droit = findViewById(R.id.droit);
        Calcul = findViewById(R.id.calcul);
        Calcul.setOnClickListener(this);
    }

    @Override

    public void onClick(View view) {
        try {
            double devmValue = Double.parseDouble(devm.getText().toString());
            double devwValue = Double.parseDouble(devw.getText().toString());
            double bdValue = Double.parseDouble(bd.getText().toString());
            double resipValue = Double.parseDouble(resip.getText().toString());
            double vhdlValue = Double.parseDouble(vhdl.getText().toString());
            double socValue = Double.parseDouble(soc.getText().toString());
            double testLValue = Double.parseDouble(test_L.getText().toString());
            double secIValue = Double.parseDouble(sec_I.getText().toString());
            double angValue = Double.parseDouble(ang.getText().toString());
            double pfaValue = Double.parseDouble(pfa.getText().toString());
            double droitValue = Double.parseDouble(droit.getText().toString());

            if (isValidInput(devmValue) && isValidInput(devwValue) && isValidInput(bdValue) &&
                    isValidInput(resipValue) && isValidInput(vhdlValue) && isValidInput(socValue) &&
                    isValidInput(testLValue) && isValidInput(secIValue) && isValidInput(angValue) &&
                    isValidInput(pfaValue) && isValidInput(droitValue)) {

                // Calculate the average coefficient
                double averageCoefficient = (devmValue * 1.5 + devwValue * 1.5 + bdValue * 1.5 +
                        resipValue * 1.5 + vhdlValue * 1.5 + socValue * 2 + testLValue + secIValue +
                        angValue + pfaValue * 1.5 + droitValue) / 15;

                Toast.makeText(MainActivity.this, "Votre moyenne est : " + averageCoefficient, Toast.LENGTH_SHORT).show();
            } else {
                // Display an error toast if any value is outside the valid range
                Toast.makeText(MainActivity.this, "Erreur : Les valeurs doivent être entre 0 et 20", Toast.LENGTH_SHORT).show();
            }
        } catch (NumberFormatException e) {
            // Handle the case where parsing fails (e.g., empty input)
            Toast.makeText(MainActivity.this, "Erreur : Veuillez saisir toutes les valeurs", Toast.LENGTH_SHORT).show();
        }
    }

    // Helper method to check if a value is between 0 and 20
    private boolean isValidInput(double value) {
        return value >= 0 && value <= 20;
    }

}
