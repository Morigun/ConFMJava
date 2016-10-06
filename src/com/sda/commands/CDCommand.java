/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sda.commands;

import com.sda.MAIN;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author suvoroda
 */
public class CDCommand extends Command{    
    private final List<String> _specArguments;

    /**
     * Change dir command
     * @param Name name command
     * @param cntArg max count args
     */
    public CDCommand(String Name, int cntArg){
        super(Name, cntArg);
        _specArguments = new ArrayList<>();
        _specArguments.add("..");
        _specArguments.add("^");
    }
    
    /**
     * Execute command
     */
    @Override
    public void Execute() {
        File f;
        switch(super.Arguments.size()){
            case 2:
                if(!checkSpecArgument(super.Arguments.get(1))){
                    f = new File(super.Arguments.get(1));
                    if(f.exists()){
                        super.path.setPath(f.getAbsolutePath());
                    } else {
                        f = new File(path.getPath() +"\\"+ super.Arguments.get(1));
                        if(f.exists()){
                            super.path.setPath(f.getAbsolutePath());
                        }
                        else{
                            System.err.println(java.util.ResourceBundle.getBundle(MAIN.Internationalization + MAIN.ShortInternationalization).getString("ERROR_PATH") + " " + f.getPath());
                        }
                    }                    
                }
                else{                   
                    f = new File(super.path.getPath());
                    switch (super.Arguments.get(1)) {
                        case "..":
                            super.path.setPath(f.toPath().getRoot().toString());
                            break;
                        case "^":
                            super.path.setPath(f.getParent());
                            break;
                    }
                }
                break;
            case 3:
                f = new File(super.Arguments.get(1)+super.Arguments.get(2));
                if(f.exists()){
                    super.path.setPath(f.getAbsolutePath());
                }else{
                    System.err.println(java.util.ResourceBundle.getBundle(MAIN.Internationalization + MAIN.ShortInternationalization).getString("ERROR_PATH") + " " + super.Arguments.get(1)+super.Arguments.get(2));
                }
                break;
            default:
                System.err.println(java.util.ResourceBundle.getBundle(MAIN.Internationalization + MAIN.ShortInternationalization).getString("COUNT_ARGUMENT_ERROR") + " " + super.Arguments.size());
                break;
        }        
        System.out.println(super.path.getPath());
    }
    
    private boolean checkSpecArgument(String argument){
        return _specArguments.stream().anyMatch((_specArgument) -> (_specArgument.equals(argument)));
    }
}
