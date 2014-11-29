import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack ;
public class Dienblad {
         private Stack<Artikel> artikelen;
         private Iterator<Artikel> it;
          /**
     * Constructor
     */
     public Dienblad() 
     {
         artikelen = new Stack<Artikel>();
     }
     
     /**
     * Methode om artikel aan dienblad toe te voegen
      * @param artikel
        */
     public void voegToe(Artikel artikel) {
         artikelen.add(artikel);
     }
     
     /**
     * Methode om aantal artikelen op dienblad te tellen
     * @return Het aantal artikelen
     */
     public int getAantalArtikelen() {
         int tempArtikel = 0;
         int aantalArtikelen = 0;
          tempArtikel = artikelen.size();
             aantalArtikelen = aantalArtikelen + tempArtikel;
     
       return aantalArtikelen;
    }
     /**
     * Methode om de totaalprijs van de artikelen
     * op dienblad uit te rekenen
     * @return De totaalprijs
     */
     public double getTotaalPrijs() {
         double prijs = 0;
         for (Artikel temp: artikelen) {
         double tempPrijs = temp.getPrijs();
         prijs = prijs + tempPrijs; 
          
        }
         return prijs;
    }
    public Stack<Artikel> getDienblad() {
                it = artikelen.iterator();
                return artikelen;
        }
}
