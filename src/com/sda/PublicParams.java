/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sda;

/**
 *
 * @author suvoroda
 */
public class PublicParams {    
    /*Commands*/
    public final static String CommandCD = "CD";
    public final static String CommandDIR = "DIR";
    public final static String CommandGP = "GP";
    public final static String CommandHELP = "HELP";
    public final static String CommandCI = "CI";
    public final static String CommandSeparator = "|";
    /*PATHS|FILES*/
    public final static String ExtVBS = ".vbs";
    public final static String PathToWScript = "C:\\Windows\\SysWOW64\\wscript.exe";
    public final static String NameTuneFile = "tune.xml";
    /*Internationalization*/
    public final static String DefaultInternationalization = "com/sda/inproperties/en";
    public final static String ENInternationalization = "com/sda/inproperties/en";
    public final static String RUInternationalization = "com/sda/inproperties/ru";
    public final static String DEFAULT = "en";
    public final static String RU = "ru";
    public final static String EN = "en";
    /*PROPERTIES*/
    public final static String Internationalization = "Internationalization";
    public final static String ShortInternationalization = "ShortInternationalization";
    public final static String PropertyPath = "PATH";
    /*COUNT ARGS*/
    public final static int CountArgsDIRCommand = 3;
    public final static int CountArgsCDCommand = 3;
    public final static int CountArgsCICommand = 2;
    public final static int CountArgsGPCommand = 2;
    public final static int CountArgsHELPCommand = 0;
    public final static int CountArgsRUNCommand = 1;
    /*COLORS*/
    public final static String ANSI_RED = "\u001b[31m";
    public final static String ANSI_RESET = "\u001b[0m";
}
