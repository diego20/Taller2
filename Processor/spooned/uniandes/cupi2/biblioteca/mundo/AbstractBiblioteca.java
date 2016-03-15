package uniandes.cupi2.biblioteca.mundo;


/** 
 * Clase abstracta que modela el comportamiento de una biblioteca.
 */
public abstract class AbstractBiblioteca extends java.util.Observable {
    /** 
     * Agrega Usuario a la biblioteca.
     * @param login Login del usuario - login != null.
     * @param clave Clave del usuario - clave != null.
     * @param nombre Nombre del usuario - nombre != null.
     * @throws UsuarioPreexistenteException Si se intenta ingresar un usuario con login repetido.
     */
    public abstract void insertarUsuario(java.lang.String login, java.lang.String clave, java.lang.String nombre) throws uniandes.cupi2.biblioteca.mundo.excepciones.UsuarioPreexistenteException;
    
    /** 
     * Agrega un libro a la biblioteca.
     * @param titulo T�tulo del libro - titulo != null.
     * @param autores Nombres de los autores del libro - autores != null.
     * @param descriptores Palabras claves del libro - descriptores != null.
     * @param ejemplares N�mero de copias del libro - ejemplares > 0.
     * @param ref Referencia del libro - referencia != null.
     * @throws LibroYaExisteException Si ya existe un libro con la referencia ingresada.
     */
    public abstract void insertarLibro(java.lang.String titulo, java.lang.String[] autores, java.lang.String[] descriptores, int ejemplares, java.lang.String ref) throws uniandes.cupi2.biblioteca.mundo.excepciones.LibroYaExisteException;
    
    /** 
     * Busca libro seg�n su t�tulo exacto.
     * @param titulo T�tulo del libro que se est� buscando - titulo != null.
     * @return Libros que cumplen con los par�metros de b�squeda.
     */
    public abstract uniandes.cupi2.collections.iterador.Iterador<uniandes.cupi2.biblioteca.mundo.ILibro>  buscarPorTituloExacto(java.lang.String titulo);
    
    /** 
     * Busca libros seg�n su t�tulo.
     * @param datos Palabras a buscar en el t�tulo - datos != null.
     * @return Libros que cumplen con los par�metros de b�squeda.
     */
    public abstract uniandes.cupi2.collections.iterador.Iterador<uniandes.cupi2.biblioteca.mundo.ILibro>  buscarPorTitulo(java.lang.String[] datos);
    
    /** 
     * Busca libros seg�n su autor exacto.
     * @param autor El nombre del autor seleccionado - datos!= null.
     * @return Libros que cumplen con los par�metros de b�squeda.
     */
    public abstract uniandes.cupi2.collections.iterador.Iterador<uniandes.cupi2.biblioteca.mundo.ILibro>  buscarPorAutoresExacto(java.lang.String autor);
    
    /** 
     * Busca libros seg�n alguno de sus autores.
     * @param datos Palabras a buscar en los nombres de los autores - datos != null.
     * @return Libros que cumplen con los par�metros de b�squeda.
     */
    public abstract uniandes.cupi2.collections.iterador.Iterador<uniandes.cupi2.biblioteca.mundo.ILibro>  buscarPorAutores(java.lang.String[] datos);
    
    /** 
     * Busca libros seg�n sus descriptores exactos.
     * @param datos Descriptores seleccionados - datos != null.
     * @return Libros que cumplen con los par�metros de b�squeda.
     */
    public abstract uniandes.cupi2.collections.iterador.Iterador<uniandes.cupi2.biblioteca.mundo.ILibro>  buscarPorDescriptoresExacto(java.lang.String[] datos);
    
    /** 
     * Busca libros seg�n alguno de sus descriptores.
     * @param datos Palabras a buscar en los descriptores del libro - datos != null.
     * @return Libros que cumplen con los par�metros de b�squeda.
     */
    public abstract uniandes.cupi2.collections.iterador.Iterador<uniandes.cupi2.biblioteca.mundo.ILibro>  buscarPorDescriptores(java.lang.String[] datos);
    
    /** 
     * Alquila un libro de la biblioteca.<br>
     * <b>pre: </b> El usuario y el libro seleccionados est�n registrados en el sistema.
     * @param usuario Login del usuario que alquila el libro - usuario!= null.
     * @param referencia Referencia del libro que se va a alquilar - referencia != null.
     * @throws CopiasInsuficientesException Si el libro no tiene copias disponibles para alquilar.
     */
    public abstract void alquilarLibro(java.lang.String usuario, java.lang.String referencia) throws uniandes.cupi2.biblioteca.mundo.excepciones.CopiasInsuficientesException;
    
    /** 
     * Retorna los libros alquilados por un usuario. <br>
     * <b>pre: </b>El usuario seleccionado est� registrado en el sistema.
     * @param usuario Usuario seleccionado - usuario != null.
     * @return Los libros alquilados por el usuario seleccionado.
     */
    public abstract uniandes.cupi2.collections.iterador.Iterador<uniandes.cupi2.biblioteca.mundo.ILibro>  darAlquilados(java.lang.String usuario);
    
    /** 
     * Devuelve un libro que estaba alquilado. <br>
     * <b>pre: </b>El usuario y libro seleccionado est�n registrados en el sistema, y el libro seleccionado est� alquilado por el usuario seleccionado.
     * @param usuario Login del usuario que est� devolviendo el libro - usuario != null.
     * @param referencia Referencia del libro que se est� devolviendo - referencia != null.
     */
    public abstract void devolverLibro(java.lang.String usuario, java.lang.String referencia);
    
    /** 
     * Retorna la cantidad total de libros de la biblioteca.
     * @return La cantidad total de libros de la biblioteca.
     */
    public abstract int darTotalLibros();
    
    /** 
     * Retorna la totalidad de copias en pr�stamo.
     * @return La totalidad de copias en pr�stamo.
     */
    public abstract int darTotalLibrosEnPrestamo();
    
    /** 
     * Verifica si una clave corresponde a un login de usuario.
     * @param login Login seleccionado - login != null.
     * @param clave Clave seleccionada - clave != null.
     * @return true si la clave seleccionada corresponde al login seleccionado o false en caso contrario.
     */
    public abstract boolean autenticar(java.lang.String login, java.lang.String clave);
    
    /** 
     * Busca un libro dada su referencia.
     * @param ref Referencia del libro buscado - ref != null.
     * @return El libro cuya referencia es la referencia ingresada o null en caso de que �ste no exista
     */
    public abstract uniandes.cupi2.biblioteca.mundo.ILibro darLibro(java.lang.String ref);
    
    /** 
     * Agrega una copia a un libro.
     * @param referencia Referencia del libro seleccionado - referencia != null.
     * @throws LibroInexistenteException Cuando se intenta ingresar una copia de un libro y el libro no est� registrado en el sistema.
     */
    public abstract void agregarCopia(java.lang.String referencia) throws uniandes.cupi2.biblioteca.mundo.excepciones.LibroInexistenteException;
    
    /** 
     * Salva la informaci�n de la biblioteca.
     * @throws SalvarBibliotecaException Si no se puede salvar la biblioteca.
     */
    public abstract void salvar() throws uniandes.cupi2.biblioteca.mundo.excepciones.SalvarBibliotecaException;
    
    /** 
     * Carga la informaci�n de la biblioteca.
     * @throws CargarBibliotecaException Si no se puede cargar los datos de la biblioteca.
     */
    public abstract void cargar() throws uniandes.cupi2.biblioteca.mundo.excepciones.CargarBibliotecaException;
    
}

