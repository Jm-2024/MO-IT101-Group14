package motorph;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class EmployeesData {
		
	private static boolean foundAttendance;
	public static void main(String[] args) throws FileNotFoundException {
		

			try (Scanner scan = new Scanner (System.in)) {
				File myObj = new File ("C:\\Users\\Dell_i5\\Downloads\\4th CSV File - Employee Details.csv");
				System.out.println("Enter Your Employee Number");
				String employeenumber = scan.nextLine();
				
				try {
					Scanner scan1 = new Scanner (myObj);
					boolean foundEmployee =false;
					
					while (scan1.hasNextLine()) {
					 String line = scan1.nextLine();
					 String[] fields = line.split(",");
					 
					 if (fields.length > 0 && fields[0].equals(employeenumber)) {
						 foundEmployee = true;
						 displayEmployeeDetails(fields);
						 break;
					 }
					}
					
					 if (!foundEmployee) {
						 System.out.println("Employee not found");
					 } else {
						 System.out.println("Enter the date (mm/dd/yy): ");
						 String input_Date = scan.nextLine();
						 
						 boolean found_Attendance = false;
						 
						 scan1 = new Scanner(myObj);
						 
						   while (scan1.hasNextLine()) {
						   String line = scan1.nextLine();
						   String[] fields = line.split(",");
						   
						   
						   if (fields.length > 0 && fields[0].equals(employeenumber)&& fields.length >20 && fields[20].equals(input_Date)) {
							   System.out.println();
							   System.out.println("Date Input: " + fields[20]);
							   System.out.println("Time in: " + fields[21]);
							   System.out.println("Time out: " + fields[22]);
							   
							   float totalWorkingHours = calculateTotalWorkingHours(fields[21], fields[22]);
				               System.out.println("Total Working Hours: " + fields[23]);
				               
				     System.out.println("=========================Salary=======================================");
				            
				                        System.out.println("workedhours: " + fields[23]);
							System.out.println("hourlyrate: " + fields[18]);
							System.out.println("Rice Subsidy: " + fields[14]);
							System.out.println("Phone Allowance: " + fields[15]);
							System.out.println("Clothing Allowance: " + fields[16]);
							System.out.println();
							System.out.println("My Salary: " + fields[28]);
				               
				               
				               foundAttendance = true;
				               break;
						   }
						  }
						   
						  if (!foundAttendance) {
							  System.out.println("Error Date!");
						  }
					     }
					 
					 scan1.close();
					 } catch (FileNotFoundException e) {
						 e.printStackTrace();
				 }
			}
			}
			
			 private static LocalDate parseDate(String inputDate) {
			        DateTimeFormatter[] formatters = {
			                DateTimeFormatter.ofPattern("M/d/yyyy"),
			                DateTimeFormatter.ofPattern("MM/d/yyyy"),
			                DateTimeFormatter.ofPattern("M/dd/yyyy"),
			                DateTimeFormatter.ofPattern("MM/dd/yyyy")
			        };

			        for (DateTimeFormatter formatter : formatters) {
			            try {
			                return LocalDate.parse(inputDate, formatter);
			            } catch (Exception e) {
			             
			            }
			        }
			        return null;
		}

		private static float calculateTotalWorkingHours(String string, String string2) {
			return 0;
		}

		private static void displayEmployeeDetails(String[] fields) {
			System.out.println("==============================================");
	    	System.out.println("             EMPLOYEE DETAILS:");
	    	System.out.println("Employee Number: " + fields[0] + "\t\tBirthday: " + fields[3]);
	    	System.out.println("First Name: " + fields[2] + "\t\tLast Name: " + fields[1]);
	    	System.out.println("Address: " + fields[4]);
	    	System.out.println("Phone Number: " + fields[5]);
	    	System.out.println("\n==============================================");

	    	System.out.println("EMPLOYEE IDENTIFICATION NUMBERS:");
	    	System.out.println("SSS #: " + fields[6]);
	    	System.out.println("Philhealth #: " + fields[7]);
	    	System.out.println("TIN #: " + fields[8]);
	    	System.out.println("Pag-ibig #: " + fields[9]);

	    	System.out.println("\n===================================================");

	    	System.out.println("JOB DETAILS:");
	    	System.out.println("Status: " + fields[10]);
	    	System.out.println("Position: " + fields[11]);
	    	System.out.println("Immediate Supervisor: " + fields[12]);
	    	System.out.println("\n===================================================");
		}
		
	        private static float calculateTotalWorkingHours1(String timeIn, String timeOut) {
	            // Split timeIn and timeOut into hours and minutes
	            String[] timeInParts = timeIn.split(":");
	            String[] timeOutParts = timeOut.split(":");

	            // Convert hours and minutes to integers
	            int inHours = Integer.parseInt(timeInParts[0]);
	            int inMinutes = Integer.parseInt(timeInParts[1]);
	            int outHours = Integer.parseInt(timeOutParts[0]);
	            int outMinutes = Integer.parseInt(timeOutParts[1]);

	            // Calculate total minutes worked
	            int totalMinutes = (outHours * 60 + outMinutes) - (inHours * 60 + inMinutes);

	            // Convert total minutes to hours
	            float totalWorkingHours = totalMinutes / 60.0f;

	            return totalWorkingHours;
	    
	        	
	        }
	    }
