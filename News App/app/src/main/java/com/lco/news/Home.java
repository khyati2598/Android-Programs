package com.lco.news;


import android.app.ProgressDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.lco.news.Model.Post;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import com.lco.news.Adapter.Adapter;

public class Home extends Fragment {

    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    String render1;
    List<Post> post;
    String URL_Data = "http://fantasysportsguruindia.com/wp-json/wp/v2/posts";
    RequestQueue requestQueue;
    ProgressDialog progressDialog;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_home, container, false);
        recyclerView = v.findViewById(R.id.recyclerView);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));

        post = new ArrayList<>();
        loadurl();

        progressDialog = new ProgressDialog(getActivity());
        progressDialog.setMessage("Loading...");
        progressDialog.setCancelable(false);
        progressDialog.show();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                progressDialog.dismiss();
            }
        }, 2000);
        return v;
    }

    private void loadurl() {
        JsonArrayRequest stringRequest = new JsonArrayRequest(URL_Data, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                getvalue(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        requestQueue = Volley.newRequestQueue(getContext());
        requestQueue.add(stringRequest);

    }


    private void getvalue(JSONArray array) {
        for (int i = 0; i < array.length(); i++) {
            Post postlist = new Post();
            JSONObject json = null;
            try {
                json = array.getJSONObject(i);
                JSONObject titleobj = json.getJSONObject("title");
                String render = titleobj.getString("rendered");
                postlist.setTitle(render);
                JSONObject descobj = json.getJSONObject("content");
                render1 = descobj.getString("rendered");
                postlist.setDescription(render1);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            post.add(postlist);
        }
        adapter = new Adapter(post, getActivity());
        recyclerView.setAdapter(adapter);
    }

 }



