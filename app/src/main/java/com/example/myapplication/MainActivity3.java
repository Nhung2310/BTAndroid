package com.example.myapplication;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity3 extends AppCompatActivity {
    EditText taiKhoan;
    EditText matKhau;
    EditText SDT;
    EditText Email;
    Button btnDangKi;
    Button btnNhapLai;
    TextView thongTin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);;
        Init();
        setEvent();
    }

    public void setEvent(){
        btnDangKi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(taiKhoan.getText().toString().equals("")){
//                    Toast.makeText(MainActivity3.this, "Bạn chưa nhập tài khoản", Toast.LENGTH_SHORT).show();
                    taiKhoan.setError("Bạn chưa nhập tài khoản");
                    return;
                }
                if(matKhau.getText().toString().equals("")){
//                    Toast.makeText(MainActivity3.this, "Bạn chưa nhập mật khẩu", Toast.LENGTH_SHORT).show();
                    matKhau.setError("Bạn chưa nhập mật khẩu");
                    return;
                }
                String mgs = "Thông tin";
                mgs += "\nTài khoản: " + taiKhoan.getText().toString();
                mgs += "\nMật khẩu: " + matKhau.getText().toString();
                mgs += "\nSố ĐT: " + SDT.getText().toString();
                mgs += "\nEmail: " + Email.getText().toString();

                thongTin.setText(mgs);
                thongTin.setTextSize(25);
                thongTin.setTextColor(Color.BLUE);
            }
        });
        btnNhapLai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                taiKhoan.setText("");
                matKhau.setText("");
                SDT.setText("");
                Email.setText("");
                thongTin.setText("");
            }
        });
    }
    private void Init(){
        taiKhoan = findViewById(R.id.edTaiKhoan);
        matKhau = findViewById(R.id.edMatKhau);
        SDT = findViewById(R.id.edSDT);
        Email = findViewById(R.id.edEmail);
        btnDangKi = findViewById(R.id.btnDangKi);
        btnNhapLai = findViewById(R.id.btnNhapLai);
        thongTin = findViewById(R.id.tvThongTin);
    }
}
