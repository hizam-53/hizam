package com.example.motorbikehealthcare;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.ArrayList;
import java.util.List;

public class Reminder_page extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reminder_page);

        com.google.android.material.floatingactionbutton.FloatingActionButton button =findViewById(R.id.fabAddReminder);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Reminder_page.this,AddReminderActivity.class));
            }
        });


        Intent insets = getIntent();
        String taskName = insets.getStringExtra("taskName");
        String mileage = insets.getStringExtra("mileage");
        String dueDate = insets.getStringExtra("dueDate");

        // Check if the data is being received correctly
        Log.d("ReminderActivity", "Task Name: " + taskName);
        Log.d("ReminderActivity", "Mileage: " + mileage);
        Log.d("ReminderActivity", "Due Date: " + dueDate);

        LinearLayout reminderListContainer = findViewById(R.id.reminder_list_container);

        LinearLayout reminderItem = new LinearLayout(this);
        reminderItem.setOrientation(LinearLayout.VERTICAL);
        reminderItem.setPadding(16,16,16,16);
      //  reminderItem.setBackgroundResource(R.drawable/reminder_item_background);

// Task Name TextView
        TextView taskNameTextView = new TextView(this);
        taskNameTextView.setText(taskName);
        taskNameTextView.setTextColor(getColor(R.color.dark_blue));
        taskNameTextView.setTextSize(18);
        taskNameTextView.setTypeface(Typeface.create("sans-serif-medium",Typeface.NORMAL));

//Mileage Textview

        TextView mileageTextView = new TextView(this);
        mileageTextView.setText(mileage);
        mileageTextView.setTextColor(getColor(R.color.black));
        mileageTextView.setTextSize(14);
        mileageTextView.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT));

//Due Date TextView
        TextView dueDateTextView = new TextView(this);
        dueDateTextView.setText("Due Date: " + dueDate);
        dueDateTextView.setTextColor(getResources().getColor(R.color.orange));
        dueDateTextView.setTextSize(14);


        reminderItem.addView(taskNameTextView);
        reminderItem.addView(mileageTextView);
        reminderItem.addView(dueDateTextView);

        reminderListContainer.addView(reminderItem);










    }
}
