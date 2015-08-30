package woodworth.travis.walkthrough.realmStuff;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import woodworth.travis.walkthrough.R;

/**
 * Created by travis woodworth-smith on 8/14/15.
 */
public class EventsAdapter extends RealmRecyclerViewAdapter<RoomsDB> {

    private class EventViewHolder extends RecyclerView.ViewHolder {

        public TextView textView;

        public EventViewHolder(View view) {
            super(view);
            textView = (TextView) itemView.findViewById(R.id.title);
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.items_home, parent, false);
        return new EventViewHolder(v);
    }
    //Used to compare and draw items to the RecycleView.
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        EventViewHolder evh = (EventViewHolder) viewHolder;
        RoomsDB event = getItem(i); //Gets realm items

        //List of words to look for.
        String[] words = {"ace", "boom", "crew", "dog", "eon", " ", "a"};
        List<String> wordList = Arrays.asList(words);

        //Used to compare items
        if (wordList.contains(event.getAmber())){
            evh.textView.setText(event.getB201() + " " + event.getAmber());
        }else {
            evh.textView.setText(event.getB201());
        }

    }

    /* The inner RealmBaseAdapter
     * view count is applied here.
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