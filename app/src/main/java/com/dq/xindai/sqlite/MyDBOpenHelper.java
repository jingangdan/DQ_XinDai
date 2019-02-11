package com.dq.xindai.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class MyDBOpenHelper extends SQLiteOpenHelper {
    /*
    * String name为数据库文件名，SQLiteOpenHelper会根据这个文件名创建数据库文件
    * SQLiteDatabase.CursorFactory factory可选的数据库游标工厂类，
    *       当查询(query)被提交时，该对象会被调用来实例化一个游标。
    *       默认为null，可以理解为查询结果集
    * int version为数据库的版本号
    * */
    public MyDBOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    //第一次创建数据库时调用，用于创建表和初始化表中数值，如果数据为已经创建，则不会执行，
    //参数 db 表示SQLite数据库对象，在方法中根据需要对该对象填充表和初始化数据
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE daily(_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "id VARCHAR(10), img VARCHAR(30), gname VARCHAR(60), cost VARCHAR(10))");
    }

    //数据库版本更改时调用，注意，只能往高版本更新，不能降低版本
    //例如从版本2降到版本1会报错：Can't downgrade database from version 2 to 1
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("ALTER TABLE daily ADD weather Varchar");
    }
}
