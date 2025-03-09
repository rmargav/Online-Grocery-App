package com.example.onlinegrocerymargav;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

    EditText etUser,etPass;
    Button btLogin,btSign,btShop;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUser = findViewById(R.id.etLoginEmail);
        etPass = findViewById(R.id.etLoginPassword);

        btLogin = findViewById(R.id.btLoginLogin);
        btSign = findViewById(R.id.btLoginSignUp);
        btShop = findViewById(R.id.btForwardBuy);

        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String user = etUser.getText().toString();
                String pass = etPass.getText().toString();

                if(user.equals("admin") && pass.equals("india"))
                {
                    Intent ii = new Intent(getApplicationContext(),AdminHome.class);
                    startActivity(ii);
                }
                else
                {
                    Toast.makeText(getApplicationContext(), "Invalid User", Toast.LENGTH_SHORT).show();
                }

                etUser.setText("");
                etPass.setText("");
            }
        });

        btShop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent ii = new Intent(getApplicationContext(),ShopGrocery.class);
                startActivity(ii);

            }
        });
    }
}