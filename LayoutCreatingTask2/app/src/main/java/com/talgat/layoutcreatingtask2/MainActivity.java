package com.talgat.layoutcreatingtask2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
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
        this.setTitle(R.string.main_activity_title);

        TextView cardTitle = findViewById(R.id.card_title);
        cardTitle.setText(getString(R.string.note1));

        TextView date = findViewById(R.id.date);
        date.setText(R.string.date);

        CardView cardView = findViewById(R.id.card_view);
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, NoteInfoActivity.class));
            }
        });

        Button emailButton = findViewById(R.id.email_button);

        emailButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                        "mailto", String.valueOf(R.string.person_email), null));
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, R.string.email_content);
                startActivity(Intent.createChooser(emailIntent, "Send email..."));
            }
        });
    }
}
