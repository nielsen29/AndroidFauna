package yanick.com.proyectofauna.androidfauna.modelo.DAOs;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import yanick.com.proyectofauna.androidfauna.OpenHelper.DBhelper;
import yanick.com.proyectofauna.androidfauna.OpenHelper.DBsingleton;
import yanick.com.proyectofauna.androidfauna.OpenHelper.OperecionesSQLite;
import yanick.com.proyectofauna.androidfauna.modelo.Clase;
import yanick.com.proyectofauna.androidfauna.modelo.contract.ContractClase;

public class DAOClase extends OperecionesSQLite<Clase> {

    private DBsingleton dBsingleton;

    private Context context;


    public DAOClase(Context context) {

        dBsingleton = DBsingleton.getInstance(context);


    }


    @Override
    public Clase mostrarbyID(String id) {

        Clase respuesta = new Clase();
        SQLiteDatabase db = dBsingleton.getDATABASE().getReadableDatabase();

        String sql = String.format("Select * from %s where id = %s", ContractClase.Clase.TABLA,id).toString();

        Cursor cursor = db.rawQuery(sql,null);

        if(cursor.moveToFirst()){
            do{
                respuesta.setId(cursor.getString(2));
                respuesta.setNombre(cursor.getString(1));
                respuesta.set_id(cursor.getInt(0));
            }while (cursor.moveToNext());

            return respuesta;
        }else{
            return null;
        }


    }

    @Override
    public String insertar(String tabla, Clase values) {


        SQLiteDatabase db = dBsingleton.getDATABASE().getWritableDatabase();
        //values.getContentValue().

        db.insertOrThrow(ContractClase.Clase.TABLA,null,values.getContentValue());

        return null;
    }

    @Override
    public ArrayList<Clase> buscar(int id) {

        ArrayList<Clase> arrayList = new ArrayList<>();

        SQLiteDatabase db = dBsingleton.getDATABASE().getReadableDatabase();

        String sql = String.format("Select * from %s where id_division = %s", ContractClase.Clase.TABLA, String.valueOf(id)).toString();

        Cursor cursor = db.rawQuery(sql,null);

        if(cursor.moveToFirst()){
            do{
                Clase respuesta = new Clase();
                respuesta.setId(cursor.getString(2));
                respuesta.setNombre(cursor.getString(1));
                respuesta.set_id(cursor.getInt(0));
                arrayList.add(respuesta);
            }while (cursor.moveToNext());

            return arrayList;
        }else{
            arrayList.clear();
            return arrayList;
        }

    }

    @Override
    public ArrayList<Clase> buscar(String id) {
        ArrayList<Clase> arrayList = new ArrayList<>();

        SQLiteDatabase db = dBsingleton.getDATABASE().getReadableDatabase();

        String sql = String.format("Select * from %s where id_division = '%s'", ContractClase.Clase.TABLA, id).toString();

        Cursor cursor = db.rawQuery(sql,null);

        if(cursor.moveToFirst()){
            do{
                Clase respuesta = new Clase();
                respuesta.setId(cursor.getString(2));
                respuesta.setNombre(cursor.getString(1));
                respuesta.set_id(cursor.getInt(0));
                arrayList.add(respuesta);
            }while (cursor.moveToNext());

            return arrayList;
        }else{
            arrayList.clear();
            return arrayList;
        }
    }

    @Override
    public boolean actualizar(int id, ContentValues values) {
        return false;
    }

    @Override
    public boolean actualizar(String id, ContentValues values) {
        return false;
    }

    @Override
    public boolean borrar(int id) {
        return false;
    }

    @Override
    public boolean borrar(String id) {
        return false;
    }

    @Override
    public ArrayList<Clase> mostrar() {

        ArrayList<Clase> arrayList = new ArrayList<>();

        SQLiteDatabase db = dBsingleton.getDATABASE().getReadableDatabase();

        String sql = String.format("Select * from %s ", ContractClase.Clase.TABLA).toString();

        Cursor cursor = db.rawQuery(sql,null);

        if(cursor.moveToFirst()){
            do{
                Clase respuesta = new Clase();
                respuesta.setId(cursor.getString(2));
                respuesta.setNombre(cursor.getString(1));
                respuesta.set_id(cursor.getInt(0));
                arrayList.add(respuesta);
            }while (cursor.moveToNext());

            return arrayList;
        }else{
            arrayList.clear();
            return arrayList;
        }

    }
}
