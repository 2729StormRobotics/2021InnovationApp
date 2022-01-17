package org.stormroboticsnj.otium;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

public class CustomizableActivity extends AppCompatActivity {

    private static final String[] NAMES = {
            "Acquire",
            "Score",
            "Traverse"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customizable);

        ConstraintLayout layout = findViewById(R.id.customizable_layout);
        addButtons(NAMES, layout, this);

    }

    private static void addButtons(String[] names, ConstraintLayout layout, CustomizableActivity activity) {
        ConstraintSet set = new ConstraintSet();

        // Add a button for each name in the names array. Save them to an array
        // so we can access them later.
        Button[] buttons = new Button[names.length + 2];

        // Create start button
        Button startButton = new Button(activity);
        startButton.setText("Start");
        startButton.setId(View.generateViewId());
        layout.addView(startButton);
        set.clone(layout);

        buttons[0] = startButton;
        // Constrain start button
        set.connect(startButton.getId(), ConstraintSet.TOP, layout.getId(), ConstraintSet.TOP, 0);

        // Center start button
        set.connect(startButton.getId(), ConstraintSet.LEFT, layout.getId(), ConstraintSet.LEFT, 0);
        set.connect(startButton.getId(), ConstraintSet.RIGHT, layout.getId(), ConstraintSet.RIGHT, 0);
        set.applyTo(layout);

        for (int i = 1; i < names.length + 1; i++) {
            buttons[i] = new Button(activity);
            buttons[i].setText(names[i - 1]);
            buttons[i].setId(View.generateViewId());
            layout.addView(buttons[i]);
            set.clone(layout);

            // Chain buttons together
            set.connect(buttons[i].getId(), ConstraintSet.TOP, buttons[i - 1].getId(), ConstraintSet.BOTTOM, 0);
            set.connect(buttons[i - 1].getId(), ConstraintSet.BOTTOM, buttons[i].getId(), ConstraintSet.TOP, 0);

            // Align buttons horizontally
            set.connect(buttons[i].getId(), ConstraintSet.LEFT, buttons[i - 1].getId(), ConstraintSet.LEFT, 0);
            set.connect(buttons[i].getId(), ConstraintSet.RIGHT, buttons[i - 1].getId(), ConstraintSet.RIGHT, 0);

            set.applyTo(layout);
        }

        // Create stop button
        Button endButton = new Button(activity);
        endButton.setText("Stop");
        endButton.setId(View.generateViewId());
        layout.addView(endButton);
        set.clone(layout);
        buttons[buttons.length - 1] = endButton;

        // Constrain stop button
        set.connect(endButton.getId(), ConstraintSet.TOP, buttons[buttons.length - 2].getId(), ConstraintSet.BOTTOM, 0);
        set.connect(buttons[buttons.length - 2].getId(), ConstraintSet.BOTTOM, endButton.getId(), ConstraintSet.TOP, 0);

        // Align stop button horizontally
        set.connect(endButton.getId(), ConstraintSet.LEFT, buttons[buttons.length - 2].getId(), ConstraintSet.LEFT, 0);
        set.connect(endButton.getId(), ConstraintSet.RIGHT, buttons[buttons.length - 2].getId(), ConstraintSet.RIGHT, 0);
        // Constrain stop button to the bottom of the screen
        set.connect(endButton.getId(), ConstraintSet.BOTTOM, layout.getId(), ConstraintSet.BOTTOM, 0);

        set.applyTo(layout);



    }
}