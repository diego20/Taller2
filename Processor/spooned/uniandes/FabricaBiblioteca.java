package uniandes;


/** 
 * Fabrica que construye bibliotecas.
 */
public class FabricaBiblioteca implements uniandes.cupi2.biblioteca.mundo.IFabricaBiblioteca {
    public uniandes.cupi2.biblioteca.mundo.AbstractBiblioteca darBiblioteca(java.lang.String archivoSerializacionLibros, java.lang.String archivoSerializacionUsuarios) {
        return new uniandes.Biblioteca(archivoSerializacionLibros , archivoSerializacionUsuarios);
    }
    
}

