/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exceptionoblig;

/**
 *
 * @author alexanderbjorlo
 */
public class InvalidOsloMetEmailException extends InvalidEmailException {
    public InvalidOsloMetEmailException(String msg){
        super(msg);
    }
}
