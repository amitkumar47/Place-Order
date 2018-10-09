package com.example.ak47.placeorder;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void inc (View view){
        TextView t1 = (TextView)findViewById(R.id.quantity);
        int num1 = Integer.parseInt(t1.getText().toString());
        num1++;
        t1.setText(Integer.toString(num1));
    }
    public void dec (View view){
        TextView t1 = (TextView)findViewById(R.id.quantity);
        int num1 = Integer.parseInt(t1.getText().toString());
        if(num1>1)
            num1--;
        else
        { Toast a1 = (Toast.makeText(getApplicationContext(),"ORDER ATLEAST 1 COFFEE",Toast.LENGTH_LONG));
            a1.show();
        }
        t1.setText(Integer.toString(num1));
    }
    public void order (View view){
        EditText e1 = (EditText) findViewById(R.id.name);
        String name = e1.getText().toString();
        CheckBox c1 = (CheckBox) findViewById(R.id.cream);
        boolean cream = c1.isChecked();
        CheckBox c2 = (CheckBox) findViewById(R.id.chocolate);
        boolean chocolate = c2.isChecked();
        TextView t1 = (TextView)findViewById(R.id.quantity);

        int quantity = Integer.parseInt(t1.getText().toString());
        int price = quantity * 5;
        if (cream)
            price++;
        if (chocolate)
            price++;

        TextView s1 = (TextView) findViewById(R.id.summary);
        String message= "Name:"+name+"\nAdd Whipped Cream:"+cream+"\nAdd Chocolate:"+chocolate+"\nQuantity:"+quantity+"\nTotal:$"+price+"\n Thank You!";
        String email="thakuramitsingh5001@gmail.com";
        {
            Intent intent = new Intent(Intent.ACTION_SENDTO);
            intent.setData(Uri.parse("mailto:")); // only email apps should handle this
            intent.putExtra(Intent.EXTRA_EMAIL, email);
            intent.putExtra(Intent.EXTRA_SUBJECT, "Placing order for "+name);
            intent.putExtra(Intent.EXTRA_TEXT, message);
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            }
        }
}}
