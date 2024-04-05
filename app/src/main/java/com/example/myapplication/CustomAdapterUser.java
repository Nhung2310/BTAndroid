package com.example.myapplication;
import com.bumptech.glide.Glide;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.content.Context;

import android.view.View;

import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;
public class CustomAdapterUser extends ArrayAdapter {
    Context context;
    int resource;
    List<User> data;
    List<User> data_all=new ArrayList<>();
    public CustomAdapterUser(@NonNull Context context, int resource, @NonNull List<User> data){
        super(context, resource, data);
        this.context=context;
        this.resource=resource;

        this.data=data;
        data_all.addAll(data);

    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
        convertView= LayoutInflater.from(context).inflate(resource, null);
        ImageView hinh= convertView.findViewById(R.id.ivHinh);
        TextView tvLogin=convertView.findViewById(R.id.tvLogin);
        TextView tvURL=convertView.findViewById(R.id.tvURL);
        User user=data.get(position);
        tvLogin.setText(user.getLogin());
        tvURL.setText(user.getUrl());
        //Picasso.get().load(user.getAvatar_url()).into(hinh);
        Glide.with(context).load(user.getAvatar_url()).into(hinh);
        return convertView;
    }
    public void search(String msg){
        data.clear();
        if(msg.equals("")){
            data.addAll(data_all);
        }
        else{
            for(User user: data_all){
                if(user.getLogin().contains(msg)){
                    data.add(user);
                }
            }
        }
        notifyDataSetChanged();
    }
}
