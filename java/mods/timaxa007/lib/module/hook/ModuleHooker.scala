package mods.timaxa007.lib.module.hook

import javassist._
import mods.timaxa007.lib.module.IModule
import net.minecraft.launchwrapper.IClassTransformer
/**
 * Created by Dragon2488 on 13.12.2014.
 */
class ModuleHooker extends AnyRef with IClassTransformer {

  val otherClassPool: ClassPool = new ClassPool

  def transform(s: String, s1: String, bytes: Array[Byte]): Array[Byte] = {
    import ModuleManager._
    otherClassPool.appendClassPath(new ByteArrayClassPath(s1, bytes))
    val clazz: CtClass = otherClassPool.get(s1);
    if (!clazz.isInterface && clazz.getInterfaces.contains(moduleClassPool.get(classOf[IModule].getName))) {
      moduleClassPool.appendClassPath(new ClassClassPath(clazz.toClass))
      hookedModules += clazz.toClass
    }
    bytes
  }
}
