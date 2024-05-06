package cleaning.service;
import cleaning.model.Cleaner;
import cleaning.model.JobToCleaner;




import java.io.*;
import java.util.*;

public class CleaningService {
    private List<Cleaner> cleaners;
    private List<JobToCleaner> jobs;

    private static final String ALL_CLEANERS = " allCleanersInfo.txt";// File to store all cleaners info

    public CleaningService() {

        this.cleaners = new ArrayList<>();
        this.jobs = new ArrayList<>();

    }

    public void addNewCleaner(String name,String address, String contactInfo, int ID) {
        Cleaner newCleaner = new Cleaner(name, address, contactInfo, ID);
        cleaners.add(newCleaner);
        System.out.println("New cleaner added: " + newCleaner);
}

    public void assignJobToCleaner  (int ID, String jobDescription, int cleanerID ) {
        JobToCleaner newJob = new JobToCleaner(ID, jobDescription, cleanerID );
        if (cleaners.isEmpty()) {
            System.out.println("No cleaners available to assign job to. Please add a cleaner" );
            return;
        }

        boolean cleanerExists = cleaners.stream().anyMatch(cleaner -> cleaner.getID() == cleanerID);
        if (!cleanerExists) {
            System.out.println("Cleaner with ID " + cleanerID + " does not exist. Please add a cleaner" );
            return;
        }

                jobs.add(newJob);
        System.out.println("Job assigned to cleaner: " + cleanerID ); // Print the job assigned to the cleaner

        try {
            FileWriter fileWriter = new FileWriter(ALL_CLEANERS, true);   // Set to true to append to the file
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(newJob.toString()); // Write the new job to the file
            bufferedWriter.newLine();
            bufferedWriter.close();

        } catch (IOException e) {
            e.printStackTrace(); // Print the exception
        }


}

    public List<JobToCleaner> viewAssignedJobs() {
        return jobs; // Return the list of jobs
    }

    public List<Cleaner> viewAvailableCleaners() {
        return cleaners;

        // Return the list of cleaners

    }

    public void removeCleaner(int cleanerIDToRemove) {
        for (Cleaner cleaner : cleaners) {
            if (cleaner.getID() == cleanerIDToRemove) {

                cleaners.remove(cleaner);
                if (cleaners.isEmpty()) {
                    System.out.println("No cleaners available to remove. Please add a cleaner" );
                    return;
                }
                System.out.println("Cleaner removed: " + cleaner);

                break;
            }
        }
    }
}
