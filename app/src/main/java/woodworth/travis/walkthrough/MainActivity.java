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
import android.widget.EditText;
import android.widget.Toast;

import java.text.DateFormat;
import java.util.Date;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmResults;
import woodworth.travis.walkthrough.realmStuff.RoomsDB;
import woodworth.travis.walkthrough.weekStuff.FragmentHome;
import woodworth.travis.walkthrough.weekStuff.FragmentMonday;
import woodworth.travis.walkthrough.navStuff.FragmentDrawer;

public class MainActivity extends AppCompatActivity implements FragmentDrawer.FragmentDrawerListener {

    private Toolbar toolbar;
    private FragmentDrawer drawerFragment;
    public static String TAG = MainActivity.class.getSimpleName();

    protected  String df = DateFormat.getDateTimeInstance().format(new Date());

    public Realm realm;

    protected EditText b201;
    protected EditText b518;
    protected EditText amber;
    protected EditText b302;
    protected EditText b703;
    protected EditText b601;
    protected EditText ga405;
    protected EditText jet;
    protected EditText b404;
    protected EditText initials;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        RealmConfiguration realmConfig = new RealmConfiguration.Builder(this).build();
        Realm.deleteRealm(realmConfig); //Remember to remove
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
    //We are humans and we like to destroy.
    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    public void isEmpty(View v){
        b201 = (EditText)this.findViewById(R.id.b201);
        b302 = (EditText)this.findViewById(R.id.b302);
        jet = (EditText)this.findViewById(R.id.jet);
        initials = (EditText)this.findViewById(R.id.initials);


        long b20 = b201.getText().length();
        long b30 = b302.getText().length();
        long je = jet.getText().length();
        long in = initials.getText().length();

        if(b20 == 0){
            Toast.makeText(getApplicationContext(), "You did not enter text in this box", Toast.LENGTH_LONG).show();
        }else {
            if (b30 == 0){
                Toast.makeText(getApplicationContext(), "You did not enter text in this box", Toast.LENGTH_LONG).show();
            }else {
                if (je == 0){
                    Toast.makeText(getApplicationContext(), "You did not enter text in this box", Toast.LENGTH_LONG).show();
                }else {
                    if (in == 0){
                        Toast.makeText(getApplicationContext(), "You did not enter text in this box", Toast.LENGTH_LONG).show();
                    }else{
                        Test();
                    }
                }
            }
        }
    }



    public void Test(){

        //Gets user input and binds it to a variable.
        b201 = (EditText)this.findViewById(R.id.b201);
        b518 = (EditText)this.findViewById(R.id.b518);
        amber = (EditText)this.findViewById(R.id.amber);
        b302 = (EditText)this.findViewById(R.id.b302);
        b703 = (EditText)this.findViewById(R.id.b703);
        b601 = (EditText)this.findViewById(R.id.b601);
        ga405 = (EditText)this.findViewById(R.id.ga405);
        jet = (EditText)this.findViewById(R.id.jet);
        b404 = (EditText)this.findViewById(R.id.b404);
        initials = (EditText)this.findViewById(R.id.initials);

        //Sets the raw input to a usable string.
        String b20 = b201.getText().toString();
        String b51 = b518.getText().toString();
        String ambe = amber.getText().toString();
        String b30 = b302.getText().toString();
        String b70 = b703.getText().toString();
        String b60 = b601.getText().toString();
        String ga40 = ga405.getText().toString();
        String je = jet.getText().toString();
        String b40 = b404.getText().toString();
        String initial = initials.getText().toString();

        realm.beginTransaction();
        
        RoomsDB rooms = realm.createObject(RoomsDB.class);

        rooms.setId(1);
        rooms.setDate_time("" + df);
        rooms.setB201("" + b20);
        rooms.setB518("" + b51);
        rooms.setAmber("" + ambe);
        rooms.setB302("" + b30);
        rooms.setB702("" + b70);
        rooms.setB601("" + b60);
        rooms.setGa405("" + ga40);
        rooms.setJet("" + je);
        rooms.setB404("" + b40);
        rooms.setInitials("" + initial);

        realm.commitTransaction();


        //This is just here for debugging
        Log.d(TAG, "transaction" + "done running.");

    }

    public void realmResults(View view) {
        //.contains()
        try {

            RealmResults<RoomsDB> results = realm.where(RoomsDB.class).findAll();
            Toast.makeText(getApplicationContext(), "" + results, Toast.LENGTH_LONG).show();

        } catch (Exception e) {
            Log.d(TAG, "Results" + e);
        }

    }


}