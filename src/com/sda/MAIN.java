/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sda;

import com.sda.Singletons.GlobalPath;
import com.sda.Singletons.GlobalProperty;
import com.sda.commands.ACommand;
import com.sda.commands.Command;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @author suvoroda
 */
public class MAIN {
    static Executor ex;
    static GlobalPath path = GlobalPath.getInstance();
    static GlobalProperty globalProp = GlobalProperty.getInstance();

    /**
     * String Internationalization
     */
    public static String Internationalization;

    /**
     * String ShortInternationalization(ru/en/...)
     */
    public static String ShortInternationalization;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {        
        setInter();
        Command.InicCommandList();
        List<String> tmpList = new ArrayList<>();
        boolean argBegin = false;
        for (String arg : args) {
            if(Command.CommandList.contains(arg.toUpperCase())){//Задаем начало команды
                argBegin = true;
            } else if(arg.contains(PublicParams.CommandSeparator)){//Задаем конец команды
                argBegin = false;
                if (ex == null)
                    ex = new Executor();
                ACommand com = ex.CheckCommand(tmpList.get(0));
                com.setArgs(tmpList);
                ex.Executed(com);//Отправляем команду на исполнение
                tmpList.clear();//Очищаем временный лист
            } else if((new File(arg)).exists() && !argBegin){
                tmpList.add(arg);
                if (ex == null)
                    ex = new Executor();
                ACommand com = ex.CheckCommand(PublicParams.CommandRUN);
                com.setArgs(tmpList);
                ex.Executed(com);
            } else if (!argBegin && !(new File(arg)).exists()){
                System.err.println(java.util.ResourceBundle.getBundle(MAIN.Internationalization + MAIN.ShortInternationalization).getString("ARGUMENT_ERROR") + " " + arg);
            }
            if(argBegin){//Заполняем временный лист аргументов команды
                tmpList.add(arg);
            }
        }
        if(!tmpList.isEmpty()){
            if (ex == null)
                ex = new Executor();
            ACommand com = ex.CheckCommand(tmpList.get(0));
            com.setArgs(tmpList);
            ex.Executed(com);            
        }
        saveInter();
        savePath();
        globalProp.StoreToXML();
    }
    
    static void setInter(){
        Internationalization = globalProp.getP().getProperty(PublicParams.Internationalization);
        ShortInternationalization = globalProp.getP().getProperty(PublicParams.ShortInternationalization);
        if(Internationalization == null){
            Internationalization = PublicParams.DefaultInternationalization;
        }
        if(ShortInternationalization == null){
            ShortInternationalization = PublicParams.DEFAULT;
        }
    }
    
    static void saveInter(){
        if(globalProp.getP().contains(PublicParams.Internationalization)){
            globalProp.getP().setProperty(PublicParams.Internationalization, Internationalization);
        } else {
            globalProp.getP().put(PublicParams.Internationalization, Internationalization);
        }
        if(globalProp.getP().contains(PublicParams.ShortInternationalization)){
            globalProp.getP().setProperty(PublicParams.ShortInternationalization, ShortInternationalization);
        } else {
            globalProp.getP().put(PublicParams.ShortInternationalization, ShortInternationalization);
        }
    }
    
    static void savePath(){
        if(globalProp.getP().contains(PublicParams.PropertyPath)){
            globalProp.getP().setProperty(PublicParams.PropertyPath, path.getPath());
        } else {
            globalProp.getP().put(PublicParams.PropertyPath, path.getPath());
        }
    }
}
