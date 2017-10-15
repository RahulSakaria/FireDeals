package com.enterprise.bfire.firedeals;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class FireDealsFragment extends Fragment {

    private RecyclerView recyclerView;
    DatabaseReference databaseReference;
    List<CardItem> lists;
    ProgressBar progressBar;


    public FireDealsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fire_deals, container, false);

        recyclerView = view.findViewById(R.id.recycler_view_fire_deals);
        databaseReference = FirebaseDatabase.getInstance().getReference();
        progressBar = view.findViewById(R.id.progress_bar_recycler_view);
        progressBar.setVisibility(View.VISIBLE);
        databaseReference.child("FireDeals").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                lists = new ArrayList<>();
                for(DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                    CardItem cardItem = new CardItem();
                    try {
                        cardItem.setProductName(dataSnapshot1.child("ProductName").getValue().toString());
                        cardItem.setProductType(dataSnapshot1.child("ProductType").getValue().toString());
                        cardItem.setPrice(dataSnapshot1.child("Price").getValue().toString());
                        cardItem.setPros1(dataSnapshot1.child("Pros1").getValue().toString());
                        cardItem.setPros2(dataSnapshot1.child("Pros2").getValue().toString());
                        cardItem.setPros3(dataSnapshot1.child("Pros3").getValue().toString());
                        cardItem.setCons1(dataSnapshot1.child("Cons1").getValue().toString());
                        cardItem.setCons2(dataSnapshot1.child("Cons2").getValue().toString());
                        cardItem.setCons3(dataSnapshot1.child("Cons3").getValue().toString());
                        cardItem.setAffiliateLink(dataSnapshot1.child("AffiliateLink").getValue().toString());
                        cardItem.setImageLink(dataSnapshot1.child("ImageLink").getValue().toString());
                        lists.add(cardItem);
                        CardAdapter adapter = new CardAdapter(getContext(), R.layout.product_card, lists);
                        recyclerView.setAdapter(adapter);
                        progressBar.setVisibility(View.INVISIBLE);
                        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                    }catch (Exception e){
                        Toast.makeText(getContext(),"Check Internet Connection",Toast.LENGTH_SHORT).show();
                    }

                }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


        // new FireDealsAsyncTask().execute();

        return view;
    }

    /*public class FireDealsAsyncTask extends AsyncTask<Void, Void, List<CardItem>> {


        @Override
        protected List<CardItem> doInBackground(Void... voids) {

            return null;
        }

        @Override
        protected void onPostExecute(List<CardItem> cardItems) {
            super.onPostExecute(cardItems);
            CardAdapter adapter = new CardAdapter(getContext(),R.layout.product_card,cardItems);
            recyclerView.setAdapter(adapter);
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        }

    }*/


}
