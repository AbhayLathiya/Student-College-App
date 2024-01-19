package com.example.kvnmapp.ebook;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.example.kvnmapp.R;

public class PdfDepartment extends AppCompatActivity {
    CardView jnmp,bcp,drb,cbpc,ncc;

    @SuppressLint({"MissingInflatedId", "SetTextI18n"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf_department);
        jnmp = findViewById(R.id.jnmp);
        bcp = findViewById(R.id.bcp);
        drb = findViewById(R.id.drb);
        cbpc = findViewById(R.id.cbpc);
        ncc = findViewById(R.id.ncc);

        TextView titleTextView = findViewById(R.id.title_toolbar);
        titleTextView.setText("Ebook Department");

        ImageButton backButton = findViewById(R.id.back);
        backButton.setOnClickListener(view -> onBackPressed());


        jnmp.setOnClickListener(v -> openJNMP());
        bcp.setOnClickListener(v -> openBCP());
        drb.setOnClickListener(v -> openDRB());
        cbpc.setOnClickListener(v -> openCBPC());
        ncc.setOnClickListener(v -> openNCC());
    }

    private void openNCC() {
        Intent intent = new Intent(this, NCCEbook.class);
        startActivity(intent);
    }

    private void openCBPC() {
        Intent intent = new Intent(this, CBPEbook.class);
        startActivity(intent);
    }

    private void openDRB() {
        Intent intent = new Intent(this, DRBEbook.class);
        startActivity(intent);
    }

    private void openBCP() {
        Intent intent = new Intent(this, BCPEbook.class);
        startActivity(intent);
    }

    private void openJNMP() {
        Intent intent = new Intent(this, JNMPEbook.class);
        startActivity(intent);
    }

    /** @noinspection deprecation*/
    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }}