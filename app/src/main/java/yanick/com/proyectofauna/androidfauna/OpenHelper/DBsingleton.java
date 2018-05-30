package yanick.com.proyectofauna.androidfauna.OpenHelper;

import android.content.ContentValues;
import android.content.Context;

public class DBsingleton {

    public static DBhelper db;
    private static final DBsingleton ourInstance = new DBsingleton();

    public static DBsingleton getInstance(Context context) {
        if(db == null){
            db = new DBhelper(context);
        }
        return ourInstance;
    }

    private DBsingleton() {
    }

    public static DBhelper getDb() {
        return db;
    }

    public static void setDb(DBhelper db) {
        DBsingleton.db = db;
    }

    public DBhelper getDATABASE(){
        return db;
    }

}
