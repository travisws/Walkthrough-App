package woodworth.travis.walkthrough.tabsStuff;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import io.realm.Realm;
import io.realm.RealmResults;
import woodworth.travis.walkthrough.R;
import woodworth.travis.walkthrough.realmHomeStuff.HomeEventsAdapter;
import woodworth.travis.walkthrough.realmHomeStuff.HomeRealmEventsAdapter;
import woodworth.travis.walkthrough.realmHomeStuff.RoomsDB;

/**
 * Created by travis on 7/19/15.
 */
public class FragmentHome extends Fragment {

    private HomeEventsAdapter adapter;
    private Realm realm;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        realm = Realm.getDefaultInstance();
        adapter = new HomeEventsAdapter();
        RecyclerView rv  = (RecyclerView) view.findViewById(R.id.recycler_view_home);
        rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        rv.setAdapter(adapter);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();

        RealmResults<RoomsDB> events = realm.where(RoomsDB.class).findAll();
        HomeRealmEventsAdapter realmAdapter;
        realmAdapter = new HomeRealmEventsAdapter(getActivity().getApplicationContext(), events, true);
        // Set the data and tell the RecyclerView to draw
        adapter.setRealmAdapter(realmAdapter);
        adapter.notifyDataSetChanged();

    }

}