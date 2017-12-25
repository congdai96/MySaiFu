package com.dainc.mysaifu;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class ThuChiMainActivity extends Activity {

    Button themGD,ls,exit;
    TextView sodu, tindung, tietkiem, tienmat;
    DatabaseHandler db;
    int sodutienmat;
    int sodutindung;
    int sodutietkiem;

    @SuppressLint("NewApi") @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        db = new DatabaseHandler(this);
        db.open();
        setContentView(com.dainc.mysaifu.R.layout.activity_thu_chi_main);
        themGD = (Button) findViewById(com.dainc.mysaifu.R.id.imgadd);
        ls = (Button)findViewById(com.dainc.mysaifu.R.id.imgweek);
        sodu = (TextView) findViewById(com.dainc.mysaifu.R.id.tvSoDu);
        tietkiem = (TextView) findViewById(com.dainc.mysaifu.R.id.TvTietKiem);
        tindung = (TextView) findViewById(com.dainc.mysaifu.R.id.TvTinDung);
        tienmat = (TextView) findViewById(com.dainc.mysaifu.R.id.TvTienMat);
        exit=(Button)findViewById(com.dainc.mysaifu.R.id.quit);
        exit.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                System.exit(0);
            }
        });
        if (db.taikhoan("クレジットカード").get(0) == null) {
            sodutindung = 0;

        } else {
            sodutindung = Integer.parseInt(db.taikhoan("クレジットカード").get(0));
        }
        if (db.taikhoan("現金").get(0) == null) {
            sodutienmat = 0;

        } else {
            sodutienmat = Integer.parseInt(db.taikhoan("現金").get(0));
        }
        if (db.taikhoan("節約").get(0) == null) {
            sodutietkiem = 0;

        } else {
            sodutietkiem = Integer.parseInt(db.taikhoan("節約").get(0));
        }

        tietkiem.setText(sodutietkiem + "");

        tindung.setText(sodutindung + "");

        tienmat.setText(sodutienmat + "");

        sodu.setText(sodutienmat + sodutindung + sodutietkiem + "");

        themGD.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent i = new Intent(ThuChiMainActivity.this,
                        ThemgiaodichActivity.class);
                startActivity(i);
            }
        });

        ls.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Intent i = new Intent(ThuChiMainActivity.this,
                        ListGiaoDichMainActivity.class);
                startActivity(i);
            }
        });

    }
}