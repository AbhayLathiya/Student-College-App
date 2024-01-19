package com.example.kvnmapp.ui.notice;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.example.kvnmapp.MainActivity;
import com.example.kvnmapp.R;
import com.example.kvnmapp.bcpdpt.BCPNotice;
import com.example.kvnmapp.cbpdpt.CBPNotice;
import com.example.kvnmapp.drbdpt.DRBNotice;
import com.example.kvnmapp.jnmpdpt.JNMPNotice;
import com.example.kvnmapp.nccdpt.NCCNotice;

public class NoticeFragment extends Fragment {
    CardView jnmp,bcp,drb,cbpc,ncc;

    @SuppressLint("SetTextI18n")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_notice, container, false);

        jnmp = view.findViewById(R.id.jnmp);
        bcp = view.findViewById(R.id.bcp);
        drb = view.findViewById(R.id.drb);
        cbpc = view.findViewById(R.id.cbpc);
        ncc = view.findViewById(R.id.ncc);

        jnmp.setOnClickListener(v -> openJNMP());
        bcp.setOnClickListener(v -> openBCP());
        drb.setOnClickListener(v -> openDRB());
        cbpc.setOnClickListener(v -> openCBPC());
        ncc.setOnClickListener(v -> openNCC());

        TextView titleTextView = view.findViewById(R.id.title_toolbar);
        titleTextView.setText("Notice Department");

        ImageButton backButton = view.findViewById(R.id.back);
        backButton.setVisibility(View.INVISIBLE);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        // Set the activity's action bar title
        ((MainActivity) requireActivity()).setActionBarTitle("Notices");
    }
    private void openNCC() {
        Intent intent = new Intent(requireActivity(), NCCNotice.class);
        startActivity(intent);
    }

    private void openCBPC() {
        Intent intent = new Intent(requireActivity(), CBPNotice.class);
        startActivity(intent);
    }

    private void openDRB() {
        Intent intent = new Intent(requireActivity(), DRBNotice.class);
        startActivity(intent);
    }

    private void openBCP() {
        Intent intent = new Intent(requireActivity(), BCPNotice.class);
        startActivity(intent);
    }

    private void openJNMP() {
        Intent intent = new Intent(requireActivity(), JNMPNotice.class);
        startActivity(intent);
    }
}
