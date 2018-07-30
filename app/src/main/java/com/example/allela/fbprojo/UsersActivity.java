package com.example.allela.fbprojo;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Collections;

public class UsersActivity extends AppCompatActivity {
    ListView list;
    CustomAdapter adapter;
    ArrayList<User> users;
    ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users);
        dialog = new ProgressDialog(this);
        dialog.setMessage("Loading...");
        list = findViewById(R.id.usersList);
        users = new ArrayList<>();
        adapter = new CustomAdapter(this,users);
        list.setAdapter(adapter);
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("Users");
        dialog.show();
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                users.clear();
                for (DataSnapshot snap: dataSnapshot.getChildren()) {
                    User user = snap.getValue(User.class);
                    users.add(user);
                    Collections.reverse(users);
                }
                adapter.notifyDataSetChanged();
                dialog.dismiss();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(UsersActivity.this, "Sorry. It Failed", Toast.LENGTH_SHORT).show();
            }
        });

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(UsersActivity.this, "Clicked", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
