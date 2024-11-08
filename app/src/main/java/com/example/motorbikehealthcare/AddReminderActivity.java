package com.example.motorbikehealthcare;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;
import android.content.Intent;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.BreakIterator;
import java.util.Calendar;

public class AddReminderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_reminder);


        final EditText dueDateEditText = findViewById(R.id.editTextDueDate);
        dueDateEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.MONTH);
                int day = calendar.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        AddReminderActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int selectedYear, int selectedMonth, int selectedDay) {
                                dueDateEditText.setText(selectedMonth + 1 + "/" + selectedDay + "/" + selectedYear);
                            }
                        },
                        year, month, day);
                datePickerDialog.show();
            }
        });

        EditText taskNameEditText = findViewById(R.id.editTextTaskName);
        EditText mileageEditText = findViewById(R.id.editTextMileage);


        Button saveReminderButton = findViewById(R.id.buttonSaveReminder);
        saveReminderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String taskName= taskNameEditText.getText().toString();
                String mileage = mileageEditText.getText().toString();
                String dueDate = dueDateEditText.getText().toString();

                if (taskName.isEmpty() || mileage.isEmpty()|| dueDate.isEmpty() ) {
                    Toast.makeText(AddReminderActivity.this, "Please fill out all field.", Toast.LENGTH_SHORT).show();
                } else {
                   // return;
                }


                Intent intent = new Intent(AddReminderActivity.this, Reminder_page.class);
                intent.putExtra("taskName", taskName);
                intent.putExtra("mileage", mileage);
                intent.putExtra("dueDate", dueDate);
                startActivity(intent);

                finish();



            }
        });

    }


}