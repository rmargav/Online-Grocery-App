package com.example.onlinegrocerymargav;


import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AdminHome extends Activity {
    Button btHomeAddGrocery,btHomeDeleteGrocery,btHomeUpdateGrocery,btHomeListGroery;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_home);

        btHomeAddGrocery = findViewById(R.id.btHomeAddGrocery);
        btHomeDeleteGrocery = findViewById(R.id.btHomeDelGrocery);
        btHomeUpdateGrocery = findViewById(R.id.btHomeUpdGrocery);
        btHomeListGroery = findViewById(R.id.btHomeListGrocery);

        btHomeAddGrocery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent ii = new Intent(getApplicationContext(),AddGrocery.class);
                startActivity(ii);
            }
        });

    }
}