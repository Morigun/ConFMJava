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
import com.sda.commands.CONCommand;
import com.sda.commands.COPYCommand;
import com.sda.commands.DATECommand;
import com.sda.commands.DELCommand;
import com.sda.commands.DIRCommand;
import com.sda.commands.GPCommand;
import com.sda.commands.HELPCommand;
import com.sda.commands.MKDIRCommand;
import com.sda.commands.MOVECommand;
import com.sda.commands.RDCommand;
import com.sda.commands.RENCommand;
import com.sda.commands.REPLACECommand;
import com.sda.commands.RUNCommand;
import com.sda.commands.TASKKILLCommand;
import com.sda.commands.TASKLISTCommand;
import com.sda.interfaces.ICommand;
import java.util.List;

/**
 *
 * @author suvoroda
 */
public class Executor implements ICommand{

    /**
     * execute command
     * @param command command class
     */
    @Override
    public void Executed(ACommand command) {
        if(command.Arguments.size() <= command.CountArg)
            command.Execute();
        else if (command.CountArg == 0){//Считаем, что кол-во параметров не ограничено
            command.Execute();
        } else {
            System.err.println(java.util.ResourceBundle.getBundle(MAIN.Internationalization + MAIN.ShortInternationalization).getString("COUNT_ARGUMENT_ERROR") + " " + command.Arguments.size());
        }
    }

    /**
     * Set Arguments 
     * @param command command class
     * @param Args list arguments
     */
    @Override
    public void SetArgs(ACommand command, List<String> Args) {
        command.setArgs(Args);
    }

    /**
     * Check command on string
     * @param NameCommand name command
     * @return Return abstract class ACommand
     */
    @Override
    public ACommand CheckCommand(String NameCommand) {
        switch(NameCommand.toUpperCase()){
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
            case PublicParams.CommandRD:
            case PublicParams.CommandRMDIR:
                return new RDCommand(NameCommand, PublicParams.CountArgsRDCommand);
            case PublicParams.CommandCOPY:
                return new COPYCommand(NameCommand, PublicParams.CountArgCOPYCommand);
            case PublicParams.CommandCOPYF:
                return new COPYCommand(NameCommand, PublicParams.CountArgCOPYFCommand);
            case PublicParams.CommandDATE:
                return new DATECommand(NameCommand, PublicParams.CountArgDATECommand);
            case PublicParams.CommandDEL:
                return new DELCommand(NameCommand, PublicParams.CountArgDELCommand);
            case PublicParams.CommandREN:
            case PublicParams.CommandRENAME:
                return new RENCommand(NameCommand, PublicParams.CountArgRENCommand);
            case PublicParams.CommandREPLACE:
                return new REPLACECommand(NameCommand, PublicParams.CountArgREPLACECommand);
            case PublicParams.CommandTASKLIST:
                return new TASKLISTCommand(NameCommand, PublicParams.CountArgTASKLISTCommand);
            case PublicParams.CommandTASKKILL:
                return new TASKKILLCommand(NameCommand, PublicParams.CountArgTASKKILLCommand);
            case PublicParams.CommandCON:
                return new CONCommand(NameCommand, PublicParams.CountArgCONCommand);
            default:
                return new Command(NameCommand, 0);
        }
        
    }
    
}
