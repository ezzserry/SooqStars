package myapplications.serry.sooqstars.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import myapplications.serry.sooqstars.R;

/**
 * Created by awstreams on 8/1/17.
 */

public class MoreFragment extends Fragment implements View.OnClickListener {
    @BindView(R.id.btn_fav_list)
    Button btnFavList;
    @BindView(R.id.btn_contact_us)
    Button btnContactUs;
    @BindView(R.id.btn_my_ads)
    Button btnMyAds;
    @BindView(R.id.btn_how_to_use)
    Button btnHowUser;
    @BindView(R.id.btn_settings)
    Button btnSettings;
    @BindView(R.id.btn_following_list)
    Button btnFollowingList;

    private View view;

    public static synchronized MoreFragment newInstance() {
        return new MoreFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragement_more, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initViews();
    }

    private void initViews() {
        btnSettings.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {

    }
}
