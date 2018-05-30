package yanick.com.proyectofauna.androidfauna.OpenHelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;



public class SQLite_OpenHelper extends SQLiteOpenHelper {


    public SQLite_OpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    //AQUÍ VAMOS A CREAR LA ESTRUCTURA DE LA BASE DE DATOS.
    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "create table usuarios(_ID integer primary key autoincrement, " +
                "Nombre text, Distrito text, Correo text, Password text);";
        db.execSQL(query);
    }

    //AQUÍ VAMOS A MODIFICAR CUALQUIERA ESTRUCTURA DE LA BASE DE DATOS.
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    //METODO QUE ME PERMITA ABRIR LA BASE DE DATOS
    public void abrir() {
        this.getWritableDatabase();
    }

    //METODO QUE ME PERMITA CERRAR LA BASE DE DATOS
    public void cerrar() {
        this.close();
    }

    //METODO QUE PERMITE INSERTAR REGISTROS EN LA TABLA DE USUARIOS.
    public void insertarReg(String nom, String dis, String cor, String pas) {
        ContentValues valores = new ContentValues();
        valores.put("Nombre", nom);
        valores.put("Distrito", dis);
        valores.put("Correo", cor);
        valores.put("Password", pas);
        this.getWritableDatabase().insert("usuarios", null, valores);
    }

    //METODO QUE PERMITE VALIDAR LA SESION SI EL USUARIO EXISTE
    public Cursor ConsultarUsuPas(String usu, String pas) throws SQLException {
        Cursor mcursor=null;
        mcursor=this.getReadableDatabase().query("usuarios" ,new String[]{"_ID",
                "Nombre","Distrito","Correo","Password"},"Correo like '"+usu+"' " +
                "and Password like '"+pas+"'",null,null,null,null);
        return mcursor;
    }


}