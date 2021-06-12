package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import static com.example.bmicalculator.R.color.purple_500;

public class BmiActivity extends AppCompatActivity {
    Button recalculatebmi;

    TextView bmidisplay,bmicategory,gender;
    Intent intent;

    ImageView imageview;
    String bmi;

    float intbmi;

    String height;
    String weight;

    float intheight,intweight;

    RelativeLayout background;

    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);
        getSupportActionBar().setElevation(0);

        getSupportActionBar().setTitle(Html.fromHtml("<font color=\"white\"></font>"));
        getSupportActionBar().setTitle("Result");

        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#1E1D1D"));
        getSupportActionBar().setBackgroundDrawable(colorDrawable);

        intent =getIntent();
        bmidisplay = findViewById(R.id.bmiDisplay);
        bmicategory= findViewById(R.id.bmiCategoryDisplay);
        gender = findViewById(R.id.genderDisplay);
        background = findViewById(R.id.contentLayout);
        recalculatebmi = findViewById(R.id.goToMain);
        imageview = findViewById(R.id.imageView);

        height = intent.getStringExtra("height");
        weight = intent.getStringExtra("weight");

        intheight = Float.parseFloat(height);
        intweight = Float.parseFloat(weight);

        intheight = intheight/100;

        intbmi = intweight/(intheight*intheight);

        bmi = Float.toString(intbmi);
        System.out.println(bmi);

        if (intbmi<16) {
            bmicategory.setText("Severe Thinness");
            background.setBackgroundColor(Color.RED);
            imageview.setImageResource(R.drawable.crosss);
        }
        else if (intbmi<16.9 && intbmi>16){
            bmicategory.setText("Moderate Thinness");
            background.setBackgroundColor(purple_500);
            imageview.setImageResource(R.drawable.warning);
        }
        else if (intbmi<18.4 && intbmi>17){
            bmicategory.setText("Mild Thinness");
            background.setBackgroundColor(purple_500);
            imageview.setImageResource(R.drawable.warning);
        }
        else if (intbmi<25 && intbmi>18.4){
            bmicategory.setText("Normal");
//            background.setBackgroundColor(Color.YELLOW);
            imageview.setImageResource(R.drawable.ok);
        }
        else if (intbmi<29 && intbmi>25){
            bmicategory.setText("OverWeight");
            background.setBackgroundColor(purple_500);
            imageview.setImageResource(R.drawable.warning);
        }
        else if(intbmi<34.9 && intbmi>30)
        {
            bmicategory.setText("Obese Class I");
            background.setBackgroundColor(purple_500);
            imageview.setImageResource(R.drawable.warning);
            //  mimageview.setBackground(colorDrawable2);
        }
        else {
            bmicategory.setText("Obese Class II");
            background.setBackgroundColor(Color.RED);
            imageview.setImageResource(R.drawable.crosss);
        }

        gender.setText(intent.getStringExtra("gender"));
        bmidisplay.setText(bmi);


        recalculatebmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(BmiActivity.this,MainActivity.class);
                startActivity(intent1);

            }
        });


    }
}