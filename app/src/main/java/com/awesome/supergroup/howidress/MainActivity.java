package com.awesome.supergroup.howidress;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Switch;

import java.util.ArrayList;


public class MainActivity extends ActionBarActivity {


    public static final String EXTRA_TENUE = "com.awesome.supergroup.howidress.tenue";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
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

    public void searchClothes(View view) {
        Intent intent = new Intent(this, OutfitActivity.class);
        ArrayList<String> outfit = new ArrayList<String>();

        Switch switchHat = (Switch)findViewById(R.id.switchHat);
        if (switchHat.isChecked()){
            outfit.add(e_clothes.hat.toString());
        }
        Switch switchScarf = (Switch)findViewById(R.id.switchScarf);
        if (switchScarf.isChecked()){
            outfit.add(e_clothes.scarf.toString());
        }
        Switch switchJacket = (Switch)findViewById(R.id.switchJacket);
        if (switchJacket.isChecked()){
            outfit.add(e_clothes.jacket.toString());
        }
        Switch switchSweater = (Switch)findViewById(R.id.switchSweater);
        if (switchSweater.isChecked()){
            outfit.add(e_clothes.sweater.toString());
        }
        Switch switchShirt = (Switch)findViewById(R.id.switchShirt);
        if (switchShirt.isChecked()){
            outfit.add(e_clothes.shirt.toString());
        }
        Switch switchJean = (Switch)findViewById(R.id.switchJean);
        if (switchJean.isChecked()){
            outfit.add(e_clothes.jean.toString());
        }
        Switch switchShoes = (Switch)findViewById(R.id.switchShoes);
        if (switchShoes.isChecked()){
            outfit.add(e_clothes.shoes.toString());
        }

        System.out.println(outfit);

        intent.putStringArrayListExtra(EXTRA_TENUE, outfit);
        startActivity(intent);
    }
}
