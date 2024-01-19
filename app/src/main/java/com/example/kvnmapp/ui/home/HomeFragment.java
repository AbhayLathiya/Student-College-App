package com.example.kvnmapp.ui.home;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;

import com.example.kvnmapp.MainActivity;
import com.example.kvnmapp.R;

public class HomeFragment extends Fragment {


    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        ImageView map = view.findViewById(R.id.map);
        ImageView ic_phone = view.findViewById(R.id.icPhone);
        ImageView loca = view.findViewById(R.id.loca);
        ImageView gmail = view.findViewById(R.id.gmail);

        ic_phone.setOnClickListener(v -> openCall());
        gmail.setOnClickListener(v -> openEmail());
        loca.setOnClickListener(v -> openMap());
        map.setOnClickListener(v -> openMap());
        return view;
    }

    private void openCall() {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:(0261) 2269094")); // Replace with the actual phone number
        startActivity(intent);
    }

    private void openEmail() {
        Uri uri = Uri.parse("mailto:info@navnirmanmandal.in");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    private void openMap() {
        Uri uri = Uri.parse("geo:0, 0?q=kantha vibhag navnirman mandal");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        intent.setPackage("com.google.android.apps.maps");
        startActivity(intent);
    }

    @Override
    public void onResume() {
        super.onResume();
        ((MainActivity) requireActivity()).setActionBarTitle("Home");
    }
}
