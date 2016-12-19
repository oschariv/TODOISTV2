import java.time.LocalDate;
/**
 * Write a description of class Tarea here.
 * 
 * @author (Oschariv) 
 * @version (2.0 - 15/10/2016)
 */
public class Tarea
{
    // instance variables
    private String descripcion;
    private boolean finalizada;
    private int prioridad;
    private LocalDate fechaTomada;

    /**
     * Constructor para objetos de la clase Tarea
     */
    public Tarea(String nombre)
    {
        descripcion = nombre;
        finalizada = false;
        prioridad = 0;
        fechaTomada = null;
    }
    
    public String mostrarTarea(){
        return descripcion;
    }
    
    public boolean mostrarFinalizada(){
        return finalizada;
    }
    
    public void marcarFinalizada(){
        finalizada = true;
    }
    
    /**
     * Metodo que devuelve una cadena al invocarlo.
     */
    public String toString() {
        String textoADevolver = "";
        String prioridadADevolver = "";
        if (finalizada){
            textoADevolver = textoADevolver + "HECHA. ";
        }      
        textoADevolver = textoADevolver + "(Prioridad " + prioridad + ")"
                        + descripcion;
        return textoADevolver;
    }
    
    /**
     * Metodo que permite modificar la prioridad de una tarea.
     * 0 minima prioridad -- 5 maxima prioridad
     */
    public void setPrioridad(int prioridad){
        if(prioridad >= 0 && prioridad <= 5){
            this.prioridad = prioridad;
        }
    }
       
    /**
     * Obtener fecha de vencimiento.
     */
    public void setFechaVencimiento(int anio, int mes, int dia){
       fechaTomada = LocalDate.of(anio, mes, dia);
    }
    
    public String fechaToString(){
        String fechaADevolver = "";
        
        String getDia = "" + fechaTomada.getDayOfMonth();
        String getMes = "" + fechaTomada.getMonthValue();
        String getAnio = "" + fechaTomada.getYear();
        
        fechaADevolver = getDia + "/" + getMes + "/" + getAnio;
        
        return fechaADevolver;
    }
}
