import java.util.ArrayList;
/** 
 * I represent in the Salaries class to define an ArrayList  storing the salaries of its employees.
 * Include methods that add(add the salaries of one employee), average( computes the average
 * salary for an employeesemployee),averageSalaries( generates an ArrayList storing the average
 * salaries  all ), not3TimesHigher( checks whether for each employee their average salary is not 
 * higher than three times the overall average salary of the other employees).
 * @author Ruopeng Jiang
 * @version 2019-10-28
 */
public class Salaries {
    /** 
     *  Field variable for the salaries of its employees. 
     */
	private ArrayList<double[]> allSalaries;// stores the salaries of its employees
    /** 
     *  Constructor to set values to the field variables
     *  @param allSalaries the salaries of its employees.
     */
	public Salaries(ArrayList<double[]> allSalaries) {
		super();
		this.allSalaries = allSalaries;
	}
    /**
     *  Method to create an initially empty ArrayList
     */
	public Salaries() {
		allSalaries= new ArrayList<double[]>();
	}
    /**
     *  Method to  add the salaries of one employee to the field variable allSalaries
     *  @param employeeSalaries One employee salaries in a year.
     */
	public void add(double[] employeeSalaries) {
		allSalaries.add(employeeSalaries);
	}
    /**
     *  Method to compute the average salary for an employee
     *  @param employeeSalaries One employee salaries in a year.
     *  @return the average salary for an employee.
     */
	public static double average(double[] employeeSalaries) {
		 double total=0;int month=0;
		 for(int i=0;i<employeeSalaries.length;i++) {
			 if (employeeSalaries[i]>0) {
				 total+=employeeSalaries[i];
				 month++;
			 }
			 }
		 if (total==0) {
			 throw new IllegalArgumentException("all values in the employeeSalaries array are zero.");
		 }
	return total/month;
	}
    /**
     *  Method to  generate an ArrayList storing the average salaries 
     *  of all employees that have at least one non-zero monthly salary.
     *  @return the Arraylist storing all employees average salaries.
     */
	public ArrayList<Double> averageSalaries(){
		ArrayList<Double> averageSalaries = new ArrayList<Double>();
        for(int i=0;i<allSalaries.size();i++) {
        	try {
        		double averageEmployee=average(allSalaries.get(i));
        		averageSalaries.add(averageEmployee);
        	}catch(IllegalArgumentException e) {
        		System.out.println("There is something wrong with input");
        	}      	
		}
        return averageSalaries;
	}
    /**
     *  Method to check whether for each employee with at least one
  	 *	non-zero monthly salary their average salary is not higher than 
  	 *  three times the overall average salary of the other employees.
     *  @return the boolean that whether the employee salaries over three times than others.
     */
	public boolean not3TimesHigher() {
		ArrayList<Double> temp=averageSalaries();
		for(int i=0;i<temp.size();i++) {
			double selectOne= temp.get(i);//choose the select employee
			temp.remove(i);//remove the select one's salary
			double[] otherEmployees=new double[temp.size()];
			for(int j=0;j<otherEmployees.length;j++) {
				otherEmployees[j]=temp.get(j);
			}
			temp.add(i,selectOne);//add the salary whose selected last time.
			try{
				if(selectOne>(average(otherEmployees)*3)) {
				return false;
			}
			}catch(IllegalArgumentException e) {
				System.out.println("There is something wrong with input");
			}
		}
	    return true;
	}
}
