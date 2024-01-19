package com.example.kvnmapp.ebook;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.kvnmapp.R;
import com.facebook.shimmer.ShimmerFrameLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.util.ArrayList;
import java.util.List;
/** @noinspection ALL*/
public class CBPEbook extends AppCompatActivity {
    private RecyclerView cbpEbookRecycler;
    private DatabaseReference reference;
    private List<EbookData> list;
    private EbookAdapter adapter;
    ShimmerFrameLayout shimmerFrameLayout;
    LinearLayout shimmer_layout;
    private EditText pdf_search;
    @SuppressLint({"ResourceType", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cbpebook);
        TextView titleTextView = findViewById(R.id.title_toolbar);
        titleTextView.setText("CBPCC Ebooks");
        ImageButton backButton = findViewById(R.id.back);
        backButton.setOnClickListener(view -> onBackPressed());
        pdf_search = findViewById(R.id.pdf_search);
        cbpEbookRecycler = findViewById(R.id.cbpEbookRecycler);
        reference = FirebaseDatabase.getInstance().getReference().child("cbppdf");
        reference.keepSynced(true);
        shimmerFrameLayout = findViewById(R.id.shimmer_view_container);
        shimmer_layout = findViewById(R.id.shimmer_layout);
        getData();
    }
    private void getData() {
        reference.addValueEventListener(new ValueEventListener() {
            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list = new ArrayList<>();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    EbookData data = snapshot.getValue(EbookData.class);

                    // Set department to "CBP" for each item
                    assert data != null;
                    data.setDepartment("CBP");

                    list.add(data);
                }
                Log.d("EbookActivity", "Data retrieved successfully. Size: " + list.size());
                adapter = new EbookAdapter(CBPEbook.this, list);
                adapter.notifyDataSetChanged();
                cbpEbookRecycler.setLayoutManager(new LinearLayoutManager(CBPEbook.this));
                cbpEbookRecycler.setAdapter(adapter);
                shimmerFrameLayout.stopShimmer();
                shimmer_layout.setVisibility(View.GONE);
                pdf_search.setVisibility(View.VISIBLE);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(CBPEbook.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        pdf_search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start,int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start,int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                filter(editable.toString());
            }
        });
    }

    private void filter(String text) {
        ArrayList<EbookData> filterList = new ArrayList<>();
        if (list != null) {
            for (EbookData item : list) {
                if (item != null && item.getCbpPdfTitle() != null && item.getCbpPdfTitle().toLowerCase().contains(text.toLowerCase())) {
                    filterList.add(item);
                }
            }
        }
        if (adapter != null) {
            adapter.FilteredList(filterList);
        }
    }
    @Override
    protected void onPause() {
        shimmerFrameLayout.stopShimmer();
        super.onPause();
    }
    @Override
    protected void onResume() {
        shimmerFrameLayout.startShimmer();
        super.onResume();
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}