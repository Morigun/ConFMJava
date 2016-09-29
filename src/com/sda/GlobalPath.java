/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sda;

/**
 * Singleton
 * @author suvoroda
 */
public class GlobalPath {
    private static GlobalPath INSTANCE;
    private String _path;
    
    private GlobalPath(){
        _path = System.getProperty("user.dir",".");
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
    }   
}
