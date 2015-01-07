import java.util.*;

public class KantineSimulatie {
    private Kantine kantine;
    private int[] hoeveelheden; // aangepast
    private static final int MINIMUM_VOORRAAD_VOOR_ARTIKELEN=9;
    private KantineAanbod kantineaanbod;
    private Random random;
    private int totaalArtikelen;

    private static final int AANTAL_ARTIKELEN=4;
    private static final String[] artikelnamen=
        new String[] {"Koffie","Broodje hamburger", "Broodje kaas", "Melk"};
    private static double[] artikelprijzen=
        new double[]{1, 2, 3, 4};   

    private static final int AANTAL_PERSONEN=1000;
    private static final int AANTAL_TE_PAKKEN_ARTIKEL=3;

    private static final int MIN_ARTIKELEN_PER_SOORT=1000;
    private static final int MAX_ARTIKELEN_PER_SOORT=2000;

    private static final int MIN_PERSONEN_PER_DAG=50;
    private static final int MAX_PERSONEN_PER_DAG=100;

    private static final int MIN_ARTIKELEN_PER_PERSOON=1;
    private static final int MAX_ARTIKELEN_PER_PERSOON=4;

    /**
     * Constructor
     */
    public KantineSimulatie(){
        kantine=new Kantine();
        random=new Random();
        hoeveelheden=getRandomArray(
            AANTAL_ARTIKELEN,MIN_ARTIKELEN_PER_SOORT, MAX_ARTIKELEN_PER_SOORT);
        kantineaanbod=new KantineAanbod(artikelnamen, artikelprijzen, 
            hoeveelheden); 
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
        double[] omzet = new double[dagen];
        double[] dagOmzet = new double[dagen];
        
        int aantalStudenten = 0;
        int aantalDocenten = 0;
        int aantalMedewerkers = 0;
        // for lus voor dagen
        for(int h = 0; h < AANTAL_PERSONEN; h++){
            int randomPersoon = getRandomValue(0, 100);
            if(randomPersoon >= 0 && randomPersoon < 90){
                aantalStudenten ++;
            }
            else if (randomPersoon >= 90 && randomPersoon < 100){
                aantalDocenten ++;
            }
            else {
                aantalMedewerkers ++;
            }
        }
        for(int i=0;i<dagen;i++) {
            // laat de personen maar komen...
            for(int j=0;j<aantalStudenten;j++) {
                // maak persoon en dienblad aan, koppel ze
                Student student = new Student();
                Dienblad dienblad = new Dienblad();
                student.pakDienblad(dienblad);
                //student.drukAf();

                pakArtikelenEnSluitAchteraan(student);
            }
            for(int j=0;j<aantalDocenten;j++) {
                // maak persoon en dienblad aan, koppel ze
                Docent docent = new Docent();
                Dienblad dienblad = new Dienblad();
                docent.pakDienblad(dienblad);
                //docent.drukAf();

                pakArtikelenEnSluitAchteraan(docent);
            }
            for(int j=0;j<aantalMedewerkers;j++) {
                // maak persoon en dienblad aan, koppel ze
                KantineMedewerker kantineMedewerker = new KantineMedewerker();
                Dienblad dienblad = new Dienblad();
                kantineMedewerker.pakDienblad(dienblad);
                //kantineMedewerker.drukAf();

                pakArtikelenEnSluitAchteraan(kantineMedewerker);
            }
            System.out.println("Aantal studenten: " + aantalStudenten);
            System.out.println("Aantal docenten: " + aantalDocenten);
            System.out.println("Aantal medewerkers: " + aantalMedewerkers);
            
            totaalArtikelen += this.kantine.getKassa().getAantalArtikelen();

            kantine.verwerkRijVoorKassa();

            System.out.println("Totaal artikelen " + this.kantine.getKassa().getAantalArtikelen() + ".");
            System.out.println("Totaal prijs " + this.kantine.getKassa().getHoeveelheidGeldInKassa() + ".");
            System.out.println("Aantal mensen " + this.kantine.getKassa().getHoeveelheidPersonen() + ".");

            aantal[i] = kantine.kassa.getHoeveelheidPersonen();
            omzet[i] = kantine.kassa.getHoeveelheidGeldInKassa();
            dagOmzet[i] = kantine.kassa.getHoeveelheidGeldInKassa();
            eindTotalen(aantal, omzet, dagOmzet);

            this.kantine.resetKassa();
        }
    }

    public int getTotaalArtikelen(){
        return totaalArtikelen;
    }

    public void pakArtikelenEnSluitAchteraan(Persoon persoon){
        // genereer de artikelnummers, dit zijn indexen 
        // van de artikelnamen array  
        int[] tepakken=getRandomArray(AANTAL_TE_PAKKEN_ARTIKEL, 0, AANTAL_ARTIKELEN-1);
        // vind de artikelnamen op basis van 
        // de indexen hierboven
        String[] artikelen=geefArtikelNamen(tepakken);
        // loop de kantine binnen, pak de gewenste 
        // artikelen, sluit aan
        kantine.loopPakSluitAan(persoon,artikelen);
        for (String artikel : artikelen){
            if(kantineaanbod.getArtikelVoorraad(artikel) < MIN_ARTIKELEN_PER_SOORT){
                kantineaanbod.updateArtikelVoorraad(artikel, MAX_ARTIKELEN_PER_SOORT);
            }
        }
    }

    public void eindTotalen(int[] aantal, double[] omzet, double[] dagOmzet){
        double gemAantalPersonen = Administratie.berekenGemiddeldAantalPersonen(aantal);

        System.out.println("De gemiddelde hoeveelheid personen van alle dagen is: "+ gemAantalPersonen);
        System.out.println("De gemiddelde omzet van alle dagen is: "+Administratie.berekenGemiddeldeOmzet(omzet));
        double[] gemDagOmzet = Administratie.berekenDagOmzet(dagOmzet);
        System.out.println("De totale omzet op maandagen: "+gemDagOmzet[0]);
        System.out.println("De totale omzet op dinsdagen: "+gemDagOmzet[1]);
        System.out.println("De totale omzet op woensdagen: "+gemDagOmzet[2]);
        System.out.println("De totale omzet op donderdagen: "+gemDagOmzet[3]);
        System.out.println("De totale omzet op vrijdagen: "+gemDagOmzet[4]);
        System.out.println("De totale omzet op zaterdagen: "+gemDagOmzet[5]);
        System.out.println("De totale omzet op zondagen: "+gemDagOmzet[6]);

    }
}
