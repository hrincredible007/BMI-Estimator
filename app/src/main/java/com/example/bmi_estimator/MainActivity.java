package com.example.bmi_estimator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView currentHeight;
    TextView ageNumeric, weightNumeric;
    ImageView weightPlus, weightMinus, agePlus, ageMinus;
    SeekBar seekbarHeight;
    RelativeLayout male, female;

    int constWeight = 55;
    int constAge = 23;
    int currentProgress;
    String mintProgress = "170";
    String typeOfUser = "0";
    String weight = "55";
    String age2 = "22";



    android.widget.Button calculateBMI;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        calculateBMI = findViewById(R.id.calculateBMI);
        ageNumeric = findViewById(R.id.ageNumeric);
        weightNumeric = findViewById(R.id.weightNumeric);
        currentHeight = findViewById(R.id.currentHeight);
        agePlus = findViewById(R.id.agePlus);
        ageMinus = findViewById(R.id.ageMinus);
        weightPlus = findViewById(R.id.weightPlus);
        weightMinus = findViewById(R.id.weightMinus);
        ageNumeric = findViewById(R.id.ageNumeric);
        seekbarHeight = findViewById(R.id.seekbarHeight);
        male = findViewById(R.id.male);
        female = findViewById(R.id.female);




        male.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                male.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.malefemalefocus));
                female.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.malefemalenotfocus));
                typeOfUser = "Male";


            }
        });

        female.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                female.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.malefemalefocus));
                male.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.malefemalenotfocus));
                typeOfUser = "Female";


            }
        });


        seekbarHeight.setMax(300);
        seekbarHeight.setProgress(160);
        seekbarHeight.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                currentProgress = i;
                mintProgress = String.valueOf(currentProgress);
                currentHeight.setText(mintProgress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        //For Add button
        agePlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(constAge<=100) {
                    constAge += 1;
                }
                ageNumeric.setText(String.valueOf(constAge));
            }
        });
        weightPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(constWeight<=200) {
                    constWeight += 1;
                }
                weightNumeric.setText(String.valueOf(constWeight));
            }
        });

        //For Minus Button
        ageMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(constAge>1) {
                    constAge -= 1;
                }

                ageNumeric.setText(String.valueOf(constAge));
            }
        });
        weightMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(constWeight>1) {
                    constWeight -= 1;
                }
                weightNumeric.setText(String.valueOf(constWeight));
            }
        });


        calculateBMI.setOnClickListener(new View.OnClickListener() {





            @Override
            public void onClick(View view) {


                if(typeOfUser.equals("0")){
                    Toast.makeText(getApplicationContext(), "Select Your Gender First", Toast.LENGTH_SHORT).show();
                }

                else if(mintProgress.equals("0")){
                    Toast.makeText(getApplicationContext(), "Select Your Height First", Toast.LENGTH_SHORT).show();

                }

                else if(constAge <= 0){
                    Toast.makeText(getApplicationContext(), "Age is incorrect", Toast.LENGTH_SHORT).show();
                }

                else if(constWeight<=0){
                    Toast.makeText(getApplicationContext(), "Weight is incorrect", Toast.LENGTH_SHORT).show();
                }
                else {

                    Intent intent = new Intent(MainActivity.this, BMI_activity.class);
                    intent.putExtra("gender", typeOfUser);
                    intent.putExtra("height", mintProgress);
                    intent.putExtra("weight", weight);
                    intent.putExtra("age", age2);
                    intent.putExtra("gender", typeOfUser);
                    intent.putExtra("gender", typeOfUser);

                    startActivity(intent);
                    finish();


                }

            }

        });


    }
}