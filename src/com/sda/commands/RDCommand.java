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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author suvoroda
 */
public class RDCommand extends Command {

    public RDCommand(String name, int cntArg) {
        super(name, cntArg);
    }
    
    @Override
    public void Execute(){
        switch(super.Arguments.size()){
            case 2:
                {
                    try {
                        if((new File(super.Arguments.get(1))).isDirectory()){
                            if((new File(super.Arguments.get(1))).exists()){
                                Files.delete((new File(super.Arguments.get(1))).toPath());
                            }
                        } else {
                            System.err.println("This is not a directory, please specify a directory");
                        }
                    }catch(DirectoryNotEmptyException ex){
                        System.err.println("Directory not empty please use Y argument");
                    } catch (IOException ex) {
                        Logger.getLogger(RDCommand.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                break;
            case 3:
                try{
                    if((new File(super.Arguments.get(1))).isDirectory()){
                        if((new File(super.Arguments.get(1))).exists()){
                            Files.delete((new File(super.Arguments.get(1))).toPath());
                        }
                    } else {
                        System.err.println("This is not a directory, please specify a directory");
                    }
                } catch(DirectoryNotEmptyException ex){
                    if(super.Arguments.get(2).contains("Y")){
                        File f = new File(super.Arguments.get(1));
                        for (File listFile : f.listFiles()) {
                            RecursDelete(listFile.getPath());
                        }
                        try {
                            Files.delete((new File(super.Arguments.get(1))).toPath());
                        } catch (IOException ex1) {
                            Logger.getLogger(RDCommand.class.getName()).log(Level.SEVERE, null, ex1);
                        }
                    } else if(super.Arguments.get(2).contains("N")){
                        System.err.println("Directory not empty please use Y argument");
                    }
                } catch (IOException ex) {
                    Logger.getLogger(RDCommand.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            default:
                System.err.println(java.util.ResourceBundle.getBundle(MAIN.Internationalization + MAIN.ShortInternationalization).getString("COUNT_ARGUMENT_ERROR") + " " + super.Arguments.size());
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
