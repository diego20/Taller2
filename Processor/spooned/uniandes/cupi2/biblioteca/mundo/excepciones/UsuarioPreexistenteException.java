package uniandes.cupi2.biblioteca.mundo.excepciones;


/** 
 * Excepci�n lanzada cuando se intenta ingresar un usuario preexistente.
 */
public class UsuarioPreexistenteException extends java.lang.Exception {
    /** 
     * Constante de serializaci�n.
     */
    private static final long serialVersionUID = 9070209798852432330L;
    
    /** 
     * Constructor de la excepci�n.
     * @param usuario Usuario preexistente que se intent� ingresar.
     */
    public UsuarioPreexistenteException(uniandes.Usuario usuario) {
        super((("El usuario identificado por el login: " + (usuario.darLogin())) + " ya existe en el sistema"));
    }
    
}

