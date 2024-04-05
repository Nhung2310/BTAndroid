package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainChiTietSP extends AppCompatActivity {
    EditText edtMaSP,edtTenSP,edtGiaSP;
    Button btnXoa,btnSua,btnBack;
    DataBaseSP data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_chi_tiet_sp);
        setControl();
        setEvent();
    }
    private void setEvent(){
        data=new DataBaseSP(this);
        SanPham sp = (SanPham) getIntent().getSerializableExtra("item");

        edtMaSP .setText(sp.getMaSP());
        edtTenSP.setText(sp.getTenSP());
        edtGiaSP.setText(sp.getGiaSP());
        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data.XoaDL(sp);
                Toast.makeText(MainChiTietSP.this, "Xoa thanh cong", Toast.LENGTH_SHORT).show();
                onBackPressed();
            }
        });
        btnSua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sp.setTenSP(edtTenSP.getText().toString());
                sp.setGiaSP(edtGiaSP.getText().toString());
                data.SuaDL(sp);
                Toast.makeText(MainChiTietSP.this, "", Toast.LENGTH_SHORT).show();
                onBackPressed();
            }
        });
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }
    private void setControl(){
        edtMaSP=findViewById(R.id.edtMaSP);
        edtTenSP=findViewById(R.id.edtTenSP);
        edtGiaSP=findViewById(R.id.edtGiaSP);
        btnXoa=findViewById(R.id.btnXoa);
        btnSua=findViewById(R.id.btnSua);
        btnBack=findViewById(R.id.btnBack);
    }
}