
/**
 * Write a description of class Docent here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Docent extends Persoon
{
    private String docentCode;
    private String afdeling;
    /**
     * Constructor for objects of class Docent
     */
    public Docent(int bsn, String voornaam, String achternaam, char nieuwGeslacht, int dag,
    int maand, int jaar, String docentCode, String afdeling)
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
    public void setDocentCode(String docentCode)
    {
        this.docentCode = docentCode;
    }
    
    public String getDocentCode()
    {
        return docentCode;
    }
    
    public void setAfdeling(String afdeling)
    {
        this.afdeling = afdeling;
    }
    
    public String getAfdeling()
    {
        return afdeling;
    }
    
    public void drukAf() 
    {
        System.out.println ("Docentcode = " +getDocentCode());
        System.out.println("Afdeling = "+getAfdeling());
    }
}
