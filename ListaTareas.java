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
    
    /**
     * Muestra todas las tareas existentes (usando un bucle WHILE)
     * y que esten numerdadas.
     */
    public void mostrarTareasNumeradas()
    {
        int contador = 0;       
        while (contador < listaDeTareas.size()) {
            System.out.println((contador +1) + ". "
                                + listaDeTareas.get(contador).toString());
            contador++;
        }
    }
    
    /**
     * Metodo que establece tareas completadas o  sin completar.
     * Metodo a prueba de errores.
     * numeroTarea es el numero de la tarea empezando en uno.
     */
    public void marcarComoCompletada(int numeroTarea){
        if (numeroTarea > 0 && numeroTarea <= listaDeTareas.size()){
            listaDeTareas.get(numeroTarea - 1).marcarFinalizada();
        }
    }

    /**
     * Muestra todas las tareas (una por linea) que contengan un determinado texto
     * pasado como parametro con su numeracion asociada correcta. si no hay ninguna
     * tarea que contenga el texto indicado, se muestra ¡un mensaje de error!.
     * Si hay tareas coincidentes, tras la lista, se muestra el numero 
     * de tareas coincidentes.
     */
        
    public void mostrarTareasCoincidentes(String textoBuscar){
        int contador = 1;
        while(contador > 0 && contador <= listaDeTareas.size()){
            if (listaDeTareas.get(contador - 1).mostrarTarea().contains(textoBuscar)){
                System.out.println((contador) + ". "
                                + listaDeTareas.get(contador - 1).toString());
            }
            contador++;
        }
    }
    
    /**
     * Metodo que permite borrar tareas de forma permanente.
     * La posicion se da a partir del 1
     */
    public void removerTarea(int posicion){
        if (posicion > 0 && posicion <= listaDeTareas.size()) {
            listaDeTareas.remove(posicion -1);
        }
    }
    
    /**
     * Metodo que nos permite establecer la prioridad a una tarea.
     * 0 Prioridad baja.
     * 5 Prioridad alta.
     */
    public void cambiarPrioridad(int posicion, int prioridad){
        listaDeTareas.get(posicion - 1).setPrioridad(prioridad);
    }
}