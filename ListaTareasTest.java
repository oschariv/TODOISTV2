

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class ListaTareasTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class ListaTareasTest
{
    private ListaTareas Tareas1;

    /**
     * Default constructor for test class ListaTareasTest
     */
    public ListaTareasTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        Tareas1 = new ListaTareas();
        Tareas1.addTarea("hacer la cama");
        Tareas1.addTarea("estudiar programacion");
        Tareas1.addTarea("Comprar pan");
        Tareas1.addTarea("hacer comida");
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }
}
