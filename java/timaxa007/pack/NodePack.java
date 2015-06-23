package timaxa007.pack;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class NodePack {

	@Retention(RetentionPolicy.RUNTIME)
	@Target(ElementType.TYPE)
	public @interface PackNode {
		String moduleTag() default "";
		String moduleName() default "";
		String moduleVersion() default "";
	}

}
