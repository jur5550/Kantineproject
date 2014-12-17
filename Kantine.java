public class Kantine {
     public static Kassa kassa;
     private KassaRij kassarij;
     private KantineAanbod kantineaanbod;
     /**
     * Constructor
     */
     public Kantine() {
         kassarij=new KassaRij();
         kassa=new Kassa(kassarij);
              }
     /**
     * In deze methode wordt een Persoon en Dienblad
     * gemaakt en aan elkaar
     * gekoppeld. Maak twee Artikelen aan en plaats
     * deze op het dienblad.
     * Tenslotte sluit de Persoon zich aan bij de rij
     * voor de kassa.
     */
     public void loopPakSluitAan2() {
         Persoon persoon = new Persoon();
         Dienblad dienblad = new Dienblad();
         Artikel artikel1 = new Artikel ("Appel", 2);
         Artikel artikel2 = new Artikel ("Banaan",34);
         persoon.pakDienblad(dienblad);
         persoon.getDienblad().voegToe(artikel1);
         persoon.getDienblad().voegToe(artikel2);
         this.kassarij.sluitAchteraan(persoon);
         
     }
         /**
         * In deze methode kiest een Persoon met een dienblad
         * de artikelen in artikelnamen.
         * @param persoon
         * @artikelnamen
         */
     public void loopPakSluitAan(Persoon persoon, String[] artikelnamen) {
         for (int i = 0; i<artikelnamen.length; i++){
             Artikel pakArt = kantineaanbod.getArtikel( artikelnamen[i]);
             persoon.getDienblad().voegToe(pakArt);
             
         
        }
        kassarij.sluitAchteraan( persoon );
     }
     // Deze methode handelt de rij voor de kassa af.
     
     public void verwerkRijVoorKassa() {
         while(kassarij.erIsEenRij() == true) {
             kassa.rekenAf(kassarij.eerstePersoonInRij())  ;          
         }
     

     }
     
         /**
     * Deze methode telt het geld uit de kassa
     * @return hoeveelheid geld in kassa
     */
     public Kassa getKassa() {
         return kassa;
     }
     
                  /**
     * Deze methode reset de bijgehouden telling van
     * het aantal artikelen
     * en "leegt" de inhoud van de kassa.
     */
     public void resetKassa() {
         kassa.resetKassa();
     }
     
     public KantineAanbod getKantineAanbod() {
           return this.kantineaanbod;
        }
    
     public void setKantineAanbod(KantineAanbod kantineaanbod)
     {
         this.kantineaanbod = kantineaanbod;
        }
}
