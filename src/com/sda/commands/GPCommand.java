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

    public GPCommand(String name, int cntArg) {
        super(name, cntArg);
    }
    
    @Override
    public void Execute() {
        System.out.println(path.getPath());
    }
    
}
