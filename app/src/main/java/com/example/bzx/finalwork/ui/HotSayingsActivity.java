package com.example.bzx.finalwork.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.bzx.finalwork.R;
import com.example.bzx.finalwork.adapter.HotSayingAdapter;
import com.example.bzx.finalwork.model.hot_sayings;
import com.example.bzx.finalwork.model.saying;

import java.util.ArrayList;
import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;

/**
 * Created by bzx on 2018/11/21.
 */

public class HotSayingsActivity extends AppCompatActivity {
    private ImageView back;
    private List<hot_sayings> data = new ArrayList<>();//必须初始化
    private RecyclerView recyclerView;
    private HotSayingAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hot_sayings);

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
        BmobQuery<saying> query = new BmobQuery("saying");
        query.order("-like_sum");
        query.findObjects(new FindListener<saying>() {
            @Override
            public void done(List<saying> list, BmobException e) {
                if (e == null) {
                    if (list.size() != 0) {
                        for (saying t : list) {
                            String img_url = "no_image";
                            if (t.getImage() != null)
                                img_url = t.getImage().getFileUrl();
                            hot_sayings flag = new hot_sayings(t.getObjectId().toString(), t.getContent().toString(), img_url);
                            data.add(flag);
                        }
                        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
                        recyclerView.setLayoutManager(layoutManager);
                        adapter = new HotSayingAdapter(data);
                        recyclerView.setAdapter(adapter);
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "查询失败", Toast.LENGTH_SHORT).show();
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
