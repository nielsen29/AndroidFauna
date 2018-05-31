package yanick.com.proyectofauna.androidfauna.modelo.DAOs;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

import java.util.ArrayList;
import java.util.Arrays;

import yanick.com.proyectofauna.androidfauna.OpenHelper.DBsingleton;
import yanick.com.proyectofauna.androidfauna.OpenHelper.OperecionesSQLite;
import yanick.com.proyectofauna.androidfauna.modelo.Animal;
import yanick.com.proyectofauna.androidfauna.modelo.Clase;
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
        ArrayList<Animal> arrayList = new ArrayList<>();

        SQLiteDatabase db = dBsingleton.getDATABASE().getReadableDatabase();

        String sql = String.format("Select * from %s ", ContractClase.Animal.TABLA).toString();

        Cursor cursor = db.rawQuery(sql,null);

        if(cursor.moveToFirst()){
            do{
                Animal respuesta = new Animal();

                respuesta.set_id(cursor.getInt(cursor.getColumnIndex(BaseColumns._ID)));
                respuesta.setId(cursor.getString(cursor.getColumnIndex(ContractClase.Animal.ID)));
                respuesta.setNombre(cursor.getString(cursor.getColumnIndex(ContractClase.Animal.NOMBRE)));
                respuesta.setDescripcion(cursor.getString(cursor.getColumnIndex(ContractClase.Animal.DESCRIPCION)));
                respuesta.setLongitud(cursor.getString(cursor.getColumnIndex(ContractClase.Animal.LONGITUD)));
                respuesta.setLatitud(cursor.getString(cursor.getColumnIndex(ContractClase.Animal.LATITUD)));
                respuesta.setLongitud(cursor.getString(cursor.getColumnIndex(ContractClase.Animal.LONGITUD)));
                respuesta.setPais(cursor.getString(cursor.getColumnIndex(ContractClase.Animal.PAIS)));
                respuesta.setId_division(cursor.getString(cursor.getColumnIndex(ContractClase.Animal.ID_DIVISION)));
                respuesta.setId_clase(cursor.getString(cursor.getColumnIndex(ContractClase.Animal.ID_CLASE)));
                respuesta.setId_orden(cursor.getString(cursor.getColumnIndex(ContractClase.Animal.ID_ORDEN)));
                respuesta.setId_familia(cursor.getString(cursor.getColumnIndex(ContractClase.Animal.ID_FAMILIA)));
                respuesta.setId_genero(cursor.getString(cursor.getColumnIndex(ContractClase.Animal.ID_GENERO)));
                respuesta.setId_especie(cursor.getString(cursor.getColumnIndex(ContractClase.Animal.ID_ESPECIE)));

                arrayList.add(respuesta);
            }while (cursor.moveToNext());

            return arrayList;
        }else{
            arrayList.clear();
            return arrayList;
        }

    }
}
