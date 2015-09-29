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
import woodworth.travis.walkthrough.realmHomeStuff.RoomsDB;
import woodworth.travis.walkthrough.realmNotesStuff.NotesEventsAdapter;
import woodworth.travis.walkthrough.realmNotesStuff.NotesRealmEventsAdapter;


public class FragmentNotes extends Fragment {

    private NotesEventsAdapter adapter;
    private Realm realm;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_notes, container, false);

        realm = Realm.getDefaultInstance();
        adapter = new NotesEventsAdapter();
        RecyclerView rv  = (RecyclerView) view.findViewById(R.id.recycler_view_notes);
        rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        rv.setAdapter(adapter);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();

        RealmResults<RoomsDB> events = realm.where(RoomsDB.class).contains("date_time", "Sep").findAll();
        NotesRealmEventsAdapter realmAdapter;
        realmAdapter = new NotesRealmEventsAdapter(getActivity().getApplicationContext(), events, true);
        // Set the data and tell the RecyclerView to draw
        adapter.setRealmAdapter(realmAdapter);
        adapter.notifyDataSetChanged();

    }

}
