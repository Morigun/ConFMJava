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

    /**
     *  GlobalPath class
     */
    protected GlobalPath path = GlobalPath.getInstance();

    /**
     * Name command
     */
    public String Name;

    /**
     * Max count arg command
     */
    public int CountArg;

    /**
     * List arguments
     */
    public List<String> Arguments;
    
    /**
     * Execute command
     */
    public abstract void Execute();

    /**
     * Set arguments list
     * @param args list Arguments
     */
    public abstract void setArgs(List<String> args);
}
