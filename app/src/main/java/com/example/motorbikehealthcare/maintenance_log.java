package com.example.motorbikehealthcare;

import android.os.Bundle;
import android.widget.CalendarView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class maintenance_log extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_maintenance_log);

        CalendarView calendarView=findViewById(R.id.maintenance_calendar);

        calendarView.setOnDateChangeListener((calendarView1, year, month, dayOfMonth) -> {

            String selectedDate = year + "_" + (month + 1) + "_" + dayOfMonth;

            if (selectedDate.equals("2024-12-01")) {
                Toast.makeText(this, "Next Oil Change", Toast.LENGTH_SHORT).show();

            } else if (selectedDate.equals("2024-12-15")){
                Toast.makeText(this,"Next Bike Wash",Toast.LENGTH_SHORT).show();

            }

        });
        }



    }
