package com.talgat.layoutcreatingtask2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setTitle("Notes");

        TextView cardTitle = (TextView) findViewById(R.id.card_title);
        cardTitle.setText("Note 1");

        TextView date = findViewById(R.id.date);
        date.setText("2019.09.10");

        CardView cardView = findViewById(R.id.card_view);
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, NoteInfoActivity.class));
            }
        });

        Button emailButton = findViewById(R.id.email_button);
        emailButton.setBackgroundColor(Color.parseColor("#009688"));

        emailButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                        "mailto","only.q@mail.ru", null));
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Notes feedback");
                startActivity(Intent.createChooser(emailIntent, "Send email..."));
            }
        });
    }
}
