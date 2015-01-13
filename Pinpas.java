public class Pinpas extends Betaalwijze {
    private double kredietLimiet;
    /**
     * Methode om kredietlimiet te zetten
     * @param kredietlimiet
     */
    public void setKredietLimiet(double kredietLimiet) {
        this.kredietLimiet = kredietLimiet;
    }

    /**
     * Methode om betaling af te handelen
     */
    public void betaal(double teBetalen) throws TeWeinigGeldException {
        
        if (teBetalen <= saldo){
            saldo -= teBetalen;
        } else {
            throw new TeWeinigGeldException("Niet genoeg geld.");
        }
    }
    
    public double getKredietLimiet(){
        return kredietLimiet;
    }
}