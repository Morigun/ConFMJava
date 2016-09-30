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
 *
 * @author suvoroda
 */
public class MAIN {
    static List<String> listArg = new ArrayList();
    static ExecuteCommand exCom;
    static GlobalPath path = GlobalPath.getInstance();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
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
            }
            if(argBegin){//Заполняем временный лист аргументов команды
                tmpList.add(arg);
            }
        }
        if(!tmpList.isEmpty()){
            exCom = new ExecuteCommand(tmpList);
            path.savePath();
        }
    }
    /**
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
     */
    static void inicListArg(){
        listArg.add(PublicParams.CommandCD);
        listArg.add(PublicParams.CommandDIR);
        listArg.add(PublicParams.CommandGP);
        listArg.add(PublicParams.CommandHELP);
    }
}
