package com.example.myrecyclerview;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private String [] myData ={"Android" , "IOS", "Blackberry"};
    private String [] myCompany ={"Android Inc" , "Apple", "Blackberry Inc"};
    private int[] myImage = {R.drawable.android, R.drawable.apple, R.drawable.blackberry};
    private RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rv =findViewById(R.id.recyclerViewid);
        //for listView code
        //rv.setLayoutManager(new LinearLayoutManager(this));

        //for GridView code
        rv.setLayoutManager(new GridLayoutManager(this, 2));
        rv.setAdapter(new MyAdapter());
    }

    public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyHolder> {

        @NonNull
        @Override
        public MyHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

            View v = LayoutInflater.from(MainActivity.this)
                    .inflate(R.layout.list_item, viewGroup, false);

            return new MyHolder(v);
        }

        @Override
        public void onBindViewHolder(@NonNull MyHolder myHolder, int i) {

            myHolder.nameView.setText(myData[i]);
            myHolder.companyView.setText(myCompany[i]);
            myHolder.companyImage.setImageResource(myImage[i]);

        }

        @Override
        public int getItemCount() {
            return myData.length;
        }

        public class MyHolder extends RecyclerView.ViewHolder {

            TextView nameView;
            TextView companyView;
            ImageView companyImage;

            public MyHolder(@NonNull View itemView) {
                super(itemView);
                nameView = itemView.findViewById(R.id.textView);
                companyView = itemView.findViewById(R.id.textView2);
                companyImage = itemView.findViewById(R.id.imageid);
            }
        }
    }



    }

