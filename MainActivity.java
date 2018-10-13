package mhacks.jonjan.firebase_test_2;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.DatabaseReference;
import android.util.Log;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;

import android.view.View;
import android.widget.TextView;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    TextView mTextViewState;
    TextView mTextViewState2;
    Button mButtonButton;

    DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();
    DatabaseReference mCondition = mDatabase.child("polaris").child("0").child("_id");

    String _id = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Get UI Elements
        mTextViewState = (TextView) findViewById(R.id.textViewState);
        mTextViewState2 = (TextView) findViewById(R.id.textViewState2);
        mButtonButton = (Button) findViewById(R.id.buttonButton);

        mTextViewState.setText("525");

        /*
        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                /*
                newPost.child("title").setValue(PostTitle);
                newPost.child("desc").setValue(PostDesc);
                newPost.child("imageUrl").setValue(downloadUrl.toString());
                newPost.child("uid").setValue(mCurrentUser.getUid());
                newPost.child("username").setValue(dataSnapshot.child("name").getValue())
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {

                                if (task.isSuccessful()) {
                                    Intent intent = new Intent(PostActivity.this, MainActivity.class);
                                    startActivity(intent);
                                }
                            }
                        });
                for (DataSnapshot d: dataSnapshot.getChildren()) {
                    _id = (String) d.child("_id").getValue();
                    System.out.print(_id);
                }
                /*
                Entry entry = dataSnapshot.getValue(Entry.class);
                System.out.println(entry._id);
                Log.d("UID", "...")
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                System.out.println("Failed");
            }
        });*/
    }

    @Override
    protected void onStart() {
        super.onStart();

        mCondition.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String text = dataSnapshot.getValue(String.class);
                mTextViewState.setText(text);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        mButtonButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}
