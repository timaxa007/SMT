package mods.timaxa007.lib.module

/**
  * Created by Dragon2488 on 13.12.2014.
  */
trait IModule {


  def getID(): String
  def getName(): String
  def getVersion(): String
  def getHolderCoreID(): String
  def preInitialization(core: ICore): Unit
  def initialization(core: ICore): Unit
  def postInitialization(core: ICore): Unit
 }
