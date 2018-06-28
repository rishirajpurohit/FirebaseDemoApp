package android.rishirajpurohit.in.firebasedemoapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Collections;

public class Main2Activity extends AppCompatActivity {

    ArrayList<TaskPOJO> tasks;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        listView = findViewById(R.id.mytasklist);
        tasks = new ArrayList<>();

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("tasks");

        myRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    TaskPOJO task = postSnapshot.getValue(TaskPOJO.class);
                    tasks.add(task);
                    ArrayAdapter<TaskPOJO> taskPOJOArrayAdapter = new ArrayAdapter<TaskPOJO>(Main2Activity.this,android.R.layout.simple_list_item_1,tasks);
                    listView.setAdapter(taskPOJOArrayAdapter);
                }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });





    }
}
