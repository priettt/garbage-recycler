package com.unicen.garbage.ui.main;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.unicen.garbage.R;
import com.unicen.garbage.domain.entities.Recycling;
import com.unicen.garbage.ui.main.ActualFragment;
import com.unicen.garbage.ui.main.CreateUserActivity;
import com.unicen.garbage.ui.main.HistoryFragment;
import com.unicen.garbage.ui.main.SectionsPagerAdapter;
import com.unicen.garbage.ui.main.TotalFragment;

public class MainActivity extends AppCompatActivity implements
        TotalFragment.OnFragmentInteractionListener,
        ActualFragment.OnSubmitToServerPressedListener,
        HistoryFragment.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar mainToolbar = findViewById(R.id.main_toolbar);
        setSupportActionBar(mainToolbar);
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.create_user_action) {
            this.startActivity(new Intent(this, CreateUserActivity.class));
        }
        return true;
    }

    @Override
    public void onFragmentInteraction(Uri uri) {
        //something
    }


    @Override
    public void onSubmitToServerPressed(Recycling recycling) {

    }
}