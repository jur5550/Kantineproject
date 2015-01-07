public class Administratie {
    private static final int DAYS_IN_WEEK = 7;
    /**
     * Deze methode berekent van de int array aantal de
     * gemiddelde waarde
     * @param aantal
     * @return het gemiddelde
     */

    private Administratie(){
        Administratie administratie = new Administratie();
    }

    public static double berekenGemiddeldAantalPersonen(int[] aantal) {
        double totaalPersonen = 0.0;
        double gemiddeldeAantal = 0.0;
        for (int i = 0; i<aantal.length; i++){
            totaalPersonen += aantal[i];
        }
        gemiddeldeAantal = totaalPersonen/aantal.length;
        return gemiddeldeAantal;
    }

    /**
     * Deze methode berekent van de double array omzet de
     * gemiddelde waarde
     * @param omzet
     * @return Het gemiddelde
     */
    public static double berekenGemiddeldeOmzet(double[] omzet) {
        double totaalOmzet = 0.0;
        double gemiddeldeOmzet = 0.0;
        for (int i = 0; i<omzet.length; i++){
            totaalOmzet += omzet[i];
        }
        gemiddeldeOmzet = totaalOmzet/omzet.length;
        return gemiddeldeOmzet;
    }

    /**
     * Methode om dagomzet uit te rekenen
     * @param omzet
     * @return array (7 elementen) met dagomzetten
     */
    public static double[] berekenDagOmzet(double[] omzet) {
        double[] temp=new double[DAYS_IN_WEEK];
        for(int i=0;i<DAYS_IN_WEEK;i++) {
            int j=0;
            while((i+DAYS_IN_WEEK*j) < omzet.length) {
                temp[i] += omzet[i + DAYS_IN_WEEK * j];
                j++;
            }
        }
        return temp;
    }
}