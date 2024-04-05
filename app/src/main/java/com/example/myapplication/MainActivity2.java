package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    EditText tieuDe;
    EditText noiDung;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Init();
        SetEvent();
    }
    public void SetEvent(){
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String msg = "";
                msg += "Tiêu đề: " + tieuDe.getText().toString();
                msg += "\nNội dung: " + noiDung.getText().toString();
                Toast.makeText(MainActivity2.this, msg, Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void Init(){
        btn = findViewById(R.id.btnSend);
        tieuDe = findViewById(R.id.edTieuDe);
        noiDung = findViewById(R.id.edNoiDung);
    }
}