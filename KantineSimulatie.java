import java.util.*;

public class KantineSimulatie {
    // kantine
    private Kantine kantine;

    // kantineaanbod
    private KantineAanbod kantineaanbod;

    // random generator
    private Random random;

    // aantal artikelen
    private static final int AANTAL_ARTIKELEN=4;

    // artikelen
    private static final String[] artikelnamen=
        new String[] {"Koffie","Broodje hamburger", "Broodje kaas", "Melk"};

    // prijzen
    private static double[] artikelprijzen=
        new double[]{1, 2, 3, 4};   

    // minimum en maximum aantal artikelen per soort
    private static final int MIN_ARTIKELEN_PER_SOORT=200;
    private static final int MAX_ARTIKELEN_PER_SOORT=800;

    // minimum en maximum aantal personen per dag
    private static final int MIN_PERSONEN_PER_DAG=50;
    private static final int MAX_PERSONEN_PER_DAG=100;

    // minimum en maximum artikelen per persoon
    private static final int MIN_ARTIKELEN_PER_PERSOON=1;
    private static final int MAX_ARTIKELEN_PER_PERSOON=4;
    private static final int AANTAL_PERSONEN= 250;
    private static final int AANTALARTIKELEN=3;
    private double[] omzet;
    private double[] dagOmzet;

    /**
     * Constructor
     */
    public KantineSimulatie(){
        kantine=new Kantine();
        random=new Random();
        int[] hoeveelheden = getRandomArray(
                AANTAL_ARTIKELEN,MIN_ARTIKELEN_PER_SOORT, MAX_ARTIKELEN_PER_SOORT);
        kantineaanbod=new KantineAanbod(
            artikelnamen, artikelprijzen, hoeveelheden); 
        kantine.setKantineAanbod(kantineaanbod);
    }

    /**
     * Methode om een array van random getallen liggend tussen min en max 
     * van de gegeven lengte te genereren
     * @param lengte
     * @param min
     * @param max
     * @return De array met random getallen
     */
    private int[] getRandomArray(int lengte, int min, int max) {
        int[] temp=new int[lengte];
        for(int i=0;i<lengte;i++) {
            temp[i]=getRandomValue(min, max);
        }
        return temp;
    }

    /**
     * Methode om een random getal tussen min(incl) en 
     * max(incl) te genereren.
     * @param min
     * @param max
     * @return Een random getal
     */
    private int getRandomValue(int min, int max) {
        return random.nextInt(max-min+1)+min;
    }

    /**
     * Methode om op basis van een array van indexen voor de array 
     * artikelnamen de bijhorende array van artikelnamen te maken
     * @param indexen
     * @return De array met artikelnamen
     */
    private String[] geefArtikelNamen(int[] indexen) {
        String[] artikelen=new String[indexen.length];
        for(int i=0;i<indexen.length;i++) { 
            artikelen[i]=artikelnamen[indexen[i]];
        }
        return artikelen;
    }

    /**
     * Deze methode simuleert een aantal dagen in het 
     * verloop van de kantine
     * @param dagen
     */
    public void simuleer(int dagen) {
        int[] aantal = new int[dagen];
        double[] omzet = new double [dagen];
        double[] dagOmzet = new double [dagen];
        
        int aantalStudenten = 0;
        int aantalDocenten = 0;
        int aantalKantineMedewerkers = 0;
            for (int h = 0; h < AANTAL_PERSONEN ; h++) {
                int randomPersoon = getRandomValue(0,100);
            if (randomPersoon >= 0 && randomPersoon < 90) 
            {
                aantalStudenten ++;
            }
            else if (randomPersoon >= 90 && randomPersoon <100)
            {
                aantalDocenten ++;
            } 
            else 
            {
                aantalKantineMedewerkers ++; 
            }
        }
        for(int i=0;i<dagen;i++) {
       
            

            for(int j = 0 ; j < aantalStudenten ; j++) {
                Student student = new Student();
                Dienblad dienblad = new Dienblad();
                student.pakDienblad(dienblad);
                pakArtikelenEnSluitAchteraan(student);
                student.drukAf();
            }
            for(int j = 0 ; j < aantalDocenten ; j++) {
                Docent docent = new Docent();
                Dienblad dienblad = new Dienblad();
                docent.pakDienblad(dienblad);
                pakArtikelenEnSluitAchteraan(docent);
                docent.drukAf();
            }
            for(int j = 0 ; j < aantalKantineMedewerkers ; j++) {
                KantineMedewerker kantineMedewerker = new KantineMedewerker();
                Dienblad dienblad = new Dienblad();
                kantineMedewerker.pakDienblad(dienblad);
                pakArtikelenEnSluitAchteraan(kantineMedewerker);
                kantineMedewerker.drukAf();
            }
            kantine.verwerkRijVoorKassa();
            aantal[i] = kantine.kassa.getHoeveelheidPersonen();
            omzet[i] = kantine.kassa.getHoeveelheidGeldInKassa();
            dagOmzet[i] = kantine.kassa.getHoeveelheidGeldInKassa();
            this.kantine.resetKassa();
            eindTotalen(aantal, omzet, dagOmzet);
        }
    } 

    public void pakArtikelenEnSluitAchteraan(Persoon persoon)
    {
        // genereer de artikelnummers, dit zijn indexen 
        // van de artikelnamen array  
        int[] tepakken=getRandomArray(AANTALARTIKELEN, 0, AANTAL_ARTIKELEN - 1);
        String[] artikelen=geefArtikelNamen(tepakken);
        kantine.loopPakSluitAan(persoon,artikelen);
        for(String artikel: artikelen) {
            if(kantineaanbod.getArtikelVoorraad(artikel) < 200) {
                kantineaanbod.updateArtikelVoorraad(artikel, 400);
            }
        }
    }

    public void eindTotalen(int[] aantal, double[] omzet, double[] dagOmzet)
    {
        double gemAantal = Administratie.berekenGemiddeldAantal(aantal);
        System.out.println("Gemiddeld hoeveelheid personen per dag " + gemAantal + ".");
        double gemOmzet = Administratie.berekenGemiddeldeOmzet(omzet);
        System.out.println("Gemiddeld hoeveelheid omzet totaal " + gemOmzet + ".");

        double[] gemDagOmzet = Administratie.berekenDagOmzet(dagOmzet);
        System.out.println("De omzet voor maandagen = " + gemDagOmzet[0] + ".") ;
        System.out.println("De omzet voor dinsdagen = " + gemDagOmzet[1] + ".");
        System.out.println("De omzet voor woensdagen = " + gemDagOmzet[2] + ".");
        System.out.println("De omzet voor donderdagen = " + gemDagOmzet[3] + ".");
        System.out.println("De omzet voor vrijdagen = " + gemDagOmzet[4] + ".");
        System.out.println("De omzet voor zaterdagen = " + gemDagOmzet[5] + ".");
        System.out.println("De omzet voor zondagen = " + gemDagOmzet[6] + ".");

    }
}
