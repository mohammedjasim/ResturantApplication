package com.example.resturant;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {

    int item;
    private ListView lv;
    private CustomeAdapter customeAdapter;
    private ArrayList<ImageModel> imageModelArrayList;
    String food[];
    int [] imgs;
    double price[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        item=getIntent().getIntExtra("position",0);
        switch (item){
            case 0:
                food=getResources().getStringArray(R.array.shrki);
                imgs=new int[]{R.drawable.kebab,R.drawable.kebabch,R.drawable.meals,R.drawable.chiken,R.drawable.kozisham,R.drawable.tashreeb};
                price=new double[]{20000,12000,25000,15000,20000,10000};
                break;
            case 1:
                food=getResources().getStringArray(R.array.ghrabi);
                imgs=new int[]{R.drawable.fahita,R.drawable.pizza,R.drawable.futusini,R.drawable.pizzamar,R.drawable.billa};
                price=new double[]{10000,15000,15000,12000,20000};
                break;
            case 2:
                food=getResources().getStringArray(R.array.sea);
                imgs=new int[]{R.drawable.robian,R.drawable.tuna,R.drawable.maskof,R.drawable.mtabak,R.drawable.kafiar};
                price=new double[]{25000,20000,25000,20000,50000};
                break;
            case 3:
                food=getResources().getStringArray(R.array.mukab);
                imgs=new int[]{R.drawable.humus,R.drawable.fatush,R.drawable.tabula,R.drawable.jajic,R.drawable.ceser,R.drawable.babaghanog,R.drawable.fingers};
                price=new double[]{4000,3000,3000,2500,6000,3000,5000};
                break;
            case 4:
                food=getResources().getStringArray(R.array.drinks);
                imgs=new int[]{R.drawable.gas,R.drawable.juice,R.drawable.tea,R.drawable.coffee,R.drawable.cappuchino};
                price=new double[]{1000,5000,2000,2500,3000};
                break;
            case 5:
                food=getResources().getStringArray(R.array.sweet);
                imgs=new int[]{R.drawable.znood,R.drawable.zlabia,R.drawable.kunafa,R.drawable.baqlawa,R.drawable.cake};
                price=new double[]{8000,5000,16000,25000,5000};
                break;

        }
        lv = (ListView) findViewById(R.id.myList);
        imageModelArrayList = populateList();
        Log.d("hjhjh", imageModelArrayList.size() + "");
        customeAdapter = new CustomeAdapter(this, imageModelArrayList);
        lv.setAdapter(customeAdapter);

    }
    private ArrayList<ImageModel> populateList() {

        ArrayList<ImageModel> list = new ArrayList<>();

        for (int i = 0; i < food.length; i++) {
            ImageModel imageModel = new ImageModel();
            imageModel.setName(food[i]+"   "+price[i]);
            imageModel.setImage_drawable(imgs[i]);
            list.add(imageModel);
        }

        return list;

    }
}
