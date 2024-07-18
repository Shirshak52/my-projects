import javax.swing.JOptionPane;//importing JOptionPane class fro Swing package
public class Regular extends Student
{
    private int numOfModules;
    private int numOfCreditHours;
    private double daysPresent;
    private boolean isGrantedScholarship;
    
    
    
    
    // constructor
    public Regular(int enrollmentID, String dateOfBirth, String courseName, String studentName, String dateOfEnrollment, int courseDuration, int tuitionFee, int numOfModules, int numOfCreditHours, double daysPresent)
    {
        super(dateOfBirth, studentName, courseDuration, tuitionFee);
        
        super.setCourseName(courseName);
        super.setEnrollmentID(enrollmentID);
        super.setDateOfEnrollment(dateOfEnrollment);
        
        this.numOfModules = numOfModules;
        this.numOfCreditHours = numOfCreditHours;
        this.daysPresent = daysPresent;
        
        isGrantedScholarship = false;
    }
    
    
    
    
    
    
    //accessor methods
    
    //accessor method for numOfModules
    public int getNumOfModules()
    {
        return numOfModules;
    }
    
    
    //accessor method for numOfCreditHours
    public int getNumOfCreditHours()
    {
        return numOfCreditHours;
    }
    
    
    //accessor method for daysPresent
    public double getDaysPresent()
    {
        return daysPresent;
    }
    
    
    //accessor method for isGrantedScholarship
    public boolean getIsGrantedScholarship()
    {
        return isGrantedScholarship;
    }
    
    

    
    //presentPercentage method
    public String presentPercentage(double daysPresent)
    {
        double presentPercentage = (100.0 * daysPresent) / (30.0 * getCourseDuration());
        
        char attendanceGrade = ' ';
        String presentPercentageMessage = "";
        
        // the if condition here implies that daysPresent > courseDuration
        if (presentPercentage > 100.0) {
            presentPercentageMessage = "Invalid data; the number of days present is greater than the course duration.";
            //attendanceGrade = 'N';
        }
    
        else if (presentPercentage <= 100.0 && presentPercentage >= 80.0) {
            isGrantedScholarship = true;
            attendanceGrade = 'A';
            presentPercentageMessage = "Attendance Grade: " + String.valueOf(attendanceGrade);
        }
        
        else if (presentPercentage <= 79.0 && presentPercentage >= 60.0) {
            attendanceGrade = 'B';
            presentPercentageMessage = "Attendance Grade: " + String.valueOf(attendanceGrade);
        }
        
        else if (presentPercentage <= 59.0 && presentPercentage >= 40.0) {
            attendanceGrade = 'C';
            presentPercentageMessage = "Attendance Grade: " + String.valueOf(attendanceGrade);
        }
        
        else if (presentPercentage <= 39.0 && presentPercentage >= 20.0) {
            attendanceGrade = 'D';
            presentPercentageMessage = "Attendance Grade: " + String.valueOf(attendanceGrade);
        }
        
        else {
            attendanceGrade = 'E';
            presentPercentageMessage = "Attendance Grade: " + String.valueOf(attendanceGrade);
        }
        
        return presentPercentageMessage;
    }

        
        

    
    
    
    
    
    
    //grantCertificate method
    public String grantCertificate(String courseName, int enrollmentID, String dateOfEnrollment)
    {
        this.setCourseName(courseName);
        this.setEnrollmentID(enrollmentID);
        this.setDateOfEnrollment(dateOfEnrollment);
        
        String grantedCertificateMessage = "The student with the following details has graduated: " + "\n\n"
        
        + "Enrollment ID: " + this.getEnrollmentID() + "\n"
        + "Student name: " + this.getStudentName() + "\n"
        + "Course name: " + this.getCourseName() + "\n"
        + "Date of Enrollment: " + this.getDateOfEnrollment() + "\n\n";
        
        
        if(isGrantedScholarship){
            grantedCertificateMessage += "The scholarship has been granted." + "\n";
        }
        
        return grantedCertificateMessage;
    }
    
    
    
    
    
    
    //display method
    @Override
    public String display()
    {
        String displayInfo = super.display();
        
        /*"Student Name: " + this.getStudentName() + "\n"
        +"DOB: " + this.getDateOfBirth() + "\n"
        +"Course Name: " + this.getCourseName() + "\n"
        +"Course Duration (in months): " + this.getCourseDuration() + "\n"
        +"Date of enrollment: " + this.getDateOfEnrollment() + "\n"
        +"Enrollment ID: " + this.getEnrollmentID() + "\n"
        +"Tuition Fee: " + this.getTuitionFee() + "\n";

        if (this.getDateOfBirth().isEmpty() || this.getStudentName().isEmpty() || this.getCourseName().isEmpty() || 
            this.getDateOfEnrollment().isEmpty() || this.getEnrollmentID() == 0 || this.getCourseDuration() == 0 || this.getTuitionFee() == 0)
        {
            displayInfo += "Please fill in all required fields \n" ;
        }*/
        
        displayInfo += "Number of Modules: " + numOfModules + "\n"
        + "Number of Credit Hours: " + numOfCreditHours + "\n"
        + "Days Present: " + daysPresent + "\n";
        
        return displayInfo;
    }
}