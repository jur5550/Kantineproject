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
     public Kassa(KassaRij kassarij) {
         this.kassarij = kassarij;
     }
     /**
      * Thema 1.2 I/TI Leertaak 1 Pagina 8 van 27 * vraag het aantal artikelen en de totaalprijs op.
     * De implementatie wordt later vervangen
     * door een echte betaling door de persoon.
     * @param persoon die moet afrekenen
     */
     public void rekenAf2(Persoon persoon) {
         
         //System.out.println(persoon.getTotaalPrijs());
         //System.out.println(persoon.getAantalArtikelen());
        this.aantalArtikelen += persoon.getAantalArtikelen();
        this.geldbalans += persoon.getTotaalPrijs();
         }
         
     public void rekenAf( Persoon persoon )  {
                Dienblad blad = persoon.getDienblad();
                Iterator<Artikel> artikelen = blad.getDienblad().iterator();
                //Maak een apparte variable aan om het te betalen bedrag van deze persoon bij te houden.
                
                // Draait de while net zo lang totdat de hele inhoud is doorgelopen.
                    while( artikelen.hasNext() ) { 
                        aantalArtikelen++; 
                        Artikel volgendeArtikel = artikelen.next();
                        geldbalans += volgendeArtikel.getPrijs();
                        
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
     public int getAantalArtikelen() {
         return aantalArtikelen;
     }
     /**
     * Geeft het totaalbedrag van alle artikelen die
     * de kassa zijn gepasseerd, vanaf het moment dat de methode
     *resetKassa
     * is aangeroepen.
     * @return hoeveelheid geld in de kassa
     */
     public double getHoeveelheidGeldInKassa() {
         return geldbalans;
     }
     /**
     * reset de waarden van het aantal gepasseerde artikelen en
     * de totale hoeveelheid geld in de kassa.
     */
     public void resetKassa() {
         geldbalans = 0;
         aantalArtikelen = 0;
         hoeveelheidPersonen = 0;
     }
     public int getHoeveelheidPersonen() {
         return hoeveelheidPersonen;
     }
    }
