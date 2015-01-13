
/**
 * Write a description of class TeWeinigGeldException here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TeWeinigGeldException extends Exception
{
     TeWeinigGeldException(){}
     
     TeWeinigGeldException(Exception e)
     {
        System.out.println(e.toString());
     }
     TeWeinigGeldException(String message)
     {
        super(message);
     }
     
}

