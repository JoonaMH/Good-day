package com.studio.jmh.goodDay;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private TextView today;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.settings:
                Toast.makeText(getApplicationContext(), "Works", Toast.LENGTH_SHORT).show();
            default:
                return super.onOptionsItemSelected(item);
        }
    }

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
        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
        int currentHour = cal.get(Calendar.HOUR_OF_DAY);

        String dayOfWeek2 = "";
        String greeting = "";
        String special = "";
        String happyBirthday = "";
        String christmas = "24/12";
        String newYear = "01/01";
        String birthday = "22/04";


        if (dayOfWeek == 1) {
            dayOfWeek2 = getString(R.string.sunday);
        } else if (dayOfWeek == 2) {
            dayOfWeek2 = getString(R.string.monday);
        } else if (dayOfWeek == 3) {
            dayOfWeek2 = getString(R.string.tuesday);
        } else if (dayOfWeek == 4) {
            dayOfWeek2 = getString(R.string.wednesday);
        } else if (dayOfWeek == 5) {
            dayOfWeek2 = getString(R.string.thursday);
        } else if (dayOfWeek == 6) {
            dayOfWeek2 = getString(R.string.friday);
        } else if (dayOfWeek == 7) {
            dayOfWeek2 = getString(R.string.saturday);
        }


        if (currentHour < 6) {
            greeting = getString(R.string.good_night);
        } else if (currentHour < 10) {
            greeting = getString(R.string.good_morning);
        } else if (currentHour < 19) {
            greeting = getString(R.string.good_day);
        } else {
            greeting = getString(R.string.good_evening);
        }

        if(holidayString.equals(christmas)){
            special = getString(R.string.christmas);
        }else if(holidayString.equals(newYear)){
            special = getString(R.string.new_year);
        }

        if(holidayString.equals(birthday)){
            happyBirthday = getString(R.string.birthday);
        }

        today.setText(greeting + "" + special + "" + happyBirthday + getString(R.string.text1) +dayOfWeek2 +" "+ dateString + getString(R.string.text2) + hourString + ".");
    }
}
