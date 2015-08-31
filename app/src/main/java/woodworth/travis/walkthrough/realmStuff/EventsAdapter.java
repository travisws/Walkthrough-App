package woodworth.travis.walkthrough.realmStuff;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import woodworth.travis.walkthrough.R;

/**
 * Created by travis woodworth-smith on 8/14/15.
 */
public class EventsAdapter extends RealmRecyclerViewAdapter<RoomsDB> {
    String value;

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

        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("h:mm a");
        String formattedDate = sdf.format(date);

        //List of words to look for.
        String[] words = {"xdp", "Xdp", "temp", "Temp", "fault", "Fault"};
        List<String> wordList = Arrays.asList(words);
        Pattern pattern = Pattern.compile(String.valueOf(wordList));
        Matcher b201 = pattern.matcher(event.getB201().toLowerCase().trim()), b518 = pattern.matcher(event.getB518().toLowerCase().trim()), b302 = pattern.matcher(event.getB302().toLowerCase().trim()),
                b702 = pattern.matcher(event.getB702().toLowerCase().trim()), b601 = pattern.matcher(event.getB601().toLowerCase().trim()), ga405 = pattern.matcher(event.getGa405().toLowerCase().trim()),
                b404 = pattern.matcher(event.getB404().toLowerCase().trim());

        //Used to compare items
        if (b201.find()) {
            evh.textView.setText("2B201: " + event.getB201() + " Time:" + formattedDate + " Initials:" + event.getInitials());
        } else if (b518.find()) {
            evh.textView.setText("2B518: " + event.getB518() + " Time:" + formattedDate + " Initials:" + event.getInitials());
        } else if (b302.find()) {
            evh.textView.setText("2B302: " + event.getB302() + " Time:" + formattedDate + " Initials:" + event.getInitials());
        } else if (b702.find()) {
            evh.textView.setText("2B702: " + event.getB702() + " Time:" + formattedDate + " Initials:" + event.getInitials());
        } else if (b601.find()) {
            evh.textView.setText("2B601: " + event.getB601() + " Time:" + formattedDate + " Initials:" + event.getInitials());
        } else if (ga405.find()) {
            evh.textView.setText("GA405: " + event.getGa405() + " Time:" + formattedDate + " Initials:" + event.getInitials());
        } else if (b404.find()) {
            evh.textView.setText("2B404: " + event.getB404() + " Time:" + formattedDate + " Initials:" + event.getInitials());
        } else {
            evh.textView.setText("All Room Are Good:" + " Time:"+ formattedDate + " Initials:" + event.getInitials());
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