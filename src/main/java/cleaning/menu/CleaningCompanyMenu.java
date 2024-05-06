package cleaning.menu;

import cleaning.model.Cleaner;
import cleaning.model.JobToCleaner;
import cleaning.service.CleaningService;


import java.util.*;



public class CleaningCompanyMenu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CleaningService cleaningService = new CleaningService();

        // Display menu and Welcome message
        System.out.println("Welcome to UiFLY Cleaning Company!");
        System.out.println("====================================");
        System.out.println("Select: 1. Add new cleaner");
        System.out.println("Select: 2. Assign job to cleaner");
        System.out.println("Select: 3. View assigned jobs");
        System.out.println("Select: 4. View Available Cleaners");
        System.out.println("Select: 5. Remove Cleaner");
        System.out.println("Select: 6. Exit");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt(); // Read user choice
        scanner.nextLine();         // Consume newline character
        System.out.println();

        // Process user choice
        while (choice != 6) { // Exit loop if choice is 6
            switch (choice) { // Process user choice
                case 1:
                    System.out.print("Enter cleaner name: ");
                    String name = scanner.nextLine(); // Read cleaner name
                    System.out.print("Enter Address: ");
                    String address = scanner.nextLine(); // Read cleaner address
                    System.out.print("Enter contact info (Phone, Email): ");
                    String contactInfo = scanner.nextLine(); // Read cleaner contact info
                    System.out.print("Cleaner iD: ");
                    int ID = scanner.nextInt(); // Read cleaner ID
                    cleaningService.addNewCleaner(name,address, contactInfo, ID);

                    System.out.println(name + address + contactInfo + ID);

                    break; // Exit switch statement


                case 2:
                    System.out.println("Enter job details to assign to cleaner:");
                    System.out.print("Enter job ID: ");
                    int jobId = scanner.nextInt(); // Read job ID
                    scanner.nextLine(); // Consume newline character
                    System.out.print("Enter job description: ");
                    String jobDescription = scanner.nextLine(); // Read job description
                    System.out.print("Enter cleaner ID: ");
                    int cleanerID = scanner.nextInt(); // Read cleaner ID
                    cleaningService.assignJobToCleaner(jobId, jobDescription, cleanerID);

                    System.out.println(jobId + jobDescription + cleanerID);

                    break;


                case 3:
                    System.out.println("View assigned jobs");
                    List<JobToCleaner> jobs = cleaningService.viewAssignedJobs(); // Get list of jobs
                    if (jobs.isEmpty()) {
                        System.out.println("No jobs assigned yet.");
                    } else {
                        System.out.println("List of assigned jobs:");
                        for (JobToCleaner job : jobs) {
                            System.out.println(job);
                        }
                    }
                    break;

                case 4:
                    System.out.println("View Available Cleaners");
                    List<Cleaner> cleaners = cleaningService.viewAvailableCleaners(); // Get list of jobs
                    if (cleaners.isEmpty()) {
                        System.out.println("No cleaners available yet.");
                    } else {
                        System.out.println("List of available cleaners:");
                        for (Cleaner cleaner : cleaners) {
                            System.out.println(cleaner);
                        }
                    }
                    break;

                case 5:
                    System.out.println("Remove Cleaner");
                    System.out.print("Enter cleaner ID to remove: ");
                    if (cleaningService.viewAvailableCleaners().isEmpty()) {
                        System.out.println("No cleaners available to remove.");
                        break;
                    }
                    int cleanerIDToRemove = scanner.nextInt(); // Read cleaner ID
                    cleaningService.removeCleaner(cleanerIDToRemove);

                    break;






                default:
                    System.out.println("Invalid choice. Please try again.");
            }
            System.out.println("Select: 1. Add new cleaner");
            System.out.println("Select: 2. Assign job to cleaner");
            System.out.println("Select: 3. View assigned jobs");
            System.out.println("Select: 4. View Available Cleaners");
            System.out.println("Select: 5. Remove Cleaner");
            System.out.println("Select: 6. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();
        }
    }
}
