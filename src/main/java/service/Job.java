package service;

import dto.JobName;
import dto.JobPriority;
import util.EmailUtility;
import util.JsonReaderUtility;

public class Job implements Runnable {
	private JobName jobName;
	private JobPriority jobPriority;

	public Job(JobName jobName, JobPriority jobPriority) {
		this.jobName = jobName;
		this.jobPriority = jobPriority;
	}

	@Override
	public void run() {

		// get the service name and call the service from the utility.
		try {
			switch (jobName) {
			case SEND_EMAIL:
				System.out.println("sending email job");
				EmailUtility.sendEmail();
				break;
			case STREAM_FILE:
				System.out.println("streaming file job");
				JsonReaderUtility.readJsonFromFile();
				break;
			default:
				break;
			}
		} catch (Exception e) {
			System.err.println("something went wrong, please try again later");
		}
	}

	public JobPriority getJobPriority() {
		return jobPriority;
	}
	public JobName getJobName() {
		return jobName;
	}

}
