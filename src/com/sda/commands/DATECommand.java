/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sda.commands;

import java.util.Calendar;

/**
 *
 * @author suvoroda
 */
public class DATECommand extends Command {

    public DATECommand(String name, int cntArg) {
        super(name, cntArg);
    }
    
    @Override
    public void Execute(){
        Calendar c = Calendar.getInstance();
        System.out.println(c.getTime());
    }
    
}
