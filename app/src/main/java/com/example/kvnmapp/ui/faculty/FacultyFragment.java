package com.example.kvnmapp.ui.faculty;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kvnmapp.MainActivity;
import com.example.kvnmapp.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.ArrayList;
import java.util.List;

public class FacultyFragment extends Fragment {

    private RecyclerView jnmpDepartment,bcpDepartment,drbDepartment,cbpcDepartment,nccDepartment;
    private LinearLayout jnmpNoData,bcpNoData,drbNoData,cbpcNoData,nccNoData;
    private List<TeacherData> list1, list2,list3, list4,list5;

    private DatabaseReference reference,dbRef;
    private TeacherAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_faculty, container, false);

        //fab= findViewById(R.id.fab);
        jnmpDepartment = view.findViewById(R.id.jnmpDepartment);
        bcpDepartment = view.findViewById(R.id.bcpDepartment);
        drbDepartment = view.findViewById(R.id.drbDepartment);
        cbpcDepartment = view.findViewById(R.id.cbpcDepartment);
        nccDepartment = view.findViewById(R.id.nccDepartment);


        jnmpNoData = view.findViewById(R.id.jnmpNoData);
        bcpNoData = view.findViewById(R.id.bcpNoData);
        drbNoData = view.findViewById(R.id.drbNoData);
        cbpcNoData = view.findViewById(R.id.cbpcNoData);
        nccNoData = view.findViewById(R.id.nccNoData);


        reference = FirebaseDatabase.getInstance().getReference().child("teacher");
//        storageReference = FirebaseStorage.getInstance().getReference();

        jnmpDepartment();
        bcpDepartment();
        drbDepartment();
        cbpcDepartment();
        nccDepartment();


        return view;
    }



    private void jnmpDepartment() {
        dbRef = reference.child("J N M Patel Science College");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list1 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    jnmpNoData.setVisibility(View.VISIBLE);
                    jnmpDepartment.setVisibility(View.GONE);
                }else{
                    jnmpNoData.setVisibility(View.GONE);
                    jnmpDepartment.setVisibility(View.VISIBLE);
                    for(DataSnapshot snapshot:dataSnapshot.getChildren()){
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list1.add(data);
                    }
                    jnmpDepartment.setHasFixedSize(true);
                    jnmpDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new TeacherAdapter(list1,getContext());
                    jnmpDepartment.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getContext(), databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void bcpDepartment() {
        dbRef = reference.child("Bhaniben Chhimkabhai Patel BBA College");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list2 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    bcpNoData.setVisibility(View.VISIBLE);
                    bcpDepartment.setVisibility(View.GONE);
                }else{
                    bcpNoData.setVisibility(View.GONE);
                    bcpDepartment.setVisibility(View.VISIBLE);
                    for(DataSnapshot snapshot:dataSnapshot.getChildren()){
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list2.add(data);
                    }
                    bcpDepartment.setHasFixedSize(true);
                    bcpDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new TeacherAdapter(list2,getContext());
                    bcpDepartment.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getContext(), databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void drbDepartment() {
        dbRef = reference.child("D R Patel and R B Patel Commerce College");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list3 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    drbNoData.setVisibility(View.VISIBLE);
                    drbDepartment.setVisibility(View.GONE);
                }else{
                    drbNoData.setVisibility(View.GONE);
                    drbDepartment.setVisibility(View.VISIBLE);
                    for(DataSnapshot snapshot:dataSnapshot.getChildren()){
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list3.add(data);
                    }
                    drbDepartment.setHasFixedSize(true);
                    drbDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new TeacherAdapter(list3,getContext());
                    drbDepartment.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getContext(), databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void cbpcDepartment() {
        dbRef = reference.child("C B Patel Computer College");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list4 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    cbpcNoData.setVisibility(View.VISIBLE);
                    cbpcDepartment.setVisibility(View.GONE);
                }else{
                    cbpcNoData.setVisibility(View.GONE);
                    cbpcDepartment.setVisibility(View.VISIBLE);
                    for(DataSnapshot snapshot:dataSnapshot.getChildren()){
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list4.add(data);
                    }
                    cbpcDepartment.setHasFixedSize(true);
                    cbpcDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new TeacherAdapter(list4,getContext());
                    cbpcDepartment.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getContext(), databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void nccDepartment() {
        dbRef = reference.child("Navnirman Commerce College");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list5 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    nccNoData.setVisibility(View.VISIBLE);
                    nccDepartment.setVisibility(View.GONE);
                }else{
                    nccNoData.setVisibility(View.GONE);
                    nccDepartment.setVisibility(View.VISIBLE);
                    for(DataSnapshot snapshot:dataSnapshot.getChildren()){
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list5.add(data);
                    }
                    nccDepartment.setHasFixedSize(true);
                    nccDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new TeacherAdapter(list5,getContext());
                    nccDepartment.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getContext(), databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    @Override
    public void onResume(){
        super.onResume();
        ((MainActivity) requireActivity()).setActionBarTitle("Faculty");
    }
}