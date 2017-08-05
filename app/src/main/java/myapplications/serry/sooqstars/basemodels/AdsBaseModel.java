package myapplications.serry.sooqstars.basemodels;

import java.util.List;

import myapplications.serry.sooqstars.models.Ad;
import myapplications.serry.sooqstars.models.Pager;

/**
 * Created by awstreams on 8/3/17.
 */

public class AdsBaseModel {
    List<Ad> Items;
    Pager Pager;

    public List<Ad> getAds() {
        return Items;
    }

    public void setAds(List<Ad> ads) {
        this.Items = ads;
    }

    public Pager getPager() {
        return Pager;
    }

    public void setPager(Pager pager) {
        this.Pager = pager;
    }
}
