package yanick.com.proyectofauna.androidfauna.OpenHelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

import yanick.com.proyectofauna.androidfauna.modelo.contract.ContractClase;

public class DBhelper extends SQLiteOpenHelper {

    private static  final int v_DATABASE = 10;

    private static final String name_DATABASE = "faunadb";

    private static  SQLiteDatabase db;

    private static DBhelper DBhelper;

    private final Context _context;


    interface Tablas{
        String DIVISION = "division";
        String CLASE = "clase";
        String ORDEN = "orden";
        String FAMILIA = "familia";
        String GENERO = "genero";
        String ESPECIE = "especie";

    }

    public DBhelper(Context context){
        super(context,name_DATABASE,null,v_DATABASE);
        _context = context;
        DBhelper = this;

    }




    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {


        //TABLA DIVISION
        sqLiteDatabase.execSQL(String.format("CREATE TABLE %s (%s INTEGER PRIMARY KEY AUTOINCREMENT," +
                        "%s TEXT NOT NULL, %s TEXT NOT NULL)",
                Tablas.DIVISION, BaseColumns._ID,
                ContractClase.Division.NOMBRE, ContractClase.Division.ID));

        //TABLA CLASE
        sqLiteDatabase.execSQL(String.format("CREATE TABLE %s (%s INTEGER PRIMARY KEY AUTOINCREMENT," +
                        "%s TEXT NOT NULL, %s TEXT NOT NULL, %s TEXT NOT NULL)",
                Tablas.CLASE, BaseColumns._ID,
                ContractClase.Clase.NOMBRE, ContractClase.Clase.ID, ContractClase.Clase.ID_DIVISION));

        //TABLA ORDEN
        sqLiteDatabase.execSQL(String.format("CREATE TABLE %s (%s INTEGER PRIMARY KEY AUTOINCREMENT," +
                        "%s TEXT NOT NULL, %s TEXT NOT NULL, %s TEXT NOT NULL)",
                ContractClase.Orden.TABLA, BaseColumns._ID,
                ContractClase.Orden.NOMBRE, ContractClase.Orden.ID, ContractClase.Orden.ID_CLASE));

        //TABLA FAMILIA
        sqLiteDatabase.execSQL(String.format("CREATE TABLE %s (%s INTEGER PRIMARY KEY AUTOINCREMENT," +
        "%s TEXT NOT NULL, %s TEXT NOT NULL, %s TEXT NOT NULL)",
                ContractClase.Familia.TABLA, BaseColumns._ID,
                ContractClase.Familia.NOMBRE, ContractClase.Familia.ID, ContractClase.Familia.ID_ORDEN));

        //TABLA GENERO
        sqLiteDatabase.execSQL(String.format("CREATE TABLE %s (%s INTEGER PRIMARY KEY AUTOINCREMENT," +
                        "%s TEXT NOT NULL, %s TEXT NOT NULL, %s TEXT NOT NULL)",
                ContractClase.Genero.TABLA, BaseColumns._ID,
                ContractClase.Genero.NOMBRE, ContractClase.Genero.ID, ContractClase.Genero.ID_FAMILIA));

        //TABLA ESPECIE
        sqLiteDatabase.execSQL(String.format("CREATE TABLE %s (%s INTEGER PRIMARY KEY AUTOINCREMENT," +
                        "%s TEXT NOT NULL, %s TEXT NOT NULL, %s TEXT NOT NULL)",
                ContractClase.Especie.TABLA, BaseColumns._ID,
                ContractClase.Especie.NOMBRE, ContractClase.Especie.ID, ContractClase.Especie.ID_GENERO));



        //TABLA ANIMAL
        sqLiteDatabase.execSQL(String.format("CREATE TABLE %s (%s INTEGER PRIMARY KEY AUTOINCREMENT," +

                        "%s TEXT NOT NULL, "+  // ID
                        "%s TEXT NOT NULL, "+   //NOMBRE
                        "%s TEXT NOT NULL, "+   //DESCRIP
                        "%s TEXT NOT NULL, "+   //LONGI
                        "%s TEXT NOT NULL, "+   //LATit
                        "%s TEXT NOT NULL, "+   //Pais
                        "%s TEXT , "+   //ID_DIV
                        "%s TEXT , "+   //ID_CLAS
                        "%s TEXT , "+   //ID_ORD
                        "%s TEXT , "+   //ID_FAM
                        "%s TEXT , "+   //ID_GEN
                        "%s TEXT "+   //ID_ESP
                        ")",
                ContractClase.Animal.TABLA,
                BaseColumns._ID,
                ContractClase.Animal.ID,
                ContractClase.Animal.NOMBRE,
                ContractClase.Animal.DESCRIPCION,
                ContractClase.Animal.LONGITUD,
                ContractClase.Animal.LATITUD,
                ContractClase.Animal.PAIS,
                ContractClase.Animal.ID_DIVISION,
                ContractClase.Animal.ID_CLASE,
                ContractClase.Animal.ID_ORDEN,
                ContractClase.Animal.ID_FAMILIA,
                ContractClase.Animal.ID_GENERO,
                ContractClase.Animal.ID_ESPECIE
                ));

        //DATOS DIVISION

        ContentValues claseValues = new ContentValues();
        String id_ = ContractClase.Division.getID();
        claseValues.put(ContractClase.Division.NOMBRE, "Echinodermata");
        claseValues.put(ContractClase.Division.ID, id_);
        sqLiteDatabase.insert(ContractClase.Division.TABLA,null,claseValues);

        ContentValues claseValues1 = new ContentValues();
        String id_1 = ContractClase.Division.getID();
        claseValues1.put(ContractClase.Division.NOMBRE, "Arthropoda");
        claseValues1.put(ContractClase.Division.ID, id_1);
        sqLiteDatabase.insert(ContractClase.Division.TABLA,null,claseValues1);

        ContentValues claseValues2 = new ContentValues();
        String id_2 = ContractClase.Division.getID();
        claseValues2.put(ContractClase.Division.NOMBRE, "Rotifera");
        claseValues2.put(ContractClase.Division.ID, id_2);
        sqLiteDatabase.insert(ContractClase.Division.TABLA,null,claseValues2);

        ContentValues claseValues22 = new ContentValues();
        String id_22 = ContractClase.Division.getID();
        claseValues22.put(ContractClase.Division.NOMBRE, "XXXXXXX");
        claseValues22.put(ContractClase.Division.ID, id_22);
        sqLiteDatabase.insert(ContractClase.Division.TABLA,null,claseValues22);

        //DATOS DE CLASE PARA LA PRIMERA DIVISION

        ContentValues claseValues4 = new ContentValues();
        claseValues4.put(ContractClase.Clase.NOMBRE, "Asteroidea");
        claseValues4.put(ContractClase.Clase.ID, ContractClase.Clase.getID());
        claseValues4.put(ContractClase.Clase.ID_DIVISION, id_);
        sqLiteDatabase.insert(ContractClase.Clase.TABLA,null,claseValues4);

        ContentValues claseValues5 = new ContentValues();
        claseValues5.put(ContractClase.Clase.NOMBRE, "Echinoidea");
        claseValues5.put(ContractClase.Clase.ID, ContractClase.Clase.getID());
        claseValues5.put(ContractClase.Clase.ID_DIVISION, id_);
        sqLiteDatabase.insert(ContractClase.Clase.TABLA,null,claseValues5);

        ContentValues claseValues6 = new ContentValues();
        claseValues6.put(ContractClase.Clase.NOMBRE, "Holothuroidea");
        claseValues6.put(ContractClase.Clase.ID, ContractClase.Clase.getID());
        claseValues6.put(ContractClase.Clase.ID_DIVISION, id_);
        sqLiteDatabase.insert(ContractClase.Clase.TABLA,null,claseValues6);

        //DATOS DE CLASE PARA LA SEGUNDA DIVISION

        ContentValues claseValues7 = new ContentValues();
        claseValues7.put(ContractClase.Clase.NOMBRE, "Arachnida");
        claseValues7.put(ContractClase.Clase.ID, ContractClase.Clase.getID());
        claseValues7.put(ContractClase.Clase.ID_DIVISION, id_1);
        sqLiteDatabase.insert(ContractClase.Clase.TABLA,null,claseValues7);

        ContentValues claseValues8 = new ContentValues();
        claseValues8.put(ContractClase.Clase.NOMBRE, "Insecta");
        claseValues8.put(ContractClase.Clase.ID, ContractClase.Clase.getID());
        claseValues8.put(ContractClase.Clase.ID_DIVISION, id_1);
        sqLiteDatabase.insert(ContractClase.Clase.TABLA,null,claseValues8);

        ContentValues claseValues9 = new ContentValues();
        claseValues9.put(ContractClase.Clase.NOMBRE, "Ostracoda");
        claseValues9.put(ContractClase.Clase.ID, ContractClase.Clase.getID());
        claseValues9.put(ContractClase.Clase.ID_DIVISION, id_1);
        sqLiteDatabase.insert(ContractClase.Clase.TABLA,null,claseValues9);


        //DATOS DE CLASE PARA LA TERCERA DIVISION

        ContentValues claseValues10 = new ContentValues();
        String llave = ContractClase.Clase.getID();
        claseValues10.put(ContractClase.Clase.NOMBRE, "Rotatoria");
        claseValues10.put(ContractClase.Clase.ID, llave);
        claseValues10.put(ContractClase.Clase.ID_DIVISION, id_2);
        sqLiteDatabase.insert(ContractClase.Clase.TABLA,null,claseValues10);







        for (int i = 0; i < 10; i++) {
            ContentValues claseValuesX = new ContentValues();
            claseValuesX.put(ContractClase.Orden.NOMBRE, "HH"+String.valueOf(i));
            claseValuesX.put(ContractClase.Orden.ID, ContractClase.Clase.getID());
            claseValuesX.put(ContractClase.Orden.ID_CLASE, llave);
            sqLiteDatabase.insert(ContractClase.Orden.TABLA,null,claseValuesX);
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + Tablas.DIVISION);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + Tablas.CLASE);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + ContractClase.Orden.TABLA);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + Tablas.FAMILIA);

        this.onCreate(sqLiteDatabase);
    }
}
