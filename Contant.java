public class Contant extends Betaalwijze {
    private double kredietLimiet;
    /**
     * Methode om betaling af te handelen
     */
    public void betaal(double teBetalen) throws TeWeinigGeldException {
        boolean temp = false;
        if (teBetalen <= saldo) {
            saldo -= teBetalen; 
            temp = true;
        } else {
            throw new TeWeinigGeldException("Niet genoeg geld.");
        }
    }
    
  
}