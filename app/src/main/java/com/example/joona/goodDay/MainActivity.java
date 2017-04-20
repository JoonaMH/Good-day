package com.example.joona.goodDay;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private TextView today;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        today = (TextView) findViewById(R.id.today);

        long date = System.currentTimeMillis();

        SimpleDateFormat dateFormat1 = new SimpleDateFormat("dd/MM/yyyy");
        String dateString = dateFormat1.format(date);

        SimpleDateFormat dateFormat2 = new SimpleDateFormat("hh:mm");
        String hourString = dateFormat2.format(date);

        SimpleDateFormat dateFormat3 = new SimpleDateFormat("dd/MM");
        String holidayString = dateFormat3.format(date);

        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
        int dayOfYear = cal.get(Calendar.DAY_OF_YEAR);
        int currentHour = cal.get(Calendar.HOUR_OF_DAY);

        String dayOfWeek2 = "";
        String greeting = "";
        String special = "";
        String happyBirthday = "";
        String christmas = "24/12";
        String newYear = "01/01";
        String birthday = "22/04";


        if (dayOfWeek == 1) {
            dayOfWeek2 = "sunnuntai";
        } else if (dayOfWeek == 2) {
            dayOfWeek2 = "maanantai";
        } else if (dayOfWeek == 3) {
            dayOfWeek2 = "tiistai";
        } else if (dayOfWeek == 4) {
            dayOfWeek2 = "keskiviikko";
        } else if (dayOfWeek == 5) {
            dayOfWeek2 = "torstai";
        } else if (dayOfWeek == 6) {
            dayOfWeek2 = "perjantai";
        } else if (dayOfWeek == 7) {
            dayOfWeek2 = "lauantai";
        }


        if (currentHour < 6) {
            greeting = "Hyvää yötä";
        } else if (currentHour < 10) {
            greeting = "Hyvää huomenta";
        } else if (currentHour < 19) {
            greeting = "Hyvää päivää";
        } else {
            greeting = "Hyvää iltaa";
        }

        if(holidayString.equals(christmas)){
            special = " ja hyvää joulua";
        }else if(holidayString.equals(newYear)){
            special = " ja hyvää uutta vuotta";
        }

        if(holidayString.equals(birthday)){
            happyBirthday = ", sekä hyvää syntymäpäivää";
        }

        today.setText(greeting + "" + special + "" + happyBirthday + "! Tänään on " + dayOfWeek2 + " " + dateString + " ja kello on " + hourString + ".");
    }
}
