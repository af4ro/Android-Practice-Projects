package com.example.android.practiceset2;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import static com.example.android.practiceset2.R.id.quantity_text_view;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // PASTE CODE YOU WANT TO TEST HERE
    }

    /**
     * Display methods that allow the text to appear on the screen. Don't worry if you don't know
     * how these work yet. We'll be covering them in lesson 3.
     */
    boolean whipppedCream = false;
    boolean chocolate = false;
    String name ;
    int coffeeCount = 1;

    public void display(String text) {
        TextView t = (TextView) findViewById(R.id.display_text_view);
        t.setText(text);
    }

    public void addWhipCream(View view)
    {
        if (((CheckBox) view).isChecked())
        {
            whipppedCream = true;
        }
        else
        {
            whipppedCream = false;
        }
    }

    public void addChocolate(View view)
    {
        if (((CheckBox) view).isChecked())
        {
            chocolate = true;
        }
        else
        {
            chocolate = false;
        }
    }

    public void increment(View view)
    {
        coffeeCount++;
        ((TextView) findViewById(R.id.quantity_text_view)).setText((""+coffeeCount));
    }

    public void decrement(View view)
    {
        coffeeCount--;
        ((TextView) findViewById(R.id.quantity_text_view)).setText((""+coffeeCount));
    }

    public void order_button(View view)
    {

        name = "" + ((EditText) findViewById(R.id.name_edit_text)).getText();
        String toDisplay = "";
        if (name != "")
            toDisplay+=("Name: "+name+"\n");
        if (whipppedCream)
            toDisplay+=("Whipped Cream present\n");
        if (chocolate)
            toDisplay+=("Chocolate present\n");
        toDisplay+=("Cost: $"+(coffeeCount*5));
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("geo:47.6,-122.3"));
        intent.setPackage("com.google.android.apps.maps");
        if (intent.resolveActivity(getPackageManager()) != null)
            startActivity(intent);
    }

    public void display(int text) {
        TextView t = (TextView) findViewById(R.id.display_text_view);
        t.setText(text + "");
    }

}