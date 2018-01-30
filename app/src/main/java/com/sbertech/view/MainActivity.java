package com.sbertech.view;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;

import com.sbertech.R;

public class MainActivity extends AppCompatActivity {
    public static final String TAG_TASK_FRAGMENT = "tagTaskFragment";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        FragmentManager fm = getSupportFragmentManager();
        BlankFragment mTaskFragment = (BlankFragment) fm.findFragmentByTag(TAG_TASK_FRAGMENT);
        if (mTaskFragment == null) {
            mTaskFragment = new BlankFragment();
            fm.beginTransaction().replace(R.id.fragmentContainer, mTaskFragment, TAG_TASK_FRAGMENT).commit();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
}
