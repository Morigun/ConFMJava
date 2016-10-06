/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sda.commands;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author suvoroda
 */
public class CONCommand extends Command {

    public CONCommand(String name, int cntArg) {
        super(name, cntArg);
    }
    
    @Override
    public void Execute(){
        try{
            String ArgumentString = CONCommand.ArgsToStr(super.Arguments), line;
            Process p;
            if(ArgumentString != null){
                p = Runtime.getRuntime().exec(ArgumentString.substring(1));
                p.waitFor();                
                try (BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream(), "UTF-8"))) {
                    while((line = input.readLine()) != null){
                        System.out.println(line);
                    }
                }
            }
        } catch(IOException ex){
            Logger.getLogger(TASKLISTCommand.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(CONCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static String ArgsToStr(List<String> Arguments){
        String res = null;
        int i = 0;
        for(String str : Arguments){
            if (i == 0){
                
            } else if (i == 1){
                res = " "+ str;
            }
            else
                res = res +" \""+ str + "\"";
            i++;
        }
        return res;
    }
}
