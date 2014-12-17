
/**
 * Write a description of class Artikel here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Artikel
{
    // instance variables - replace the example below with your own
    private String artikel;
    private double prijs;
    public Artikel(String artikel, double prijs)
    {
        this.artikel = artikel;
        this.prijs = prijs;
    }
    
    public String getArtikel()
    {
        return artikel;
    } 
    public double getPrijs()
    {
        return prijs;
    } 
    public void setArtikel(String andereNaam)
    {
        this.artikel = artikel;
    }
    public void setPrijs(double prijs)
    {
        this.prijs = prijs;
    }
    public void drukAf() 
    {
        System.out.println ("Artikel = " +getArtikel());
        System.out.println("Prijs = "+getPrijs());
    }
}
