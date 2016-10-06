/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sda.commands;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author suvoroda
 */
public class TASKLISTCommand extends Command {

    public TASKLISTCommand(String name, int cntArg) {
        super(name, cntArg);
    }
    
    @Override
    public void Execute(){
        String ArgumentString = CONCommand.ArgsToStr(super.Arguments), line;
        try {            
            Process p;
            if(ArgumentString != null){
                p = Runtime.getRuntime().exec(System.getenv("windir") + "\\system32\\"+"tasklist.exe" + ArgumentString);
            } else {
                p = Runtime.getRuntime().exec(System.getenv("windir") + "\\system32\\"+"tasklist.exe");
            }
            try (BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()))) {
                while((line = input.readLine()) != null){
                    System.out.println(line);
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(TASKLISTCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
