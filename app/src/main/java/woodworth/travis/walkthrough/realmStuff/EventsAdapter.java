package woodworth.travis.walkthrough.realmStuff;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import io.realm.Realm;
import io.realm.RealmResults;
import woodworth.travis.walkthrough.R;
import woodworth.travis.walkthrough.asyncStuff.SaveInfo;

/**
 * Created by travis woodworth-smith on 8/14/15.
 */
public class EventsAdapter extends RealmRecyclerViewAdapter<RoomsDB> {

    private Realm realm;

    private class EventViewHolder extends RecyclerView.ViewHolder {
        public TextView textView;
        public EventViewHolder(View view) {
            super(view);
            textView = (TextView) itemView.findViewById(R.id.title);
        }
    }
    //Need to work on it for it to compare
    private String test(String results){

        realm = Realm.getDefaultInstance();
        RealmResults<RoomsDB> room = realm.where(RoomsDB.class).contains("b201", "test").findAll();

        for(RoomsDB obj : room){

            if (!obj.getB201().equals("test")){

            }

        }
        return results;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.items_home, parent, false);
        return new EventViewHolder(v);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        EventViewHolder evh = (EventViewHolder) viewHolder;
        RoomsDB event = getItem(i);
        evh.textView.setText(event.getB201() + " " + test("help"));
    }


    /* The inner RealmBaseAdapter
     * view count is applied here.
     *
     * getRealmAdapter is defined in RealmRecyclerViewAdapter.
     */
    @Override
    public int getItemCount() {
        if (getRealmAdapter() != null) {
            return getRealmAdapter().getCount();
        }
        return 0;
    }
}