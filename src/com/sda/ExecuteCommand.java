/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sda;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author suvoroda
 */
public class ExecuteCommand {
    private GlobalPath path = GlobalPath.getInstance();
    private GlobalProperty prop = GlobalProperty.getInstance();
    private List<String> listArg;
    public ExecuteCommand(List<String> args){
        listArg = args;
        switch(args.get(0)){
            case PublicParams.CommandCD:
                CD();
                break;
            case PublicParams.CommandDIR:
                DIR();
                break;
            case PublicParams.CommandGP:
                GP();
                break;
            case PublicParams.CommandHELP:
                HELP();
                break;
            case PublicParams.CommandCI:
                CI();
                break;
            default:
                CHECKRUN();
                break;
        }        
    }
    
    private void CD(){
        File f;
        switch(listArg.size()){
            case 2:
                if(!listArg.get(1).equals("..")){
                    f = new File(listArg.get(1));
                    if(f.exists()){
                        path.setPath(f.getAbsolutePath());
                    }else{
                        System.err.println(java.util.ResourceBundle.getBundle(MAIN.Internationalization).getString("ERROR PATH") + " " + listArg.get(1));
                    }
                }
                else{
                    f = new File(path.getPath());
                    path.setPath(f.toPath().getRoot().toString());
                }
                break;
            case 3:
                f = new File(listArg.get(1)+listArg.get(2));
                if(f.exists()){
                    path.setPath(f.getAbsolutePath());
                }else{
                    System.err.println(java.util.ResourceBundle.getBundle(MAIN.Internationalization).getString("ERROR PATH") + " " + listArg.get(1)+listArg.get(2));
                }
                break;
            default:
                System.err.println(java.util.ResourceBundle.getBundle(MAIN.Internationalization).getString("COUNT ARGUMENT ERROR") + " " + listArg.size());
        }        
        System.out.println(path.getPath());
    }
    
    private void DIR(){
        File f = null;
        switch(listArg.size()){
            case 1:
                f = new File(path.getPath());                
                break;
            case 2:
                f = new File(listArg.get(1));                
                break;
            case 3:
                f = new File(listArg.get(1) + listArg.get(2));
                break;
            default:
                System.err.println(java.util.ResourceBundle.getBundle(MAIN.Internationalization).getString("COUNT ARGUMENT ERROR") + " " + listArg.size());
        }
        if(f != null){
            if(f.isDirectory()){
                for(String object : f.list()){
                    System.out.println(object);
                }
            } else {
                System.err.println(java.util.ResourceBundle.getBundle(MAIN.Internationalization).getString("PATH NOT CORRECTED") + " " + f.getPath());
            }
        } else {
            System.err.println(java.util.ResourceBundle.getBundle(MAIN.Internationalization).getString("PATH NOT FOUNDED"));
        }
        
    }
    
    private void GP(){
        System.out.println(path.getPath());
    }
    
    private void HELP(){
        
    }
    
    private void CHECKRUN(){
        if(listArg.size() == 1){
            if((new File(listArg.get(0))).exists()){
                RUN(listArg.get(0));
            }
        } else {
            System.err.println(java.util.ResourceBundle.getBundle(MAIN.Internationalization).getString("COUNT ARGUMENT ERROR") + " " + listArg.size());
        }
    }
    
    private void RUN(String pathToFile){
        try {
            //Runtime.getRuntime().exec(pathToFile);
            Desktop.getDesktop().open(new File(pathToFile));
        } catch (IOException ex) {
            if(pathToFile.contains(PublicParams.ExtVBS)){
                try {
                    Runtime.getRuntime().exec(PublicParams.PathToWScript + " \"" + path + "\"");
                } catch (IOException ex1) {
                    System.err.println(java.util.ResourceBundle.getBundle(MAIN.Internationalization).getString("ERROR SCRIPT RUN"));
                }
            }
            else{
                System.err.println(java.util.ResourceBundle.getBundle(MAIN.Internationalization).getString("ERROR FILE RUN"));
            }
        }
    }
    
    private void CI(){
        if(listArg.size() == 2){
            switch(listArg.get(1)){
                case PublicParams.RU:
                    MAIN.Internationalization = PublicParams.RUInternationalization;
                    MAIN.ShortInternationalization = PublicParams.RU;
                    break;
                case PublicParams.EN:
                    MAIN.Internationalization = PublicParams.DefaultInternationalization;
                    MAIN.ShortInternationalization = PublicParams.EN;
                    break;
                default:
                    MAIN.Internationalization = PublicParams.DefaultInternationalization;
                    MAIN.ShortInternationalization = PublicParams.DEFAULT;
                    break;
            }
        } else if(listArg.size() == 1) {
            System.out.println(MAIN.ShortInternationalization);
        } else {
            System.err.println(java.util.ResourceBundle.getBundle(MAIN.ShortInternationalization).getString("COUNT ARGUMENT ERROR") + " " + listArg.size());
        }
    }
}
