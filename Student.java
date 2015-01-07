/**
 * Write a description of class Student here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Student extends Persoon
{
    private int studentNummer;
    private String studieRichting;

    /**
     * Constructor for objects of class Student
     */
    public Student(int bsn, String voornaam, String achternaam, char nieuwGeslacht, int dag, int maand, int jaar, int studentNummer, String studieRichting)
    {
        super(bsn, voornaam, achternaam, nieuwGeslacht, dag, maand, jaar);
        this.studentNummer = studentNummer;
        this.studieRichting = studieRichting;
    }
    
    public Student()
    {
        super();
        this.studentNummer = 0;
        this.studieRichting = "";
    }
    
    public void setStudentNummer(int nieuwStudentNummer){
        studentNummer = nieuwStudentNummer;
    }
    
    public int getStudentNummer(){
        return studentNummer;
    }
    
    public String getStudieRichting(){
        return studieRichting;
    }
    
    public void setStudieRichting(String nieuwStudieRichting){
        studieRichting = nieuwStudieRichting;
    }
    
    public String toString() 
    {
        String returnValue = "Student \n";
        returnValue += super.toString() +"\n";
        returnValue += "Studentnummer: "+ studentNummer + "\n";
        returnValue += "Studierichting: " + studieRichting + "\n";
        return returnValue;
    }
}
