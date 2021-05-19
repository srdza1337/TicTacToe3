package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import static java.lang.Integer.parseInt;

public class First_Page extends AppCompatActivity {
    //public static final String EXTRA_TEXT = "com.example.tictactoe.EXTRA_TEXT";
    private Button add;
    Spinner sp;
    ArrayAdapter<String> adapter;
    static String names[] = {"3x3", "4x4", "5x5", "6x6"};
    String record = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_page);
        add = findViewById(R.id.addName);
        sp = findViewById(R.id.spin);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, names);
        sp.setAdapter(adapter);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GameMode();
            }
        });

    }

    private void GameMode() {
        EditText playerOne = findViewById(R.id.playerName1);
        EditText playerTwo = findViewById(R.id.playerName2);

        String pl1 = playerOne.getText().toString().trim();
        String pl2 = playerTwo.getText().toString().trim();
        String spinner = sp.getSelectedItem().toString();//novo

        switch (spinner) {
            case "3x3":
                Intent i = new Intent(First_Page.this, MainActivity.class);
                i.putExtra("pl1", pl1);
                i.putExtra("pl2", pl2);
                startActivity(i);
                break;
            case "4x4":
                Intent i4x4 = new Intent(First_Page.this, Game4x4.class);
                i4x4.putExtra("pl1", pl1);
                i4x4.putExtra("pl2", pl2);
                startActivity(i4x4);
                break;
            case "5x5":
                Intent i5x5 = new Intent(First_Page.this, Game5x5.class);
                i5x5.putExtra("pl1", pl1);
                i5x5.putExtra("pl2", pl2);
                startActivity(i5x5);
                break;
            case "6x6":
                Intent i6x6 = new Intent(First_Page.this, Game6x6.class);
                i6x6.putExtra("pl1", pl1);
                i6x6.putExtra("pl2", pl2);
                startActivity(i6x6);
                break;
        }
    }

}