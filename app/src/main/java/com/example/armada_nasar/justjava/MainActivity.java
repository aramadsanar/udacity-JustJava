package com.example.armada_nasar.justjava;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int numberOfCoffee = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        numberOfCoffee = 2;
        ((TextView)findViewById(R.id.quantity)).setText(new Integer(numberOfCoffee).toString());
        calculatePrice(null);


        //Log.v("Whipped Cream: ", whipped_cream.toString() + "");
    }

    public void calculatePrice(View view) {

       // String priceString = "";

        CheckBox cb = (CheckBox) findViewById(R.id.lolicon);
        CheckBox chocolate = (CheckBox) findViewById(R.id.cibai);
        numberOfCoffee = Integer.parseInt(((TextView)findViewById(R.id.quantity)).getText().toString());

        //TextView priceTextView = (TextView) findViewById(R.id.priceLabel);
        int basePrice = 5;
        if (cb.isChecked()) basePrice++;
        if (chocolate.isChecked()) basePrice +=2;
        int price = new Integer(numberOfCoffee * basePrice);


        //priceString= "Amount due: " + "$" + price+ ".\n" + "Thank you for ordering.";
        //priceTextView.setText(createOrderSummary(numberOfCoffee, price));
    }
    public void createOrderSummary(int quantity, int price) {
        EditText name = (EditText) findViewById(R.id.nameText);
        CheckBox cb = (CheckBox) findViewById(R.id.lolicon);
        CheckBox chocolate = (CheckBox) findViewById(R.id.cibai);
        cb.isChecked();
        String isCheck = "false";
        if (cb.isChecked())
            isCheck = "true";
        String isChocolate = "false";

        if (chocolate.isChecked())
            isChocolate = "true";
        String orderSummary = "Name: " + name.getText().toString() + "\n"+ "Add whipped cream? " + isCheck + "\n"+ "Add chocolate? " + isChocolate +  "\n" + "Quantity: " + quantity + "\nTotal: $" + price + "\nThank you!\n";
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("*/*");
        intent.putExtra(Intent.EXTRA_TEXT, orderSummary);

        if (intent.resolveActivity(getPackageManager()) != null)
            startActivity(intent);


        //return orderSummary;
        //return "";
    }
    public void increment(View view) {
        numberOfCoffee++;
        if (numberOfCoffee > 100) {
            numberOfCoffee = 100;
            Toast.makeText(this, "You can't have more than 100 coffees", Toast.LENGTH_SHORT);
        }

        ((TextView)findViewById(R.id.quantity)).setText(new Integer(numberOfCoffee).toString());
    }

    public void decrement(View view) {
        Toast.makeText(this, "You can't have less than 1 coffee", Toast.LENGTH_LONG);
        if (numberOfCoffee > 0) {
            numberOfCoffee--;

            if (numberOfCoffee < 1) {
                numberOfCoffee = 1;

            }

            ((TextView) findViewById(R.id.quantity)).setText(new Integer(numberOfCoffee).toString());
        }
    }
}
