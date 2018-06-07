package yanick.com.proyectofauna.androidfauna.modelo.DAOs;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import yanick.com.proyectofauna.androidfauna.OpenHelper.DBsingleton;
import yanick.com.proyectofauna.androidfauna.OpenHelper.OperecionesSQLite;
import yanick.com.proyectofauna.androidfauna.modelo.Especie;
import yanick.com.proyectofauna.androidfauna.modelo.contract.ContractClase;

public class DAOEspecie extends OperecionesSQLite <Especie> {

    private DBsingleton dBsingleton;

    private Context context;

    public DAOEspecie(Context context) {
        this.context = context;
        dBsingleton = DBsingleton.getInstance(context);
    }


    @Override
    public Especie mostrarbyID(String id) {
        return null;
    }

    @Override
    public String insertar(String tabla, Especie values) {
        return null;
    }

    @Override
    public ArrayList<Especie> buscar(int id) {
        return null;
    }

    @Override
    public ArrayList<Especie> buscar(String id) {

        ArrayList<Especie> arrayList = new ArrayList<>();

        SQLiteDatabase db = dBsingleton.getDATABASE().getReadableDatabase();

        String sql = String.format("Select * from %s where "+ ContractClase.Especie.ID_GENERO +" = '%s'", ContractClase.Especie.TABLA, id).toString();

        Cursor cursor = db.rawQuery(sql,null);

        if(cursor.moveToFirst()){
            do{
                Especie respuesta = new Especie();
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
    public ArrayList<Especie> mostrar() {
        return null;
    }
}
