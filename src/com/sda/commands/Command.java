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
    public static List<String> CommandList;
    public Command(String name, int cntArg){
        super.Name = name;
        super.CountArg = cntArg;
        super.Arguments = new ArrayList<>();
    }
    
    @Override
    public void setArgs(List<String> args){        
        super.Arguments.addAll(args);
    }
    
    @Override
    public void Execute() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
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
    }
    
}
