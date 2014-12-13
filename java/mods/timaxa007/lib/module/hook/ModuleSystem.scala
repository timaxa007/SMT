package mods.timaxa007.lib.module.hook

import java.util
import cpw.mods.fml.relauncher.{IFMLCallHook, IFMLLoadingPlugin}

import scala.collection.mutable

/**
 * Created by Dragon2488 on 13.12.2014.
 */


class ModuleSystem extends AnyRef with IFMLLoadingPlugin with IFMLCallHook {

  override def getASMTransformerClass: Array[String] = {
    val list: mutable.MutableList[String] = new mutable.MutableList[String]
    list += classOf[CoreHooker].getName
    list += classOf[ModuleHooker].getName
    list.toArray[String]
  }
  override def injectData(data: util.Map[String, AnyRef]): Unit = null
  override def getModContainerClass: String = null
  override def getAccessTransformerClass: String = null
  override def getSetupClass: String = classOf[ModuleSystem].getName

  override def call(): Void = {
    ModuleManager.buildCoresAndModules()
    null
  }
}
