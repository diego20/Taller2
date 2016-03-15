package uniandes.cupi2.biblioteca.mundo.excepciones;


/** 
 * Excepci�n lanzada cuando se presenta alg�n error al salvar la informaci�n de la biblioteca.
 */
public class SalvarBibliotecaException extends java.lang.Exception {
    /** 
     * Constante de serializaci�n.
     */
    private static final long serialVersionUID = -4720386525812340814L;
    
    /** 
     * Constructor de la excepci�n.
     * @param mensaje Mensaje de la excepci�n.
     */
    public SalvarBibliotecaException(java.lang.String mensaje) {
        super(mensaje);
    }
    
}

