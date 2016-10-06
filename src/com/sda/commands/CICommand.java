/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sda.commands;

import com.sda.MAIN;
import com.sda.PublicParams;

/**
 *
 * @author suvoroda
 */
public class CICommand extends Command{

    /**
     *
     * @param name
     * @param cntArg
     */
    public CICommand(String name, int cntArg) {
        super(name, cntArg);
    }
    
    /**
     * Execute command
     */
    @Override
    public void Execute() {
        if(super.Arguments.size() == 2){
            switch(super.Arguments.get(1)){
                case PublicParams.RU:
                    MAIN.Internationalization = PublicParams.DefaultInternationalization;
                    MAIN.ShortInternationalization = PublicParams.RU;
                    break;
                case PublicParams.EN:
                    MAIN.Internationalization = PublicParams.DefaultInternationalization;
                    MAIN.ShortInternationalization = PublicParams.EN;
                    break;
                default:
                    try{
                        java.util.ResourceBundle.getBundle(MAIN.Internationalization + super.Arguments.get(1));
                        MAIN.Internationalization = PublicParams.DefaultInternationalization;
                        MAIN.ShortInternationalization = super.Arguments.get(1);
                        break;
                    } catch(java.util.MissingResourceException ex){
                        System.err.println(java.util.ResourceBundle.getBundle(MAIN.Internationalization + MAIN.ShortInternationalization).getString("NOT_FOUN_INTR"));
                        MAIN.Internationalization = PublicParams.DefaultInternationalization;
                        MAIN.ShortInternationalization = PublicParams.DEFAULT;
                        break;
                    }
            }
        } else if(super.Arguments.size() == 1) {
            System.out.println(MAIN.ShortInternationalization);
        } else {
            System.err.println(java.util.ResourceBundle.getBundle(MAIN.Internationalization + MAIN.ShortInternationalization).getString("COUNT_ARGUMENT_ERROR") + " " + super.Arguments.size());
        }
    }
    
}
