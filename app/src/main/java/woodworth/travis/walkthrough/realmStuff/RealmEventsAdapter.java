package woodworth.travis.walkthrough.realmStuff;

import android.content.Context;

import io.realm.RealmResults;
import woodworth.travis.walkthrough.homeStuff.HomeCardAdapter;
import woodworth.travis.walkthrough.homeStuff.HomeItems;

/**
 * Created by travisws on 8/14/15.
 */
public class RealmEventsAdapter  extends HomeCardAdapter<RoomsDB> {

    public RealmEventsAdapter(Context context, RealmResults<RoomsDB> realmResults, boolean automaticUpdate) {

        super(context, realmResults, automaticUpdate);
    }
}
