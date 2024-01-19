package com.example.kvnmapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.Objects;

import de.hdodenhof.circleimageview.CircleImageView;

public class DeveloperActivity extends AppCompatActivity {

    private Uri uri;
    private ImageView gmail, harshilGmail, abhishekGmail;
    private CircleImageView github, linkedin, harshilLink, harshilGit, abhishekGit, abhishekLink;
    private Intent intent;
    private Toolbar toolbar;

    @SuppressLint({"RestrictedApi", "MissingInflatedId", "ResourceType"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_developer);

        // Find views
        toolbar = findViewById(R.id.appbarDEV);
        gmail = findViewById(R.id.gmail);
        linkedin = findViewById(R.id.linkedin);
        github = findViewById(R.id.github);
        harshilGmail = findViewById(R.id.harshilGmail);
        harshilLink = findViewById(R.id.harshilLink);
        harshilGit = findViewById(R.id.harshilGit);
        abhishekGmail = findViewById(R.id.abhishekGmail);
        abhishekGit = findViewById(R.id.abhishekGit);
        abhishekLink = findViewById(R.id.abhishekLink);

        // Set up Toolbar
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        toolbar.setTitle("Developers");
        toolbar.setTitleTextAppearance(this, R.font.poppinsbold);

        // Set up onClick listeners for buttons to visit links

        // Abhay
        gmail.setOnClickListener(v -> openLink("mailto:abhaylathiya01@gmail.com"));
        linkedin.setOnClickListener(v -> openLink("https://www.linkedin.com/in/abhay-lathiya-44389327a/"));
        github.setOnClickListener(v -> openLink("https://github.com/AbhayLathiya"));

        // Harshil
        harshilGmail.setOnClickListener(v -> openLink("mailto:harshilsuhagiya112@gmail.com"));
        harshilLink.setOnClickListener(v -> openLink("https://www.linkedin.com/in/harshil-suhagiya/"));
        harshilGit.setOnClickListener(v -> openLink("https://github.com/HarshilSuhagiya"));

        // Abhishek
        abhishekGmail.setOnClickListener(v -> openLink("mailto:patel140920@gmail.com"));
        abhishekLink.setOnClickListener(v -> openLink("https://www.linkedin.com/in/abhishek-mandani-3a2338237/"));
        abhishekGit.setOnClickListener(v -> openLink("https://github.com/AbhayLathiya"));
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            // Handle the up/back navigation here
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        // Handle the back button press. You can use finish() to close the activity.
        super.onBackPressed();
        finish();
    }

    // Helper method to open links
    private void openLink(String url) {
        uri = Uri.parse(url);
        intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }
}
