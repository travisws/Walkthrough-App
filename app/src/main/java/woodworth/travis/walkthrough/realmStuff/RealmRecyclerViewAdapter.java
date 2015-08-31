package woodworth.travis.walkthrough.realmStuff;

import android.support.v7.widget.RecyclerView;
import android.widget.AdapterView;

import io.realm.RealmBaseAdapter;
import io.realm.RealmObject;

/**
 * Created by travisws on 8/14/15.
 */
public abstract class RealmRecyclerViewAdapter<T extends RealmObject> extends RecyclerView.Adapter {
    private RealmBaseAdapter<T> realmBaseAdapter;

    /* getItemCount() is not implemented in this class
     * This is left to concrete implementations */
    public void setRealmAdapter(RealmBaseAdapter<T> realmAdapter) {
        realmBaseAdapter = realmAdapter;
    }

    public T getItem(int position) {
        return realmBaseAdapter.getItem(position);
    }

    public RealmBaseAdapter<T> getRealmAdapter() {
        return realmBaseAdapter;
    }
}

