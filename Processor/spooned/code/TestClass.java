package code;


@annotation.Feature(featureName = "TestClass")
public class TestClass {
    int i;
    
    java.lang.String s;
    
    java.lang.Object o;
    
    @annotation.Feature(obligatorio = "La Prueba2")
    public TestClass() {
    }
    
    @annotation.Feature(obligatorio = "Libros")
    private void foo() {
        (this.i)++;
    }
    
    @annotation.Feature(obligatorio = "Catalogos")
    private void foo2() {
        (this.i)++;
    }
    
}

