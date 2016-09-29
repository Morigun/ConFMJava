/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sda;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Singleton
 * @author suvoroda
 */
public class GlobalPath {
    private static GlobalPath INSTANCE;
    private String _path;
    Properties p;
    
    private GlobalPath(){        
        p = new Properties();
        try {
            p.loadFromXML(new FileInputStream(new File("prop.xml")));
            _path = p.getProperty("PATH");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MAIN.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MAIN.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(_path == null)
            _path = System.getProperty("user.dir",".");
        }
    }
    
    public static GlobalPath getInstance(){
        if(INSTANCE == null)
            INSTANCE = new GlobalPath();             
        return INSTANCE;
    }

    public String getPath() {
        return _path;
    }

    public void setPath(String _path) {
        this._path = _path;
        if(!p.contains("PATH"))
            p.put("PATH", _path);
        else
            p.setProperty("PATH", _path);
    }
    
    public void savePath(){
        try (PrintStream ps = new PrintStream(new File("prop.xml"))) {
            p.storeToXML(ps, "");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(GlobalPath.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(GlobalPath.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
