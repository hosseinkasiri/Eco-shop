package com.example.databaseroom;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    private Button mAddButton;
    private RecyclerView mRecyclerView;
    private static final String DIALOG_TAG = "dialog tag";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAddButton = findViewById(R.id.add_button);
        mAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogAddUser addUser = DialogAddUser.newInstance();
                addUser.show(getSupportFragmentManager(),null);
                addUser.setOnAddButtonClick(new OnAddButtonClick() {
                    @Override
                    public void onAddButton(String firstName, String lastName) {
                        User user = new User();
                        user.setFirstName(firstName);
                        user.setLastName(lastName);
                        AppDatabase.getInstance(getBaseContext()).userDao().insertAll(user);
                    }
                });
            }
        });
        }
    }