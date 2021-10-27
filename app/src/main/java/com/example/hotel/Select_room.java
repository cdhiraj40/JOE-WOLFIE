package com.example.hotel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Select_room extends AppCompatActivity {
    List<String> roomName= new ArrayList<>();
    List<String> roomPrice= new ArrayList<>();
    List<Integer> roomImage= new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_room);

        Bundle bundle = getIntent().getExtras();
        Integer total_day= bundle.getInt("total_day");
        Integer total_room= bundle.getInt("total_room");

        roomName.add("Single Room");
        roomName.add("Double Room");
        roomName.add("King Room");
        roomName.add("Queen Room");
        roomName.add("Suite Room");
        roomName.add("Master Suite Room");

        roomPrice.add("5400");
        roomPrice.add("6400");
        roomPrice.add("7000");
        roomPrice.add("8500");
        roomPrice.add("9000");
        roomPrice.add("10000");

        roomImage.add(R.drawable.single);
        roomImage.add(R.drawable.doublee);
        roomImage.add(R.drawable.king);
        roomImage.add(R.drawable.queen);
        roomImage.add(R.drawable.suite);
        roomImage.add(R.drawable.master_suite);

        RecyclerView recyclerView= (RecyclerView) findViewById(R.id.recyclerRoom);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        SelectRoomAdapter adapter= new SelectRoomAdapter(roomName, roomPrice, roomImage, total_day, total_room);
        recyclerView.setAdapter(adapter);

    }
}