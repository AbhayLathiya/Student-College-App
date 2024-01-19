package com.example.kvnmapp.ui.gallery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kvnmapp.MainActivity;
import com.example.kvnmapp.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.messaging.FirebaseMessaging;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GalleryFragment extends Fragment {

    RecyclerView campusRecycler, unifestRecycler, otherRecycler;
    GalleryAdapter adapter;
    DatabaseReference reference;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_gallery, container, false);
        campusRecycler = view.findViewById(R.id.campusRecycler);
        unifestRecycler = view.findViewById(R.id.unifestRecycler);
        otherRecycler = view.findViewById(R.id.otherRecycler);

        // Subscribe to FCM topics
        FirebaseMessaging.getInstance().subscribeToTopic("Collegefests");
        FirebaseMessaging.getInstance().subscribeToTopic("College Campus");
        FirebaseMessaging.getInstance().subscribeToTopic("Other Events");


        reference = FirebaseDatabase.getInstance().getReference().child("gallery");

        getCampusImage();
        getUnifestImage();
        getOtherImage();

        return view;
    }

    private void getOtherImage() {
        reference.child("Other Events").addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                List<String> imageList = getImageList(dataSnapshot);
                adapter = new GalleryAdapter(getContext(), imageList);
                otherRecycler.setLayoutManager(new GridLayoutManager(getContext(), 2));
                otherRecycler.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    private void getCampusImage() {
        reference.child("College Campus").addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                List<String> imageList = getImageList(dataSnapshot);
                adapter = new GalleryAdapter(getContext(), imageList);
                campusRecycler.setLayoutManager(new GridLayoutManager(getContext(), 2));
                campusRecycler.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    private void getUnifestImage() {
        reference.child("Collegefests").addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                List<String> imageList = getImageList(dataSnapshot);
                adapter = new GalleryAdapter(getContext(), imageList);
                unifestRecycler.setLayoutManager(new GridLayoutManager(getContext(), 2));
                unifestRecycler.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    private List<String> getImageList(DataSnapshot dataSnapshot) {
        List<String> imageList = new ArrayList<>();
        for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
            Object data = snapshot.getValue();
            if (data instanceof String) {
                // If data is a String, assume it's the image URL
                imageList.add((String) data);
            } else if (data instanceof Map) {
                // If data is a Map, check for the "imageUrl" key
                Map<String, Object> dataMap = (Map<String, Object>) data;
                if (dataMap.containsKey("imageUrl")) {
                    String imageUrl = (String) dataMap.get("imageUrl");
                    imageList.add(imageUrl);
                }
            }
        }
        return imageList;
    }
    @Override
    public void onResume(){
        super.onResume();
        ((MainActivity) requireActivity()).setActionBarTitle("Gallery");
    }
}
