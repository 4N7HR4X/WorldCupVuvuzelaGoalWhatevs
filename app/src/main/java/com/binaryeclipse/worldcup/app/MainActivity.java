package com.binaryeclipse.worldcup.app;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.binaryeclipse.worldcup.app.views.home.fragments.HomeFragment;

public class MainActivity extends Activity {

    private static final int HOME_FRAGMENT = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showScreen(HOME_FRAGMENT, null);
    }

    private void showScreen(int fragmentType, Bundle args) {
        switch (fragmentType) {
            case HOME_FRAGMENT:
                replaceFragment(new HomeFragment(), false);
        }
    }

    private void replaceFragment(Fragment fragment, boolean addToBackStack) {
        FragmentTransaction transaction = getFragmentManager()
                .beginTransaction()
                //.setCustomAnimations(R.anim.fragment_enter, R.anim.fragment_exit)
                .replace(R.id.content, fragment);
        if (addToBackStack) {
            transaction.addToBackStack(fragment.getClass().getSimpleName());
        }
        transaction.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
