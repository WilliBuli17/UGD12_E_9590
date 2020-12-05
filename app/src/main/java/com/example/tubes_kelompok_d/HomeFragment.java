package com.example.tubes_kelompok_d;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.icu.util.Calendar;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.tubes_kelompok_d.adapter.RvHotelAdapter;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

public class HomeFragment extends Fragment {
    CarouselView carouselView;
    AutoCompleteTextView dewasa, anak, kamar;
    TextInputEditText tglCheckIn, tglCheckOut;
    DatePickerDialog datePickerDialog;
    MaterialButton carihotel;
    Calendar calendar;
    int dayIn=0, monthIn=0, yearIn=0, dayOut=0, monthOut=0, yearOut=0;

    int[] sampleImages = {R.drawable.image_1, R.drawable.image_2, R.drawable.image_3, R.drawable.image_4, R.drawable.image_5};
    ImageListener imageListener = new ImageListener() {
        @Override
        public void setImageForPosition(int position, ImageView imageView) {
            imageView.setImageResource(sampleImages[position]);
        }
    };

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home, container, false);
        carouselView = (CarouselView) v.findViewById(R.id.carouselView);
        carouselView.setImageListener(imageListener);
        carouselView.setPageCount(sampleImages.length);

        dewasa = v.findViewById(R.id.dewasa_text);
        anak = v.findViewById(R.id.anak_text);
        kamar = v.findViewById(R.id.kamar_text);
        tglCheckIn = v.findViewById(R.id.checkInInput);
        tglCheckOut = v.findViewById(R.id.checkOutInput);
        carihotel = v.findViewById(R.id.cariHotrl);

        ArrStr();

        tglCheckIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calendar = Calendar.getInstance();
                dayIn = calendar.get(Calendar.DAY_OF_MONTH);
                monthIn = calendar.get(Calendar.MONTH);
                yearIn = calendar.get(Calendar.YEAR);

                datePickerDialog = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int years, int months, int days) {
                        tglCheckIn.setText(days + "/" + (months + 1) + "/" + years);
                        dayIn = days;
                        monthIn = months+1;
                        yearIn = years;
                    }
                }, yearIn, monthIn, dayIn);
                datePickerDialog.show();
            }
        });

        tglCheckOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calendar = Calendar.getInstance();
                dayOut = calendar.get(Calendar.DAY_OF_MONTH);
                monthOut = calendar.get(Calendar.MONTH);
                yearOut = calendar.get(Calendar.YEAR);

                datePickerDialog = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int years, int months, int days) {
                        tglCheckOut.setText(days + "/" + (months + 1) + "/" + years);
                        dayOut = days;
                        monthOut = months+1;
                        yearOut = years;
                    }
                }, yearOut, monthOut, dayOut);
                datePickerDialog.show();
            }
        });

        carihotel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cek();
            }
        });

        return v;
    }

    private void ArrStr() {
        final ArrayAdapter<String> arrayAdapterDewasa = new ArrayAdapter<>(getActivity(),
                android.R.layout.simple_list_item_1,
                getResources().getStringArray(R.array.dewasa_text));
        arrayAdapterDewasa.setDropDownViewResource(android.R.layout
                .simple_spinner_dropdown_item);
        dewasa.setAdapter(arrayAdapterDewasa);

        final ArrayAdapter<String> arrayAdapterAnak = new ArrayAdapter<>(getActivity(),
                android.R.layout.simple_list_item_1,
                getResources().getStringArray(R.array.anak_text));
        arrayAdapterAnak.setDropDownViewResource(android.R.layout
                .simple_spinner_dropdown_item);
        anak.setAdapter(arrayAdapterAnak);

        final ArrayAdapter<String> arrayAdapterKamar = new ArrayAdapter<>(getActivity(),
                android.R.layout.simple_list_item_1,
                getResources().getStringArray(R.array.kamar_text));
        arrayAdapterKamar.setDropDownViewResource(android.R.layout
                .simple_spinner_dropdown_item);
        kamar.setAdapter(arrayAdapterKamar);
    }

    private void cek(){
        String dws = String.valueOf(dewasa.getText());
        String ank = String.valueOf(anak.getText());
        String kmr = String.valueOf(kamar.getText());
        int yIn = yearIn;
        int mIn = monthIn;
        int dIn = dayIn;
        int yOut = yearOut;
        int mOut = monthOut;
        int dOut = dayOut;
        double cekIn = (yIn*365) + (mIn*30) + dIn;
        double cekOut = (yOut*365) + (mOut*30) + dOut;

        if(yIn == 0 || mIn == 0  || dIn == 0 ) {
            Toast.makeText(getActivity(),"Enter Your Tanggal Check In",Toast.LENGTH_SHORT).show();
        }else if(yOut == 0 || mOut == 0  || dOut == 0 ) {
            Toast.makeText(getActivity(),"Enter Your Tanggal Check Out",Toast.LENGTH_SHORT).show();
        }else if(dws.isEmpty()) {
            Toast.makeText(getActivity(),"Enter Your Jumlah Dewasa",Toast.LENGTH_SHORT).show();
        }else if(ank.isEmpty()) {
            Toast.makeText(getActivity(),"Enter YourJumlah Anak",Toast.LENGTH_SHORT).show();
        }else if(kmr.isEmpty()) {
            Toast.makeText(getActivity(),"Enter Your Jumlah Kamar",Toast.LENGTH_SHORT).show();
        }else if(cekOut<=cekIn){
            Toast.makeText(getActivity(),"Minimal Booking 1 day",Toast.LENGTH_SHORT).show();
        }else if((cekOut-cekIn)>30){
            Toast.makeText(getActivity(),"Maximal Booking 30 day",Toast.LENGTH_SHORT).show();
        }else {
            startActivity(new Intent(getActivity(), SearchHotel.class));
        }
    }
}