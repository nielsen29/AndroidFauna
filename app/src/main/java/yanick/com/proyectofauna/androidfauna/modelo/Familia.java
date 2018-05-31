package yanick.com.proyectofauna.androidfauna.modelo;


import android.content.ContentValues;

import yanick.com.proyectofauna.androidfauna.modelo.contract.ContractClase;

public class Familia {

    private int _id;
    private String id;
    private String nombre;
    private String id_Orden;
    private Orden orden;


    public Familia(String nombre, Orden orden) {
        this.id = ContractClase.Familia.getID();
        this.nombre = nombre;
        this.orden = orden;
    }

    public Familia() {
        this.id = ContractClase.Familia.getID();
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
        return id_Orden;
    }

    public void setId_Clase(String id_Orden) {
        this.id_Orden = id_Orden;
    }

    @Override
    public String toString() {
        return this.nombre;
    }

    public ContentValues getContentValue(){
        if(this.orden == null){
            return null;
        }
        ContentValues values = new ContentValues();
        values.put(ContractClase.Familia.ID,this.id);
        values.put(ContractClase.Familia.NOMBRE,this.nombre);
        values.put(ContractClase.Familia.ID_ORDEN,this.orden.getId());
        return values;
    }
}
