/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sda;

import java.io.File;
import java.util.List;

/**
 *
 * @author suvoroda
 */
public class ExecuteCommand {
    private GlobalPath path = GlobalPath.getInstance();
    private List<String> listArg;
    public ExecuteCommand(List<String> args){
        listArg = args;
        switch(args.get(0)){
            case "CD":
                CD();
                break;
            case "DIR":
                DIR();
                break;
            case "GP":
                GP();
                break;
        }
    }
    
    private void CD(){
        File f;
        switch(listArg.size()){
            case 2:
                if(!listArg.get(1).equals("..")){
                    f = new File(listArg.get(1));
                    if(f.exists()){
                        path.setPath(f.getAbsolutePath());
                    }else{
                        System.err.println("Error path " + listArg.get(1));
                    }
                }
                else{
                    f = new File(path.getPath());
                    path.setPath(f.toPath().getRoot().toString());
                }
                break;
            case 3:
                f = new File(listArg.get(1)+listArg.get(2));
                if(f.exists()){
                    path.setPath(f.getAbsolutePath());
                }else{
                    System.err.println("Error path " + listArg.get(1)+listArg.get(2));
                }
                break;
            default:
                System.err.println("Count Argument Error " + listArg.size());
        }        
        System.out.println(path.getPath());
    }
    
    private void DIR(){
        
    }
    
    private void GP(){
        System.out.println(path.getPath());
    }
}
