package com.example.loveleenkaur_mapd711_assignment4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class HomeScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
    }

    // trigger button click by function and move to another activity
    public void findBrandLocation(View v) {

        // brand data through intent
        switch (v.getId()) {
            case R.id.nike:
                Intent intent1 = new Intent(this, MapsActivity.class);
                intent1.putExtra("Brand", "Nike");
                startActivity(intent1);
                break;
            case R.id.roots:
                Intent intent2 = new Intent(this, MapsActivity.class);
                intent2.putExtra("Brand", "Roots");
                startActivity(intent2);
                break;
            case R.id.husdonBay:
                Intent intent3 = new Intent(this, MapsActivity.class);
                intent3.putExtra("Brand", "Hudson's Bay");
                startActivity(intent3);
                break;
            case R.id.tommy_hilfiger:
                Intent intent4 = new Intent(this, MapsActivity.class);
                intent4.putExtra("Brand", "Tommy Hilfiger");
                startActivity(intent4);
                break;
        }
    }
}
