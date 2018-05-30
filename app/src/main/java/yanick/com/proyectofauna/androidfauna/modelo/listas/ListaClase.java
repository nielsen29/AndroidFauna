package yanick.com.proyectofauna.androidfauna.modelo.listas;

import android.content.Context;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

import yanick.com.proyectofauna.androidfauna.modelo.Clase;
import yanick.com.proyectofauna.androidfauna.modelo.DAOs.DAOClase;
import yanick.com.proyectofauna.androidfauna.modelo.Division;


public class ListaClase {

    private ArrayList<Clase> ListaClase;
    private Division division;

    private DAOClase daoClase;

    public ListaClase(Context context) {
        this.ListaClase = new ArrayList<>();
        //this.division = division;
        daoClase = new DAOClase(context);
        CargarLista(context);

    }
    private void CargarLista(Context context)
    {

        this.setListaClase(daoClase.mostrar());

        /*switch (division.getId()){
            case 890:
                this.ListaClase.add(new Clase("xxxx", this.division));
                this.ListaClase.add(new Clase("xddddd", this.division));
                this.ListaClase.add(new Clase("mmmmmm", this.division));
                break;
            case 2:
                this.ListaClase.add(new Clase("123", this.division));
                this.ListaClase.add(new Clase("12333", this.division));
                this.ListaClase.add(new Clase("11111111", this.division));
                break;
            case 1:
                this.ListaClase.add(new Clase("kkkkkkk", this.division));
                this.ListaClase.add(new Clase("lllllllllll", this.division));
                this.ListaClase.add(new Clase("aaaaaaaaaaaaa", this.division));
                break;
        }*/

    }
    public ArrayList<Clase> BuscarLista(String id_division){
        this.setListaClase(daoClase.buscar(id_division));
        return this.ListaClase;

    }

    public ArrayList<Clase> getListaClase() {
        return ListaClase;
    }

    public void setListaClase(ArrayList<Clase> listaClase) {
        ListaClase = listaClase;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
