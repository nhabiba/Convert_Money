package com.example.convert_money;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
     Spinner sp1,sp2;
     EditText ed1;
     Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ed1 = findViewById(R.id.txtamount);
        sp1 = findViewById(R.id.spFrom);
        sp2 = findViewById(R.id.spTo);
        b1 = findViewById(R.id.btn1);

        String[] From = {"USD","MAD","EURO" };
        ArrayAdapter ad = new ArrayAdapter<String>(this, androidx.constraintlayout.widget.R.layout.support_simple_spinner_dropdown_item,From);
        sp1.setAdapter(ad);
        String[] To = {"USD","MAD","EURO" };
        ArrayAdapter ad1 = new ArrayAdapter<String>(this, androidx.constraintlayout.widget.R.layout.support_simple_spinner_dropdown_item,To);
        sp2.setAdapter(ad1);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Double tot ;
                Double amount = Double.parseDouble(ed1.getText().toString());
                if(sp1.getSelectedItem().toString() == "EURO" && sp2.getSelectedItem().toString()=="MAD")
                {
                    tot = amount * 11.09 ;
                    Toast.makeText(getApplicationContext(),tot.toString(), Toast.LENGTH_SHORT).show();
                }
                else if (sp1.getSelectedItem().toString() == "EURO" && sp2.getSelectedItem().toString()=="USD")
                {
                    tot = amount * 1.06 ;
                    Toast.makeText(getApplicationContext(),tot.toString(), Toast.LENGTH_SHORT).show();
                }
                else if (sp1.getSelectedItem().toString() == "MAD" && sp2.getSelectedItem().toString()=="EURO")
                {
                    tot = amount * 0.09 ;
                    Toast.makeText(getApplicationContext(),tot.toString(), Toast.LENGTH_SHORT).show();
                }
                else if (sp1.getSelectedItem().toString() == "MAD" && sp2.getSelectedItem().toString()=="USD")
                {
                    tot = amount * 0.097 ;
                    Toast.makeText(getApplicationContext(),tot.toString(), Toast.LENGTH_SHORT).show();
                }
                else if (sp1.getSelectedItem().toString() == "USD" && sp2.getSelectedItem().toString()=="EURO")
                {
                    tot = amount * 0.94 ;
                    Toast.makeText(getApplicationContext(),tot.toString(), Toast.LENGTH_SHORT).show();
                }
                else {
                    tot = amount * 10.34;
                    Toast.makeText(getApplicationContext(),tot.toString(), Toast.LENGTH_SHORT).show();
                }

            }
        });

    }


}