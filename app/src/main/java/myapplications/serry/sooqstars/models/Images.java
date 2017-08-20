package myapplications.serry.sooqstars.models;

/**
 * Created by awstreams on 8/20/17.
 */

public class Images {
    String Id;
    String AdId;
    String URL;
    String IsActive;
    String DeletedDate;

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getAdId() {
        return AdId;
    }

    public void setAdId(String adId) {
        AdId = adId;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public String getIsActive() {
        return IsActive;
    }

    public void setIsActive(String isActive) {
        IsActive = isActive;
    }

    public String getDeletedDate() {
        return DeletedDate;
    }

    public void setDeletedDate(String deletedDate) {
        DeletedDate = deletedDate;
    }
}
