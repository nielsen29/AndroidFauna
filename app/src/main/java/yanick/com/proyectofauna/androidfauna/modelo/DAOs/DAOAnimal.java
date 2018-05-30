package yanick.com.proyectofauna.androidfauna.modelo.DAOs;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.Arrays;

import yanick.com.proyectofauna.androidfauna.OpenHelper.DBsingleton;
import yanick.com.proyectofauna.androidfauna.OpenHelper.OperecionesSQLite;
import yanick.com.proyectofauna.androidfauna.modelo.Animal;
import yanick.com.proyectofauna.androidfauna.modelo.contract.ContractClase;

public class DAOAnimal extends OperecionesSQLite<Animal> {

    private DBsingleton dBsingleton;

    private Context context;


    public DAOAnimal(Context context) {
        this.context = context;

        this.dBsingleton = DBsingleton.getInstance(context);
    }

    @Override
    public Animal mostrarbyID(String id) {

        Animal respuesta = new Animal();
        SQLiteDatabase db = dBsingleton.getDATABASE().getReadableDatabase();

        String sql = String.format("Select * from "+ContractClase.Animal.TABLA+ " where "+ContractClase.Animal.ID+ " = '%s'",id);

        Cursor cursor = db.rawQuery(sql,null);
        if(cursor.moveToFirst()){
            do{
                respuesta.setFromCursor(cursor);
            }while (cursor.moveToNext());
        }
        return respuesta;
    }

    @Override
    public String insertar(String tabla, Animal values) {

        SQLiteDatabase db = dBsingleton.getDATABASE().getWritableDatabase();

        db.insert(ContractClase.Animal.TABLA,null,values.getContentValue());

        return values.getId();
    }

    @Override
    public ArrayList<Animal> buscar(int id) {
        return null;
    }

    @Override
    public ArrayList<Animal> buscar(String id) {
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
    public ArrayList<Animal> mostrar() {
        return null;
    }
}
