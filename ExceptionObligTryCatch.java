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
public class ExceptionObligTryCatch {
    
    
public static int checkValidOsloMetMail(String email) {
    String[] splitStrAlpha = email.split("@");
    try {
        if (splitStrAlpha.length == 2)
            throw new InvalidEmailException("Not a valid E-mail");
    } catch(InvalidEmailException ee){
        System.err.println("Not a valid E-mail.");
    }
    
    try{
        if(!splitStrAlpha[1].equals("oslomet.no")) 
            throw new InvalidOsloMetEmailException("Not a valid oslomet E-mail");
    } catch(InvalidOsloMetEmailException omee) {
        System.err.println("Not a valid Oslomet E-mail.");
    }
 
    String studentStr = splitStrAlpha[0];
    try{
        if(studentStr.length() != 7 || studentStr.charAt(0) != 's')
            throw new InvalidStudentOsloMetEmailException("Not a valid student number");
    } catch(InvalidStudentOsloMetEmailException iomee){
        System.err.println("Not a valid student  number");
    }

    // check if the six numbers behind "s" are valid numbers
    try {
        int testInt = Integer.parseInt(studentStr.substring(1));
        if(testInt < 0)
            return -3; // no negative numbers in student numbers
    } catch(NumberFormatException e) {
        return -3;
    }

    return 0; // email is valid

}


public static void checkMail(String email){
    int testMail = checkValidOsloMetMail(email);

    if(testMail == -3) {
        System.err.println(email + " is not a valid OsloMet student email");
    }
    else {
        System.out.println("Hello student with id " + email.split("@")[0]);
    }
}

public static void main(String[] args){
    String email1 = "s123456@hioa.no";
    String email2 = "s123456@oslomet.no";
    String email3 = "henrik.lieng@oslomet.no";
    String email4 = "so_bad!@oslomet.no";
    String email5 = "thisIsNoEMail";

    checkMail(email1);
    checkMail(email2);
    checkMail(email3);
    checkMail(email4);
    checkMail(email5);
}
    
}
