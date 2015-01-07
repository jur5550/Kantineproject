/**
 * Write a description of class Docent here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Docent extends Persoon implements KortingskaartHouder
{
    // instance variables - replace the example below with your own
    private String docentCode;
    private String afdeling;
    private static final double kortingsPercentage = 0.25 ;
    private static final double maximumKorting = 1.00;
    private static final boolean heeftMaximum = true;
    /**
     * Constructor for objects of class Student
     */
    public Docent(int bsn, String voornaam, String achternaam, char nieuwGeslacht, int dag, int maand, int jaar, String docentCode, String afdeling)
    {
        super(bsn, voornaam, achternaam, nieuwGeslacht, dag, maand, jaar);
        this.docentCode = docentCode;
        this.afdeling = afdeling;
    }
    
    public Docent()
    {
        super();
        this.docentCode = "";
        this.afdeling = "";
    }
    
    public String getDocentCode(){
        return docentCode;
    }
    
    public String getAfdeling(){
        return afdeling;
    }
    
    public void setDocentCode(String nieuwDocentCode){
        docentCode = nieuwDocentCode;
    }
    
    public void setAfdeling(String nieuwAfdeling){
        afdeling = nieuwAfdeling;
    }
    
    public void drukAf() 
    {
        System.out.println("Docentcode = "+getDocentCode());
        System.out.println("Afdeling = "+getAfdeling());
    }
    
    public String toString() 
    {
        String returnValue = "Docent \n";
        returnValue += super.toString() +"\n";
        returnValue += "Docentcode: "+ docentCode + "\n";
        returnValue += "Afdeling: " + afdeling + "\n";
        return returnValue;
    }
    // methode om kortingspercentage op te vragen
    public double geefKortingsPercentage()
    {
        return kortingsPercentage;
    }
     // methode om op te vragen of er maximum per keer aan de korting zit
    public boolean heeftMaximum()
    {
        return heeftMaximum;
    }
     // methode om het maximum kortingsbedrag op te vragen
    public double geefMaximum()
    {
        return maximumKorting;
    }
}
