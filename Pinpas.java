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
    public boolean betaal(double teBetalen) {
        boolean temp = false;
        if (teBetalen <= saldo){
            saldo -= teBetalen;
            temp = true;
        }
        return temp;
    }
    
    public double getKredietLimiet(){
        return kredietLimiet;
    }
}