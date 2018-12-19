package com.example.dmswcksno.loginsqlite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView txtBerhasil;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtBerhasil = findViewById(R.id.txtBerhasil);

        String email = getIntent().getStringExtra("email");
        txtBerhasil.setText("Kamu telah berhasil login \n"+email);
    }
}
