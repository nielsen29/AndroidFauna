package yanick.com.proyectofauna.androidfauna.modelo;

import yanick.com.proyectofauna.androidfauna.modelo.contract.ContractClase;
import android.content.ContentValues;


public class Genero {

    private int _id;
    private String id;
    private String nombre;
    private String id_Familia;


    public Genero(String nombre) {
        this.id = ContractClase.Genero.getID();
        this.nombre = nombre;
    }

    public Genero() {
        this.id = ContractClase.Genero.getID();
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

    public String getId_Clase() {
        return id_Familia;
    }

    public void setId_Clase(String id_Clase) {
        this.id_Familia = id_Familia;
    }

    @Override
    public String toString() {
        return this.nombre;
    }

    public ContentValues getContentValue(){
        if(this.nombre == null){
            return null;
        }
        ContentValues values = new ContentValues();
        values.put(ContractClase.Genero.ID,this.id);
        values.put(ContractClase.Genero.NOMBRE,this.nombre);
        values.put(ContractClase.Genero.ID_FAMILIA,this.id_Familia);
        return values;
    }


}
