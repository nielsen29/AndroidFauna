package yanick.com.proyectofauna.androidfauna.modelo.listas;

import android.content.Context;

import java.util.ArrayList;

import yanick.com.proyectofauna.androidfauna.modelo.DAOs.DAODivision;
import yanick.com.proyectofauna.androidfauna.modelo.Division;


public class ListaDivision
{
    private ArrayList<Division> listadivision;
    private DAODivision daoDivision;

    public ListaDivision(Context context) {
       this.listadivision = new ArrayList<>();
        daoDivision = new DAODivision(context);
        this.CargarLista(context);

    }

     private void CargarLista(Context context)
     {

         this.setListadivision(daoDivision.mostrar());

     }

    public ArrayList<Division> getListadivision() {
        return listadivision;
    }

    public void setListadivision(ArrayList<Division> listadivision) {
        this.listadivision = listadivision;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
