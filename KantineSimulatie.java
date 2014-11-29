public class KantineSimulatie {
    private Kantine kantine;
    /**
     * Constructor
     */
    public KantineSimulatie() {
        kantine=new Kantine();
    }

    /**
     * Deze methode simuleert een aantal dagen in het
     * verloop van de kantine
     * @param dagen
     */
    public void simuleer(int dagen) {
        // for lus voor dagen
        for(int i = 1; i <= dagen; i++) {
            // per dag nu even vast 10+i personen naar binnen
            // laten gaan, wordt volgende week veranderd...
            // for lus voor personen
            for(int j = 0;j<10+i;j++){
                kantine.loopPakSluitAan();// kantine.(…);
                
            }
            // verwerk rij voor de kassa
            kantine.verwerkRijVoorKassa();
            // toon dagtotalen (artikelen en geld in kassa)
            System.out.println(this.kantine.aantalArtikelen());
            // reset de kassa voor de volgende dag
            this.kantine.resetKassa();
        }
    }
}
