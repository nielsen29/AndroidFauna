package yanick.com.proyectofauna.androidfauna.modelo;

import android.content.ContentValues;

import yanick.com.proyectofauna.androidfauna.modelo.contract.ContractClase;


public class Especie {

    private int _id;
    private String id;
    private String nombre;
    private String id_Genero;
    private Especie especie;


    public Especie(String nombre, Especie especie) {
        this.id = ContractClase.Especie.getID();
        this.nombre = nombre;
        this.especie = especie;
    }

    public Especie() {
        this.id = ContractClase.Especie.getID();
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
        return id_Genero;
    }

    public void setId_Clase(String id_Clase) {
        this.id_Genero = id_Genero;
    }

    @Override
    public String toString() {
        return this.nombre;
    }

    public ContentValues getContentValue(){
        if(this.especie == null){
            return null;
        }
        ContentValues values = new ContentValues();
        values.put(ContractClase.Especie.ID,this.id);
        values.put(ContractClase.Especie.NOMBRE,this.nombre);
        values.put(ContractClase.Especie.ID_GENERO,this.especie.getId());
        return values;
    }

}
