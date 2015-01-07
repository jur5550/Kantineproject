public class Contant extends Betaalwijze {
    private double kredietLimiet;
    /**
     * Methode om betaling af te handelen
     */
    public boolean betaal(double teBetalen) {
        boolean temp = false;
        if (teBetalen <= saldo) {
            saldo -= teBetalen; 
            temp = true;
        }
        return temp;
    }
    
  
}