/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sda.commands;

import com.sda.MAIN;
import com.sda.PublicParams;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

/**
 *
 * @author suvoroda
 */
public class RUNCommand extends Command{
    
    public RUNCommand(String name, int cntArg) {
        super(name, cntArg);
    }
    
    @Override
    public void Execute() {
        try {
            Desktop.getDesktop().open(new File(super.Arguments.get(0)));
        } catch (IOException ex) {
            if(super.Arguments.get(0).contains(PublicParams.ExtVBS)){
                try {
                    Runtime.getRuntime().exec(PublicParams.PathToWScript + " \"" + path + "\"");
                } catch (IOException ex1) {
                    System.err.println(java.util.ResourceBundle.getBundle(MAIN.Internationalization + MAIN.ShortInternationalization).getString("ERROR_SCRIPT_RUN"));
                }
            }
            else{
                System.err.println(java.util.ResourceBundle.getBundle(MAIN.Internationalization + MAIN.ShortInternationalization).getString("ERROR_FILE_RUN"));
            }
        }
    }
    
}
