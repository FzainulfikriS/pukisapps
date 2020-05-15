package com.example.pukisapps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import com.example.pukisapps.MainActivity;
import com.example.pukisapps.R;
import com.hololo.tutorial.library.Step;
import com.hololo.tutorial.library.TutorialActivity;

public class pageview extends TutorialActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        //slide 1
        addFragment(new Step.Builder().setTitle("pukis apps")
                .setContent("apa sih pukis apps itu? pukis apps adalah aplikasi yang dibuat oleh " +
                        "faiz zainulfikri untuk mereprentasikan user persona dari faiz zainulfikri " +
                        "kenapa diberi nama pukis? karena pukis adalah nama panggilan sehari-hari dari faiz zainulfikri")
                .setBackgroundColor(Color.parseColor("#ffe277")) // int background color
                .setDrawable(R.drawable.slider1) // int top drawable
                .build());

        //slide 2
        addFragment(new Step.Builder().setTitle("Faiz Zainulfikri")
                .setContent("jalan jalan ke jakarta \n jangan lupa membeli batagor \n jika kamu " +
                        "cari yang setia \n pilihlah aku sang editor \n \n jahahahayuk")
                .setBackgroundColor(Color.parseColor("#ffe277")) // int background color
                .setDrawable(R.drawable.fotohom) // int top drawable
                .build());

        //slide 3
        addFragment(new Step.Builder().setTitle("Wolf")
                .setContent("WOLFIEEEEEEEEEEEEEEEEE")
                .setBackgroundColor(Color.parseColor("#ffe277")) // int background color
                .setDrawable(R.drawable.wolf) // int top drawable
                .build());

    }

    @Override
    public void currentFragmentPosition(int position) {

    }
    // pindah ke halaman selanjutnya
    @Override
    public void finishTutorial() {
        Intent intent = new Intent(pageview.this, MainActivity.class);
        startActivity(intent);
    }
}