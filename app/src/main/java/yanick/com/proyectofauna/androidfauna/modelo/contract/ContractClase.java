package yanick.com.proyectofauna.androidfauna.modelo.contract;

import java.util.UUID;

import yanick.com.proyectofauna.androidfauna.modelo.Animal;

public class ContractClase {

    //CAMPOS TABLA DIVISION
    interface ColumnasDivision
    {
        String TABLA = "division";
        String ID = "id";
        String NOMBRE = "nombre";
    }

    interface ColumnasClase
    {
        String TABLA = "clase";
        String ID = "id";
        String NOMBRE = "nombre";
        String ID_DIVISION = "id_division";
    }

    //CAMPOS TABLA ORDEN
    interface ColumnasOrden
    {
        String TABLA = "orden";
        String ID = "id";
        String NOMBRE = "nombre";
        String ID_CLASE = "id_clase";
    }

    //CAMPOS TABLA FAMILIA
    interface ColumnasFamilia
    {
        String TABLA = "familia";
        String ID = "id";
        String NOMBRE = "nombre";
        String ID_ORDEN = "id_orden";
    }

    //CAMPOS TABLA GENERO
    interface ColumnasGenero
    {
        String TABLA = "genero";
        String ID = "id";
        String NOMBRE = "nombre";
        String ID_FAMILIA = "id_familia";
    }

    //CAMPOS TABLA ESPECIE
    interface ColumnasEspecie
    {
        String TABLA = "especie";
        String ID = "id";
        String NOMBRE = "nombre";
        String ID_GENERO = "id_genero";
    }

    //DATOS ANIMAL
    interface  ColumnasAnimal
    {
        String TABLA = "animal";
        String ID    = "id";
        String NOMBRE = "nombre";
        String DESCRIPCION = "descripcion";
        String LONGITUD = "longitud";
        String LATITUD = "latitud";
        String PAIS  = "pais";

        //TAXONOMIA

        String ID_DIVISION = "id_division";
        String ID_CLASE = "id_clase";
        String ID_ORDEN = "id_orden";
        String ID_FAMILIA = "id_familia";
        String ID_GENERO = "id_genero";
        String ID_ESPECIE = "id_especie";

    }

    public static class Division implements ColumnasDivision{
        public static String getID(){
            return "DIV-" + UUID.randomUUID().toString();
        }
    }

    public static class Clase implements ColumnasClase{
        public static String getID(){
            return "CLS-" + UUID.randomUUID().toString();
        }
    }

    public static class Orden implements ColumnasOrden{
        public static String getID(){
            return "ORD-" + UUID.randomUUID().toString();
        }
    }

    public static class Familia implements ColumnasFamilia{
        public static String getID() { return "FAM-" + UUID.randomUUID().toString();
        }
    }

    public static class Genero implements ColumnasGenero{
        public static String getID() { return "GEN-" + UUID.randomUUID().toString();
        }
    }

    public static class Especie implements ColumnasEspecie{
        public static String getID() { return "ESP-" + UUID.randomUUID().toString();
        }
    }

    public static class Animal implements ColumnasAnimal{
        public static String getID() { return  "ANI-" + UUID.randomUUID().toString();
        }
    }



    public ContractClase() {
    }
}
