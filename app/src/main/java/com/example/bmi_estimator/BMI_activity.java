package com.example.bmi_estimator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class BMI_activity extends AppCompatActivity {
    android.widget.Button recalculateBMI;

    TextView displayBMI, genderDisplay, statusDisplay;
    Intent intent;
    ImageView mimageview;
    String mBMI;
    float intBMI;
    String height;
    String weight;
    float intweight, intheight;
    RelativeLayout Background;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);


        //getSupportActionBar().setElevation(0);
        //getSupportActionBar().setTitle(Html.fromHtml("<font color = \"white\"></font>"));
        //getSupportActionBar().setTitle("Result");


        intent = getIntent();
        recalculateBMI = findViewById(R.id.recalculateBMI);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        displayBMI = findViewById(R.id.displayBMI);
        genderDisplay = findViewById(R.id.genderDisplay);
        statusDisplay = findViewById(R.id.statusDisplay);
        mimageview = findViewById(R.id.imageViewOk);
        Background = findViewById(R.id.contentLayout);

        height = intent.getStringExtra("height");
        weight = intent.getStringExtra("weight");
        intheight = Float.parseFloat(height);
        intweight = Float.parseFloat(weight);

        intheight = intheight / 100;
        intBMI = intweight / (intheight * intheight);


        mBMI = Float.toString(intBMI);

        if (intBMI < 16) {
            statusDisplay.setText("Severe Thinness");
            Background.setBackgroundColor(Color.RED);
            mimageview.setImageResource(R.drawable.crosss);
        } else if (intBMI < 16.9 && intBMI >= 16) {
            statusDisplay.setText("Moderate Thinness");
            Background.setBackgroundColor(Color.RED);
            mimageview.setImageResource(R.drawable.crosss);
        } else if (intBMI < 18.4 && intBMI >= 17) {
            statusDisplay.setText("Mild Thinness");
            Background.setBackgroundColor(Color.RED);
            mimageview.setImageResource(R.drawable.warning);
        } else if (intBMI < 25 && intBMI >= 18.4) {
            statusDisplay.setText("Normal");
            Background.setBackgroundColor(Color.YELLOW);
            mimageview.setImageResource(R.drawable.ok);
        } else if (intBMI < 29.4 && intBMI >= 25) {
            statusDisplay.setText("Overweight Thinness");
            Background.setBackgroundColor(Color.RED);
            mimageview.setImageResource(R.drawable.warning);
        } else{
            statusDisplay.setText("Obesity");
            Background.setBackgroundColor(Color.RED);
            mimageview.setImageResource(R.drawable.crosss);
        }

        genderDisplay.setText(intent.getStringExtra("gender"));
        displayBMI.setText(mBMI);


        recalculateBMI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BMI_activity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}