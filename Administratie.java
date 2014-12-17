public class Administratie {
    private KantineSimulatie kantineSimulatie;
    private static final int DAYS_IN_WEEK = 7;
    private Administratie()
    {
        Administratie administratie = new Administratie();
    }

    /**
     * Deze methode berekent van de int array aantal de
     * gemiddelde waarde
     * 
     * @param aantal
     * @return het gemiddelde
     */
    public static double berekenGemiddeldAantal(int[] aantal) {
        if (aantal.length==0) return 0.0;
        double totaalArtikelen = 0.0;
        double gemiddeldeAantal = 0;
        for(int i = 0 ; i < aantal.length ; i++) 
            totaalArtikelen+=aantal[i];
        gemiddeldeAantal = totaalArtikelen/aantal.length;

        return gemiddeldeAantal;
    }

    /**
     * Deze methode berekent van de double array omzet de
     * gemiddelde waarde
     * @param omzet
     * @return Het gemiddelde
     */
    public static double berekenGemiddeldeOmzet(double[] omzet) {
        if (omzet.length==0) return 0.0;
        double totaalBedrag = 0.0;
        double gemiddeldBedrag = 0;
        for(int i = 0 ; i < omzet.length ; i++) 
            totaalBedrag+=omzet[i];
        gemiddeldBedrag = totaalBedrag/omzet.length;

        return gemiddeldBedrag;
    }

    /**
     * Methode om dagomzet uit te rekenen
     * @param omzet
     * @return array (7 elementen) met dagomzetten
     */
    public static double[] berekenDagOmzet(double[] omzet) {
        double[] temp=new double[7];
        for(int i = 0 ; i < DAYS_IN_WEEK ; i++) {
        int j = 0;
         
         while((i + j * DAYS_IN_WEEK ) < omzet.length) {
            temp[i] += omzet[i + DAYS_IN_WEEK * j];
            j++;
            
            
        }
       } 
       return temp;
    }
    
    
}
