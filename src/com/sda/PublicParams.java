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

    /**
     * String name CD command
     */
    
    public final static String CommandCD = "CD";

    /**
     * String name CD command
     */
    public final static String CommandCHDIR = "CHDIR";

    /**
     * String name DIR command
     */
    public final static String CommandDIR = "DIR";

    /**
     * String name GP command
     */
    public final static String CommandGP = "GP";

    /**
     * String name HELP command
     */
    public final static String CommandHELP = "HELP";

    /**
     * String name CI command
     */
    public final static String CommandCI = "CI";

    /**
     * String name RUN command
     */
    public final static String CommandRUN = "RUN";

    /**
     * String command separator
     */
    public final static String CommandSeparator = "|";

    /**
     * String name MOVE command
     */
    public final static String CommandMOVE = "MOVE";

    /**
     * String name MD command
     */
    public final static String CommandMKDIR = "MKDIR";

    /**
     * String name MD command
     */
    public final static String CommandMD = "MD";
    
    /**
     * String name RD command
     */
    public final static String CommandRD = "RD";

    /**
     * String name RD command
     */
    public final static String CommandRMDIR = "RMDIR";

    /**
     * String name COPY command
     */
    public final static String CommandCOPY = "COPY";
    
    /**
     * String name COPYF command
     */
    public final static String CommandCOPYF = "COPYF";

    /**
     * String name DATE command
     */
    public final static String CommandDATE = "DATE";

    /**
     * String name DEL command
     */
    public final static String CommandDEL = "DEL";

    /**
     * String name REN command
     */
    public final static String CommandREN = "REN";

    /**
     * String name REN command
     */
    public final static String CommandRENAME = "RENAME";

    /**
     * String name REPLACE command
     */
    public final static String CommandREPLACE = "REPLACE";

    /**
     * String name TASKLIST command
     */
    public final static String CommandTASKLIST = "TASKLIST";

    /**
     * String name TASKKILL command
     */
    public final static String CommandTASKKILL = "TASKKILL";
    
    /**
     * String name CON command
     */
    public final static String CommandCON = "CON";
    /*PATHS|FILES*/

    /**
     * Extension file vbs
     */
    
    public final static String ExtVBS = ".vbs";

    /**
     * Path to wscript.exe
     */
    public final static String PathToWScript = "C:\\Windows\\SysWOW64\\wscript.exe";

    /**
     * Tune file name
     */
    public final static String NameTuneFile = "tune.xml";
    /*Internationalization*/

    /**
     * Path to internationalization propeties files
     */
    
    public final static String DefaultInternationalization = "com/sda/inproperties/";

    /**
     * Internationalization default(en)
     */
    public final static String DEFAULT = "en";

    /**
     * Internationalization ru
     */
    public final static String RU = "ru";

    /**
     * Internationalization en
     */
    public final static String EN = "en";
    /*PROPERTIES*/

    /**
     * String properties Internationalization
     */
    
    public final static String Internationalization = "Internationalization";

    /**
     * String properties ShortInternationalization
     */
    public final static String ShortInternationalization = "ShortInternationalization";

    /**
     * String properties PATH
     */
    public final static String PropertyPath = "PATH";
    /*COUNT ARGS*/

    /**
     * MAX count arguments for DIR command
     */
    
    public final static int CountArgsDIRCommand = 3;

    /**
     * MAX count arguments for CD command
     */
    public final static int CountArgsCDCommand = 3;

    /**
     * MAX count arguments for Ci command
     */
    public final static int CountArgsCICommand = 2;

    /**
     * MAX count arguments for GP command
     */
    public final static int CountArgsGPCommand = 2;

    /**
     * MAX count arguments for HELP command
     */
    public final static int CountArgsHELPCommand = 1;

    /**
     * MAX count arguments for RUN command
     */
    public final static int CountArgsRUNCommand = 1;

    /**
     * MAX count arguments for MOVE command
     */
    public final static int CountArgsMOVECommand = 4;

    /**
     * MAX count arguments for MD command
     */
    public final static int CountArgsMKDIRCommand = 2;
    
    /**
     * MAX count arguments for RD command
     */
    public final static int CountArgsRDCommand = 3;
    
    /**
     * MAX count argument for COPY command
     */
    public final static int CountArgCOPYCommand = 4;
    
    /**
     * MAX count argument for COPYF command
     */
    public final static int CountArgCOPYFCommand = 4;
    
    /**
     * MAX count argument for DATE command
     */
    public final static int CountArgDATECommand = 1;
    
    /**
     * MAX count argument for DEL command
     */
    public final static int CountArgDELCommand = 2;
    
    /**
     * MAX count argument for REN command
     */
    public final static int CountArgRENCommand = 3;
    
    /**
     * MAX count argument for REPLACE command
     */
    public final static int CountArgREPLACECommand = 3;
    
    /**
     * MAX count argument for TASKLIST command
     */
    public final static int CountArgTASKLISTCommand = 0;
    
    /**
     * MAX count argument for TASKKILL command
     */
    public final static int CountArgTASKKILLCommand = 0;
    
    /**
     * MAX count argument for CON command
     */
    public final static int CountArgCONCommand = 0;
}
