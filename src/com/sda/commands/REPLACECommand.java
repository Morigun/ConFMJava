/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sda.commands;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author suvoroda
 */
public class REPLACECommand extends Command {

    public REPLACECommand(String name, int cntArg) {
        super(name, cntArg);
    }
    
    @Override
    public void Execute(){
        File f = new File(super.Arguments.get(1));
        try {
            if(new File(super.Arguments.get(2)).exists())
                FileUtils.forceDelete(new File(super.Arguments.get(2)));
        } catch (IOException ex) {
            Logger.getLogger(REPLACECommand.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            if((new File(super.Arguments.get(1))).toPath().getRoot() != null){
                FileUtils.copyFile(f, new File(super.Arguments.get(2)));
            } else {
                f = new File(super.path.getPath() + "\\" + new File(super.Arguments.get(1)));
                FileUtils.copyFile(f, new File(super.Arguments.get(2)));                
            }
        } catch (IOException ex) {
            Logger.getLogger(REPLACECommand.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
