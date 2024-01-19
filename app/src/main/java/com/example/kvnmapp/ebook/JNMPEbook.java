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
public class JNMPEbook extends AppCompatActivity {
    private RecyclerView jnmpEbookRecycler;
    private DatabaseReference reference;
    private List<EbookData> list;
    private EbookAdapter adapter;
    ShimmerFrameLayout shimmerFrameLayout;
    LinearLayout shimmer_layout;
    private EditText pdf_search;
    @SuppressLint({"ResourceType", "MissingInflatedId", "SetTextI18n"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jnmpebook);
        TextView titleTextView = findViewById(R.id.title_toolbar);
        titleTextView.setText("JNMP Ebooks");
        ImageButton backButton = findViewById(R.id.back);
        backButton.setOnClickListener(view -> onBackPressed());
        pdf_search = findViewById(R.id.pdf_search);
        jnmpEbookRecycler = findViewById(R.id.jnmpEbookRecycler);
        reference = FirebaseDatabase.getInstance().getReference().child("jnmppdf");
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

                    // Set department to "JNMP" for each item
                    assert data != null;
                    data.setDepartment("JNMP");

                    list.add(data);
                }
                Log.d("EbookActivity", "Data retrieved successfully. Size: " + list.size());
                adapter = new EbookAdapter(JNMPEbook.this, list);
                adapter.notifyDataSetChanged();
                jnmpEbookRecycler.setLayoutManager(new LinearLayoutManager(JNMPEbook.this));
                jnmpEbookRecycler.setAdapter(adapter);
                shimmerFrameLayout.stopShimmer();
                shimmer_layout.setVisibility(View.GONE);
                pdf_search.setVisibility(View.VISIBLE);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(JNMPEbook.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        pdf_search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
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
                if (item != null && item.getJnmpPdfTitle() != null && item.getJnmpPdfTitle().toLowerCase().contains(text.toLowerCase())) {
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
    /** @noinspection deprecation*/
    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}