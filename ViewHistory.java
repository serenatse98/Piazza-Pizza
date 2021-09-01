/* Serena Tse 21907178
   Jenny Xie Ng 60748939 */

package com.ppiazzapizza;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class ViewHistory extends AppCompatActivity {

    private FirebaseDatabase database;
    private DatabaseReference myRef;
    private ChildEventListener cel;
    private PizzaAdapter listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_history);

        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("pizza");

        ArrayList<Customer> customerList = new ArrayList<Customer>();

        cel = new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                listAdapter.add(dataSnapshot.getValue(Customer.class));
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        };

        myRef.addChildEventListener(cel);

        listAdapter = new PizzaAdapter(this, customerList);
        ListView results = findViewById(R.id.listViewResults);
        results.setAdapter(listAdapter);
    }


}
