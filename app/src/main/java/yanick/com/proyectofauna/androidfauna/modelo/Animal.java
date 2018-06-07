package yanick.com.proyectofauna.androidfauna.modelo;

import android.content.ContentValues;
import android.database.Cursor;

import yanick.com.proyectofauna.androidfauna.modelo.contract.ContractClase;

public class Animal {


    //VARIABLES ANIMAL
    private int _id;
    private String id;
    private String nombre;
    private String descripcion;
    private String longitud;
    private String latitud;
    private String pais;

    //VARIABLES TAXONOMIA
    private String id_division;
    private String id_clase;
    private String id_orden;
    private String id_familia;
    private String id_genero;
    private String id_especie;


    public Animal() {
        this.id = ContractClase.Animal.getID();
    }

    public Animal(int _id, String id, String nombre, String descripcion, String longitud,
                  String latitud, String pais, String id_division, String id_clase, String id_orden,
                  String id_familia, String id_genero, String id_especie) {

        this._id = _id;
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.longitud = longitud;
        this.latitud = latitud;
        this.pais = pais;
        this.id_division = id_division;
        this.id_clase = id_clase;
        this.id_orden = id_orden;
        this.id_familia = id_familia;
        this.id_genero = id_genero;
        this.id_especie = id_especie;

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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getLongitud() {
        return longitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }

    public String getLatitud() {
        return latitud;
    }

    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getId_division() {
        return id_division;
    }

    public void setId_division(String id_division) {
        this.id_division = id_division;
    }

    public String getId_clase() {
        return id_clase;
    }

    public void setId_clase(String id_clase) {
        this.id_clase = id_clase;
    }

    public String getId_orden() {
        return id_orden;
    }

    public void setId_orden(String id_orden) {
        this.id_orden = id_orden;
    }

    public String getId_familia() {
        return id_familia;
    }

    public void setId_familia(String id_familia) {
        this.id_familia = id_familia;
    }

    public String getId_genero() {
        return id_genero;
    }

    public void setId_genero(String id_genero) {
        this.id_genero = id_genero;
    }

    public String getId_especie() {
        return id_especie;
    }

    public void setId_especie(String id_especie) {
        this.id_especie = id_especie;
    }

    public ContentValues getContentValue(){
        if(this.nombre == null){
            return null;
        }

        ContentValues values = new ContentValues();
        values.put(ContractClase.Animal.ID,this.id);
        values.put(ContractClase.Animal.NOMBRE,this.nombre);
        values.put(ContractClase.Animal.DESCRIPCION,this.descripcion);
        values.put(ContractClase.Animal.LONGITUD,this.longitud);
        values.put(ContractClase.Animal.LATITUD, this.latitud);
        values.put(ContractClase.Animal.PAIS, this.pais);
        values.put(ContractClase.Animal.ID_DIVISION, this.id_division);
        values.put(ContractClase.Animal.ID_CLASE, this.id_clase);
        values.put(ContractClase.Animal.ID_ORDEN, this.id_orden);
        values.put(ContractClase.Animal.ID_FAMILIA, this.id_familia);
        values.put(ContractClase.Animal.ID_GENERO,this.id_genero);
        values.put(ContractClase.Animal.ID_ESPECIE, this.id_especie);
        return values;
    }

    public void setFromCursor(Cursor cursor){

        this._id = cursor.getInt(0);
        this.id = cursor.getString(1);
        this.nombre = cursor.getString(2);
        this.descripcion = cursor.getString(3);
        this.longitud = cursor.getString(4);
        this.latitud = cursor.getString(5);
        this.pais = cursor.getString(6);
        this.id_division = cursor.getString(7);
        this.id_clase = cursor.getString(8);

    }

    @Override
    public String toString() {
        return this.nombre;
    }


}
