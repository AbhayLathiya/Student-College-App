package com.example.kvnmapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;


public class Department extends AppCompatActivity {
    CardView jnmp,bcp,drb,cbpc,ncc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_department);

        jnmp = findViewById(R.id.jnmp);
        bcp = findViewById(R.id.bcp);
        drb = findViewById(R.id.drb);
        cbpc = findViewById(R.id.cbpc);
        ncc = findViewById(R.id.ncc);

        jnmp.setOnClickListener(v -> openJNMP());
        bcp.setOnClickListener(v -> openBCP());
        drb.setOnClickListener(v -> openDRB());
        cbpc.setOnClickListener(v -> openCBPC());
        ncc.setOnClickListener(v -> openNCC());


    }
    private void openNCC() {
        Uri uri = Uri.parse("https://navnirmanmandal.in/NAVDRB/indexDRB.php");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    private void openCBPC() {
        Uri uri = Uri.parse("https://navnirmanmandal.in/BCA/indexDRB.php");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    private void openDRB() {
        Uri uri = Uri.parse("https://navnirmanmandal.in/DRB/indexDRB.php");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    private void openBCP() {
        Uri uri = Uri.parse("https://navnirmanmandal.in/BBA/indexDRB.php");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    private void openJNMP() {
        Uri uri = Uri.parse("https://navnirmanmandal.in/science/index.php");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }
}