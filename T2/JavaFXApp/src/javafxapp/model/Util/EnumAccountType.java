/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapp.model.Util;

/**
 *
 * @author user
 */
public enum EnumAccountType {    
    CORRENTE {
        @Override
        public String toString() {
            return "Corrente";
        }
    },
    POUPANCA {
        @Override
        public String toString() {
            return "Poupança";
        }
    },
    DI {
        @Override
        public String toString() {
            return "DI";
        }
    },    
    TESOURO {
        @Override
        public String toString() {
            return "Tesouro";
        }
    }    
}   
