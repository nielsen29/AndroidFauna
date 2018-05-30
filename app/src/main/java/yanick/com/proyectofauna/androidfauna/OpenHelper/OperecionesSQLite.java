package yanick.com.proyectofauna.androidfauna.OpenHelper;

import android.content.ContentValues;
import android.database.Cursor;

import java.util.ArrayList;

public abstract class OperecionesSQLite <T> {


    public abstract T mostrarbyID(String id);
    public abstract String insertar(String tabla, T values);
    public abstract ArrayList<T> buscar(int id);
    public abstract ArrayList<T> buscar(String id);
    public abstract boolean actualizar(int id,ContentValues values);
    public abstract boolean actualizar(String id,ContentValues values);
    public abstract boolean borrar(int id);
    public abstract boolean borrar(String id);
    public abstract ArrayList<T> mostrar();


}
