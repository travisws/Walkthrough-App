package woodworth.travis.walkthrough.daysOfWeek;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import woodworth.travis.walkthrough.navStuff.NavigationDrawerAdapter;
import woodworth.travis.walkthrough.R;

/**
 * Created by travis on 7/19/15.
 */
public class FragmentHome extends Fragment {

    private RecyclerView recyclerView;
    private NavigationDrawerAdapter adapter; //Need to change to new adapter.


    public FragmentHome() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {

        View layout = inflater.inflate(R.layout.fragment_home, container, false);

        recyclerView = (RecyclerView) layout.findViewById(R.id.rv);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        // Inflate the layout for this fragment
        return layout;
    }
    /*
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }*/
}
