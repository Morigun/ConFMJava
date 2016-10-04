/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sda.commands;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author suvoroda
 */
public class Command extends ACommand{

    public Command(String name, int cntArg){
        super.Name = name;
        super.CountArg = cntArg;
        super.Arguments = new ArrayList<>();
    }
    
    @Override
    public void setArgs(List<String> args){        
        super.Arguments.addAll(args);
    }
    
    @Override
    public void Execute() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
