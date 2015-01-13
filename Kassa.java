import java.util.*;
/**
 * Write a description of class Kassa here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Kassa {
    private KassaRij kassarij;
    private int aantalArtikelen ;
    private double geldbalans = 0;
    private Dienblad dienblad;
    private int hoeveelheidPersonen = 0;

    /**
     * Constructor
     */
    public Kassa(KassaRij kassarij)
    {
        this.kassarij = kassarij;
    }

    /**
     * Thema 1.2 I/TI Leertaak 1 Pagina 8 van 27 * vraag het aantal artikelen en de totaalprijs op.
     * De implementatie wordt later vervangen
     * door een echte betaling door de persoon.
     * @param persoon die moet afrekenen
     */
    public void rekenAf2(Persoon persoon)
    {
        //System.out.println(persoon.getTotaalPrijs());
        //System.out.println(persoon.getAantalArtikelen());
        this.aantalArtikelen += persoon.getAantalArtikelen();
        this.geldbalans += persoon.getTotaalPrijs();
    }

    public void rekenAf( Persoon persoon ) 
    {
        Dienblad blad = persoon.getDienblad();
        Iterator<Artikel> artikelen = blad.getDienblad().iterator();
        double totaalPrijs = 0;
        boolean kortingKaartHouder = false;
        double kortingsPercentage = 0.00;
        double maximumKorting = 0.00;
        boolean heeftMaximumKorting = false;
        double korting = 0.00;
        //Controleert of de persoon een kortingskaartheeft en of die een maximaal bedrag heeft (1 euro)
         if (persoon instanceof KortingskaartHouder)
            { kortingKaartHouder = true; 
              kortingsPercentage = persoon.geefKortingsPercentage();
               if (persoon.heeftMaximum()){
                   heeftMaximumKorting = true;
                   maximumKorting = persoon.geefMaximum();
                   
              } else {
                  heeftMaximumKorting = false;
              }
        }    
        
        
        // Draait de while net zo lang totdat de hele inhoud is doorgelopen.
        while( artikelen.hasNext() ) { 
            aantalArtikelen++;
            double artikelPrijs = 0.00;
            Artikel volgendeArtikel = artikelen.next();
            if (kortingKaartHouder){
               artikelPrijs = volgendeArtikel.getPrijs();
               korting +=(artikelPrijs*(1-kortingsPercentage));
           } else {
               artikelPrijs = volgendeArtikel.getPrijs();
               totaalPrijs += artikelPrijs;
           }
           
           if (kortingKaartHouder){
           
               if (heeftMaximumKorting && korting>maximumKorting){
                   korting=maximumKorting;
                }
                
           }     
           totaalPrijs -= korting;
        }
        
        Betaalwijze persoonBetaalwijze = persoon.getBetaalwijze();
        if (persoonBetaalwijze instanceof Pinpas)
        {
            try
                {persoonBetaalwijze.betaal(totaalPrijs);
                 geldbalans += totaalPrijs;
                
            } catch (Exception e){
                System.out.println(e);
                System.out.println(persoon.getVoornaam());
            }
        }
        else
        {
            try
                {persoonBetaalwijze.betaal(totaalPrijs);
                geldbalans += totaalPrijs;
            } catch (Exception e){
                System.out.println(e);
                System.out.println(persoon);
            }    
        }

        hoeveelheidPersonen += 1;    
    } 

    /**
     * Geeft het aantal artikelen dat de kassa
     * heeft gepasseerd,
     * vanaf het moment dat de methode resetWaarden
     * is aangeroepen.
     * @return aantal artikelen
     */
    public int getAantalArtikelen()
    {
        return aantalArtikelen;
    }

    /**
     * Geeft het totaalbedrag van alle artikelen die
     * de kassa zijn gepasseerd, vanaf het moment dat de methode
     *resetKassa
     * is aangeroepen.
     * @return hoeveelheid geld in de kassa
     */
    public double getHoeveelheidGeldInKassa()
    {
        return geldbalans;
    }

    /**
     * reset de waarden van het aantal gepasseerde artikelen en
     * de totale hoeveelheid geld in de kassa.
     */
    public void resetKassa()
    {
        geldbalans = 0;
        aantalArtikelen = 0;
        hoeveelheidPersonen = 0;
    }

    public int getHoeveelheidPersonen()
    {
        return hoeveelheidPersonen;
    }
}
