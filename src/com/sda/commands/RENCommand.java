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
public class RENCommand extends Command {

    public RENCommand(String name, int cntArg) {
        super(name, cntArg);
    }
    
    @Override
    public void Execute(){
        File f = new File(super.Arguments.get(1));
        f.renameTo(new File(super.Arguments.get(2)));
    }    
}
