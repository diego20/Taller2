package uniandes.cupi2.biblioteca.interfaz;


/** 
 * Interfaz principal de la aplicaci�n.
 */
public class InterfazBiblioteca extends javax.swing.JFrame {
    /** 
     * Constante para la serializaci�n.
     */
    private static final long serialVersionUID = 1L;
    
    /** 
     * F�brica que construye la clase principal del mundo.
     */
    private uniandes.cupi2.biblioteca.mundo.IFabricaBiblioteca fabrica;
    
    /** 
     * Interfaz de la clase principal del mundo.
     */
    private uniandes.cupi2.biblioteca.mundo.AbstractBiblioteca biblioteca;
    
    /** 
     * Login del usuario que est� utilizando la aplicaci�n.
     */
    private java.lang.String loginUsuario;
    
    /** 
     * Panel principal.
     */
    private javax.swing.JPanel panelPrincipal;
    
    /** 
     * Panel donde est� la imagen.
     */
    private uniandes.cupi2.biblioteca.interfaz.PanelImagen panelImagen;
    
    /** 
     * Scroll donde est� la lista de libros.
     */
    private uniandes.cupi2.biblioteca.interfaz.PanelLibros panelLibros;
    
    /** 
     * Panel donde est�n ubicadas las acciones.
     */
    private uniandes.cupi2.biblioteca.interfaz.PanelAccionesContenedora panelAccionesContenedora;
    
    /** 
     * Constructor de interfaz principal de la aplicaci�n.
     */
    public InterfazBiblioteca() {
        try {
            fabrica = new uniandes.FabricaBiblioteca();
            loginUsuario = "";
            biblioteca = fabrica.darBiblioteca("./data/bibliotecaLibros.data" ,"./data/bibliotecaUsuarios.data");
            biblioteca.cargar();
        } catch (uniandes.cupi2.biblioteca.mundo.excepciones.CargarBibliotecaException e) {
            javax.swing.JOptionPane.showMessageDialog(this ,(("Error cargando el archivo: " + (e.getMessage())) + "\nSe reinicir�n los datos del sistema") ,"Error" ,javax.swing.JOptionPane.ERROR_MESSAGE);
        }
        setSize(779 ,710);
        setBackground(new java.awt.Color(238 , 238 , 179));
        setResizable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        java.awt.GridBagConstraints gridBagConstraints12 = new java.awt.GridBagConstraints();
        gridBagConstraints12.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints12.gridy = 1;
        gridBagConstraints12.weightx = 1.0;
        gridBagConstraints12.weighty = 1.0;
        gridBagConstraints12.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints12.gridx = 1;
        java.awt.GridBagConstraints gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.gridy = 0;
        java.awt.GridBagConstraints gridBagConstraints1 = new java.awt.GridBagConstraints();
        gridBagConstraints1.gridx = 0;
        gridBagConstraints1.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints1.gridwidth = 1;
        gridBagConstraints1.gridy = 1;
        panelPrincipal = new javax.swing.JPanel();
        panelPrincipal.setLayout(new java.awt.GridBagLayout());
        panelPrincipal.setMinimumSize(new java.awt.Dimension(700 , 478));
        panelImagen = new uniandes.cupi2.biblioteca.interfaz.PanelImagen();
        panelPrincipal.add(panelImagen ,gridBagConstraints);
        panelLibros = new uniandes.cupi2.biblioteca.interfaz.PanelLibros(this);
        panelPrincipal.add(panelLibros ,gridBagConstraints12);
        panelAccionesContenedora = new uniandes.cupi2.biblioteca.interfaz.PanelAccionesContenedora(this);
        panelPrincipal.add(panelAccionesContenedora ,gridBagConstraints1);
        add(panelPrincipal);
        setTitle("Biblioteca");
    }
    
    /** 
     * Registra un nuevo usuario en el sistemas de biblioteca.
     * @param login Login del usuario.
     * @param contrasenia Contrase�a del usuario.
     * @param nombre Nombre del usuario.
     * @throws UsuarioPreexistenteException Si ya existe un usuario con el login ingresado.
     */
    public void registrarUsuario(java.lang.String login, java.lang.String contrasenia, java.lang.String nombre) throws uniandes.cupi2.biblioteca.mundo.excepciones.UsuarioPreexistenteException {
        biblioteca.insertarUsuario(login ,contrasenia ,nombre);
    }
    
    /** 
     * M�todo para la autenticaci�n del usuario.
     * @param login Login del usuario.
     * @param contrasenia Contrase�a de usuario.
     */
    public void autenticar(java.lang.String login, java.lang.String contrasenia) {
        boolean correcto = biblioteca.autenticar(login ,contrasenia);
        if (correcto) {
            loginUsuario = login;
            panelLibros.cambiarUsuario(login);
            panelAccionesContenedora.login(login ,biblioteca ,biblioteca.darTotalLibros() ,biblioteca.darTotalLibrosEnPrestamo());
            javax.swing.JOptionPane.showMessageDialog(this ,"Sesi�n iniciada con exito" ,("Bienvenido " + login) ,javax.swing.JOptionPane.INFORMATION_MESSAGE);
        } else {
            javax.swing.JOptionPane.showMessageDialog(this ,"Nombre de usuario o contrase�a incorrectos" ,"Error" ,javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }
    
    /** 
     * Agrega una copia de un libro a la biblioteca.<br>
     * <b>post:</b> En caso que exista el libro aumenta en uno el n�mero de copias.
     * @param referencia Referencia del libro.
     * @throws LibroInexistenteException Se lanza esta excepci�n cuando se intenta ingresar la copia de un libro que no existe
     */
    public void insertarCopiaLibro(java.lang.String referencia) throws uniandes.cupi2.biblioteca.mundo.excepciones.LibroInexistenteException {
        biblioteca.agregarCopia(referencia);
    }
    
    /** 
     * Agrega un libro a la biblioteca. <br>
     * <b>post:</b> La biblioteca tiene un nuevo libro con los datos dados.
     * @param titulo Nombre del libro.
     * @param autores Autores del libro.
     * @param descriptores Palabras que describen el libro.
     * @param referencia Referencia del libro.
     */
    public void insertarLibro(java.lang.String titulo, java.lang.String[] autores, java.lang.String[] descriptores, java.lang.String referencia) {
        try {
            biblioteca.insertarLibro(titulo ,autores ,descriptores ,1 ,referencia);
            javax.swing.JOptionPane.showMessageDialog(this ,"Libro agregado con exito" ,"Libro agregado" ,javax.swing.JOptionPane.INFORMATION_MESSAGE);
        } catch (uniandes.cupi2.biblioteca.mundo.excepciones.LibroYaExisteException e) {
            javax.swing.JOptionPane.showMessageDialog(this ,"El libro ya exist�a previamente" ,"Libro agregado" ,javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }
    
    /** 
     * Termina la sesi�n.
     */
    public void salir() {
        loginUsuario = null;
        panelAccionesContenedora.salir();
    }
    
    /** 
     * Hace la b�squeda de un libro por palabras del t�tulo.
     * @param datos Datos de la b�squeda.
     */
    public void buscarTituloPorPalabra(java.lang.String[] datos) {
        uniandes.cupi2.collections.iterador.Iterador<uniandes.cupi2.biblioteca.mundo.ILibro>  libros = biblioteca.buscarPorTitulo(datos);
        panelLibros.actualizarListaBusqueda(libros);
    }
    
    /** 
     * Hace la b�squeda de un libro por el t�tulo exacto del libro.
     * @param titulo T�tulo a buscar.
     */
    public void buscarTituloExacto(java.lang.String titulo) {
        uniandes.cupi2.collections.iterador.Iterador<uniandes.cupi2.biblioteca.mundo.ILibro>  libros = biblioteca.buscarPorTituloExacto(titulo);
        panelLibros.actualizarListaBusqueda(libros);
    }
    
    /** 
     * Busca los libros descritos por los autores que tienen las palabras dadas.
     * @param datos Datos de la b�squeda.
     */
    public void buscarAutoresPorPalabra(java.lang.String[] datos) {
        uniandes.cupi2.collections.iterador.Iterador<uniandes.cupi2.biblioteca.mundo.ILibro>  libros = biblioteca.buscarPorAutores(datos);
        panelLibros.actualizarListaBusqueda(libros);
    }
    
    /** 
     * Hace la b�squeda de los libros por el nombre exacto del autor del libro.
     * @param datos Datos de la b�squeda.
     */
    public void buscarAutoresExacto(java.lang.String datos) {
        uniandes.cupi2.collections.iterador.Iterador<uniandes.cupi2.biblioteca.mundo.ILibro>  libros = biblioteca.buscarPorAutoresExacto(datos);
        panelLibros.actualizarListaBusqueda(libros);
    }
    
    /** 
     * Busca los libros descritos por los descriptores que tienen las palabras dadas.
     * @param datos Datos de la b�squeda.
     */
    public void buscarDescriptoresPorPalabra(java.lang.String[] datos) {
        uniandes.cupi2.collections.iterador.Iterador<uniandes.cupi2.biblioteca.mundo.ILibro>  libros = biblioteca.buscarPorDescriptores(datos);
        panelLibros.actualizarListaBusqueda(libros);
    }
    
    /** 
     * Hace la b�squeda de los libros por los descriptores exactos del autor del libro.
     * @param datos Datos de la b�squeda.
     */
    public void buscarDescriptoresExacto(java.lang.String[] datos) {
        uniandes.cupi2.collections.iterador.Iterador<uniandes.cupi2.biblioteca.mundo.ILibro>  libros = biblioteca.buscarPorDescriptoresExacto(datos);
        panelLibros.actualizarListaBusqueda(libros);
    }
    
    /** 
     * Acci�n que se ejecuta cuando el usuario que est� autenticado alquila un libro.
     * @param libro Libro que va alquilar el usuario.
     * @throws CopiasInsuficientesException Se lanza esta excepci�n cuando no hay copias suficientes.
     */
    public void alquilar(java.lang.String libro) throws uniandes.cupi2.biblioteca.mundo.excepciones.CopiasInsuficientesException {
        biblioteca.alquilarLibro(loginUsuario ,libro);
        javax.swing.JOptionPane.showMessageDialog(this ,"Petici�n realizada con �xito" ,"�xito" ,javax.swing.JOptionPane.INFORMATION_MESSAGE);
    }
    
    /** 
     * Acci�n que se ejecuta cuando el usuario que est� autenticado devuelve un libro alquilado.
     * @param libro Libro alquilado que se va devolver.
     */
    public void devolver(java.lang.String libro) {
        biblioteca.devolverLibro(loginUsuario ,libro);
        panelLibros.actualizarListaAlquilados(biblioteca.darAlquilados(loginUsuario));
        javax.swing.JOptionPane.showMessageDialog(this ,"Petici�n realizada con �xito" ,"�xito" ,javax.swing.JOptionPane.INFORMATION_MESSAGE);
    }
    
    /** 
     * Borra un libro que se devolvi� de la lista de libros.
     * @param panelLibroAlquilado Panel donde se muestran los datos del libro alquilado.
     */
    public void borrarDevuelto(uniandes.cupi2.biblioteca.interfaz.PanelLibroAlquilado panelLibroAlquilado) {
        panelLibros.remove(panelLibroAlquilado);
    }
    
    /** 
     * Muestra los libros que est� alquilados por el usuario que est� autenticado.
     */
    public void verAlquilados() {
        panelLibros.actualizarListaAlquilados(biblioteca.darAlquilados(loginUsuario));
    }
    
    /** 
     * M�todo que se ejecuta cuando se cierra la aplicaci�n.
     */
    public void dispose() {
        try {
            biblioteca.salvar();
            super.dispose();
        } catch (java.lang.Exception e) {
            setVisible(true);
            int respuesta = javax.swing.JOptionPane.showConfirmDialog(this ,(("Problemas salvando la informaci�n de la biblioteca:\n" + (e.getMessage())) + "\n�Quiere cerrar el programa sin salvar?") ,"Error" ,javax.swing.JOptionPane.YES_NO_OPTION);
            if (respuesta == (javax.swing.JOptionPane.YES_OPTION)) {
                super.dispose();
            } 
        }
    }
    
    /** 
     * Main de la aplicaci�n.
     * @param args Lista de argumentos con las que corre la aplicaci�n.
     */
    public static void main(java.lang.String[] args) {
        javax.swing.SwingUtilities.invokeLater(new java.lang.Runnable() {
            public void run() {
                uniandes.cupi2.biblioteca.interfaz.InterfazBiblioteca thisClass = new uniandes.cupi2.biblioteca.interfaz.InterfazBiblioteca();
                thisClass.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
                thisClass.setVisible(true);
            }
            
        });
    }
    
}

