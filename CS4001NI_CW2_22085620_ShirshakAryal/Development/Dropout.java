public class Dropout extends Student
{
    private int numOfRemainingModules;
    private int numOfMonthsAttended;
    private String dateOfDropout;
    private int remainingAmount;
    private boolean hasPaid;
    
    
    
    //constructor
    public Dropout(int enrollmentID, String dateOfBirth, String courseName, String studentName, 
    String dateOfEnrollment, int courseDuration, int tuitionFee, int numOfRemainingModules, int numOfMonthsAttended, int remainingAmount, String dateOfDropout)
    {
        super(dateOfBirth, studentName, courseDuration, tuitionFee);
        
        this.setCourseName(courseName);
        this.setEnrollmentID(enrollmentID);
        this.setDateOfEnrollment(dateOfEnrollment);
        
        this.numOfRemainingModules = numOfRemainingModules;
        this.numOfMonthsAttended = numOfMonthsAttended;
        this.dateOfDropout = dateOfDropout;
        this.remainingAmount = remainingAmount;
        
        remainingAmount = 0;
        hasPaid = false;
    }
    
    
    
    
    
    
    
    //ACCESSOR METHODS
    //accessor for numOfRemainingModules
    public int getNumOfRemainingModules()
    {
        return numOfRemainingModules;
    }
    
    //accessor for numOfMonthsAttended
    public int getNumOfMonthsAttended()
    {
        return numOfMonthsAttended;
    }
    
    //accessor for dateOfDropout
    public String getDateOfDropout()
    {
        return dateOfDropout;
    }
    
    //accessor for remainingAmount
    public int getRemainingAmount()
    {
        return remainingAmount;
    }
    
    //accessor for hasPaid
    public boolean getHasPaid()
    {
        return hasPaid;
    }
    
    
    
    
    
    
    
    //billsPayable method
    public String billsPayable()
    {
        remainingAmount = (this.getCourseDuration() - numOfMonthsAttended) * this.getTuitionFee();
        
        hasPaid = true;
        String remainingFeeMessage = "The remaining amount of Rs. " + remainingAmount + " has been cleared.";
        
        return remainingFeeMessage;
    }
    
    //removeStudent method
    public String removeStudent()
    {
        String removedStudentMessage = "";
        if (hasPaid) {
            this.setDateOfBirth("");
            this.setCourseName("");
            this.setStudentName("");
            this.setDateOfEnrollment("");
            
            dateOfDropout = "";
            
            this.setTuitionFee(0);
            this.setCourseDuration(0);
            this.setEnrollmentID(0);
            
            numOfRemainingModules = 0;
            numOfMonthsAttended = 0;
            remainingAmount = 0;
            
            removedStudentMessage = "Successfully removed dropout student.";
        }
        
        else {
            removedStudentMessage = "All bills not cleared";
        }
        
        return removedStudentMessage;
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
        +"Tuition Fee: " + this.getTuitionFee() + "\n";*/

        displayInfo += "Number of Remaining Modules: " + numOfRemainingModules + "\n"
        + "Number of Months Attended: " + numOfMonthsAttended + "\n"
        + "Date of Dropout: " + dateOfDropout + "\n"
        + "Remaining Amount: " + remainingAmount + "\n";
        
        return displayInfo;
    }
}