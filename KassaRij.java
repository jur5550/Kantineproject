import java.util.ArrayList;

/**
 * Write a description of class Kassarij here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class KassaRij {
    private ArrayList<Persoon> rij;
    private Persoon eerstepersoon;
     /**
     * Constructor
     */
     public KassaRij() {
      rij = new ArrayList<Persoon>();//method body omitted
     }
    
     /**
     Thema 1.2 I/TI Leertaak 1 Pagina 7 van 27 * Persoon sluit achter in de rij aan
     * @param persoon
     */
     public void sluitAchteraan(Persoon persoon) {
      rij.add(persoon);
     }
     
     /**
     * Indien er een rij bestaat, de eerste Persoon uit
     * de rij verwijderen en retourneren.
     * Als er niemand in de rij staat geeft deze null terug.
     * @return Eerste persoon in de rij of null
     */
     public Persoon eerstePersoonInRij() {
         if (erIsEenRij() == true) {
             return (this.rij.remove(0));
            }
            else
            {
             Persoon eerstePersoon = null;
             return eerstePersoon;
            }
        }
     
     /**
     * Methode kijkt of er personen in de rij staan.
     * @return Of er wel of geen rij bestaat
     */
     public boolean erIsEenRij() {
         if (rij.isEmpty()){
             return false ;
            } else {
             return true;
            }
     }
}
