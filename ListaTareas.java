import java.util.ArrayList;
/**
 * Write a description of class ListaTareas here.
 * 
 * @author (Oschariv) 
 * @version (2.0 - 15/12/2016)
 */
public class ListaTareas
{
    // instance variables 
    private ArrayList<Tarea> listaDeTareas;

    /**
     * Constructor for objects of class ListaTareas
     */
    public ListaTareas()
    {
        listaDeTareas = new ArrayList<Tarea>();
    }

    /**
     * Metodo que permite añadir una nueva tarea.
     */
    public void addTarea(String descripcion)
    {
        Tarea nuevaTarea = new Tarea(descripcion);
        listaDeTareas.add(nuevaTarea);
    }
}
