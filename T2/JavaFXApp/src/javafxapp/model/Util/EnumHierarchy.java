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
public enum EnumHierarchy {    
    CLIENT {
        @Override
        public String toString() {
            return "Cliente";
        }
    },
    EMPLOYEE {
        @Override
        public String toString() {
            return "Funcionário";
        }
    },
    MANAGER {
        @Override
        public String toString() {
            return "Gerente";
        }
    }    
}
