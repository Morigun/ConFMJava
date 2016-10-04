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

    public CICommand(String name, int cntArg) {
        super(name, cntArg);
    }
    
    @Override
    public void Execute() {
        if(super.Arguments.size() == 2){
            switch(super.Arguments.get(1)){
                case PublicParams.RU:
                    MAIN.Internationalization = PublicParams.RUInternationalization;
                    MAIN.ShortInternationalization = PublicParams.RU;
                    break;
                case PublicParams.EN:
                    MAIN.Internationalization = PublicParams.DefaultInternationalization;
                    MAIN.ShortInternationalization = PublicParams.EN;
                    break;
                default:
                    MAIN.Internationalization = PublicParams.DefaultInternationalization;
                    MAIN.ShortInternationalization = PublicParams.DEFAULT;
                    break;
            }
        } else if(super.Arguments.size() == 1) {
            System.out.println(MAIN.ShortInternationalization);
        } else {
            System.err.println(java.util.ResourceBundle.getBundle(MAIN.ShortInternationalization).getString("COUNT ARGUMENT ERROR") + " " + super.Arguments.size());
        }
    }
    
}
