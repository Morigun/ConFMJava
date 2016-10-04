/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sda.commands;

import com.sda.MAIN;
import java.io.File;

/**
 *
 * @author suvoroda
 */
public class DIRCommand extends Command{

    public DIRCommand(String name, int cntArg) {
        super(name, cntArg);
    }
    
    @Override
    public void Execute() {
        File f = null;
        switch(super.Arguments.size()){
            case 1:
                f = new File(path.getPath());                
                break;
            case 2:
                f = new File(super.Arguments.get(1));                
                break;
            case 3:
                f = new File(super.Arguments.get(1) + super.Arguments.get(2));
                break;
            default:
                System.err.println(java.util.ResourceBundle.getBundle(MAIN.Internationalization + MAIN.ShortInternationalization).getString("COUNT_ARGUMENT_ERROR") + " " + super.Arguments.size());
        }
        if(f != null){
            if(f.isDirectory()){
                for(String object : f.list()){
                    System.out.println(object);
                }
            } else {
                System.err.println(java.util.ResourceBundle.getBundle(MAIN.Internationalization + MAIN.ShortInternationalization).getString("PATH_NOT_CORRECTED") + " " + f.getPath());
            }
        } else {
            System.err.println(java.util.ResourceBundle.getBundle(MAIN.Internationalization + MAIN.ShortInternationalization).getString("PATH_NOT_FOUNDED"));
        }
    }    
}
