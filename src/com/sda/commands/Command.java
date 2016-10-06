/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sda.commands;

import com.sda.PublicParams;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author suvoroda
 */
public class Command extends ACommand{

    /**
     * command list
     */
    public static List<String> CommandList;

    /**
     * Constructor command
     * @param name Name command
     * @param cntArg max count arg
     */
    public Command(String name, int cntArg){
        super.Name = name;
        super.CountArg = cntArg;
        super.Arguments = new ArrayList<>();
    }
    
    /**
     * Set arguments
     * @param args list argument
     */
    @Override
    public void setArgs(List<String> args){        
        super.Arguments.addAll(args);
    }
    
    /**
     * Execute command
     */
    @Override
    public void Execute() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    /**
     * Initialize command list
     */
    public static void InicCommandList(){
        CommandList = new ArrayList<>();
        CommandList.add(PublicParams.CommandCD);
        CommandList.add(PublicParams.CommandCHDIR);
        CommandList.add(PublicParams.CommandDIR);
        CommandList.add(PublicParams.CommandGP);
        CommandList.add(PublicParams.CommandHELP);
        CommandList.add(PublicParams.CommandCI);
        CommandList.add(PublicParams.CommandMOVE);
        CommandList.add(PublicParams.CommandMKDIR);
        CommandList.add(PublicParams.CommandMD);
        CommandList.add(PublicParams.CommandRD);
        CommandList.add(PublicParams.CommandRMDIR);
        CommandList.add(PublicParams.CommandCOPY);
        CommandList.add(PublicParams.CommandCOPYF);
        CommandList.add(PublicParams.CommandDATE);
        CommandList.add(PublicParams.CommandDEL);
        CommandList.add(PublicParams.CommandREN);
        CommandList.add(PublicParams.CommandRENAME);
        CommandList.add(PublicParams.CommandREPLACE);
        CommandList.add(PublicParams.CommandTASKLIST);
        CommandList.add(PublicParams.CommandTASKKILL);
        CommandList.add(PublicParams.CommandCON);
    }
    
}
