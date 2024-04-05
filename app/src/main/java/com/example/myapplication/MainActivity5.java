package com.example.myapplication;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity5 extends AppCompatActivity {
    EditText edtHoTen, edtCCCD;
    RadioButton rdDaiHoc, rdCaoDang, rdTrungCap;
    CheckBox cbChoiGame, cbDocSach, cbDocBao;
    Button btnThoat, btnNhapLai, btnDangKi;
    TextView tvThongTin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        Init();
        setEvent();
    }

    public void setEvent(){

        btnThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        btnNhapLai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edtHoTen.setText("");
                edtCCCD.setText("");
                rdDaiHoc.setChecked(true);
                cbChoiGame.setChecked(false);
                cbDocBao.setChecked(false);
                cbDocSach.setChecked(false);
                tvThongTin.setText("");
                edtHoTen.requestFocus();
                tvThongTin.setBackgroundColor(Color.WHITE);
            }
        });
        btnDangKi.setOnClickListener(new View.OnClickListener() {
            String mgs = "";//có lúc khởi tạo, khi click đăng ký nữa sẽ ghi thêm
            @Override
            public void onClick(View view) {
                mgs += "\nThông tin";
                mgs += "\nHọ tên: " + edtHoTen.getText().toString();
                mgs += "\nCCCD: " + edtCCCD.getText().toString();
                if(rdDaiHoc.isChecked()){
                    mgs += "\nBằng cấp: " + rdDaiHoc.getText().toString();
                }
                if(rdCaoDang.isChecked()){
                    mgs += "\nBằng cấp: " + rdCaoDang.getText().toString();
                }
                if(rdTrungCap.isChecked()){
                    mgs += "\nBằng cấp: " + rdTrungCap.getText().toString();
                }
                mgs += "\nSở thích: ";
                if(cbChoiGame.isChecked()){
                    mgs += cbChoiGame.getText().toString() + " ";
                }
                if(cbDocSach.isChecked()){
                    mgs += cbDocSach.getText().toString() + " ";
                }
                if(cbDocBao.isChecked()){
                    mgs += cbDocSach.getText().toString() + " ";
                }
                mgs += "\n";
                tvThongTin.setText(mgs);
                tvThongTin.setTextSize(25);
                tvThongTin.setBackgroundColor(Color.GREEN);
            }
        });
    }
    public void Init(){
        edtHoTen = findViewById(R.id.edtHoTen);
        edtCCCD = findViewById(R.id.edtCCCD);
        rdDaiHoc = findViewById(R.id.rdDaiHoc);
        rdCaoDang = findViewById(R.id.rdCaoDang);
        rdTrungCap = findViewById(R.id.rdTrungCap);
        cbChoiGame = findViewById(R.id.cbChoiGame);
        cbDocSach = findViewById(R.id.cbDocSach);
        cbDocBao = findViewById(R.id.cbDocBao);
        btnDangKi = findViewById(R.id.btnDangKi);
        btnNhapLai = findViewById(R.id.btnNhapLai);
        btnThoat = findViewById(R.id.btnThoat);
        tvThongTin = findViewById(R.id.tvThongTin);
    }
}
