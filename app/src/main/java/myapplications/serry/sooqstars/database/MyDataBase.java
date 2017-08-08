package myapplications.serry.sooqstars.database;

import com.raizlabs.android.dbflow.annotation.Database;
import com.raizlabs.android.dbflow.structure.BaseModel;

/**
 * Created by LENOVO on 08/08/2017.
 */
@Database(name = MyDataBase.NAME, version = MyDataBase.VERSION)

public class MyDataBase  {
    public static final String NAME = "AppDatabase"; // we will add the .db extension

    public static final int VERSION = 1;
}
