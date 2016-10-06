/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sda.commands;

/**
 *
 * @author suvoroda
 */
public class GPCommand extends Command{

    /**
     * Constructor GPCommand
     * @param name command name
     * @param cntArg max count arguments
     */
    public GPCommand(String name, int cntArg) {
        super(name, cntArg);
    }
    
    /**
     * Execute command
     */
    @Override
    public void Execute() {
        System.out.println(path.getPath());
    }
    
}
