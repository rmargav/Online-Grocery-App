package com.example.onlinegrocerymargav;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class GroceryInvoice extends AppCompatActivity {

    TextView tvGroceryGrandTotal,tvGroceryBillDate,tvGroceryBillTime;
    ListView lvGroceryPuchased;
    Button btGroceryPayment;
    String totalAmount;
    ArrayList<String> gNameList = new ArrayList<String>();
    ArrayList<String> gQtyList = new ArrayList<String>();
    ArrayList<String> gPriceList = new ArrayList<String>();
    ArrayList<String> gAmountList = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grocery_invoice);

        Intent ii = getIntent();

        totalAmount = ii.getStringExtra("totalamount");
        gNameList = ii.getStringArrayListExtra("gnamelist");
        gQtyList = ii.getStringArrayListExtra("gqtylist");
        gPriceList = ii.getStringArrayListExtra("gpricelist");
        gAmountList = ii.getStringArrayListExtra("gamountlist");

        tvGroceryGrandTotal = findViewById(R.id.tvGroceryGrandTotal);
        lvGroceryPuchased = findViewById(R.id.lvGroceryPurchsed);
        btGroceryPayment = findViewById(R.id.btGroceryPayment);
        tvGroceryBillDate = findViewById(R.id.tvGroceryBillDate);
        tvGroceryBillTime = findViewById(R.id.tvGroceryBillTime);

        tvGroceryGrandTotal.setText("Rs. "+totalAmount);

        GroceryInvoiceAdapter ga = new GroceryInvoiceAdapter(getApplicationContext(),R.layout.groceryitemsbillview,gNameList,gQtyList,gPriceList,gAmountList);
        lvGroceryPuchased.setAdapter(ga);

        btGroceryPayment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(getApplicationContext(),PaymentActivity.class);
                startActivity(i);

            }
        });

    }
}