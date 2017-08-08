package myapplications.serry.sooqstars.models;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;

import myapplications.serry.sooqstars.database.MyDataBase;

/**
 * Created by awstreams on 8/8/17.
 */
//@Table(database = MyDataBase.class)
public class Districts {
//    @PrimaryKey
//    @Column
    String Id;
//    @Column
    String Name;
//    @Column
    String CityId;
//    @Column
    String IsActive;

    public Districts() {
    }

    public Districts(String id, String name, String cityId, String isActive) {
        Id = id;
        Name = name;
        CityId = cityId;
        IsActive = isActive;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getCityId() {
        return CityId;
    }

    public void setCityId(String cityId) {
        CityId = cityId;
    }

    public String getIsActive() {
        return IsActive;
    }

    public void setIsActive(String isActive) {
        IsActive = isActive;
    }
}
