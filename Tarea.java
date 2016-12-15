
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

    /**
     * Constructor para objetos de la clase Tarea
     */
    public Tarea(String nombre)
    {
        descripcion = nombre;
        finalizada = false;
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
	
	
}
