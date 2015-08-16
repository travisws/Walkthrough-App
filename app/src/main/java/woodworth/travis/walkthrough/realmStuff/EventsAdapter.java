package woodworth.travis.walkthrough.realmStuff;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import woodworth.travis.walkthrough.R;

/**
 * Created by travisws on 8/14/15.
 */
public class EventsAdapter extends RealmRecyclerViewAdapter<RoomsDB> {

    private class EventViewHolder extends RecyclerView.ViewHolder {
        public TextView tvName;
        public EventViewHolder(View view) {
            super(view);
            tvName = (TextView) itemView.findViewById(R.id.title);
        }
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
        evh.tvName.setText(event.getB201() + " " + event.getAmber());
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
