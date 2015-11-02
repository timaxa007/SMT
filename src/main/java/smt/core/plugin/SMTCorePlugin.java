package smt.core.plugin;

import cpw.mods.fml.relauncher.IFMLCallHook;
import cpw.mods.fml.relauncher.IFMLLoadingPlugin;
import net.minecraft.launchwrapper.LaunchClassLoader;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

import java.io.File;
import java.util.Map;

/**
 * SMT Core Plugin
 * Contains useful methods
 * @author Dragon2488
 */
@IFMLLoadingPlugin.Name("SMT")
@IFMLLoadingPlugin.MCVersion("1.7.10")
@IFMLLoadingPlugin.TransformerExclusions("smt.core.plugin")
public class SMTCorePlugin implements IFMLCallHook, IFMLLoadingPlugin {

    /**
     * Primary logger, used for all mod logging
     * @see org.apache.logging.log4j.Logger
     */
    public static Logger log;

    /**
     * Coremod source location, can be null
     * if we're in deobfuscated environment
     */
    public static File coremodLocation;

    /**
     * Minecraft main directory,
     * often current directory or '.'
     */
    public static File mcLocation;

    /**
     * Primary class loader, which load all game classes
     * @see net.minecraft.launchwrapper.LaunchClassLoader
     */
    public static LaunchClassLoader classLoader;

    /**
     * Is Runtime Deobfuscation enabled?
     * true if enabled, otherwise false
     */
    public static boolean runtimeDeobfuscation;

    /**
     * TODO: Classes transforming
     * @return class transformers
     * @see net.minecraft.launchwrapper.IClassTransformer
     */
    @Override
    public String[] getASMTransformerClass() {
        return new String[] {};
    }

    /**
     * TODO: Access classes transforming
     * @return access transformer class
     * @see net.minecraft.launchwrapper.IClassNameTransformer
     */
    @Override
    public String getAccessTransformerClass() {
        return null;
    }

    /**
     * Used to load mod container
     * @return mod container class
     * @see cpw.mods.fml.common.ModContainer
     */
    @Override
    public String getModContainerClass() {
        return "smt.core.SMTContainer";
    }

    /**
     * Used to get class with call() method,
     * for us it's same as core plugin class
     * @return setup class
     * @see cpw.mods.fml.relauncher.IFMLCallHook
     */
    @Override
    public String getSetupClass() {
        return getClass().getName();
    }

    /**
     * Receives given data and stores it
     * @param data given data
     */
    @Override
    public void injectData(Map<String, Object> data) {
        coremodLocation = (File) data.get("coremodLocation");
        mcLocation = (File) data.get("mcLocation");

        classLoader = (LaunchClassLoader) data.get("classLoader");
        runtimeDeobfuscation = (Boolean) data.get("runtimeDeobfuscationEnabled");
    }

    /**
    * Does some pre-startup stuffs, such as
    * log initialization and other stuffs
    * @return null
    */
    @Override
    public Void call() {
        log = (Logger) LogManager.getLogger("SMT");
        if(!runtimeDeobfuscation) {
            log.info("We're running in deobfuscated environment, debug enabled");
            log.setLevel(Level.ALL);
        }
        return null;
    }

}
