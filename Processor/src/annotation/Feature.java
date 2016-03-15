package annotation;

public @interface Feature {

	String featureName() default "";
	
	String obligatorio() default "";

	String opcional() default "";
	
	String excluyente() default "";
	
	String incluyente() default "";
	
	String excludes() default "";

	String requires() default "";
}
