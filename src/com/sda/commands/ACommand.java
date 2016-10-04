/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sda.commands;

import com.sda.Singletons.GlobalPath;
import java.util.List;

/**
 *
 * @author suvoroda
 */
public abstract class ACommand {
    protected GlobalPath path = GlobalPath.getInstance();
    public String Name;
    public int CountArg;
    public List<String> Arguments;
    
    public abstract void Execute();
    public abstract void setArgs(List<String> args);
}
