/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banksystem.model.Enum;

/**
 *
 * @author user
 */
public enum AccountTypeEnum {
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
    TESOURO{
        @Override
        public String toString() {
            return "Tesouro";
        }
    };        
}