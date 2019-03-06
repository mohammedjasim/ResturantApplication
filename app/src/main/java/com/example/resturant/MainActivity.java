package com.example.resturant;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView lv;
    private CustomeAdapter customeAdapter;
    private ArrayList<ImageModel> imageModelArrayList;

    String []catigories={"اكلات شرقية","اكلات غربية","اكلات بحرية","مقبلات","مشروبات","حلويات"};
    int []images={R.drawable.iraqifood,R.drawable.italian,R.drawable.seafood,R.drawable.mokabilat,R.drawable.drinks,R.drawable.sweets};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = (ListView) findViewById(R.id.myList);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent in=new Intent(MainActivity.this,Main2Activity.class);
                in.putExtra("position",position);
                startActivity(in);
            }
        });


        imageModelArrayList = populateList();
        Log.d("hjhjh", imageModelArrayList.size() + "");
        customeAdapter = new CustomeAdapter(this, imageModelArrayList);
        lv.setAdapter(customeAdapter);
    }

    private ArrayList<ImageModel> populateList() {

        ArrayList<ImageModel> list = new ArrayList<>();

        for (int i = 0; i < catigories.length; i++) {
            ImageModel imageModel = new ImageModel();
            imageModel.setName(catigories[i]);
            imageModel.setImage_drawable(images[i]);
            list.add(imageModel);
        }

        return list;

    }
}
