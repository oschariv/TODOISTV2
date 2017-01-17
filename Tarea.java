import java.time.LocalDate;
/**
 * Write a description of class Tarea here.
 * 
 * @author (Oschariv) 
 * @version (2.0 - 15/10/2016)
 */
public class Tarea
{
    // Almacena la descripcion de la tarea.
    private String descripcion;
    // Almacena si la tarea esta finalizada o no
    private boolean finalizada;
    // Almacena la prioridad de una tarea.
    private int prioridad;
    // Almacena la fecha de vencimiento de una tarea
    private LocalDate fechaVencimiento;
    // Almacena el identificador de una tarea.
    private int id;

    /**
     * Constructor para objetos de la clase Tarea
     */
    public Tarea(int id, String nombre)
    {
        this.id = id;
        descripcion = nombre;
        finalizada = false;
        prioridad = 0;
        fechaVencimiento = null;
    }
    
    /**
     * Devuelve la descripcion de la tarea.
     */
    public String mostrarTarea(){
        return descripcion;
    }
    
    /**
     * Muestra si la tarea esta finalizada.
     */
    public boolean mostrarFinalizada(){
        return finalizada;
    }
    
    /**
     * Marca la tarea como finalizada.
     */
    public void marcarFinalizada(){
        finalizada = true;
    }
    
    /**
     * Metodo que devuelve una cadena al invocarlo.
     */
    public String toString() {
        String idDevolver = id + "";
        if (id < 10) {
            idDevolver = "0" + id;
        }
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
        textoADevolver ="ID: " + idDevolver + textoADevolver + "(Prioridad " + prioridad + ")"
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
     * Establecer fecha de vencimiento.
     */
    public void setFechaVencimiento(int anio, int mes, int dia){
       fechaVencimiento = LocalDate.of(anio, mes, dia);
    }
    
    /**
     * Devuelve la fecha de vencicimiento.
     */
    public LocalDate getFechaVencimiento(){
        return fechaVencimiento;
    }
    
    /**
     * Devuelve la prioridad.
     */
    public int getPrioridad(){
        return prioridad;
    }
    
    /**
     * Devuelve el identificador de la tarea.
     */
    public int getId(){
        return id;
    }
}
