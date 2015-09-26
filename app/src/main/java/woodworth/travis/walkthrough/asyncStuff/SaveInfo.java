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

        String a = args[0], b = args[1], c = args[2], d = args[3], e = args[4], f = args[5], g = args[6], h = args[7], i = args[8];

        realm = Realm.getDefaultInstance();

        realm.beginTransaction();

        RoomsDB rooms = realm.createObject(RoomsDB.class);

        rooms.setId(1);
        rooms.setDate_time("" + df);
        rooms.setB201("" + a);
        rooms.setB518("" + b);
        rooms.setB302("" + c);
        rooms.setB702("" + d);
        rooms.setB601("" + e);
        rooms.setGa405("" + f);
        rooms.setJet("" + g);
        rooms.setB404("" + h);
        rooms.setInitials("" + h);

        realm.commitTransaction();

        return "done";
    }
}

