package woodworth.travis.walkthrough.weekStuff;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import woodworth.travis.walkthrough.R;


public class FragmentNotes extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_notes, container, false);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();

    }

}
