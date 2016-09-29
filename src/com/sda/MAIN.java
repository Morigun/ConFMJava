/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sda;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author suvoroda
 */
public class MAIN {
    static List<String> listArg = new ArrayList();
    static ExecuteCommand exCom;
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
            } else if(arg.contains("|")){//Задаем конец команды
                argBegin = false;
                exCom = new ExecuteCommand(tmpList);//Отправляем команду на исполнение
                tmpList.clear();//Очищаем временный лист
            }
            if(argBegin){//Заполняем временный лист аргументов команды
                tmpList.add(arg);
            }
        }
    }
    /**
     * Comands
     * CD - Change Dir
     * * CD [D:\] [PATH]
     * * CD [PATH]
     * * CD [..]
     * DIR - View Directory
     * * DIR [D:\] [PATH]
     * | - Separater comand
     */
    static void inicListArg(){
        listArg.add("CD");
        listArg.add("DIR");
    }
}
