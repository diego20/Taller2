package code;

import annotation.Feature;

@Feature(featureName="TestClass")
public class TestClass {

	int i;
	String s;
	Object o;
	
	@Feature(obligatorio="La Prueba2")
	public TestClass(){}
	
	@Feature(obligatorio="Libros")
	private void foo(){
		this.i++;
	}
	
	@Feature(obligatorio="Catalogos")
	private void foo2(){
		this.i++;
	}
}
