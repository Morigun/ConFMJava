/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sda.Singletons;

import com.sda.PublicParams;

/**
 * Singleton
 * @author suvoroda
 */
public class GlobalPath {
    private static GlobalPath INSTANCE;
    private String _path;
    GlobalProperty globalProp;
    
    private GlobalPath(){        
        globalProp = GlobalProperty.getInstance();
        _path = globalProp.getP().getProperty(PublicParams.PropertyPath);
        if(_path == null){
            _path = System.getProperty("user.dir",".");
        }
    }
    
    /**
     * get instance
     * @return class GlobalPath
     */
    public static GlobalPath getInstance(){
        if(INSTANCE == null)
            INSTANCE = new GlobalPath();             
        return INSTANCE;
    }

    /**
     * Get global path
     * @return String path GlobalPath
     */
    public String getPath() {
        return _path;
    }

    /**
     * set global path
     * @param _path String path GlobalPath
     */
    public void setPath(String _path) {
        this._path = _path;
        if(!globalProp.getP().contains(PublicParams.PropertyPath))
            globalProp.getP().put(PublicParams.PropertyPath, _path);
        else
            globalProp.getP().setProperty(PublicParams.PropertyPath, _path);
    }
}
