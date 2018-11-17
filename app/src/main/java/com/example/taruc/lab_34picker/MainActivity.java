package com.example.taruc.lab_34picker;

import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    int useryear;
    TextView ages;
    TextView  dob;
    EditText edit;
    TextView amount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showDatePicker(View view) {
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(),"datePicker");
    }

    public void processDatePickerResult(int year, int month, int day) {


        int currentyear = Calendar.getInstance().get(Calendar.YEAR);



         dob=findViewById(R.id.buttonDOB);
         ages=findViewById(R.id.textViewAge);
        String month_string = Integer.toString(month+1);
        String day_string = Integer.toString(day);
        String year_string = Integer.toString(year);
        String dateMessage = (month_string +
                "/" + day_string + "/" + year_string);

        dob.setText(day + "/" + month+ "/" +year);
        useryear=currentyear - year;
        ages.setText("Age : " + useryear);


    }

    public void Calculate(View view){
        int minSavings=0;
        edit = findViewById(R.id.editTestAccountBalance);
        amount = findViewById(R.id.textViewEligibleAmount);
        String result = edit.getText().toString();
        int value = Integer.parseInt(result);
        if(useryear>=16 && useryear<=20){

            minSavings= 5000;

        }
        else if(useryear>=21 && useryear<=25){
            minSavings= 14000;


        }
        else if(useryear>=26 && useryear<=30){

            minSavings= 29000;

        }
        else if(useryear>=31 && useryear<=35){

            minSavings= 50000;

        }
        else if(useryear>=36 && useryear<=40){

            minSavings= 78000;

        }
        else if(useryear>=41 && useryear<=45){

            minSavings= 116000;

        }
        else if(useryear>=46 && useryear<=50){

            minSavings= 16500;

        }
        else if(useryear>=51 && useryear<=55){
            minSavings= 228000;


        }
        else{
            minSavings=0;

        }

        double money= value-minSavings;
        money = money*0.3;
        if(money>=0) {
            String moneyAmount = Double.toString(money);
            amount.setText("Eligible Amount = RM " + moneyAmount);
        }
        else if(money<0){
            amount.setText("Not Eligible");
        }

    };

    public void Reset(View view) {
        useryear = 0;
        ages.setText("Age");
        dob.setText("Date of Birth");
        amount.setText("Eligible Amount");
        edit.setText("");
    }
}
