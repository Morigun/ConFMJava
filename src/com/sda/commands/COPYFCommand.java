/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sda.commands;

import com.sda.MAIN;
import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author suvoroda
 */
public class COPYFCommand extends Command {

    public COPYFCommand(String name, int cntArg) {
        super(name, cntArg);
    }
    
    @Override
    public void Execute(){
        switch(super.Arguments.size()){
            case 3:
                {
                    try {
                        Files.copy((new File(super.Arguments.get(1)).toPath()), (new File(super.Arguments.get(2)).toPath()), StandardCopyOption.ATOMIC_MOVE);
                    } catch (IOException ex) {
                        Logger.getLogger(COPYCommand.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                break;
            case 4:
                switch (super.Arguments.get(3)) {
                    case "N":
                        try {
                            Files.copy((new File(super.Arguments.get(1))).toPath(), new File(super.Arguments.get(2)).toPath(), StandardCopyOption.ATOMIC_MOVE);
                        } catch (IOException ex) {
                            Logger.getLogger(MOVECommand.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        break;
                    case "Y":
                        try {
                            Files.copy((new File(super.Arguments.get(1))).toPath(), new File(super.Arguments.get(2)).toPath(), StandardCopyOption.REPLACE_EXISTING);                          
                        } catch(DirectoryNotEmptyException ex){
                            File f = new File(super.Arguments.get(1));
                            for (File listFile : f.listFiles()) {
                                RecursDelete(listFile.getPath());
                            }
                            try {
                                FileUtils.copyFile(new File(super.Arguments.get(1)), new File(super.Arguments.get(2)));
                            } catch (IOException ex1) {
                                Logger.getLogger(COPYCommand.class.getName()).log(Level.SEVERE, null, ex1);
                            }
                        } catch (IOException ex) {
                            Logger.getLogger(MOVECommand.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        break;
                }
                break;
            default:
                System.err.println(java.util.ResourceBundle.getBundle(MAIN.Internationalization + MAIN.ShortInternationalization).getString("COUNT_ARGUMENT_ERROR") + " " + super.Arguments.size());
                break;
        }
    }
    
    void RecursDelete(String pathToDelete){
        try {
            Files.delete((new File(pathToDelete)).toPath());
        } catch(DirectoryNotEmptyException ex){
            File f = new File(pathToDelete);
            for (File listFile : f.listFiles()) {
                RecursDelete(listFile.getPath());
            }
            try {
                Files.delete((new File(pathToDelete)).toPath());
            } catch (IOException ex1) {
                Logger.getLogger(RDCommand.class.getName()).log(Level.SEVERE, null, ex1);
            }
        } catch (IOException ex) {
            Logger.getLogger(RDCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
