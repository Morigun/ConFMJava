/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sda;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @author suvoroda
 * Comands
 * HELP - Help on commands
 * * HELP [COMMAND]
 * CD - Change Dir
 * * CD [D:\] [PATH]
 * * CD [PATH]
 * * CD [D:\]
 * * CD [..]
 * DIR - View Directory
 * * DIR [D:\] [PATH]
 * * DIR [PATH]
 * * DIR [D:\]
 * GP - Get now path
 * | - Separater comand
 * CI - Change internationalization
 * * CI [CODE INTER]
 */
public class MAIN {
    static List<String> listArg = new ArrayList();
    static ExecuteCommand exCom;
    static GlobalPath path = GlobalPath.getInstance();
    static GlobalProperty globalProp = GlobalProperty.getInstance();
    public static String Internationalization;
    public static String ShortInternationalization;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {        
        setInter();
        inicListArg();
        List<String> tmpList = new ArrayList<>();
        boolean argBegin = false;
        for (String arg : args) {
            if(listArg.contains(arg)){//Задаем начало команды
                argBegin = true;
            } else if(arg.contains(PublicParams.CommandSeparator)){//Задаем конец команды
                argBegin = false;
                exCom = new ExecuteCommand(tmpList);//Отправляем команду на исполнение
                tmpList.clear();//Очищаем временный лист
            } else if((new File(arg)).exists() && !argBegin){
                tmpList.add(arg);
                exCom = new ExecuteCommand(tmpList);
            } else if (!argBegin && !(new File(arg)).exists()){
                System.err.println(java.util.ResourceBundle.getBundle(MAIN.Internationalization).getString("ARGUMENT ERROR") + " " + arg);
            }
            if(argBegin){//Заполняем временный лист аргументов команды
                tmpList.add(arg);
            }
        }
        if(!tmpList.isEmpty()){
            exCom = new ExecuteCommand(tmpList);
        }
        saveInter();
        savePath();
        globalProp.StoreToXML();
    }
    static void inicListArg(){
        listArg.add(PublicParams.CommandCD);
        listArg.add(PublicParams.CommandDIR);
        listArg.add(PublicParams.CommandGP);
        listArg.add(PublicParams.CommandHELP);
        listArg.add(PublicParams.CommandCI);
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
