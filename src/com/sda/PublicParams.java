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
    public final static String CommandCHDIR = "CHDIR";
    public final static String CommandDIR = "DIR";
    public final static String CommandGP = "GP";
    public final static String CommandHELP = "HELP";
    public final static String CommandCI = "CI";
    public final static String CommandRUN = "RUN";
    public final static String CommandSeparator = "|";
    public final static String CommandMOVE = "MOVE";
    public final static String CommandMKDIR = "MKDIR";
    public final static String CommandMD = "MD";
    
    public final static String CommandRD = "RD";
    public final static String CommandRMDIR = "RMDIR";
    public final static String CommandCOPY = "COPY";
    public final static String CommandDATE = "DATE";
    public final static String CommandDEL = "DEL";
    public final static String CommandFTYPE = "FTYPE";
    public final static String CommandMKLINK = "MKLINK";
    public final static String CommandREN = "REN";
    public final static String CommandRENAME = "RENAME";
    public final static String CommandREPLACE = "REPLACE";
    public final static String CommandTASKLIST = "TASKLIST";
    public final static String CommandTASKKILL = "TASKKILL";
    /*PATHS|FILES*/
    public final static String ExtVBS = ".vbs";
    public final static String PathToWScript = "C:\\Windows\\SysWOW64\\wscript.exe";
    public final static String NameTuneFile = "tune.xml";
    /*Internationalization*/
    public final static String DefaultInternationalization = "com/sda/inproperties/";
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
    public final static int CountArgsHELPCommand = 1;
    public final static int CountArgsRUNCommand = 1;
    public final static int CountArgsMOVECommand = 3;
    public final static int CountArgsMKDIRCommand = 2;
    /*COLORS*/
    public final static String ANSI_RED = "\u001b[31m";
    public final static String ANSI_RESET = "\u001b[0m";
}
