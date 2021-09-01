/* Serena Tse 21907178
   Jenny Xie Ng 60748939 */

package com.ppiazzapizza;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class EditHistory extends AppCompatActivity {

    private FirebaseDatabase database;
    private DatabaseReference myRef;

    private ChildEventListener childEventListener;
    private ArrayList<Customer> pizzaList;
    private ArrayList<Customer> searchResults;

    private PizzaAdapter listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_history);

        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("pizza");

        pizzaList = new ArrayList<Customer>();
        searchResults = new ArrayList<Customer>();

        childEventListener = new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                pizzaList.add(dataSnapshot.getValue(Customer.class));
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {
            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        };

        myRef.addChildEventListener(childEventListener);
        listAdapter = new PizzaAdapter(this, searchResults);

        ListView results = findViewById(R.id.searchResults);
        results.setAdapter(listAdapter);

        results.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Customer selectedItem = (Customer) parent.getItemAtPosition(position);
                myRef.child(selectedItem.getUid()).removeValue();
                pizzaList.remove(selectedItem);
                refresh(selectedItem.getName());
            }
        });
    }

    public void refresh(String update) {
        listAdapter.clear();
        for (Customer c : pizzaList) {
            if (c.getName().equalsIgnoreCase(update)) {
                listAdapter.add(c);
            }
        }
    }

    public void removeRecord(View view) {
        listAdapter.clear();
        boolean found = false;
        EditText text = (EditText)findViewById(R.id.editTextSearchName);
        String search = text.getText().toString();
        for (Customer c : pizzaList) {
            if (c.getName().equalsIgnoreCase(search)) {
                listAdapter.add(c);
                found = true;
            }
        }
        text.setText("");
    }
}