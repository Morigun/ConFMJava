/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sda.Singletons;

import com.sda.PublicParams;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 
 * @author suvoroda
 */
public final class GlobalProperty {
    Properties p;
    private static GlobalProperty INSTANCE;
    
    private GlobalProperty(){
        p = new Properties();
        LoadFromXML();
    }
    
    /**
     * Get instance GlobalProperty
     * @return Object GlobalProperty
     */
    public static GlobalProperty getInstance(){
        if(INSTANCE == null){
            INSTANCE = new GlobalProperty();
        } 
        return INSTANCE;
    }

    /**
     * get Property
     * @return class Properties
     */
    public Properties getP() {
        return p;
    }

    /**
     * set Property
     * @param p class Properties
     */
    public void setP(Properties p) {
        this.p = p;
    }
    
    /**
     * Save properties to xml
     */
    public void StoreToXML(){
        try (PrintStream ps = new PrintStream(new File(PublicParams.NameTuneFile))) {
            getP().storeToXML(ps, null);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(GlobalPath.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(GlobalPath.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Load properties from xml
     */
    public void LoadFromXML(){
        try {
            getP().loadFromXML(new FileInputStream(new File(PublicParams.NameTuneFile)));
        } catch (IOException ex) {
            Logger.getLogger(GlobalProperty.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
