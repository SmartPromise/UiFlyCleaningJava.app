package cleaning.model;

import java.util.*;

public class JobToCleaner {
    private int jobId;
    private String jobDescription;
    private int cleanerID;

    public JobToCleaner(int jobId, String jobDescription, int cleanerID) {
        this.jobId = jobId;
        this.jobDescription = jobDescription;
        this.cleanerID = cleanerID;
    }



    @Override
    public String toString() {
        return "JobToCleaner " + "JobId: " + jobId + ", JobDescription:'"
                + jobDescription + '\'' + ", cleaner ID: '" + cleanerID + '\'' + '.';
    }
}
