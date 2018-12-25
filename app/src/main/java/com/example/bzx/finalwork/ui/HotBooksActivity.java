package com.example.bzx.finalwork.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.bzx.finalwork.R;
import com.example.bzx.finalwork.adapter.HomepageBookAdapter;
import com.example.bzx.finalwork.model.collection;
import com.example.bzx.finalwork.model.the_collection;

import java.util.ArrayList;
import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;

/**
 * Created by bzx on 2018/11/21.
 */

public class HotBooksActivity extends AppCompatActivity {
    private ImageView back;
    private List<the_collection> data = new ArrayList<>();//必须初始化
    private RecyclerView recyclerView;
    private HomepageBookAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hot_books);

        findView();
        initialization();
        clickEvents();

    }

    public void findView() {
        back = (ImageView) findViewById(R.id.back);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
    }

    public void initialization() {

        //查询收藏数排前的笔记本
        BmobQuery<collection> query = new BmobQuery("collection");
        query.order("-like_sum");
        query.findObjects(new FindListener<collection>() {
            @Override
            public void done(List<collection> list, BmobException e) {
                if (e == null) {
                    if (list.size() != 0) {
                        for (collection t : list) {
                            the_collection flag = new the_collection(t.getObjectId().toString(), t.getName().toString(), t.getImage().getFileUrl());
                            data.add(flag);
                        }
                        GridLayoutManager layoutManager = new GridLayoutManager(getApplicationContext(), 3);
                        recyclerView.setLayoutManager(layoutManager);
                        adapter = new HomepageBookAdapter(data);
                        recyclerView.setAdapter(adapter);
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "笔记本查询失败", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    public void clickEvents() {

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }


}
