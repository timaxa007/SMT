package mods.timaxa007.lib.module.hook

import javassist.{ClassClassPath, ClassPool}
import mods.timaxa007.lib.module.{IModule, ICore}
import scala.collection.mutable.{HashMap => MMap, MutableList => MList}

/**
 * Created by Dragon2488 on 13.12.2014.
 */
object ModuleManager {

  //Cores
  val hookedCores: MList[Class[_]] = new MList
  val coreClassPool: ClassPool = new ClassPool
  coreClassPool.appendClassPath(new ClassClassPath(classOf[ICore]))

  //Modules
  val hookedModules: MList[Class[_]] = new MList
  val moduleClassPool: ClassPool = new ClassPool
  moduleClassPool.appendClassPath(new ClassClassPath(classOf[IModule]))

  //Core IDs map
  val coresIDs: MMap[String, ICore] = new MMap[String, ICore]
  //Modules ID's map
  val modulesCoresIDs: MMap[String, MList[IModule]] = new MMap[String, MList[IModule]]

  //Build cores and modules
  def buildCoresAndModules(): Unit = {
    for(clazz: Class[ICore] <- hookedCores) {
      val core: ICore = clazz.newInstance
      modulesCoresIDs.put(core.getID, new MList[IModule])
      coresIDs.put(core.getID, core);
      for(mclazz: Class[IModule] <- hookedModules) {
        val module: IModule = mclazz.newInstance()
        if(core.getID.equalsIgnoreCase(module.getHolderCoreID)) {
          val modules: MList[IModule] = modulesCoresIDs.get(core.getID).get
          modules += module
          modulesCoresIDs.put(core.getID, modules)
        }
      }
      core.modules = modulesCoresIDs.get(core.getID).get
    }
  }

  def preInitialization(): Unit = {
    for(core: ICore <- coresIDs.values) {
      core.preLoad()
    }

  }

  def initialization(): Unit = {
    for(core: ICore <- coresIDs.values) {
      core.load()
    }
  }

  def postInitialization(): Unit = {
    for(core: ICore <- coresIDs.values) {
      core.postLoad()
    }
  }
}
