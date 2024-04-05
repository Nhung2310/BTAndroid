package com.example.myapplication;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity4 extends AppCompatActivity {
    EditText edtSo1, edtSo2, edtKetQua;
    TextView tvDanhSach;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        Init();
    }

    public void PhepTinh(View v){
        int so1 = Integer.parseInt(edtSo1.getText().toString());
        int so2 = Integer.parseInt(edtSo2.getText().toString());
        int ketQua = Integer.parseInt(edtKetQua.getText().toString());
        String mgs = "";
        if(v.getId() == R.id.btnCong){
            Toast.makeText(this, "Phép cộng", Toast.LENGTH_SHORT).show();
            if(so1 + so2 == ketQua){
                mgs = so1 + "+" + so2 + "=" + ketQua + " : Đúng";
            } else {
                mgs = so1 + "+" + so2 + "=" + ketQua + " : Sai";
            }
        }
        if(v.getId() == R.id.btnTru){
            Toast.makeText(this, "Phép trừ", Toast.LENGTH_SHORT).show();
            if(so1 - so2 == ketQua){
                mgs = so1 + "-" + so2 + "=" + ketQua + " : Đúng";
            } else {
                mgs = so1 + "-" + so2 + "=" + ketQua + " : Sai";
            }
        }
        if(v.getId() == R.id.btnNhan){
            Toast.makeText(this, "Phép nhân", Toast.LENGTH_SHORT).show();
            if(so1 * so2 == ketQua){
                mgs = so1 + "*" + so2 + "=" + ketQua + " : Đúng";
            } else {
                mgs = so1 + "*" + so2 + "=" + ketQua + " : Sai";
            }
        }
        if(v.getId() == R.id.btnChia){
            Toast.makeText(this, "Phép chia", Toast.LENGTH_SHORT).show();
            if(so1 / so2 == ketQua){
                mgs = so1 + "/" + so2 + "=" + ketQua + " : Đúng";
            } else {
                mgs = so1 + "/" + so2 + "=" + ketQua + " : Sai";
            }
        }
        tvDanhSach.setText(tvDanhSach.getText() + "\n" + mgs);
        tvDanhSach.setTextSize(25);
        tvDanhSach.setBackgroundColor(Color.GREEN);
    }

    public void Init(){
        edtSo1 = findViewById(R.id.edtSo1);
        edtSo2 = findViewById(R.id.edtSo2);
        edtKetQua = findViewById(R.id.edtKetQua);
        tvDanhSach = findViewById(R.id.tvDanhSach);
    }
}
