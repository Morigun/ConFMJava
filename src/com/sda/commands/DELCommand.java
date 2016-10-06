/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sda.commands;

import java.io.File;

/**
 *
 * @author suvoroda
 */
public class DELCommand extends Command {

    public DELCommand(String name, int cntArg) {
        super(name, cntArg);
    }
    
    @Override
    public void Execute(){
        File f = new File(super.Arguments.get(1));        
        if((new File(super.Arguments.get(1))).toPath().getRoot() != null){
            if(f.isFile()){
                f.delete();
            } else {
                System.err.println("This is not a file.");
            }
        } else {
            f = new File(super.path.getPath() + "\\" + super.Arguments.get(1));
            if(f.isFile()){
                f.delete();
            } else {
                System.err.println("This is not a file.");
            }
        }
        
    }
    
}
