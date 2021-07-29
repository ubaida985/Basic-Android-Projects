package com.example.paymentapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.paypal.checkout.PayPalCheckout;
import com.paypal.checkout.config.CheckoutConfig;
import com.paypal.checkout.config.Environment;
import com.paypal.checkout.config.SettingsConfig;
import com.paypal.checkout.createorder.CurrencyCode;
import com.paypal.checkout.createorder.UserAction;
import com.paypal.pyplcheckout.BuildConfig;

public class MainActivity extends AppCompatActivity {

    //Buttons
    private Button buttonPaypal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //casting method
        castVaribles();
        CheckoutConfig config = new CheckoutConfig(
                this,
                ClientConfiguration.PAYPAL_CLIENT_ID,
                Environment.SANDBOX,
                String.format("%s://paypalpay", BuildConfig.APPLICATION_ID),
                CurrencyCode.USD,
                UserAction.PAY_NOW,
                new SettingsConfig(
                        true,
                        false
                )
        );
        PayPalCheckout.setConfig(config);

    }

    private void castVaribles() {
        buttonPaypal = findViewById(R.id.buttonPaypal);
    }

    private void paypalPayment(View view) {

    }
}