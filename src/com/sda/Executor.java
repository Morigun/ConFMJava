/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sda;

import com.sda.commands.ACommand;
import com.sda.commands.Command;
import com.sda.commands.CDCommand;
import com.sda.commands.CICommand;
import com.sda.commands.DIRCommand;
import com.sda.commands.GPCommand;
import com.sda.commands.HELPCommand;
import com.sda.commands.MKDIRCommand;
import com.sda.commands.MOVECommand;
import com.sda.commands.RUNCommand;
import com.sda.interfaces.ICommand;
import java.util.List;

/**
 *
 * @author suvoroda
 */
public class Executor implements ICommand{

    @Override
    public void Executed(ACommand command) {
        if(command.Arguments.size() <= command.CountArg)
            command.Execute();
        else
            System.err.println(java.util.ResourceBundle.getBundle(MAIN.Internationalization + MAIN.ShortInternationalization).getString("COUNT_ARGUMENT_ERROR") + " " + command.Arguments.size());
    }

    @Override
    public void SetArgs(ACommand command, List<String> Args) {
        command.setArgs(Args);
    }

    @Override
    public ACommand CheckCommand(String NameCommand) {
        switch(NameCommand){
            case PublicParams.CommandCHDIR:
            case PublicParams.CommandCD:
                return new CDCommand(NameCommand, PublicParams.CountArgsCDCommand);
            case PublicParams.CommandDIR:
                return new DIRCommand(NameCommand, PublicParams.CountArgsDIRCommand);
            case PublicParams.CommandCI:
                return new CICommand(NameCommand, PublicParams.CountArgsCICommand);
            case PublicParams.CommandGP:
                return new GPCommand(NameCommand, PublicParams.CountArgsGPCommand);
            case PublicParams.CommandHELP:
                return new HELPCommand(NameCommand, PublicParams.CountArgsHELPCommand);
            case PublicParams.CommandRUN:
                return new RUNCommand(NameCommand, PublicParams.CountArgsRUNCommand);
            case PublicParams.CommandMOVE:
                return new MOVECommand(NameCommand, PublicParams.CountArgsMOVECommand);                
            case PublicParams.CommandMD:
            case PublicParams.CommandMKDIR:
                return new MKDIRCommand(NameCommand, PublicParams.CountArgsMKDIRCommand);
            default:
                return new Command(NameCommand, 0);
        }
        
    }
    
}
