package woodworth.travis.walkthrough;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import io.realm.Realm;
import io.realm.RealmResults;
import woodworth.travis.walkthrough.daysOfWeek.FragmentHome;
import woodworth.travis.walkthrough.daysOfWeek.FragmentMonday;
import woodworth.travis.walkthrough.navStuff.FragmentDrawer;
import woodworth.travis.walkthrough.realmStuff.RoomsDB;

public class MainActivity extends AppCompatActivity implements FragmentDrawer.FragmentDrawerListener {

    private Toolbar toolbar;
    private FragmentDrawer drawerFragment;
    public static String TAG = MainActivity.class.getSimpleName();

    public Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        drawerFragment = (FragmentDrawer) getSupportFragmentManager().findFragmentById(R.id.fragment_navigation_drawer);
        drawerFragment.setUp(R.id.fragment_navigation_drawer, (DrawerLayout) findViewById(R.id.drawer_layout), toolbar);
        drawerFragment.setDrawerListener(this);

        realm = Realm.getInstance(this); //DO NOT TOUCH!!! if you want realm to work...

        transaction();

        // display the first navigation drawer view on app launch
        displayView(0);

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

    //@Override
    public void onDrawerItemSelected(View view, int position) {
        displayView(position);
    }

    private void displayView(int position) {
        Fragment fragment = null;
        String title = getString(R.string.app_name);
        switch (position) {
            case 0:
                fragment = new FragmentHome();
                //title = getString(R.string.drawer_close);
                break;
            case 1:
                fragment = new FragmentMonday();
                break;
            default:
                break;
        }

        if (fragment != null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.container_body, fragment);
            fragmentTransaction.commit();

            // set the toolbar title
            getSupportActionBar().setTitle(title);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        realm.close(); // Remember to close.
    }

    public void transaction(){

        try{
            realm.beginTransaction();
            RoomsDB person = realm.createObject(RoomsDB.class);
            person.setId(1);
            person.setB201("2B201");
            Log.d(TAG, "done");
            realm.commitTransaction();
        }catch(Exception e){
            Log.d(TAG, "Transaction" + e);
        }

    }


    public void realmResults(View view) {
        try {
            RealmResults<RoomsDB> results = realm.where(RoomsDB.class).findAll();
            Toast.makeText(getApplicationContext(), "Results" + results, Toast.LENGTH_LONG).show();
            Log.d(TAG, "Results" + results);
        } catch (Exception e) {
            Log.d(TAG, "Results" + e);
        }
    }

}