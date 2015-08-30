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

        String a = args[0], b = args[1], c = args[2], d = args[3], e = args[4], f = args[5], g = args[6], h = args[7], i = args[8], j = args[9];

        realm = Realm.getDefaultInstance();

        realm.beginTransaction();

        RoomsDB rooms = realm.createObject(RoomsDB.class);

        rooms.setId(1);
        rooms.setDate_time("" + df);
        rooms.setB201("" + a);
        rooms.setB518("" + b);
        rooms.setAmber("" + c);
        rooms.setB302("" + d);
        rooms.setB702("" + e);
        rooms.setB601("" + f);
        rooms.setGa405("" + g);
        rooms.setJet("" + h);
        rooms.setB404("" + i);
        rooms.setInitials("" + j);

        realm.commitTransaction();

        return "done";
    }
}

