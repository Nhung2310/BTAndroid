package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class MainTrangchu extends AppCompatActivity {
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ActionBarDrawerToggle drawerToggle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maintrangchu);
        setControl();
        setEvent();
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item){
        if(drawerToggle.onOptionsItemSelected(item))
            return true;
        if(item.getItemId()==R.id.mnDanhSach){
            Toast.makeText(MainTrangchu.this,"Danh sach", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, MainActivity8.class);
            startActivity(intent);
        }
        if(item.getItemId()==R.id.mnGioHang){
            Toast.makeText(MainTrangchu.this,"Gio hang", Toast.LENGTH_SHORT).show();
        }
        if(item.getItemId()==R.id.mnCaiDat){
            Toast.makeText(MainTrangchu.this,"Cai dat", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }
    private void setEvent(){
        drawerToggle=new ActionBarDrawerToggle(this, drawerLayout,R.string.app_name,R.string.app_name);
        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


    }
    private void setControl(){
        drawerLayout=findViewById(R.id.drawer);
        navigationView=findViewById(R.id.navigation);
    }
//    @Override
//    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem){
//        if(menuItem.getItemId()==R.id.mnDanhSach){
//            Toast.makeText(MainTrangchu.this,"Danh sach", Toast.LENGTH_SHORT).show();
//        }
//        if(menuItem.getItemId()==R.id.mnGioHang){
//            Toast.makeText(MainTrangchu.this,"Gio hang", Toast.LENGTH_SHORT).show();
//        }
//        if(menuItem.getItemId()==R.id.mnCaiDat){
//            Toast.makeText(MainTrangchu.this,"Cai dat", Toast.LENGTH_SHORT).show();
//        }
//        drawerLayout.closeDrawers();
//        getSupportFragmentManager().beginTransaction().replace(R.id.flContent.fragment);
//        return false;
//    }
}