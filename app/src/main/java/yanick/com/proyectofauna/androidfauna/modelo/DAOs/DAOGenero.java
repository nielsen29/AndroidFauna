package yanick.com.proyectofauna.androidfauna.modelo.DAOs;

import android.content.Context;

import yanick.com.proyectofauna.androidfauna.OpenHelper.DBsingleton;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import yanick.com.proyectofauna.androidfauna.OpenHelper.OperecionesSQLite;
import yanick.com.proyectofauna.androidfauna.modelo.Genero;
import yanick.com.proyectofauna.androidfauna.modelo.contract.ContractClase;

public class DAOGenero extends OperecionesSQLite <Genero> {

    private DBsingleton dBsingleton;

    private Context context;

    public DAOGenero(Context context) {
        this.context = context;
        dBsingleton = DBsingleton.getInstance(context);
    }

    @Override
    public Genero mostrarbyID(String id) {
        return null;
    }

    @Override
    public String insertar(String tabla, Genero values) {
        return null;
    }

    @Override
    public ArrayList<Genero> buscar(int id) {
        return null;
    }

    @Override
    public ArrayList<Genero> buscar(String id) {

        ArrayList<Genero> arrayList = new ArrayList<>();

        SQLiteDatabase db = dBsingleton.getDATABASE().getReadableDatabase();

        String sql = String.format("Select * from %s where "+ ContractClase.Genero.ID_FAMILIA +" = '%s'", ContractClase.Familia.TABLA, id).toString();

        Cursor cursor = db.rawQuery(sql,null);

        if(cursor.moveToFirst()){
            do{
                Genero respuesta = new Genero();
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
    public ArrayList<Genero> mostrar() {

        ArrayList<Genero> arrayList = new ArrayList<>();

        SQLiteDatabase db = dBsingleton.getDATABASE().getReadableDatabase();

        String sql = String.format("Select * from %s ", ContractClase.Genero.TABLA).toString();

        Cursor cursor = db.rawQuery(sql, null);

        if (cursor.moveToFirst()) {
            do {
                Genero respuesta = new Genero();
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

