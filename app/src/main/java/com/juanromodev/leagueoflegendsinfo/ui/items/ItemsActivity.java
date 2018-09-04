package com.juanromodev.leagueoflegendsinfo.ui.items;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.juanromodev.leagueoflegendsinfo.R;

public class ItemsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_items);

        ItemsFragment itemsFragment =
                (ItemsFragment) getSupportFragmentManager().findFragmentById(R.id.items_fragment_container);
        if (itemsFragment == null) {
            itemsFragment = ItemsFragment.newInstance();
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.items_fragment_container, itemsFragment)
                    .commit();
        }
    }
}
