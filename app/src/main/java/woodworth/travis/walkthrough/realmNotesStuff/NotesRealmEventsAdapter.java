package woodworth.travis.walkthrough.realmNotesStuff;

import android.content.Context;

import io.realm.RealmResults;
import woodworth.travis.walkthrough.homeStuff.HomeCardAdapter;
import woodworth.travis.walkthrough.homeStuff.HomeItems;
import woodworth.travis.walkthrough.realmHomeStuff.RoomsDB;

/**
 * Created by travisws on 8/14/15.
 */
public class NotesRealmEventsAdapter  extends HomeCardAdapter<RoomsDB> {

    public NotesRealmEventsAdapter(Context context, RealmResults<RoomsDB> realmResults, boolean automaticUpdate) {

        super(context, realmResults, automaticUpdate);
    }
}
