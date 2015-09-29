package woodworth.travis.walkthrough.realmHomeStuff;

import android.content.Context;

import io.realm.RealmResults;
import woodworth.travis.walkthrough.homeStuff.HomeCardAdapter;

/**
 * Created by travisws on 8/14/15.
 */
public class HomeRealmEventsAdapter extends HomeCardAdapter<RoomsDB> {

    public HomeRealmEventsAdapter(Context context, RealmResults<RoomsDB> realmResults, boolean automaticUpdate) {

        super(context, realmResults, automaticUpdate);
    }
}
