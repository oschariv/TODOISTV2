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
    private LocalDate fechaVencimiento;

    /**
     * Constructor para objetos de la clase Tarea
     */
    public Tarea(String nombre)
    {
        descripcion = nombre;
        finalizada = false;
        prioridad = 0;
        fechaVencimiento = null;
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
        String fechaADevolver = "";
        if (finalizada){
            textoADevolver = textoADevolver + "HECHA. ";
        }
        if(fechaVencimiento != null){
            int getDia = fechaVencimiento.getDayOfMonth();
            int getMes = fechaVencimiento.getMonthValue();
            int getAnio = fechaVencimiento.getYear();
        
            fechaADevolver = "[" + getDia + "/" + getMes + "/" + getAnio + "]";
        }
        textoADevolver = textoADevolver + "(Prioridad " + prioridad + ")"
                        + descripcion + " " + fechaADevolver;
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
       fechaVencimiento = LocalDate.of(anio, mes, dia);
    }
}
