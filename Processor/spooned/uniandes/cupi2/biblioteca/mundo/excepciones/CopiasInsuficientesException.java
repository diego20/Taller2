package uniandes.cupi2.biblioteca.mundo.excepciones;


/** 
 * Excepci�n lanzada cuando se intenta prestar un libro que no tiene copias disponibles.
 */
public class CopiasInsuficientesException extends java.lang.Exception {
    /** 
     * Constante de serializaci�n.
     */
    private static final long serialVersionUID = -3638303840577988228L;
    
    /** 
     * Constructor de la excepci�n.
     * @param libro Libro que gener� el error de pr�stamo.
     */
    public CopiasInsuficientesException(uniandes.Libro libro) {
        super((("El libro " + (libro.darTitulo())) + " no tiene copias disponibles"));
    }
    
}

