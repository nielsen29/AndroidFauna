package yanick.com.proyectofauna.androidfauna.modelo.DAOs;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import yanick.com.proyectofauna.androidfauna.OpenHelper.DBsingleton;
import yanick.com.proyectofauna.androidfauna.OpenHelper.OperecionesSQLite;
import yanick.com.proyectofauna.androidfauna.modelo.Clase;
import yanick.com.proyectofauna.androidfauna.modelo.Division;
import yanick.com.proyectofauna.androidfauna.modelo.contract.ContractClase;

public class DAODivision extends OperecionesSQLite<Division> {
    private DBsingleton dBsingleton;

    private Context context;

    public DAODivision(Context context) {
        this.context = context;
        dBsingleton = DBsingleton.getInstance(context);
    }

    @Override
    public Division mostrarbyID(String id) {
        return null;
    }

    @Override
    public String insertar(String tabla, Division values) {
        return null;
    }

    @Override
    public ArrayList<Division> buscar(int id) {
        return null;
    }

    @Override
    public ArrayList<Division> buscar(String id) {
        return null;
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
    public ArrayList<Division> mostrar() {
        ArrayList<Division> arrayList = new ArrayList<>();

        SQLiteDatabase db = dBsingleton.getDATABASE().getReadableDatabase();

        String sql = String.format("Select * from %s ", ContractClase.Division.TABLA).toString();

        Cursor cursor = db.rawQuery(sql,null);

        if(cursor.moveToFirst()){
            do{
                Division respuesta = new Division();
                respuesta.setId(cursor.getString(2));
                respuesta.setNombre(cursor.getString(1));
                respuesta.set_id(cursor.getInt(0));
                arrayList.add(respuesta);
            }while (cursor.moveToNext());

            return arrayList;
        }else{
            return arrayList;
        }
    }
}
