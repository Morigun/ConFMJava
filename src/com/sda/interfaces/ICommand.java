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
    void Executed(ACommand command);
    void SetArgs(ACommand command, List<String> Args);
    ACommand CheckCommand(String NameCommand);
}
