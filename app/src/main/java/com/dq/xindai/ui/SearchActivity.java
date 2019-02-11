package com.dq.xindai.ui;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import com.dq.xindai.R;
import com.dq.xindai.base.BaseActivity;
import com.dq.xindai.sqlite.RecordSQLiteOpenHelper;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 搜索
 * Created by jingang on 2018/6/7.
 */

public class SearchActivity extends BaseActivity {
    @Bind(R.id.et_search_keywords)
    EditText etSearchKeywords;
    @Bind(R.id.iv_search)
    ImageView ivSearch;
    @Bind(R.id.lv_search)
    ListView lvSearch;
    @Bind(R.id.but_clear_history)
    Button butClearHistory;
    @Bind(R.id.lin_keywords)
    LinearLayout linKeywords;

    private RecordSQLiteOpenHelper helper = new RecordSQLiteOpenHelper(this);
    ;
    private SQLiteDatabase db;
    private BaseAdapter adapter;

    private Intent intent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setBaseContentView(R.layout.activity_search);
        ButterKnife.bind(this);
        setIvBack();
        setTvTitle("关键字搜索");

        // 搜索框的文本变化实时监听
        etSearchKeywords.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.toString().trim().length() == 0) {
                    //tv_tip.setText("搜索历史");
                } else {
                    //tv_tip.setText("搜索结果");
                }
                String tempName = etSearchKeywords.getText().toString();
                // 根据tempName去模糊查询数据库中有没有数据
                queryData(tempName);

            }
        });

        lvSearch.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView textView = (TextView) view.findViewById(android.R.id.text1);
                String name = textView.getText().toString();
                etSearchKeywords.setText(name);

            }
        });

        queryData("");
    }

    @OnClick({R.id.iv_search, R.id.but_clear_history})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_search:
                if (!(etSearchKeywords.getText().toString().equals(""))) {

                    boolean hasData = hasData(etSearchKeywords.getText().toString().trim());
                    if (!hasData) {
                        insertData(etSearchKeywords.getText().toString().trim());
                        queryData("");
                    }

                } else {
                    showMessage("请输入搜索内容");
                }
                break;
            case R.id.but_clear_history:
                //清空历史记录
                deleteData();
                queryData("");
                break;
        }
    }

    /**
     * 插入数据
     */
    private void insertData(String tempName) {
        db = helper.getWritableDatabase();
        db.execSQL("insert into records(name) values('" + tempName + "')");
        db.close();
    }

    /**
     * 模糊查询数据
     */
    private void queryData(String tempName) {
        Cursor cursor = helper.getReadableDatabase().rawQuery(
                "select id as _id,name from records where name like '%" + tempName + "%' order by id desc ", null);
        // 创建adapter适配器对象
        adapter = new SimpleCursorAdapter(this, android.R.layout.simple_list_item_1, cursor, new String[]{"name"},
                new int[]{android.R.id.text1}, CursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER);
        // 设置适配器
        lvSearch.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    /**
     * 检查数据库中是否已经有该条记录
     */
    private boolean hasData(String tempName) {
        Cursor cursor = helper.getReadableDatabase().rawQuery(
                "select id as _id,name from records where name =?", new String[]{tempName});
        //判断是否有下一个
        return cursor.moveToNext();
    }

    /**
     * 清空数据
     */
    private void deleteData() {
        db = helper.getWritableDatabase();
        db.execSQL("delete from records");
        db.close();
    }
}
