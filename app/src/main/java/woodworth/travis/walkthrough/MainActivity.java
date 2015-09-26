package woodworth.travis.walkthrough;

import android.content.Intent;
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
import android.widget.EditText;
import android.widget.Toast;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmResults;

import woodworth.travis.walkthrough.asyncStuff.SaveInfo;
import woodworth.travis.walkthrough.realmStuff.RoomsDB;
import woodworth.travis.walkthrough.weekStuff.FragmentHome;
import woodworth.travis.walkthrough.weekStuff.FragmentInput;
import woodworth.travis.walkthrough.navStuff.FragmentDrawer;
import woodworth.travis.walkthrough.weekStuff.FragmentNotes;

public class MainActivity extends AppCompatActivity implements FragmentDrawer.FragmentDrawerListener {

    private Toolbar toolbar;
    private FragmentDrawer drawerFragment;
    public static String TAG = MainActivity.class.getSimpleName();

    private Realm realm;

    protected EditText b201, b518, amber, b302, b703, b601, ga405, jet, b404, initials;

    private SaveInfo asyncTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        RealmConfiguration realmConfig = new RealmConfiguration.Builder(this).build();
        //Realm.deleteRealm(realmConfig); //Remember to remove
        Realm.setDefaultConfiguration(realmConfig);
        realm = Realm.getInstance(realmConfig); //DO NOT TOUCH!!! if you want realm to work...

        drawerFragment = (FragmentDrawer) getSupportFragmentManager().findFragmentById(R.id.fragment_navigation_drawer);
        drawerFragment.setUp(R.id.fragment_navigation_drawer, (DrawerLayout) findViewById(R.id.drawer_layout), toolbar);
        drawerFragment.setDrawerListener(this);

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
                title = getString(R.string.home_page);
                break;
            case 1:
                fragment = new FragmentInput();
                title = getString(R.string.input_page);
                break;
            case 2:
                fragment = new FragmentNotes();
                title = getString(R.string.notes_page);
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
    //We are humans and we like to destroy.
    @Override
    protected void onDestroy() {
        super.onDestroy();
        realm.close();
    }

    /*Used to see if there was user input before committing to DB.
     *Passes the text to the AsyncTask(SaveInfo).
     */
    public void isEmpty(View v){
        b201 = (EditText)this.findViewById(R.id.b201);
        b518 = (EditText)this.findViewById(R.id.b518);
        b302 = (EditText)this.findViewById(R.id.b302);
        b703 = (EditText)this.findViewById(R.id.b703);
        b601 = (EditText)this.findViewById(R.id.b601);
        ga405 = (EditText)this.findViewById(R.id.ga405);
        jet = (EditText)this.findViewById(R.id.jet);
        b404 = (EditText)this.findViewById(R.id.b404);
        initials = (EditText)this.findViewById(R.id.initials);

        String b20 = b201.getText().toString(), b51 = b518.getText().toString(), b30 = b302.getText().toString(), b70 = b703.getText().toString(),
                b60 = b601.getText().toString(), ga40 = ga405.getText().toString(), je = jet.getText().toString(), b40 = b404.getText().toString(), initial = initials.getText().toString();

        long qb20 = b201.getText().length(), qb30 = b302.getText().length(), qje = jet.getText().length(), in = initials.getText().length();

        if(qb20 == 0){
            Toast.makeText(getApplicationContext(), "You did not enter text in the box", Toast.LENGTH_LONG).show();
        }else {
            if (qb30 == 0){
                Toast.makeText(getApplicationContext(), "You did not enter text in the box", Toast.LENGTH_LONG).show();
            }else {
                if (qje == 0){
                    Toast.makeText(getApplicationContext(), "You did not enter text in the box", Toast.LENGTH_LONG).show();
                }else {
                    if (in == 0){
                        Toast.makeText(getApplicationContext(), "You did not enter text in the box", Toast.LENGTH_LONG).show();
                    }else{
                        asyncTask = new SaveInfo();
                        asyncTask.execute(b20, b51, b30, b70, b60, ga40, je, b40, initial);
                        Toast.makeText(getApplicationContext(), "Done", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        }
    }

    public FragmentTransaction open(){
        FragmentTransaction fragmentTransaction;
        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        FragmentInput input = new FragmentInput();
        fragmentTransaction.replace(R.id.fragment_input, input);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
        return fragmentTransaction;
    }

    //Used to see realm DB in a toast, but will be remove in final run
    public void realmResults(View view) {
        try {
            RealmResults<RoomsDB> results = realm.where(RoomsDB.class).findAll();
            Toast.makeText(getApplicationContext(), "" + results, Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            Log.d(TAG, "Results" + e);
        }
    }

}