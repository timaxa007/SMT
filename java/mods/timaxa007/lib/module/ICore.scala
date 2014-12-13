package mods.timaxa007.lib.module


import cpw.mods.fml.common.Loader
import mods.timaxa007.lib.module.hook.ModuleManager

import scala.collection.mutable.{MutableList => MList}

/**
 * Created by Dragon2488 on 13.12.2014.
 */
trait ICore {

  private[ModuleManager] var modules: MList[IModule] = new MList[IModule]

  def getModules(): MList[IModule] = modules
  private[ModuleManager] def preLoad(): Unit = {
    preInitialization()
    for(module: IModule <- modules) {
      module.preInitialization(this)
    }
  }

  private[ModuleManager] def load(): Unit = {
    initialization()
    for(module: IModule <- modules) {
      module.initialization(this)
    }
  }

  private[ModuleManager] def postLoad(): Unit = {
    postInitialization()
    for(module: IModule <- modules) {
      module.postInitialization(this)
      Loader.
    }
  }
  def getID(): String
  def getName(): String
  def getVersion(): String
  def preInitialization(): Unit
  def initialization(): Unit
  def postInitialization(): Unit
}
