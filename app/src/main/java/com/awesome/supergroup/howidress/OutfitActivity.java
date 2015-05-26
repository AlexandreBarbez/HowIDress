package com.awesome.supergroup.howidress;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.ArrayList;


public class OutfitActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_outfit);
        Intent intent = getIntent();
        ArrayList<String> outfit = intent.getStringArrayListExtra(MainActivity.EXTRA_TENUE);

        buildOutfit(outfit);

    }

    private void buildOutfit(ArrayList<String> p_outfit) {
        TextView textViewToAppend = (TextView)findViewById(R.id. textViewOutfit);
        for (int i = 0; i < p_outfit.size();i++){
            System.out.println(p_outfit.get(i)+" : "+i);

            switch (p_outfit.get(i)){
                case "hat" :    textViewToAppend.append(" un chapeau");
                                break;
                case "scarf" :  textViewToAppend.append(" une echarpe");
                                break;
                case "jacket" : textViewToAppend.append(" un blouson");
                                break;
                case "sweater" :textViewToAppend.append(" un pull");
                                break;
                case "shirt" :  textViewToAppend.append(" un t-shirt");
                                break;
                case "jean" :   textViewToAppend.append(" un jean");
                                break;
                case "shoes" :  textViewToAppend.append(" des chaussures");
                                break;
            }


        }

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
