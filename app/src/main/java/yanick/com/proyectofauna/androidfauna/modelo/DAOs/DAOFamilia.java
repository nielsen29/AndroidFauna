package yanick.com.proyectofauna.androidfauna.modelo.DAOs;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import yanick.com.proyectofauna.androidfauna.OpenHelper.DBsingleton;
import yanick.com.proyectofauna.androidfauna.OpenHelper.OperecionesSQLite;
import yanick.com.proyectofauna.androidfauna.modelo.Familia;
import yanick.com.proyectofauna.androidfauna.modelo.contract.ContractClase;


public class DAOFamilia extends OperecionesSQLite <Familia> {

    private DBsingleton dBsingleton;

    private Context context;


    public DAOFamilia(Context context) {
        this.context = context;
        this.dBsingleton = DBsingleton.getInstance(context);
    }


    @Override
    public Familia mostrarbyID(String id) {
        return null;
    }

    @Override
    public String insertar(String tabla, Familia values) {
        return null;
    }

    @Override
    public ArrayList<Familia> buscar(int id) {
        return null;

    }

    @Override
    public ArrayList<Familia> buscar(String id) {

        ArrayList<Familia> arrayList = new ArrayList<>();

        SQLiteDatabase db = dBsingleton.getDATABASE().getReadableDatabase();

        String sql = String.format("Select * from %s where "+ ContractClase.Familia.ID_ORDEN +" = '%s'", ContractClase.Familia.TABLA, id).toString();

        Cursor cursor = db.rawQuery(sql,null);

        if(cursor.moveToFirst()){
            do{
                Familia respuesta = new Familia();
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
    public ArrayList<Familia> mostrar() {

        ArrayList<Familia> arrayList = new ArrayList<>();

        SQLiteDatabase db = dBsingleton.getDATABASE().getReadableDatabase();

        String sql = String.format("Select * from %s ", ContractClase.Familia.TABLA).toString();

        Cursor cursor = db.rawQuery(sql, null);

        if (cursor.moveToFirst()) {
            do {
                Familia respuesta = new Familia();
                respuesta.setId(cursor.getString(2));
                respuesta.setNombre(cursor.getString(1));
                respuesta.set_id(cursor.getInt(0));
                arrayList.add(respuesta);
            } while (cursor.moveToNext());

            return arrayList;
        } else {
            return arrayList;
        }

    }
}
