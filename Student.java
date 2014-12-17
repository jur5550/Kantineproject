
/**
 * Write a description of class Student here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Student extends Persoon
{
    // instance variables - replace the example below with your own
    private String studieRichting;
    private int studentNummer;

    /**
     * Constructor for objects of class Student
     */
    public Student(int bsn, String voornaam, String achternaam, char nieuwGeslacht, int dag,
    int maand, int jaar, int studentNummer, String studieRichting)
    {
        super(bsn, voornaam, achternaam, nieuwGeslacht, dag, maand, jaar);
        this.studieRichting = studieRichting;
        this.studentNummer = studentNummer;
       
    }
    
    public Student()
    {
        super();
        this.studieRichting = "";
        this.studentNummer = 0;
        
    }
    public void setStudieRichting(String studieRichting)
    {
        this.studieRichting = studieRichting;
    }
    
    public String getStudieRichting()
    {
        return studieRichting;
    }
    
    public void setStudentNummer(int studentNummer)
    {
        this.studentNummer = studentNummer;
    }
    
    public int getStudentNummer()
    {
        return studentNummer;
    }
    public void drukAf() 
    {
        System.out.println ("Studierichting = " +getStudieRichting());
        System.out.println("Studentnummer = "+getStudentNummer());
    }
}
