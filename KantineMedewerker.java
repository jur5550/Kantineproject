
/**
 * Write a description of class Docent here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class KantineMedewerker extends Persoon implements KortingskaartHouder
{
    // instance variables - replace the example below with your own
    private int medewerkersNummer;
    private boolean magAchterDeKassa;
    private static final double kortingsPercentage = 0.35 ;
    private static final double maximumKorting = 1.00;
    private static final boolean heeftMaximum = false;
    /**
     * Constructor for objects of class Student
     */
    public KantineMedewerker(int bsn, String voornaam, String achternaam, char nieuwGeslacht, int dag, int maand, int jaar, int medewerkersNummer, boolean magAchterDeKassa)
    {
        super(bsn, voornaam, achternaam, nieuwGeslacht, dag, maand, jaar);
        this.medewerkersNummer = medewerkersNummer;
        this.magAchterDeKassa = magAchterDeKassa;
    }
    
    public KantineMedewerker()
    {
        super();
        this.medewerkersNummer = 0;
        this.magAchterDeKassa = true;
    }
    
    public void setMedewerkersNummer(int nieuwMedewerkersnummer){
        medewerkersNummer = nieuwMedewerkersnummer;
    }
    
    public void setMagAchterDeKassa(boolean nieuwMagAchterDeKassa){
        magAchterDeKassa = nieuwMagAchterDeKassa;
    }
    
    public int getMedewerkersNummer(){
        return medewerkersNummer;
    }
    
    public boolean getMagAchterDeKassa(){
        return magAchterDeKassa;
    }
    
    public String getStringMagAchterDeKassa()
    {
        String temp = "";
        if (magAchterDeKassa == true)
        {
            temp = "ja";
        }
        else
        {
            temp = "nee";
        }
        return temp;
    }
    
    public void drukAf() 
    {
        System.out.println("Medewerkersnummer = "+getMedewerkersNummer());
        System.out.println("Deze persoon mag achter de kassa. "+getMagAchterDeKassa());
    }
    
    public String toString() 
    {
        String returnValue = "Medewerker \n";
        returnValue += super.toString() +"\n";
        returnValue += "Medewerkernummer: "+ medewerkersNummer + "\n";
        returnValue += "Medewerker mag achter de kassa: " + getStringMagAchterDeKassa() + "\n";
        return returnValue;
    }
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