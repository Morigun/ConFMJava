/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sda.commands;

import com.sda.MAIN;
import java.io.File;

/**
 *
 * @author suvoroda
 */
public class CDCommand extends Command{    
    public CDCommand(String Name, int cntArg){
        super(Name, cntArg);
    }
    
    @Override
    public void Execute() {
        File f;
        switch(super.Arguments.size()){
            case 2:
                if(!super.Arguments.get(1).equals("..")){
                    f = new File(super.Arguments.get(1));
                    if(f.exists()){
                        super.path.setPath(f.getAbsolutePath());
                    }else{
                        System.err.println(java.util.ResourceBundle.getBundle(MAIN.Internationalization).getString("ERROR PATH") + " " + super.Arguments.get(1));
                    }
                }
                else{
                    f = new File(super.path.getPath());
                    super.path.setPath(f.toPath().getRoot().toString());
                }
                break;
            case 3:
                f = new File(super.Arguments.get(1)+super.Arguments.get(2));
                if(f.exists()){
                    super.path.setPath(f.getAbsolutePath());
                }else{
                    System.err.println(java.util.ResourceBundle.getBundle(MAIN.Internationalization).getString("ERROR PATH") + " " + super.Arguments.get(1)+super.Arguments.get(2));
                }
                break;
            default:
                System.err.println(java.util.ResourceBundle.getBundle(MAIN.Internationalization).getString("COUNT ARGUMENT ERROR") + " " + super.Arguments.size());
        }        
        System.out.println(super.path.getPath());
    }
}
