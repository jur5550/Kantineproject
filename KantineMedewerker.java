
/**
 * Write a description of class KantineMedewerker here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class KantineMedewerker extends Persoon
{
    private boolean magAchterDeKassa;
    private int medewerkersNummer;
    /**
     * Constructor for objects of class KantineMedewerker
     */
    public KantineMedewerker(int bsn, String voornaam, String achternaam, char nieuwGeslacht, int dag,
    int maand, int jaar, int medewerkersNummer, boolean magAchterDeKassa)
    {
        super(bsn, voornaam, achternaam, nieuwGeslacht, dag, maand, jaar);
        this.magAchterDeKassa = magAchterDeKassa;
        this.medewerkersNummer = medewerkersNummer;
    }
    public KantineMedewerker()
    {
        super();
        this.magAchterDeKassa = false;
        this.medewerkersNummer = 0;
    }
    public void setMagAchterDeKassa(boolean magAchterDeKassa)
    {
        this.magAchterDeKassa = magAchterDeKassa;
    }
    
    public boolean getMagAchterDeKassa()
    {
        return magAchterDeKassa;
    }
    
    public void setMedewerkersNummer(int medewerkersNummer)
    {
        this.medewerkersNummer = medewerkersNummer;
    }
    
    public int getMedewerkersNummer()
    {
        return medewerkersNummer;
    }
    public void drukAf() 
    {
        System.out.println ("Medewerkersnummer = " +getMedewerkersNummer());
        System.out.println("Mag achter de kassa staan? = "+getMagAchterDeKassa());
    }
}
