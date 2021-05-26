package org.stormroboticsnj;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AvatarActivity extends AppCompatActivity  implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_avatar);

        Button customize = findViewById(R.id.btn_Customize);
        Button shop = findViewById(R.id.btn_Shop);

        customize.setOnClickListener(this);
        shop.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

    }
}