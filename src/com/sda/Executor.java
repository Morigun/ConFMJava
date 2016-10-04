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
        command.Execute();
    }

    @Override
    public void SetArgs(ACommand command, List<String> Args) {
        command.setArgs(Args);
    }

    @Override
    public ACommand CheckCommand(String NameCommand) {
        switch(NameCommand){
            case "CD":
                return new CDCommand(NameCommand, PublicParams.CountArgsCDCommand);
            case "DIR":
                return new DIRCommand(NameCommand, PublicParams.CountArgsDIRCommand);
            case "CI":
                return new CICommand(NameCommand, PublicParams.CountArgsCICommand);
            case "GP":
                return new GPCommand(NameCommand, PublicParams.CountArgsGPCommand);
            case "HELP":
                return new HELPCommand(NameCommand, PublicParams.CountArgsHELPCommand);
            case "RUN":
                return new RUNCommand(NameCommand, PublicParams.CountArgsRUNCommand);
            default:
                return new Command(NameCommand, 0);
        }
        
    }
    
}
