package uniandes.cupi2.biblioteca.mundo;


/** 
 * Interfaz que modela el comportamiento de un libro.
 */
public interface ILibro extends java.io.Serializable , java.lang.Comparable<uniandes.cupi2.biblioteca.mundo.ILibro> {
    /** 
     * Reduce el n�mero de copias disponibles en 1.
     * @throws CopiasInsuficientesException El libro no tiene copias suficientes.
     */
    public void reducirCopiasDisponibles() throws uniandes.cupi2.biblioteca.mundo.excepciones.CopiasInsuficientesException;
    /** 
     * Reduce el n�mero de copias en pr�stamo en 1.
     */
    public void reducirCopiasEnPrestamo();
    /** 
     * Aumenta el n�mero de copias disponibles en 1.
     */
    public void aumentarCopiasDisponibles();
    /** 
     * Aumenta el n�mero de copias en pr�stamo en 1.
     */
    public void aumentarCopiasEnPrestamo();
    /** 
     * Retorna la referencia del libro.
     * @return La referencia del libro.
     */
    public java.lang.String darReferencia();
    /** 
     * Retorna el t�tulo del libro.
     * @return El t�tulo del libro.
     */
    public java.lang.String darTitulo();
    /** 
     * Retorna una cadena de caracteres con todos los autores asociados al libro.
     * @return Una cadena de caracteres con todos los autores asociados al libro.
     */
    public java.lang.String darAutores();
    /** 
     * Retorna el arreglo de autores del libro.
     * @return El arreglo de autores del libro.
     */
    public java.lang.String[] darArregloAutores();
    /** 
     * Retorna una cadena de caracteres con todos los descriptores asociados al libro.
     * @return Una cadena de caracteres con todos los descriptores asociados al libro.
     */
    public java.lang.String darDescriptores();
    /** 
     * Retorna el n�mero de copias disponibles.
     * @return El n�mero de copias disponibles.
     */
    public int darCopiasDisponibles();
    /** 
     * Retorna el n�mero de copias en pr�stamo.
     * @return El n�mero de copias en pr�stamo.
     */
    public int darCopiasPrestamo();
    /** 
     * Retorna el arreglo de descriptores.
     * @return El arreglo de descriptores.
     */
    public java.lang.String[] darArregloDescriptores();
    /** 
     * Verifica si la cadena dada es un descriptor del libro.
     * @param descriptor Descriptor a verificar.
     * @return true si la cadena dada es un descriptor del libro o false en caso contrario.
     */
    public boolean esDescriptor(java.lang.String descriptor);
}

