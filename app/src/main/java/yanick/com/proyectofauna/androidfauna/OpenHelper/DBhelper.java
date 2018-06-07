package yanick.com.proyectofauna.androidfauna.OpenHelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

import yanick.com.proyectofauna.androidfauna.modelo.Clase;
import yanick.com.proyectofauna.androidfauna.modelo.Division;
import yanick.com.proyectofauna.androidfauna.modelo.Especie;
import yanick.com.proyectofauna.androidfauna.modelo.Familia;
import yanick.com.proyectofauna.androidfauna.modelo.Genero;
import yanick.com.proyectofauna.androidfauna.modelo.Orden;
import yanick.com.proyectofauna.androidfauna.modelo.contract.ContractClase;

public class DBhelper extends SQLiteOpenHelper {

    private static  final int v_DATABASE = 16;

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

    public DBhelper(Context context, String faunadb, Object o, int i){
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
        sqLiteDatabase.insert(ContractClase.Orden.TABLA, null,orden2.getContentValue());

        //DATOS ORDEN ECHINOIDEA

        Orden orden3 = new Orden("Clypeasteroidea",clase2);
        sqLiteDatabase.insert(ContractClase.Orden.TABLA, null,orden3.getContentValue());

        Orden orden4 = new Orden("Diadematoida",clase2);
        sqLiteDatabase.insert(ContractClase.Orden.TABLA, null,orden4.getContentValue());

        //DATOS ORDEN HOLOTHUROIDEA

        Orden orden5 = new Orden("Aspidochirotida",clase3);
        sqLiteDatabase.insert(ContractClase.Orden.TABLA, null,orden5.getContentValue());

        //DATOS ORDEN ARACHNIDA

        Orden orden6 = new Orden("Acarina",clase4);
        sqLiteDatabase.insert(ContractClase.Orden.TABLA, null,orden6.getContentValue());

        Orden orden7 = new Orden("Araneae",clase4);
        sqLiteDatabase.insert(ContractClase.Orden.TABLA, null,orden7.getContentValue());

        Orden orden8 = new Orden("Scorpiones",clase4);
        sqLiteDatabase.insert(ContractClase.Orden.TABLA, null,orden8.getContentValue());

        // DATOS ORDEN INSECTA

        Orden orden9 = new Orden("Coleoptera",clase5);
        sqLiteDatabase.insert(ContractClase.Orden.TABLA, null,orden9.getContentValue());

        Orden orden10 = new Orden("Dermaptera",clase5);
        sqLiteDatabase.insert(ContractClase.Orden.TABLA, null,orden10.getContentValue());

        Orden orden11 = new Orden("Dictyoptera",clase5);
        sqLiteDatabase.insert(ContractClase.Orden.TABLA, null,orden11.getContentValue());

        //DATOS ORDEN OSTRACODA

        Orden orden12 = new Orden("Platycopa",clase6);
        sqLiteDatabase.insert(ContractClase.Orden.TABLA, null,orden12.getContentValue());

        Orden orden13 = new Orden("Podocopa",clase6);
        sqLiteDatabase.insert(ContractClase.Orden.TABLA, null,orden13.getContentValue());

        //DATOS ORDEN ROTATORIA

        Orden orden14 = new Orden("Bolloidea",clase7);
        sqLiteDatabase.insert(ContractClase.Orden.TABLA, null,orden14.getContentValue());

        Orden orden15 = new Orden("Gnesiotrocha",clase7);
        sqLiteDatabase.insert(ContractClase.Orden.TABLA, null,orden15.getContentValue());

        Orden orden16 = new Orden("Ploimida",clase7);
        sqLiteDatabase.insert(ContractClase.Orden.TABLA, null,orden16.getContentValue());

        //DATOS FAMILIA PAXILLOSIDA

        Familia familia1 = new Familia("AstroPectinidae",orden1);
        sqLiteDatabase.insert(ContractClase.Familia.TABLA, null,familia1.getContentValue());

        //DATOS FAMILIA SPINULOSIDA

        Familia familia2 = new Familia("Echinasteridae",orden2);
        sqLiteDatabase.insert(ContractClase.Familia.TABLA, null,familia2.getContentValue());

        //DATOS FAMILIA CLYPEASTOROIDEA

        Familia familia3 = new Familia("Spatangidae",orden3);
        sqLiteDatabase.insert(ContractClase.Familia.TABLA, null,familia3.getContentValue());

        //DATOS FAMILIA DIADEMATOIDA

        Familia familia4 = new Familia("Echinidae",orden4);
        sqLiteDatabase.insert(ContractClase.Familia.TABLA, null,familia4.getContentValue());

        //DATOS FAMILIA Aspidochirotida

        Familia familia5 = new Familia("Holothuriidae",orden5);
        sqLiteDatabase.insert(ContractClase.Familia.TABLA, null,familia5.getContentValue());

        //DATOS FAMILIA ACARINA

        Familia familia6 = new Familia("Ixodidae",orden6);
        sqLiteDatabase.insert(ContractClase.Familia.TABLA, null,familia6.getContentValue());

        Familia familia7 = new Familia("Neotrombidiidae",orden6);
        sqLiteDatabase.insert(ContractClase.Familia.TABLA, null,familia7.getContentValue());

        // DATOS FAMILIA ARANEAE

        Familia familia8 = new Familia("Lycosidae",orden7);
        sqLiteDatabase.insert(ContractClase.Familia.TABLA, null,familia8.getContentValue());

        Familia familia9 = new Familia("Thomsidae",orden7);
        sqLiteDatabase.insert(ContractClase.Familia.TABLA, null,familia9.getContentValue());

        Familia familia10 = new Familia("Araneidae",orden7);
        sqLiteDatabase.insert(ContractClase.Familia.TABLA, null,familia10.getContentValue());

        Familia familia11 = new Familia("Tetragnathidae",orden7);
        sqLiteDatabase.insert(ContractClase.Familia.TABLA, null,familia11.getContentValue());

        //DATOS FAMILIA SCORPIONES

        Familia familia12 = new Familia("Buthidae",orden8);
        sqLiteDatabase.insert(ContractClase.Familia.TABLA, null,familia12.getContentValue());

        //DATOS FAMILIA COLEOPTERA

        Familia familia13 = new Familia("Alleculidae",orden9);
        sqLiteDatabase.insert(ContractClase.Familia.TABLA, null,familia13.getContentValue());

        Familia familia14 = new Familia("Anthicidae",orden9);
        sqLiteDatabase.insert(ContractClase.Familia.TABLA, null,familia14.getContentValue());

        Familia familia15 = new Familia("Aphodiidae",orden9);
        sqLiteDatabase.insert(ContractClase.Familia.TABLA, null,familia15.getContentValue());

        //DATOS FAMILIA DERMAPTERA

        Familia familia16 = new Familia("Forficulidae",orden10);
        sqLiteDatabase.insert(ContractClase.Familia.TABLA, null,familia16.getContentValue());

        Familia familia17 = new Familia("Labiduridae",orden10);
        sqLiteDatabase.insert(ContractClase.Familia.TABLA, null,familia17.getContentValue());

        //DATOS FAMILIA DICTYOPTERA

        Familia familia18 = new Familia("Blattellidae",orden11);
        sqLiteDatabase.insert(ContractClase.Familia.TABLA, null,familia18.getContentValue());

        Familia familia19 = new Familia("Blattidae",orden11);
        sqLiteDatabase.insert(ContractClase.Familia.TABLA, null,familia19.getContentValue());

        Familia familia20 = new Familia("Empusidae",orden11);
        sqLiteDatabase.insert(ContractClase.Familia.TABLA, null,familia20.getContentValue());

        Familia familia21 = new Familia("Mantidae",orden11);
        sqLiteDatabase.insert(ContractClase.Familia.TABLA, null,familia21.getContentValue());

        //DATOS FAMILIA PLATYCOPA

        Familia familia22 = new Familia("Candonidae",orden12);
        sqLiteDatabase.insert(ContractClase.Familia.TABLA, null,familia22.getContentValue());

        //DATOS FAMILIA PODOCOPA

        Familia familia23 = new Familia("Cyprididae",orden13);
        sqLiteDatabase.insert(ContractClase.Familia.TABLA, null,familia23.getContentValue());

        Familia familia24 = new Familia("Darwinulidae",orden13);
        sqLiteDatabase.insert(ContractClase.Familia.TABLA, null,familia24.getContentValue());

        Familia familia25 = new Familia("Iilocyprididae",orden13);
        sqLiteDatabase.insert(ContractClase.Familia.TABLA, null,familia25.getContentValue());

        //DATOS FAMILIA BOLLOIDEA

        Familia familia26 = new Familia("Philodinidae",orden14);
        sqLiteDatabase.insert(ContractClase.Familia.TABLA, null,familia26.getContentValue());

        //DATOS FAMILIA GNESIOTROCHA

        Familia familia27 = new Familia("Conochilidae",orden15);
        sqLiteDatabase.insert(ContractClase.Familia.TABLA, null,familia27.getContentValue());

        Familia familia28 = new Familia("Filiniidae",orden15);
        sqLiteDatabase.insert(ContractClase.Familia.TABLA, null,familia28.getContentValue());

        Familia familia29 = new Familia("Flosculariidae",orden15);
        sqLiteDatabase.insert(ContractClase.Familia.TABLA, null,familia29.getContentValue());

        //DATO FAMILIA PLOIMIDA

        Familia familia30 = new Familia("Asplanchnidae",orden16);
        sqLiteDatabase.insert(ContractClase.Familia.TABLA, null,familia30.getContentValue());

        Familia familia31 = new Familia("Brachionidae",orden16);
        sqLiteDatabase.insert(ContractClase.Familia.TABLA, null,familia31.getContentValue());

        Familia familia32 = new Familia("Colurellidae",orden16);
        sqLiteDatabase.insert(ContractClase.Familia.TABLA, null,familia32.getContentValue());



        //DATOS GENERO ASTROPECTINIDAE

        Genero genero1 = new Genero("Astropecten",familia1);
        sqLiteDatabase.insert(ContractClase.Genero.TABLA, null,genero1.getContentValue());

        //DATOS GENERO ECHINASTERIDAE

        Genero genero2 = new Genero("Echinaster",familia2);
        sqLiteDatabase.insert(ContractClase.Genero.TABLA, null,genero2.getContentValue());

        //DATOS GENERO SPATANGIDAE

        Genero genero3 = new Genero("Echinocardium",familia3);
        sqLiteDatabase.insert(ContractClase.Genero.TABLA, null,genero3.getContentValue());

        Genero genero4 = new Genero("Spatangus",familia3);
        sqLiteDatabase.insert(ContractClase.Genero.TABLA, null,genero4.getContentValue());

        //DATOS GENERO ECHINIDAE

        Genero genero5 = new Genero("Paracentrotus",familia4);
        sqLiteDatabase.insert(ContractClase.Genero.TABLA, null,genero5.getContentValue());

        //DATOS GENERO HOLOTHURIIDAE

        Genero genero6 = new Genero("Holothuria",familia5);
        sqLiteDatabase.insert(ContractClase.Genero.TABLA, null,genero6.getContentValue());

        //DATOS GENERO IXODIDAE

        Genero genero7 = new Genero("Ixodes",familia6);
        sqLiteDatabase.insert(ContractClase.Genero.TABLA, null,genero7.getContentValue());

        //DATOS GENERO NEOTROMBIDIIDAE

        Genero genero8 = new Genero("Southcottella",familia7);
        sqLiteDatabase.insert(ContractClase.Genero.TABLA, null,genero8.getContentValue());

        //DATOS GENERO LYCOSIDAE

        Genero genero9 = new Genero("Donacosa",familia8);
        sqLiteDatabase.insert(ContractClase.Genero.TABLA, null,genero9.getContentValue());

        Genero genero10 = new Genero("Lycosa",familia8);
        sqLiteDatabase.insert(ContractClase.Genero.TABLA, null,genero10.getContentValue());

        //DATOS GENERO THOMISIDAE

        Genero genero11 = new Genero("Coriarachne",familia9);
        sqLiteDatabase.insert(ContractClase.Genero.TABLA, null,genero11.getContentValue());

        Genero genero12 = new Genero("Thomisus",familia9);
        sqLiteDatabase.insert(ContractClase.Genero.TABLA, null,genero12.getContentValue());

        //DATOS GENERO ARANEIDAE

        Genero genero13 = new Genero("Argiope",familia10);
        sqLiteDatabase.insert(ContractClase.Genero.TABLA, null,genero13.getContentValue());

        //DATOS GENERO BUTHIDAE

        Genero genero14 = new Genero("Buthus",familia12);
        sqLiteDatabase.insert(ContractClase.Genero.TABLA, null,genero14.getContentValue());

        //DATOS GENERO ALLECULIDAE

        Genero genero15 = new Genero("Heliotaurus",familia13);
        sqLiteDatabase.insert(ContractClase.Genero.TABLA, null,genero15.getContentValue());

        //DATOS GENERO ANTHICIDAE

        Genero genero16 = new Genero("Anthicus",familia14);
        sqLiteDatabase.insert(ContractClase.Genero.TABLA, null,genero16.getContentValue());

        Genero genero17 = new Genero("Cordicomus",familia14);
        sqLiteDatabase.insert(ContractClase.Genero.TABLA, null,genero17.getContentValue());

        //DATOS GENERO APHODIIDAE

        Genero genero18 = new Genero("Aphodius",familia15);
        sqLiteDatabase.insert(ContractClase.Genero.TABLA, null,genero18.getContentValue());

        Genero genero19 = new Genero("Heptaulacus",familia15);
        sqLiteDatabase.insert(ContractClase.Genero.TABLA, null,genero19.getContentValue());

        //DATOS GENERO FORFICULIDAE

        Genero genero20 = new Genero("Forficula",familia16);
        sqLiteDatabase.insert(ContractClase.Genero.TABLA, null,genero20.getContentValue());

        //DATOS GENERO LABIDURIDAE

        Genero genero21 = new Genero("Labidura",familia17);
        sqLiteDatabase.insert(ContractClase.Genero.TABLA, null,genero21.getContentValue());

        Genero genero22 = new Genero("Nala",familia17);
        sqLiteDatabase.insert(ContractClase.Genero.TABLA, null,genero22.getContentValue());

        //DATOS GENERO BLATTELLIDAE

        Genero genero23 = new Genero("Loboptera",familia18);
        sqLiteDatabase.insert(ContractClase.Genero.TABLA, null,genero23.getContentValue());

        //DATOS GENERO BLATTIDAE

        Genero genero24 = new Genero("Blatta",familia19);
        sqLiteDatabase.insert(ContractClase.Genero.TABLA, null,genero24.getContentValue());

        //DATOS GENERO EMPUSIDAE

        Genero genero25 = new Genero("Empusa",familia20);
        sqLiteDatabase.insert(ContractClase.Genero.TABLA, null,genero25.getContentValue());

        //DATOS GENERO MANTIDAE

        Genero genero26 = new Genero("Ameles",familia21);
        sqLiteDatabase.insert(ContractClase.Genero.TABLA, null,genero26.getContentValue());

        Genero genero27 = new Genero("Mantis",familia21);
        sqLiteDatabase.insert(ContractClase.Genero.TABLA, null,genero27.getContentValue());

        Genero genero28 = new Genero("Sphodromantis",familia21);
        sqLiteDatabase.insert(ContractClase.Genero.TABLA, null,genero28.getContentValue());

        //DATOS GENERO CANDONIDAE

        Genero genero29 = new Genero("Candona",familia22);
        sqLiteDatabase.insert(ContractClase.Genero.TABLA, null,genero29.getContentValue());

        Genero genero30 = new Genero("Cypria",familia22);
        sqLiteDatabase.insert(ContractClase.Genero.TABLA, null,genero30.getContentValue());

        //DATOS GENERO CYPRIDIDAE

        Genero genero31 = new Genero("Cyclocypris",familia23);
        sqLiteDatabase.insert(ContractClase.Genero.TABLA, null,genero31.getContentValue());

        Genero genero32 = new Genero("Cypricercus",familia23);
        sqLiteDatabase.insert(ContractClase.Genero.TABLA, null,genero32.getContentValue());

        //DATOS GENERO DARWINULIDAE

        Genero genero33 = new Genero("Darwinula",familia24);
        sqLiteDatabase.insert(ContractClase.Genero.TABLA, null,genero33.getContentValue());

        //DATOS GENERO Iilocyprididae

        Genero genero34 = new Genero("Ilyocypris",familia25);
        sqLiteDatabase.insert(ContractClase.Genero.TABLA, null,genero34.getContentValue());

        Genero genero35 = new Genero("Isocypris",familia25);
        sqLiteDatabase.insert(ContractClase.Genero.TABLA, null,genero35.getContentValue());

        //DATOS GENERO PHILODINIDAE

        Genero genero36 = new Genero("Philodinidae",familia26);
        sqLiteDatabase.insert(ContractClase.Genero.TABLA, null,genero36.getContentValue());

        //DATOS GENERO Conochilidae

        Genero genero37 = new Genero("Conochilus",familia27);
        sqLiteDatabase.insert(ContractClase.Genero.TABLA, null,genero37.getContentValue());

        //DATOS GENERO FILINIIDAE

        Genero genero38 = new Genero("Filinia",familia28);
        sqLiteDatabase.insert(ContractClase.Genero.TABLA, null,genero38.getContentValue());

        //DATOS GENERO FLOSCULARIIDAE

        Genero genero39 = new Genero("Beauchampiella",familia29);
        sqLiteDatabase.insert(ContractClase.Genero.TABLA, null,genero39.getContentValue());

        Genero genero40 = new Genero("Ptygura",familia29);
        sqLiteDatabase.insert(ContractClase.Genero.TABLA, null,genero40.getContentValue());

        //DATOS GENERO ASPLANCHNIDAE

        Genero genero41 = new Genero("Anchistetudinella",familia30);
        sqLiteDatabase.insert(ContractClase.Genero.TABLA, null,genero41.getContentValue());

        Genero genero42 = new Genero("Asplanchna",familia30);
        sqLiteDatabase.insert(ContractClase.Genero.TABLA, null,genero42.getContentValue());

        Genero genero43 = new Genero("Asplanchnopus",familia30);
        sqLiteDatabase.insert(ContractClase.Genero.TABLA, null,genero43.getContentValue());

        //DATOS GENERO BRACHIONIDAE

        Genero genero44 = new Genero("Anuraeopsis",familia31);
        sqLiteDatabase.insert(ContractClase.Genero.TABLA, null,genero44.getContentValue());

        Genero genero45 = new Genero("Brachionus",familia31);
        sqLiteDatabase.insert(ContractClase.Genero.TABLA, null,genero45.getContentValue());

        Genero genero46 = new Genero("Dipleuchlanis",familia31);
        sqLiteDatabase.insert(ContractClase.Genero.TABLA, null,genero46.getContentValue());

        //DATOS GENERO COLURELLIDAE

        Genero genero47 = new Genero("Colurella",familia32);
        sqLiteDatabase.insert(ContractClase.Genero.TABLA, null,genero47.getContentValue());

        Genero genero48 = new Genero("Lepadella",familia32);
        sqLiteDatabase.insert(ContractClase.Genero.TABLA, null,genero48.getContentValue());




        //DATOS ESPECIE ASTROPECTEN

        Especie especie1 = new Especie("Estrella de Arena Naranja",genero1);
        sqLiteDatabase.insert(ContractClase.Especie.TABLA, null,especie1.getContentValue());

        Especie especie2 = new Especie("Estrella de Mar",genero1);
        sqLiteDatabase.insert(ContractClase.Especie.TABLA, null,especie2.getContentValue());

        //DATOS ESPECIE ECHINASTER

        Especie especie3 = new Especie("Erizo",genero2);
        sqLiteDatabase.insert(ContractClase.Especie.TABLA, null,especie3.getContentValue());

        //DATOS ESPECIE ECHINOCARDIUM

        Especie especie4 = new Especie("Echinocardium cordatum",genero3);
        sqLiteDatabase.insert(ContractClase.Especie.TABLA, null,especie4.getContentValue());

        //DATOS ESPECIE SPATANGUS

        Especie especie5 = new Especie("Erizo de Mar",genero4);
        sqLiteDatabase.insert(ContractClase.Especie.TABLA, null,especie5.getContentValue());

        //DATOS ESPECIE PARANCENTROTUS

        Especie especie6 = new Especie("Erizo de Mar",genero5);
        sqLiteDatabase.insert(ContractClase.Especie.TABLA, null,especie6.getContentValue());

        //DATOS ESPECIE HOLOTHURIA

        Especie especie7 = new Especie("Pepino de Mar sp.",genero6);
        sqLiteDatabase.insert(ContractClase.Especie.TABLA, null,especie7.getContentValue());

        //DATOS ESPECIE IXODES

        Especie especie8 = new Especie("Ixodes ricinus",genero7);
        sqLiteDatabase.insert(ContractClase.Especie.TABLA, null,especie8.getContentValue());

        //DATOS ESPECIE SOUTHCOTTELLA

        Especie especie9 = new Especie("Southcottella nematii",genero8);
        sqLiteDatabase.insert(ContractClase.Especie.TABLA, null,especie9.getContentValue());

        //DATOS ESPECIE DONACOSA

        Especie especie10 = new Especie("Donacosa merlini",genero9);
        sqLiteDatabase.insert(ContractClase.Especie.TABLA, null,especie10.getContentValue());

        //DATOS ESPECIE LYCOSA

        Especie especie11 = new Especie("Tetragnathidae",genero10);
        sqLiteDatabase.insert(ContractClase.Especie.TABLA, null,especie11.getContentValue());

        //DATOS ESPECIE CORIARACHNE

        Especie especie12 = new Especie("Coriarachne fienae",genero11);
        sqLiteDatabase.insert(ContractClase.Especie.TABLA, null,especie12.getContentValue());

        //DATOS ESPECIE THOMISUS

        Especie especie13 = new Especie("Araña Cangrejo",genero12);
        sqLiteDatabase.insert(ContractClase.Especie.TABLA, null,especie13.getContentValue());





















































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
