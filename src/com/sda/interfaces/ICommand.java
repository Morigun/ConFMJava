/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sda.interfaces;

import com.sda.commands.ACommand;
import java.util.List;

/**
 *
 * @author suvoroda
 */
public interface ICommand {

    /**
     * Execute command
     * @param command command class
     */
    void Executed(ACommand command);

    /**
     * Set arguments
     * @param command command class
     * @param Args arguments list
     */
    void SetArgs(ACommand command, List<String> Args);

    /**
     * Check commands on string name
     * @param NameCommand string name command
     * @return command class
     */
    ACommand CheckCommand(String NameCommand);
}
