package com.packagenemo.stopdiabete;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class AccueilActivity extends AppCompatActivity {

    View settingsButtons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accueil);

        settingsButtons = findViewById(R.id.accueilThreeDots);

        settingsButtons.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SettingsActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        try {
            SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
            boolean mySwitchParamValue = sharedPreferences.getBoolean("alarmes", false);

            ImageButton flashButtonOn;
            flashButtonOn = findViewById(R.id.mesAlertes);

            if (mySwitchParamValue){
                flashButtonOn.setImageResource(R.drawable.alertesactive);
            } else {
                flashButtonOn.setImageResource(R.drawable.alertesdesactive);
            }
        } catch (Exception e){
            System.out.println(e);
        }

    }
}

