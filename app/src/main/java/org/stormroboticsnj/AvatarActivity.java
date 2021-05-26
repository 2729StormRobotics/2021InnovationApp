package org.stormroboticsnj;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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
        if (v.getId() == R.id.btn_Customize) {
            Intent intent = new Intent(AvatarActivity.this, CustomizeActivity.class);
            startActivity(intent);
        }

        else if (v.getId() == R.id.btn_Shop) {
            Intent intent = new Intent(AvatarActivity.this, ShopActivity.class);
            startActivity(intent);
        }
    }
}