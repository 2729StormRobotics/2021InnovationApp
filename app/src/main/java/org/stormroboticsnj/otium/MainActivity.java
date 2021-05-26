package org.stormroboticsnj.otium;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

// Make sure to implement the listener so you can handle button clicks
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find the buttons from the layout using their IDs
        Button learnButton = findViewById(R.id.main_btn_learn);
        Button journalButton = findViewById(R.id.main_btn_journal);

        // Tell the buttons to look at this class as the click-handler
        learnButton.setOnClickListener(this);
        journalButton.setOnClickListener(this);
    }

    // Override the onClick method (android will do this for you) and here is your button code
    @Override
    public void onClick(View v) {
        // v.getId() tells you which button was clicked
        switch (v.getId()) {
            case R.id.main_btn_learn:
                // To start another activity use this intent syntax
                // The first argument is this class (context), and the second argument is the activity you want to start
                Intent learnIntent = new Intent(MainActivity.this, LearnActivity.class);
                startActivity(learnIntent);
                break;
            case R.id.main_btn_journal:
                Intent journalIntent = new Intent(MainActivity.this, JournalActivity.class);
                startActivity(journalIntent);
                break;
        }
    }
}