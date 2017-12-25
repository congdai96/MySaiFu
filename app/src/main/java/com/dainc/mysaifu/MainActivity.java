package com.dainc.mysaifu;

import android.app.TabActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TabHost;
import android.widget.Toast;

import com.dainc.mysaifu.ThongKe.StatsActivity;

public class MainActivity extends TabActivity {
        @Override

        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(com.dainc.mysaifu.R.layout.activity_main);
            SharedPreferences preferences=getSharedPreferences("account",MODE_PRIVATE);
            String storedPin=preferences.getString("pin","1234");
            if(storedPin.equals("1234")){
                Toast.makeText(MainActivity.this,"セキュリティのために、パスワードを変更してください", Toast.LENGTH_SHORT).show();
            }
            final TabHost tabHost = getTabHost();

            TabHost.TabSpec thuchi = tabHost.newTabSpec("収支");
            thuchi.setIndicator("収支", getResources().getDrawable(com.dainc.mysaifu.R.mipmap.ic_launcher));
            Intent i = new Intent(MainActivity.this, ThuChiMainActivity.class);
            thuchi.setContent(i);

            TabHost.TabSpec thongke = tabHost.newTabSpec("統計");

            thongke.setIndicator("統計", getResources().getDrawable(com.dainc.mysaifu.R.mipmap.ic_launcher));
            Intent o = new Intent(this, StatsActivity.class);
            thongke.setContent(o);

            TabHost.TabSpec caidat = tabHost.newTabSpec("カテゴリ管理");
            caidat.setIndicator("カテゴリ管理", getResources().getDrawable(com.dainc.mysaifu.R.mipmap.ic_launcher));
            Intent p = new Intent(this, CaiDatActivity.class);
            caidat.setContent(p);




            tabHost.addTab(thuchi);
            tabHost.addTab(thongke);
            tabHost.addTab(caidat);

            tabHost.setCurrentTab(0);

        }

}

