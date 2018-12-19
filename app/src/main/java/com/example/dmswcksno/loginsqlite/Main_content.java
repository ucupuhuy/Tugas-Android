package com.example.dmswcksno.loginsqlite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.TextView;

public class Main_content extends AppCompatActivity {

    CardView text1;
    CardView text2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_content);

        //fungsi button text untuk menampilkan descrip Derscripsi_konten
        text1 = (CardView) findViewById(R.id.Apotik1);
        text1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), Derscripsi_konten.class);
                startActivity(i);
            }
        });

        text2 = (CardView) findViewById(R.id.Apotik2);
        text2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), Deskripsi_konten2.class);
                startActivity(i);
            }
        });

    }
}
