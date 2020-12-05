package com.example.tubes_kelompok_d;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.tubes_kelompok_d.adapter.RvHotelAdapter;
import com.example.tubes_kelompok_d.databinding.ActivitySearchHotelBinding;
import com.example.tubes_kelompok_d.model.DaftarHotel;
import com.example.tubes_kelompok_d.model.Hotel;

import java.util.ArrayList;

public class SearchHotel extends AppCompatActivity {
    ActivitySearchHotelBinding binding;
    private ArrayList<Hotel> listHotel;
    private RecyclerView recyclerView;
    private RvHotelAdapter adapter;
    private RecyclerView.LayoutManager manager;
    Button gantiPencarian;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_hotel);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_search_hotel);
        listHotel = new DaftarHotel().HOTEL;
        adapter = new RvHotelAdapter(this,listHotel);
        binding.setHotelAdapter(adapter);
        gantiPencarian = findViewById(R.id.gntPencarian);
        gantiPencarian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SearchHotel.this, Navbar.class));
            }
        });

//
//        ArrayList<Hotel> hotel = new ArrayList<>();
//        hotel.add(new Hotel(R.drawable.horison, "Horison", "Jogja", "Rp450.000"));
//
//        recyclerView = findViewById(R.id.rvHotel);
//        recyclerView.setHasFixedSize(true);
//        manager = new LinearLayoutManager(this);
//        adapter = new RvHotelAdapter(hotel);
//
//        recyclerView.setLayoutManager(manager);
//        recyclerView.setAdapter(adapter);
    }
}