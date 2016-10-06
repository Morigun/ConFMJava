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
public class MKDIRCommand extends Command{

    /**
     * MD command constructor
     * @param name command name
     * @param cntArg max count arguments
     */
    public MKDIRCommand(String name, int cntArg) {
        super(name, cntArg);
    }
    
    /**
     * Execute command
     */
    @Override
    public void Execute() {
        File f = null;
        switch(super.Arguments.size()){
            case 2:
                if((new File(super.Arguments.get(1))).toPath().getRoot() != null){
                    f = new File(super.Arguments.get(1));
                    f.mkdirs();
                } else {               
                    f = new File(super.path.getPath() + "\\" + super.Arguments.get(1));
                    if(!f.exists()){
                        f.mkdirs();
                    }
                }
                break;
            default:
                System.err.println(java.util.ResourceBundle.getBundle(MAIN.Internationalization + MAIN.ShortInternationalization).getString("COUNT_ARGUMENT_ERROR") + " " + super.Arguments.size());
        }
        if( f != null)
            System.out.println("Create folder " + f.getPath());
    }
    
}
