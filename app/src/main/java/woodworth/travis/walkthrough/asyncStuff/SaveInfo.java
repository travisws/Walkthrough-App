package woodworth.travis.walkthrough.asyncStuff;


import android.os.AsyncTask;

import java.text.DateFormat;
import java.util.Date;

import io.realm.Realm;
import woodworth.travis.walkthrough.realmStuff.RoomsDB;

/**
 * Created by travisws on 8/15/15.
 */
public class SaveInfo extends AsyncTask<String, String, String> {

    private Realm realm;
    protected  String df = DateFormat.getDateTimeInstance().format(new Date());

    @Override
    protected String doInBackground(String... args) {

        String b20 = args[0], b51= args[1], ambe = args[2], b30 = args[3], b70 = args[4], b60 = args[5], ga40 = args[6], je = args[7], b40 = args[8], initial = args[9];

        realm = Realm.getDefaultInstance();

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

        return "done";
    }
}

