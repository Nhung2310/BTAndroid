package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.ToggleButton;

public class MainActivity6 extends AppCompatActivity {
    Switch swBongDen;
    LinearLayout lBongDen;
    ImageView imgBongDenBat, imgBongDenTat;
    ToggleButton tgBatTat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);
        Init();
        setEvent();
    }
    public void setEvent(){
        swBongDen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(swBongDen.isChecked()){
                    lBongDen.setVisibility(view.VISIBLE);
                } else {
                    lBongDen.setVisibility(view.GONE);
                }
            }
        });
        tgBatTat.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    imgBongDenBat.setVisibility(View.GONE);
                    imgBongDenTat.setVisibility(View.VISIBLE);
                    System.out.println(1);
                } else {
                    imgBongDenBat.setVisibility(View.VISIBLE);
                    imgBongDenTat.setVisibility(View.GONE);
                    System.out.println(2);
                }
            }
        });
    }

    public void Init(){
        swBongDen = findViewById(R.id.swBongDen);
        lBongDen = findViewById(R.id.lbongDen);
        imgBongDenBat = findViewById(R.id.imgBongDenBat);
        imgBongDenTat = findViewById(R.id.imgBongDenTat);
        tgBatTat = findViewById(R.id.tgBatTat);

    }
}