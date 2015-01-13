import java.util.ArrayList;
/**
 * Write a description of class Persoon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Persoon {
    private int bsn;
    private String voornaam;
    private String achternaam;
    private String Persoonsgeboortedatum ; 
    private char geslacht;
    private Dienblad dienblad;
    
    private Betaalwijze betaalwijze;
    private Contant contant;
    private Pinpas pinpas;
    public Persoon(int bsn, String voornaam, String achternaam, char nieuwGeslacht, int dag, int maand, int jaar)
    { 
        this.bsn = bsn;
        this.voornaam = voornaam;
        this.achternaam = achternaam;
        setgeboortedatum (dag,maand,jaar);
        setGeslacht (nieuwGeslacht);
    }
    
    public Persoon()
    {   
        bsn = 0000;
        voornaam = "<voornaam van de persoon>";
        achternaam = "";
        Persoonsgeboortedatum =("0/0/0");
        geslacht = 0;
        betaalwijze = new Pinpas();
        setBetaalwijze(10.0);
    }
    
    public void setBSN(int bsn)
    {
        this.bsn = bsn;
    } 

    public void setVoornaam(String voornaam)
    {
        this.voornaam = voornaam;
    } 

    public void setAchternaam(String achternaam)
    {
        this.achternaam = achternaam;
    } 

    public void setGeslacht(char nieuwGeslacht)
    {
        switch (nieuwGeslacht)
        {case 1:
            case 2:
            geslacht = nieuwGeslacht;
            break;
            default: geslacht = 00 ; 
        }   
    }

    /**
     * Getter voor geboortedatum
     * @return Geboortedatum 
     */
    public String getGeboorteDatum() {
        String temp;
        if (Persoonsgeboortedatum=="0/0/0") {
            temp="Onbekend";
        } else {
            temp=Persoonsgeboortedatum;
        }
        return temp;
    }
    
        /**
     * Methode om dienblad te koppelen aan een persoon
     * @param dienblad
     */
    public void pakDienblad(Dienblad dienblad) {
        this.dienblad = dienblad;
    } 
    
    /**
     * Methode om de totaalprijs van de artikelen
     * op dienblad dat bij de persoon hoort uit te rekenen
     * @return De totaalprijs
     */
    public double getTotaalPrijs() {
      return dienblad.getTotaalPrijs();
    }
    
    /**
     * Methode om het aantal artikelen op dienblad dat bij de
     * persoon hoort te tellen
     * @return Het aantal artikelen
     */
    public int getAantalArtikelen() 
      {   
       return dienblad.getAantalArtikelen();
       
    }
    
     public String getGeslacht() {
        String temp;
        switch(geslacht) {
            case 1:
                temp = "Man";
                break;
            case 2:
                temp = "Vrouw";
                break;
            default: temp="Onbekend";
            break;
        }
        return temp;
    }
    
    public String getVoornaam() {
         return voornaam;
        }
    
    public String getAchternaam() {
         return achternaam;
        }
        
    public int getBSN(){
        return bsn;
        }
        
    public void setgeboortedatum(int dag, int maand, int jaar)
    {
        if (dag > 0)
            if (maand >= 1 && maand <= 12)
                if (jaar >= 1900 && jaar <= 2100){
                    switch (maand) {
                        case 1: 
                        case 3: 
                        case 5:
                        case 7: 
                        case 8: 
                        case 10:
                        case 12:
                            if (dag <=31){
                                     Persoonsgeboortedatum = dag+"/"+maand+"/"+jaar;
                                } else { 
                                    Persoonsgeboortedatum = "0/0/0"; 
                                }
                            break;
                        case 4: 
                        case 6:
                        case 9: 
                        case 11:
                            if (dag <=30){
                                 Persoonsgeboortedatum = dag+"/"+maand+"/"+jaar;
                            } else { 
                                Persoonsgeboortedatum = "0/0/0"; 
                            }
                            break;
                        case 2:
                            if (((jaar % 4 == 0) && 
                                 !(jaar % 100 == 0))
                                 || (jaar % 400 == 0))
                                if(dag <=29) {
                                    Persoonsgeboortedatum = dag+"/"+maand+"/"+jaar; 
                                 }else { 
                                    Persoonsgeboortedatum = "0/0/0";
                                 }
                            else
                                if(dag<=28) {
                                    Persoonsgeboortedatum = dag+"/"+maand+"/"+jaar; 
                                } else {
                                    Persoonsgeboortedatum = "0/0/0";
                                } 
                            break;
                            default: Persoonsgeboortedatum = "0/0/0"; 
                            break;
                        }
                    }
                }
    
    public void drukAf() 
    {
        System.out.println ("BSN = " +getBSN());
        System.out.println("Voornaam = "+getVoornaam());
        System.out.println("Achternaam = "+getAchternaam());
        System.out.println("Geboortedatum = "+getGeboorteDatum());
        System.out.println("Geslacht = "+getGeslacht());
    }
    public Dienblad getDienblad()
     {
        return dienblad;
     }
     
    public String toString()
    {
        String naam = voornaam+" "+achternaam;
        return naam;
    }
    
    public boolean equals(Object object){
        if (this == object)
        {
            return true;
        }
        if (!(object instanceof Persoon))
        {
            return false;
        }
        Persoon other = (Persoon) object;
        return bsn == other.bsn;
    }
    
    public Betaalwijze getBetaalwijze(){
        return betaalwijze;
    }
    
    public void setBetaalwijze(double saldo){
        betaalwijze.setSaldo(saldo);
    }
    
    public Pinpas getPinpas()
    {
        return pinpas;
    }
    
    public void newPinpas(int kredietlimiet){
        pinpas = new Pinpas();
        pinpas.setKredietLimiet(kredietlimiet);
    }
    
    public double geefKortingsPercentage()
    {
        return 0.00;
    }
     // methode om op te vragen of er maximum per keer aan de korting zit
    public boolean heeftMaximum()
    {
        return false;
    }
     // methode om het maximum kortingsbedrag op te vragen
    public double geefMaximum()
    {
        return 0.00;
    }
}