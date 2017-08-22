package myapplications.serry.sooqstars.activities;

import android.content.res.ColorStateList;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.internal.BottomNavigationItemView;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import myapplications.serry.sooqstars.R;
import myapplications.serry.sooqstars.fragments.AdDetailsFragment;
import myapplications.serry.sooqstars.fragments.HomeFragment;
import myapplications.serry.sooqstars.fragments.MessagesFragment;
import myapplications.serry.sooqstars.fragments.MoreFragment;
import myapplications.serry.sooqstars.fragments.NotificationsFragment;
import myapplications.serry.sooqstars.interfaces.OnAdClickListener;
import myapplications.serry.sooqstars.models.Ad;

/**
 * Created by awstreams on 8/1/17.
 */

public class MainActivity extends AppCompatActivity implements View.OnClickListener, OnAdClickListener {
    @BindView(R.id.bottom_navigation)
    LinearLayout bottomNavigationItemView;
    @BindView(R.id.ib_home)
    ImageButton ibHome;
    @BindView(R.id.ib_add_ad)
    ImageButton ibAddAd;
    @BindView(R.id.ib_notifications)
    ImageButton ibNotifications;
    @BindView(R.id.ib_messages)
    ImageButton ibMessages;
    @BindView(R.id.ib_more)
    ImageButton ibMore;
    ArrayList<ImageButton> menuItems = new ArrayList();
    @BindView(R.id.toolbar)
    CoordinatorLayout toolbar;
    @BindView(R.id.tv_page_title)
    TextView tvPageTitle;
    private ImageButton ibSearch, ibSideMenu;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initViews();
    }

    private void initViews() {
        menuItems.add(0, ibHome);
        menuItems.add(1, ibMessages);
        menuItems.add(2, ibNotifications);
        menuItems.add(3, ibMore);
        ibHome.setOnClickListener(this);
        ibAddAd.setOnClickListener(this);
        ibNotifications.setOnClickListener(this);
        ibMessages.setOnClickListener(this);
        ibMore.setOnClickListener(this);
        selectHomeFragment();
    }

    private void selectHomeFragment() {
        HomeFragment homeFragment = HomeFragment.newInstance();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.content_container, homeFragment);
        fragmentTransaction.commit();
    }

    @Override
    public void onClick(View view) {
        Fragment selectedFragment = null;
        FragmentTransaction fragmentTransaction;
        switch (view.getId()) {
            case R.id.ib_home:
                resetBackground(0);
                selectedFragment = HomeFragment.newInstance();
                break;
            case R.id.ib_messages:
                resetBackground(1);
                selectedFragment = MessagesFragment.newInstance();
                break;
            case R.id.ib_notifications:
                resetBackground(2);
                selectedFragment = NotificationsFragment.newInstance();
                break;
            case R.id.ib_more:
                resetBackground(3);
                selectedFragment = MoreFragment.newInstance();
                break;
            case R.id.ib_add_ad:
                resetBackground(4);
                selectedFragment = HomeFragment.newInstance();
                break;
        }
        fragmentTransaction = getSupportFragmentManager().beginTransaction().addToBackStack("");
        fragmentTransaction.replace(R.id.content_container, selectedFragment);
        fragmentTransaction.commit();

    }

    private void resetBackground(int selectedItem) {
        for (int i = 0; i < menuItems.size(); i++) {
            ImageButton imageButton = menuItems.get(i);
            if (selectedItem != 4) {
                if (i != selectedItem) {
                    imageButton.setBackgroundColor(ResourcesCompat.getColor(getResources(), R.color.bottom_menu_item, null));
                    imageButton.clearColorFilter();
                } else {
                    imageButton.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.bg_selected_menu_item, null));
                    imageButton.setColorFilter(ContextCompat.getColor(getApplicationContext(), R.color.white));
                }
            } else {
                imageButton.setBackgroundColor(ResourcesCompat.getColor(getResources(), R.color.bottom_menu_item, null));
                imageButton.clearColorFilter();
            }
        }
    }

    @Override
    public void onAdClick(String adId) {
        AdDetailsFragment adDetailsFragment = AdDetailsFragment.newInstance(adId);
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.content_container, adDetailsFragment);
        fragmentTransaction.addToBackStack("Ad Details");
        fragmentTransaction.commit();
    }

    @Override
    public void onBackPressed() {
        int count = getFragmentManager().getBackStackEntryCount();

        if (count == 0) {
            super.onBackPressed();
            //additional code
        } else {
            getFragmentManager().popBackStack();
        }
    }
}