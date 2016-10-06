/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sda.commands;

import com.sda.MAIN;


/**
 *
 * @author suvoroda
 */
public class HELPCommand extends Command{

    /**
     * Help command constructor
     * @param name name command
     * @param cntArg max count args
     */
    public HELPCommand(String name, int cntArg) {
        super(name, cntArg);
    }
    
    /**
     * Execute command
     */
    @Override
    public void Execute() {
        System.out.println("Comands\n" +
        " HELP - "+java.util.ResourceBundle.getBundle(MAIN.Internationalization + MAIN.ShortInternationalization).getString("HELP_ON_COMMANDS")+"\n" +
        "  HELP [COMMAND]\n" +
        " CD - "+java.util.ResourceBundle.getBundle(MAIN.Internationalization + MAIN.ShortInternationalization).getString("CHANGE_DIR")+"\n" +
        "  CD [DISK:\\] [PATH] - "+java.util.ResourceBundle.getBundle(MAIN.Internationalization + MAIN.ShortInternationalization).getString("TO_PATH_ON_DISK")+"\n" +
        "  CD [PATH] - "+java.util.ResourceBundle.getBundle(MAIN.Internationalization + MAIN.ShortInternationalization).getString("TO_PATH")+"\n" +
        "  CD [DISK:\\] - "+java.util.ResourceBundle.getBundle(MAIN.Internationalization + MAIN.ShortInternationalization).getString("TO_DISK")+"\n" +
        "  CD [..] - "+java.util.ResourceBundle.getBundle(MAIN.Internationalization + MAIN.ShortInternationalization).getString("TO_ROOT")+"\n" +
        "  CD [^] - "+java.util.ResourceBundle.getBundle(MAIN.Internationalization + MAIN.ShortInternationalization).getString("TO_PARENT")+"\n" +
        " CHDIR - "+java.util.ResourceBundle.getBundle(MAIN.Internationalization + MAIN.ShortInternationalization).getString("CHANGE_DIR")+"\n" +
        " DIR - "+java.util.ResourceBundle.getBundle(MAIN.Internationalization + MAIN.ShortInternationalization).getString("VIEW_DIR")+"\n" +
        "  DIR [DISK:\\] [PATH] - "+java.util.ResourceBundle.getBundle(MAIN.Internationalization + MAIN.ShortInternationalization).getString("VIEW_D_P")+"\n" +
        "  DIR [PATH] - "+java.util.ResourceBundle.getBundle(MAIN.Internationalization + MAIN.ShortInternationalization).getString("VIEW_P")+"\n" +
        "  DIR [DISK:\\] - "+java.util.ResourceBundle.getBundle(MAIN.Internationalization + MAIN.ShortInternationalization).getString("VIEW_D")+"\n" +
        " GP - "+java.util.ResourceBundle.getBundle(MAIN.Internationalization + MAIN.ShortInternationalization).getString("GP")+"\n" +
        " | - "+java.util.ResourceBundle.getBundle(MAIN.Internationalization + MAIN.ShortInternationalization).getString("SEP")+"\n" +
        " CI - "+java.util.ResourceBundle.getBundle(MAIN.Internationalization + MAIN.ShortInternationalization).getString("CI")+"\n" +
        "  CI [CODE INTER] - "+java.util.ResourceBundle.getBundle(MAIN.Internationalization + MAIN.ShortInternationalization).getString("CI_SET") + "\n" +
        " MKDIR - "+java.util.ResourceBundle.getBundle(MAIN.Internationalization + MAIN.ShortInternationalization).getString("MD") + "\n" +
        "  MKDIR [PATH] - "+java.util.ResourceBundle.getBundle(MAIN.Internationalization + MAIN.ShortInternationalization).getString("MD_PATH") + "\n"+
        " MD - "+java.util.ResourceBundle.getBundle(MAIN.Internationalization + MAIN.ShortInternationalization).getString("MD") + "\n" +
        " MOVE - " +java.util.ResourceBundle.getBundle(MAIN.Internationalization + MAIN.ShortInternationalization).getString("MOVE") + "\n" +
        "  MOVE [DISK:\\][PATH] [PATH] [N|Y] - " +java.util.ResourceBundle.getBundle(MAIN.Internationalization + MAIN.ShortInternationalization).getString("MOVE") + "\n" +
        "  MOVE [PATH] - " +java.util.ResourceBundle.getBundle(MAIN.Internationalization + MAIN.ShortInternationalization).getString("MOVE_P2P") + "\n" +
        "  MOVE [PATH] [N|Y] - " +java.util.ResourceBundle.getBundle(MAIN.Internationalization + MAIN.ShortInternationalization).getString("MOVE_P2P_YN") + "\n" +
        " RD - " +java.util.ResourceBundle.getBundle(MAIN.Internationalization + MAIN.ShortInternationalization).getString("RD") + "\n" +
        "  RD [DISK:\\][PATH] [PATH] [N|Y] - " +java.util.ResourceBundle.getBundle(MAIN.Internationalization + MAIN.ShortInternationalization).getString("RD_DISK_PATH") + " \n " +
        "  RD [DISK:\\][PATH] - " +java.util.ResourceBundle.getBundle(MAIN.Internationalization + MAIN.ShortInternationalization).getString("RD_PATH") + "\n" +
        "  RD [DISK:\\][PATH] [N|Y] - " +java.util.ResourceBundle.getBundle(MAIN.Internationalization + MAIN.ShortInternationalization).getString("RD_PATH_YN") + "\n" +
        " COPY - " + "\n" +
        " COPYF - " + "\n" +
        " DATE - " + "\n" +
        " DEL - " + "\n" +
        " REN - " + "\n" +
        " RENAME - " + "\n" +
        " REPLACE - " + "\n" +
        " TASKLIST - " + "\n" +
        " TASKKILL - " + "\n" +
        " CON - " + "\n"
        );
    }
    
}
