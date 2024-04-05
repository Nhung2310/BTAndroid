package com.example.myapplication;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DataBaseSP extends SQLiteOpenHelper {

    public DataBaseSP(@Nullable Context context) {
        super(context, "dbSanPham", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql="Create table tbSanPham (masp text, tensp text, gia text, loaisp text)";
        db.execSQL(sql);
        System.out.println("Dang chay ...");
    }

    public List<SanPham> DocDL(){
        SQLiteDatabase db=getReadableDatabase();
        String sql="select * from tbSanPham";
        List<SanPham> data=new ArrayList<>();
        Cursor cursor = db.rawQuery(sql, null);
        if (cursor.moveToFirst()){
            do{
                SanPham sp = new SanPham();
                sp.setMaSP(cursor.getString(0));
                sp.setTenSP(cursor.getString(1));
                sp.setGiaSP(cursor.getString(2));
                sp.setLoaiSP(cursor.getString(3));
                data.add(sp);
            }
            while(cursor.moveToNext());
        }
        return data;
    }

    public void ThemDL(SanPham sp){
        SQLiteDatabase db=getWritableDatabase();
        String sql="insert into tbSanPham values(?,?,?,?)";
        db.execSQL(sql,new String[]{sp.getMaSP(),sp.getTenSP(),sp.getGiaSP(),sp.getLoaiSP()});
    }

    public void XoaDL(SanPham sp){
        SQLiteDatabase db=getWritableDatabase();
        String sql="Delete from tbSanPham where masp=?";
        db.execSQL(sql,new String[]{sp.getMaSP()});
    }

    public void SuaDL(SanPham sp){
        SQLiteDatabase db=getWritableDatabase();
        try{
            Cursor cursor = db.query("tbSanPham",null,null,null,null,null,null);
            String []columnsNames=cursor.getColumnNames();
            for (String e: columnsNames) {
                System.out.println(e);
            }
            String sql="Update tbSanPham set tensp=?,gia=?,loaisp=? where masp=?";
            db.execSQL(sql,new String[]{sp.getTenSP(),sp.getGiaSP(),sp.getLoaiSP(),sp.getMaSP()});
        }
        catch (Exception e){
            System.out.println("Error"+e.toString());
            return;
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
