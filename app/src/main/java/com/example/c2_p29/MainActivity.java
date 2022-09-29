package com.example.c2_p29;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView count1;
    private TextView count2;
    private TextView count3;
    private TextView countTotal;
    private Button submit;
    private EditText edit1;
    private EditText edit2;
    private EditText edit3;

    private int cal1 = 100;
    private int cal2 = 50;
    private int cal3 = 250;
    private int calories = 0;
    private int serve1 = 0;
    private int serve2 = 0;
    private int serve3 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        count1 = (TextView) findViewById(R.id.food1_count);
        count2 = (TextView) findViewById(R.id.food2_count);
        count3 = (TextView) findViewById(R.id.food3_count);
        countTotal = (TextView) findViewById(R.id.count_name);
        submit = (Button) findViewById(R.id.submit_name);
        edit1 = (EditText) findViewById(R.id.edit1);
        edit2 = findViewById(R.id.edit2);
        edit3 = findViewById(R.id.edit3);

        count1.setText(getResources().getString(R.string.calories, cal1));
        count2.setText(getResources().getString(R.string.calories, cal2));
        count3.setText(getResources().getString(R.string.calories, cal3));
        countTotal.setText(getResources().getString(R.string.calories, 0));

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                serve1 = getInt(edit1);
                serve2 = getInt(edit2);
                serve3 = getInt(edit3);

                calories += serve1*cal1 + serve2*cal2 +serve3*cal3;

                countTotal.setText(getResources().getString(R.string.calories, calories));
            }
        });
    }

    private int getInt(EditText txt){
        int val =0;
        if (!txt.getText().toString().matches("")){
            val = Integer.parseInt(txt.getText().toString());
        }
        return val;
    }
}