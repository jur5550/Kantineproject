public class PersoonVergelijker{
    public PersoonVergelijker()
    {
        main();
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public static void main()
    {
        Persoon persoon1 = new Persoon();
        Persoon persoon2 = new Persoon();
        
        if (persoon1 == persoon2){
            System.out.println("persoon1 == persoon2");
        }
        else {
            System.out.println("persoon1 != persoon2");
        }
        if (persoon1.equals(persoon2)){
            System.out.println("persoon1.equals(persoon2)");
        }
        else {
            System.out.println("!persoon1.equals(persoon2)");
        }
    }
}
