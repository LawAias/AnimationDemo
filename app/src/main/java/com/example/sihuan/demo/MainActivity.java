package com.example.sihuan.demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.sihuan.demo.adapter.MyAdapter;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
        initViews();
    }


    RecyclerView mRecyclerView;

    private void findViews() {
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview);
    }

    MyAdapter myAdapter;

    private void initViews() {
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(myAdapter = new MyAdapter(this));
        List<String> list = Arrays.asList(getResources().getStringArray(R.array.data));
        myAdapter.setmData(list);
    }
}
