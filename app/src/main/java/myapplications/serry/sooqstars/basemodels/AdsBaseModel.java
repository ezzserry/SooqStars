package myapplications.serry.sooqstars.basemodels;

import java.util.List;

import myapplications.serry.sooqstars.models.Ad;
import myapplications.serry.sooqstars.models.Pager;

/**
 * Created by awstreams on 8/3/17.
 */

public class AdsBaseModel {
    List<Ad> items;
    Pager pager;

    public List<Ad> getAds() {
        return items;
    }

    public void setAds(List<Ad> ads) {
        this.items = ads;
    }

    public Pager getPager() {
        return pager;
    }

    public void setPager(Pager pager) {
        this.pager = pager;
    }
}
