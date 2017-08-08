package myapplications.serry.sooqstars.models;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.ForeignKey;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

import java.util.List;

import myapplications.serry.sooqstars.database.MyDataBase;

/**
 * Created by awstreams on 8/8/17.
 */
//@Table(database = MyDataBase.class)
public class Cities extends BaseModel {
//    @PrimaryKey
//    @Column
    String Id;
//    @Column
    String Name;
//    @Column
//    @ForeignKey(saveForeignKeyModel = true)
    List<Districts> Districts;

    public Cities() {
    }

    public Cities(List<Districts> districts, String id, String name) {
        Districts = districts;
        Id = id;
        Name = name;
    }

    public List<Districts> getDistricts() {
        return Districts;
    }

    public void setDistricts(List<Districts> districts) {
        Districts = districts;
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
}
