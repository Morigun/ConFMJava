/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sda.commands;

import com.sda.MAIN;
import java.io.File;
import java.io.IOException;
import java.nio.file.AccessDeniedException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author suvoroda
 */
public class MOVECommand extends Command{
    private final List<String> _specArguments;

    /**
     * Move file constructor
     * @param name name command
     * @param cntArg max count args
     */
    public MOVECommand(String name, int cntArg) {
        super(name, cntArg);
        _specArguments = new ArrayList<>();
        _specArguments.add("N");
        _specArguments.add("Y");
    }
    
    /**
     * Execute command
     */
    @Override
    public void Execute() {
        switch(super.Arguments.size()){
            case 3:
                {
                    try {                        
                        Files.move((new File(super.Arguments.get(1))).toPath(), new File(super.Arguments.get(2)).toPath(), StandardCopyOption.ATOMIC_MOVE);                        
                    } catch(AccessDeniedException ex){
                            System.err.println(java.util.ResourceBundle.getBundle(MAIN.Internationalization + MAIN.ShortInternationalization).getString("ERROR_MOVE"));
                    } catch (IOException ex) {
                        Logger.getLogger(MOVECommand.class.getName()).log(Level.SEVERE, null, ex);
                    } 
                }
                break;
            case 4:
                {
                    if(_specArguments.stream().anyMatch((_specArgument) -> (_specArgument.equals(super.Arguments.get(3))))){
                        switch (super.Arguments.get(3)) {
                            case "N":
                                try {
                                    Files.move((new File(super.Arguments.get(1))).toPath(), new File(super.Arguments.get(2)).toPath(), StandardCopyOption.ATOMIC_MOVE);
                                } catch (IOException ex) {
                                    Logger.getLogger(MOVECommand.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                break;
                            case "Y":
                                try {
                                    Files.move((new File(super.Arguments.get(1))).toPath(), new File(super.Arguments.get(2)).toPath(), StandardCopyOption.REPLACE_EXISTING);
                                } catch (IOException ex) {
                                    Logger.getLogger(MOVECommand.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                break;
                        }
                    } else {
                        System.err.println(java.util.ResourceBundle.getBundle(MAIN.Internationalization + MAIN.ShortInternationalization).getString("ARGUMENT_ERROR") + " " + super.Arguments.get(3));
                    }
                }
                break;
            default:
                System.err.println(java.util.ResourceBundle.getBundle(MAIN.Internationalization + MAIN.ShortInternationalization).getString("COUNT_ARGUMENT_ERROR") + " " + super.Arguments.size());
                break;
        }
    }
    
}
