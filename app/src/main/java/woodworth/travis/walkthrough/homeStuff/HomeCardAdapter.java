package woodworth.travis.walkthrough.homeStuff;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

import io.realm.RealmBaseAdapter;
import io.realm.RealmObject;
import io.realm.RealmResults;
import woodworth.travis.walkthrough.R;

/**
 * Created by travisws on 8/8/15.
 */
public class HomeCardAdapter<T extends RealmObject> extends RealmBaseAdapter<T> {

    public HomeCardAdapter(Context context, RealmResults<T> realmResults, boolean automaticUpdate) {
        super(context, realmResults, automaticUpdate);
        }

    // I'm not sorry.
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
        }
}
