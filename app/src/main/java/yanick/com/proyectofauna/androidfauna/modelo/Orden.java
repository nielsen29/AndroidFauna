package yanick.com.proyectofauna.androidfauna.modelo;

import android.content.ContentValues;

import yanick.com.proyectofauna.androidfauna.modelo.contract.ContractClase;

public class Orden {

    private int _id;
    private String id;
    private String nombre;
    private String id_Clase;


    public Orden(String nombre) {
        this.id = ContractClase.Orden.getID();
        this.nombre = nombre;
    }

    public Orden() {
        this.id = ContractClase.Orden.getID();
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
        return id_Clase;
    }

    public void setId_Clase(String id_Clase) {
        this.id_Clase = id_Clase;
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
        values.put(ContractClase.Orden.ID,this.id);
        values.put(ContractClase.Orden.NOMBRE,this.nombre);
        values.put(ContractClase.Orden.ID_CLASE,this.id_Clase);
        return values;
    }
}
