package com.example.hotel;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class SelectRoomAdapter extends RecyclerView.Adapter<SelectRoomAdapter.RoomViewHolder> {
    List<String> roomName;
    List<String> roomPrice;
    List<Integer> roomImage;
    Integer total_day, total_room, price, rprice;


    public SelectRoomAdapter(List<String> roomName, List<String> roomPrice, List<Integer> roomImage, Integer total_day, Integer total_room) {
        this.roomName = roomName;
        this.roomPrice = roomPrice;
        this.roomImage = roomImage;
        this.total_day = total_day;
        this.total_room = total_room;
    }

    @NonNull
    @Override
    public RoomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.room_prototype, parent, false);
        return new RoomViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RoomViewHolder holder, int position) {

        holder.room_name.setText(roomName.get(position));
        holder.room_price.setText(roomPrice.get(position));
        holder.room_img.setImageResource(roomImage.get(position));
        holder.buttonBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                price= total_day * total_room * Integer.parseInt(holder.room_price.getText().toString());
                Intent intent= new Intent(view.getContext(), Booking.class);
                Bundle mybundle = new Bundle();
                mybundle.putInt("price", price);
                intent.putExtras(mybundle);
                view.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return roomName.size();
    }

    public class RoomViewHolder extends RecyclerView.ViewHolder{
        TextView room_name, room_price;
        ImageButton room_img;
        Button buttonBook;

        public RoomViewHolder(@NonNull View itemView) {
            super(itemView);
            room_name= itemView.findViewById(R.id.textRoomName);
            room_price= itemView.findViewById(R.id.roomPrice);
            room_img= itemView.findViewById(R.id.imageRoom);
            buttonBook= itemView.findViewById(R.id.buttonBook);





        }
    }
}
