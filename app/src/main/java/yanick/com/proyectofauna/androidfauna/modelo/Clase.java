package yanick.com.proyectofauna.androidfauna.modelo;

import android.content.ContentValues;

import yanick.com.proyectofauna.androidfauna.modelo.contract.ContractClase;

public class Clase {

    private int _id;
    private String id;
    private String nombre;
    private Division division;

    public Clase() {

    }

    public Clase (String nombre, Division division) {
        this.id = ContractClase.Clase.getID();
        this.nombre = nombre;
        this.division = division;
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

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }

    @Override
    public String toString() {
        return this.nombre;
    }

    public ContentValues getContentValue(){
        if(this.division == null){
            return null;
        }

        ContentValues values = new ContentValues();
        values.put(ContractClase.Clase.ID,this.id);
        values.put(ContractClase.Clase.NOMBRE,this.nombre);
        values.put(ContractClase.Clase.ID_DIVISION, this.division.getId());
        return values;
    }
}


