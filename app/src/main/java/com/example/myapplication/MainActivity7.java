package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class MainActivity7 extends AppCompatActivity {
    private EditText edtMaSP, edtTenSP, edtGiaSP;
    private Spinner spLoaiSP;
    private List<String> data_lsp = new ArrayList<>();
    private ArrayAdapter adapter_lsp;
    private ImageView ivHinh;
    private Button btnThem, btnXoa, btnSua, btnThoat;
    private ListView lvDanhSach;
    private int index;
    List<SanPham> data_sp = new ArrayList<>();
    CustomAdapterSanPham adapter_sp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);
        Init();
        setEvent();
    }

    private void setEvent() {
        KhoiTao();

        adapter_lsp = new ArrayAdapter(this, android.R.layout.simple_list_item_1, data_lsp);
        spLoaiSP.setAdapter(adapter_lsp);
        spLoaiSP.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(spLoaiSP.getSelectedItem().equals("SamSung")){
                    ivHinh.setImageResource(R.drawable.samsung);
                }
                if(spLoaiSP.getSelectedItem().equals("Iphone")){
                    ivHinh.setImageResource(R.drawable.iphone);
                }
                if(spLoaiSP.getSelectedItem().equals("Nokia")){
                    ivHinh.setImageResource(R.drawable.nokia);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        adapter_sp = new CustomAdapterSanPham(this, R.layout.layout_item_sp, data_sp);
        lvDanhSach.setAdapter(adapter_sp);
        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ThemDL();
            }
        });
        lvDanhSach.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                SanPham sp = data_sp.get(i);
                index = i;
                edtMaSP.setText(sp.getMaSP());
                edtTenSP.setText(sp.getTenSP());
                edtGiaSP.setText(sp.getGiaSP());
                if(sp.getLoaiSP().equals("SamSung")){
                    spLoaiSP.setSelection(0);
                    ivHinh.setImageResource(R.drawable.samsung);
                }
                if(sp.getLoaiSP().equals("Iphone")){
                    spLoaiSP.setSelection(1);
                    ivHinh.setImageResource(R.drawable.iphone);
                }
                if(sp.getLoaiSP().equals("Nokia")){
                    spLoaiSP.setSelection(2);
                    ivHinh.setImageResource(R.drawable.nokia);
                }
            }
        });
        lvDanhSach.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                data_sp.remove(i);
                adapter_sp.notifyDataSetChanged();
                return false;
            }
        });
        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data_sp.remove(index);
                adapter_sp.notifyDataSetChanged();
            }
        });
        btnSua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SanPham sp = data_sp.get(index);
                sp.setMaSP(edtMaSP.getText().toString());
                sp.setTenSP(edtTenSP.getText().toString());
                sp.setGiaSP(edtGiaSP.getText().toString());
                sp.setLoaiSP(spLoaiSP.getSelectedItem().toString());
                adapter_sp.notifyDataSetChanged();
            }
        });
    }

    private void ThemDL() {
        SanPham sp = new SanPham();
        sp.setMaSP(edtMaSP.getText().toString());
        sp.setTenSP(edtTenSP.getText().toString());
        sp.setGiaSP(edtGiaSP.getText().toString());
        sp.setLoaiSP(spLoaiSP.getSelectedItem().toString());
        data_sp.add(sp);
        adapter_sp.notifyDataSetChanged();
    }

    private void KhoiTao() {
        data_lsp.add("SamSung");
        data_lsp.add("Iphone");
        data_lsp.add("Nokia");
    }

    private void Init(){
        edtMaSP = findViewById(R.id.edtMaSP);
        edtTenSP = findViewById(R.id.edtTenSP);
        edtGiaSP = findViewById(R.id.edtGiaSP);
        spLoaiSP = findViewById(R.id.spLoaiSP);
        ivHinh = findViewById(R.id.ivHinh);
        btnThem = findViewById(R.id.btnThem);
        btnXoa = findViewById(R.id.btnXoa);
        btnSua = findViewById(R.id.btnSua);
        btnThoat = findViewById(R.id.btnThoat);
        lvDanhSach = findViewById(R.id.lvSP);
    }
}