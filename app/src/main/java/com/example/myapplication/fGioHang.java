package com.example.myapplication;//package com.example.demo;
//
//import android.os.Bundle;
//
//import androidx.fragment.app.Fragment;
//
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ListView;
//
//import java.util.ArrayList;
//import java.util.List;
//
//
//public class fGioHang extends Fragment {
//    ListView lvDanhSach;
//    CustomAdapterSanPham adapterSanPham;
//    public static List<SanPham> giohang=new ArrayList<>();
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        // Inflate the layout for this fragment
//        View view =  inflater.inflate(R.layout.fragment_f_gio_hang, container, false);
//        setControl(view);
//        setEvent();
//        return view;
//    }
//    private void setEvent(){
////        adapterSanPham = new CustomAdapterSanPham(getActivity(),R.layout.layout_item_sp);
//    }
//    private void setControl(View view){
//        lvDanhSach=view.findViewById(R.id.DanhSach);
//    }
//}