import java.util.ArrayList;
import java.time.LocalDate;
/**
 * Write a description of class ListaTareas here.
 * 
 * @author (Oschariv) 
 * @version (2.0 - 15/12/2016)
 */
public class ListaTareas
{
    // Crea un array a partir de la clase tarea.
    private ArrayList<Tarea> listaDeTareas;
    // Almacena el identificador de la tarea en la lista de tareas.
    private int id;

    /**
     * Constructor for objects of class ListaTareas
     */
    public ListaTareas()
    {
        listaDeTareas = new ArrayList<Tarea>();
        id = 0;        
    }

    /**
     * Metodo que permite añadir una nueva tarea.
     */
    public void addTarea(String descripcion)
    {        
        if (id < 89) {
            Tarea nuevaTarea = new Tarea(id, descripcion);
            listaDeTareas.add(nuevaTarea);
            id++;
        }     
    }
    
    /**
     * Muestra todas las tareas existentes (usando un bucle WHILE)
     * y que esten numerdadas.
     */
    public void mostrarTareasNumeradas()
    {
        int contador = 0;       
        while (contador < listaDeTareas.size()) {
            System.out.println(listaDeTareas.get(contador).toString());
            contador++;
        }
    }
    
    /**
     * 
     */
    public boolean esValidoElIndice(int id){
        return id >= 0 && id < this.id;
    }
    
    /**
     * Metodo que establece tareas completadas o  sin completar.
     * Metodo a prueba de errores.
     * El id de las tarea empieza en cero hasta el 89.
     */
    public void marcarComoCompletada(int id){
        if (esValidoElIndice(id)){
            listaDeTareas.get(id).marcarFinalizada();
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
    public void removerTarea(int id){
        if (esValidoElIndice(id)) {
            listaDeTareas.remove(id);
        }
    }
    
    /**
     * Metodo que nos permite establecer la prioridad a una tarea.
     * 0 Prioridad baja.
     * 5 Prioridad alta.
     */
    public void cambiarPrioridad(int id, int prioridad){
        if (esValidoElIndice(id)) {
            listaDeTareas.get(id).setPrioridad(prioridad);
        }
    }
    
    public void establecerFechaVencimiento(int id, int anio, int mes, int dia){
        if (esValidoElIndice(id)) {
            listaDeTareas.get(id).setFechaVencimiento(anio, mes, dia);
        }
    }
    
    /**
     * Metodo que muestra por pantalla si hay tareas para vencer en la fecha actual
     */
    public void mostrarHoy(){    
        int posicion = 1;
        LocalDate hoy = LocalDate.now();
        for (Tarea tarea : listaDeTareas){
            if (tarea.getFechaVencimiento() != null){
                if (tarea.getFechaVencimiento().isEqual(hoy)) {
                    System.out.println(tarea.toString());
                    posicion++;
                }
            }
        }        
    }
    
    /**
     * Metodo que muestra las tareas ya vencidas antes de la fecha de hoy
     */
    public void mostrarVencidas(){
        int posicion = 1;
        LocalDate hoy = LocalDate.now();
        for (Tarea tarea : listaDeTareas){
            if (tarea.getFechaVencimiento() != null){
                if (tarea.getFechaVencimiento().isBefore(hoy)) {
                    System.out.println(tarea.toString());
                    posicion++;
                }
            }
        }
    }
    
    /**
     * Metodo que muestra la tarea con la más alta prioridad. 
     * Si hay varias tareas con la misma priodad, debe mostrar todas las tareas.
     */
    
    /**public void verTareaMasPrioritaria()
    {
        int i = 0;
        int buscarPrioridad = 5;
        boolean localizado = false;
        Tarea tareaLocal = new Tarea("");
        while(buscarPrioridad >= 0 && !localizado){
             while(i < listaDeTareas.size()){
                 tareaLocal = listaDeTareas.get(i);
                 if(tareaLocal.getPrioridad() == buscarPrioridad){
                     System.out.println((i + 1) + " " + tareaLocal.toString());
                     localizado = true;
                 }
                 i++;
                 
             }
             i = 0;
             buscarPrioridad--;
        }
     }*/
        
    /**
      * Muestra la tarea con mayor prioridad.
      * En caso de que haya dos o mas tareas con la misma prioridad muestra solo la 
      * última tarea.
      */
    public void verTareaMasPrioritaria2()
    {
        if(listaDeTareas.size() > 0){
            int prioridadMaxima = listaDeTareas.get(0).getPrioridad();
            Tarea tareaGuardada = listaDeTareas.get(0);
            int index = 1;
            int indexGuardado = index;
            for(Tarea tarea : listaDeTareas){
                if(tarea.getPrioridad() >= prioridadMaxima){
                    tareaGuardada = tarea;
                    prioridadMaxima = tarea.getPrioridad();
                    indexGuardado = index;
                }
                index++;
            }
            System.out.println(indexGuardado + " " + tareaGuardada.toString());
        }
    }
    
    /**
     * Metodo que nos permite localizar la tarea mas antigua que aun esta pendiente.
     * En caso de que no haya tarea sin completar devuelve -1.
     */
    public int tareaMasViejaPendiente(){
        int idEncontrado = -1;
        int index = 0;
        boolean buscando = true;
        while (index < listaDeTareas.size() && buscando){
            Tarea tareaActual = listaDeTareas.get(index);
            if (!(tareaActual.mostrarFinalizada())){
                idEncontrado = tareaActual.getId();
                buscando = false;
            }
            index ++;
        }
        
        return idEncontrado;
    }
    
    /**
     * Devuelve el numero de tareas sin terminar
     */
    public int numeroTareasSinTerminar(){
        int tareasEncontradas = 0;
        int index = 0;        
        while (index < listaDeTareas.size()){
            Tarea tareaActual = listaDeTareas.get(index);
            if (!(tareaActual.mostrarFinalizada())){                
                tareasEncontradas++;
            }
            index ++;
        }
        
        return tareasEncontradas;
    }
    
    /**
     * Metodo que devuelve true si hay tareas duplicadas, y false si no las hay.
     * 
     * indiceLento es el contador del bucle externo.
     * indiceRapido es el contador del bucle interno.
     * buscando cuando cambia a false para todo el bucle
     */
    public boolean hayTareasDuplicadas(){
        boolean tareaDuplicada = false;
        String tareaABuscar = "";
        int indiceLento = 0;
        while (indiceLento < listaDeTareas.size() && (!tareaDuplicada)){
            int indiceRapido = indiceLento + 1;
            tareaABuscar = listaDeTareas.get(indiceLento).mostrarTarea();
            while(indiceRapido < listaDeTareas.size() && (!tareaDuplicada)){
                String tareaAComparar = listaDeTareas.get(indiceRapido).mostrarTarea();
                if(tareaABuscar == tareaAComparar){
                    tareaDuplicada = true;
                }
                indiceRapido++;
            }
            indiceLento++;
        } 
        return tareaDuplicada;
    }
}
