package com.example.greening_personal_java_2;



import static com.example.greening_personal_java_2.ListviewAdapter.setListViewHeightBasedOnItems;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class OrderActivity extends AppCompatActivity {

    ListView listView;
    ListviewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); // 뒤로가기 버튼, 디폴트로 true만 해도 백버튼이 생김


        listView = (ListView)findViewById(R.id.listview);
        adapter = new ListviewAdapter();

        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.greening_main_logo_top), "친환경 우유", "수량 : 1", "15000");
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.greening_main_logo_top), "친환경 빨대", "수량 : 1", "3000");
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.greening_main_logo_top), "친환경 에코백", "수량 : 1", "15000");


        listView.setAdapter(adapter);
        setListViewHeightBasedOnItems(listView);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long I) {
                Listviewitem listviewitem = (Listviewitem) adapterView.getItemAtPosition(i);
                Toast.makeText(getApplicationContext(), listviewitem.getText1() + "를 선택하셨습니다.", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:{ //toolbar의 back키 눌렀을 때 동작
                finish();
                return true;
            }
        }
        return super.onOptionsItemSelected(item);


    }
}