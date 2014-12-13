package mods.timaxa007.lib.module.hook

import cpw.mods.fml.common.Mod
import cpw.mods.fml.common.Mod.{EventHandler, Instance}
import cpw.mods.fml.common.event.{FMLPostInitializationEvent, FMLInitializationEvent, FMLPreInitializationEvent}

/**
 * Created by Dragon2488 on 13.12.2014.
 */

@Mod(name = "SubMods System Core", modid = "SMSC", version = "beta 0.1", modLanguage = "scala")
class DummyLoader {

  @Instance("SMSC")
  val instance: DummyLoader = null

  @EventHandler
  def preLoad(e: FMLPreInitializationEvent): Unit = {
    ModuleManager.preInitialization()
  }

  @EventHandler
  def load(e: FMLInitializationEvent): Unit = {
    ModuleManager.initialization()
  }

  @EventHandler
  def postLoad(e: FMLPostInitializationEvent): Unit = {
    ModuleManager.postInitialization()
  }

}
