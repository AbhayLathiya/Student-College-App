package com.example.kvnmapp.ui.about;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.bumptech.glide.Glide;
import com.example.kvnmapp.MainActivity;
import com.example.kvnmapp.R;

import java.util.ArrayList;
import java.util.List;



public class AboutFragment extends Fragment {

    private ViewPager viewPager;
    private BranchAdapter adapter;
    private List<BranchModel>list;
    private ImageView map;

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_about, container, false);
        list = new ArrayList<>();
        list.add(new BranchModel(R.drawable.jnmp,"J N M Patel Science College"));
        list.add(new BranchModel(R.drawable.bba,"Bhaniben Chhimkabhai Patel BBA College"));
        list.add(new BranchModel(R.drawable.bcom,"D R Patel and R B Patel Commerce College"));
        list.add(new BranchModel(R.drawable.cbpc,"C B Patel Computer College"));
        list.add(new BranchModel(R.drawable.socsa_ic1,"Navnirman Commerce College"));

        adapter = new BranchAdapter(getContext(), list);

        viewPager = view.findViewById(R.id.viewPager);

        viewPager.setAdapter(adapter);

        ImageView imageView = view.findViewById(R.id.college_image);

        Glide.with(getContext())
                .load("https://firebasestorage.googleapis.com/v0/b/ppsuapp-66dbf.appspot.com/o/gallery%2F%5BB%406a47fe9jpg?alt=media&token=878edbb5-0e0a-4bd8-8b34-3647f1f0f547")
                .into(imageView);

        return view;

    }
    @Override
    public void onResume(){
        super.onResume();
        ((MainActivity) getActivity()).setActionBarTitle("About");
    }
}