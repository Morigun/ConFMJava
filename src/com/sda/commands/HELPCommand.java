/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sda.commands;

import com.sda.PublicParams;

/**
 *
 * @author suvoroda
 */
public class HELPCommand extends Command{

    public HELPCommand(String name, int cntArg) {
        super(name, cntArg);
    }
    
    @Override
    public void Execute() {
        System.out.println("Comands\n" +
        " HELP - Help on commands\n" +
        "  HELP [COMMAND]\n" +
        " CD - Change Dir\n" +
        "  CD [D:\\] [PATH]\n" +
        "  CD [PATH]\n" +
        "  CD [D:\\]\n" +
        "  CD [..]\n" +
        " DIR - View Directory\n" +
        "  DIR [D:\\] [PATH]\n" +
        "  DIR [PATH]\n" +
        "  DIR [D:\\]\n" +
        " GP - Get now path\n" +
        " | - Separater comand\n" +
        " CI - Change internationalization\n" +
        "  CI [CODE INTER]");
    }
    
}
