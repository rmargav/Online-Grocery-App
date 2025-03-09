package com.example.onlinegrocerymargav;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

import com.razorpay.Checkout;
import com.razorpay.PaymentResultListener;

import org.json.JSONObject;

public class PaymentActivity extends Activity implements PaymentResultListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        Checkout checkout = new Checkout();
        checkout.setKeyID("rzp_test_gcSCXENrJeCCv7");

        JSONObject object = new JSONObject();

        try
        {
            object.put("name","Vikas Patni");
            object.put("description","Thankyou for your purchase");
            object.put("theme.color","#0093DD");
            object.put("currency","INR");
            object.put("amount",(12000*100));
            object.put("prefill.content","7874393661");
            object.put("prefill","my@gmail.com");

        }
        catch (Exception e)
        {
            Toast.makeText(getApplicationContext(),"Payment Error : "+e.getMessage(),Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onPaymentSuccess(String s) {

    }

    @Override
    public void onPaymentError(int i, String s) {

    }
}