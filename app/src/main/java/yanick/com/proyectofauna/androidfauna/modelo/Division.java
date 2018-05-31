package yanick.com.proyectofauna.androidfauna.modelo;

import android.content.ContentValues;

import yanick.com.proyectofauna.androidfauna.modelo.DAOs.DAODivision;
import yanick.com.proyectofauna.androidfauna.modelo.contract.ContractClase;

public class Division {

private int _id;

private String id;

private String nombre;

    public Division()
    {

    }

    public Division( String nombre) {
        this.id = ContractClase.Division.getID();
        this.nombre = nombre;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return nombre;
    }


    public ContentValues getContentValue(){
        if(this.nombre == null){
            return null;
        }

        ContentValues values = new ContentValues();
        values.put(ContractClase.Division.ID,this.id);
        values.put(ContractClase.Division.NOMBRE,this.nombre);
        return values;
    }
}
