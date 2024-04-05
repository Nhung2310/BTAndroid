package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity10 extends AppCompatActivity {
    private ListView lvDanhSach;
    private List<User> data= new ArrayList<>();
    private List<User> all_data= new ArrayList<>();
    private CustomAdapterUser adapterUser;
    private SearchView svSearch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main10);
        setControl();
        setEvent();
    }
    public void DocDL(){
        data.clear();
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        String url="https://api.github.com/search/users?q=mojombo";
        JsonObjectRequest request= new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject jsonObject) {
                Log.d("abc",jsonObject.toString());
                try {
                    String total_count = jsonObject.getString("total_count");
                    Toast.makeText(MainActivity10.this,total_count,Toast.LENGTH_SHORT).show();
                    JSONArray items = jsonObject.getJSONArray("items");
                    for (int i =0;i<items.length();i++){
                        JSONObject item= items.getJSONObject(i);
                        User user=new User();
                        user.setLogin(item.getString("login"));
                        user.setUrl(item.getString("url"));
                        user.setAvatar_url(item.getString("avatar_url"));
                        data.add(user);
                        all_data.add(user);
                        System.out.println(data.get(i).getLogin());
                    }
                    adapterUser.notifyDataSetChanged();
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("abc","Loi: "+error.toString());
            }
        });
        requestQueue.add(request);
//        String url="https://api.github.com/users";
//        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url, null,
//            new Response.Listener<JSONArray>() {
//                @Override
//                public void onResponse(JSONArray jsonArray) {
//                    for (int i = 0; i<jsonArray.length();i++){
//                        try {
//                            JSONObject item=jsonArray.getJSONObject(i);
//                            User user=new User();
//                            user.setLogin(item.getString("login"));
//                            user.setUrl(item.getString("url"));
//                            user.setAvatar_url(item.getString("avatar_url"));
//                            data.add(user);
//                            System.out.println(data.get(i).getLogin());
//                        } catch (JSONException e) {
//                            throw new RuntimeException(e);
//                        }
//                    }
//                    adapterUser.notifyDataSetChanged();
//
//                }
//            }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                Log.d("abc",error.toString());
//
//                Toast.makeText(MainActivity10.this,"Loi\n"+error.toString(),Toast.LENGTH_SHORT).show();
//            }
//        });
//        requestQueue.add(request);
    }
    public void setEvent(){

        adapterUser = new CustomAdapterUser(this,R.layout.layout_item_user,data);
        lvDanhSach.setAdapter(adapterUser);
        svSearch.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                adapterUser.search(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
//                adapterUser.search(newText);
                if(newText.equals("")){
                    data.clear();
                    data.addAll(all_data);
                    adapterUser.notifyDataSetChanged();
                }
                else{
                    data.clear();
                    for(User user:all_data){
                        if(user.getLogin().contains(newText)){
                            data.add(user);
                        }
                    }

                }
                adapterUser.notifyDataSetChanged();
                return false;
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        DocDL();
    }

    public void setControl(){
        lvDanhSach=findViewById(R.id.lvDanhSach);
        svSearch=findViewById(R.id.svSearch);
    }
}