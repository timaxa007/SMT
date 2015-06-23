package timaxa007.module;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class NodeModule {

	@Retention(RetentionPolicy.RUNTIME)
	@Target(ElementType.TYPE)
	public @interface ModuleNode {
		String moduleTag() default "";
		String moduleName() default "";
		String moduleVersion() default "";
	}

}
