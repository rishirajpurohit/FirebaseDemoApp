package android.rishirajpurohit.in.firebasedemoapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button button = findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editText = findViewById(R.id.editText);
                EditText editText2 = findViewById(R.id.editText2);
                EditText editText3 = findViewById(R.id.editText3);


                TaskPOJO task = new TaskPOJO();
                task._ID = editText.getText().toString();
                task.name = editText2.getText().toString();
                task.description = editText3.getText().toString();

                // Write a message to the database
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference("tasks");
                myRef.child(task._ID).setValue(task);
            }
        });

        startActivity(new Intent(this,Main2Activity.class));


    }
}
