package uniandes.cupi2.biblioteca.mundo.excepciones;


/** 
 * Excepci�n lanzada cuando se presenta alg�n error al cargar la informaci�n de la biblioteca.
 */
public class CargarBibliotecaException extends java.lang.Exception {
    /** 
     * Constante de serializaci�n.
     */
    private static final long serialVersionUID = 354958047650021157L;
    
    /** 
     * Constructor de la excepci�n.
     * @param mensaje Mensaje de la excepci�n.
     */
    public CargarBibliotecaException(java.lang.String mensaje) {
        super(mensaje);
    }
    
}

