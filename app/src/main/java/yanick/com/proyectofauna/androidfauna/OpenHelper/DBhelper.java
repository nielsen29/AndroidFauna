package yanick.com.proyectofauna.androidfauna.OpenHelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

import yanick.com.proyectofauna.androidfauna.modelo.Clase;
import yanick.com.proyectofauna.androidfauna.modelo.Division;
import yanick.com.proyectofauna.androidfauna.modelo.Orden;
import yanick.com.proyectofauna.androidfauna.modelo.contract.ContractClase;

public class DBhelper extends SQLiteOpenHelper {

    private static  final int v_DATABASE = 12;

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

        Division division1 = new Division("Echinodermata");
        sqLiteDatabase.insert(ContractClase.Division.TABLA,null,division1.getContentValue());

        Division division2 = new Division("Arthropoda");
        sqLiteDatabase.insert(ContractClase.Division.TABLA,null,division2.getContentValue());

        Division division3 = new Division("Rotifera");
        sqLiteDatabase.insert(ContractClase.Division.TABLA,null,division3.getContentValue());


        //DATOS CLASE ECHINODERMATA

        Clase clase1 = new Clase("Asteroidea",division1);
        sqLiteDatabase.insert(ContractClase.Clase.TABLA,null,clase1.getContentValue());

        Clase clase2 = new Clase("Echinoidea",division1);
        sqLiteDatabase.insert(ContractClase.Clase.TABLA,null,clase2.getContentValue());

        Clase clase3 = new Clase("Holothuroidea",division1);
        sqLiteDatabase.insert(ContractClase.Clase.TABLA, null,clase3.getContentValue());

        //DATOS CLASE ARTHROPODA

        Clase clase4 = new Clase("Arachnida",division2);
        sqLiteDatabase.insert(ContractClase.Clase.TABLA, null,clase4.getContentValue());

        Clase clase5 = new Clase("Insecta",division2);
        sqLiteDatabase.insert(ContractClase.Clase.TABLA, null,clase5.getContentValue());

        Clase clase6 = new Clase("Ostracoda",division2);
        sqLiteDatabase.insert(ContractClase.Clase.TABLA, null,clase6.getContentValue());

        //DATOS CLASE ROTIFERA

        Clase clase7 = new Clase("Rotaroria",division3);
        sqLiteDatabase.insert(ContractClase.Clase.TABLA, null,clase7.getContentValue());

        //DATOS ORDEN ASTEROIDEA

        Orden orden1 = new Orden("Paxillosida",clase1);
        sqLiteDatabase.insert(ContractClase.Orden.TABLA, null,orden1.getContentValue());

        Orden orden2 = new Orden("Spinulosida",clase1);
        sqLiteDatabase.insert(ContractClase.Orden.TABLA, null,clase2.getContentValue());

        //DATOS ORDEN ECHINOIDEA

        Orden orden3 = new Orden("Clypeasteroidea",clase2);
        sqLiteDatabase.insert(ContractClase.Orden.TABLA, null,orden3.getContentValue());

        Orden orden4 = new Orden("Diadematoida",clase2);
        sqLiteDatabase.insert(ContractClase.Orden.TABLA, null,orden4.getContentValue());

        //DATOS ORDEN HOLOTHUROIDEA

        Orden orden5 = new Orden("Aspidochirotida",clase3);
        sqLiteDatabase.insert(ContractClase.Orden.TABLA, null,orden5.getContentValue());
































    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + ContractClase.Animal.TABLA);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + Tablas.DIVISION);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + Tablas.CLASE);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + ContractClase.Orden.TABLA);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + Tablas.FAMILIA);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + Tablas.GENERO);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + Tablas.ESPECIE);

        this.onCreate(sqLiteDatabase);
    }
}
