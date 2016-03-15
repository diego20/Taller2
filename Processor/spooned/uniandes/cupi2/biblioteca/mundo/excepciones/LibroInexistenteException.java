package uniandes.cupi2.biblioteca.mundo.excepciones;


/** 
 * Excepci�n lanzada cuando se referencia un libro inexistente.
 */
public class LibroInexistenteException extends java.lang.Exception {
    /** 
     * Constante de serializaci�n.
     */
    private static final long serialVersionUID = -3643531559677936939L;
    
    /** 
     * Constructor de la excepci�n.
     * @param referencia Referencia del libro inexistente.
     */
    public LibroInexistenteException(java.lang.String referencia) {
        super(("No existe ning�n libro con la referencia: " + referencia));
    }
    
}

