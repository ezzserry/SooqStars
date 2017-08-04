package myapplications.serry.sooqstars.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import myapplications.serry.sooqstars.R;

/**
 * Created by awstreams on 8/1/17.
 */

public class MessagesFragment extends Fragment {

    private View view;

    public static synchronized MessagesFragment newInstance() {
        return new MessagesFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_list, container, false);
        return view;
    }
}
