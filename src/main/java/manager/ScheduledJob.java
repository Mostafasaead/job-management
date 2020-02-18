package manager;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import dto.JobName;
import dto.JobPriority;
import service.Job;

public class ScheduledJob extends TimerTask {
	private Job job;

	public ScheduledJob(Job job) {
		this.job = job;
	}

	@Override
	public void run() {
		Thread t = new Thread(job);
		t.start();
		System.out.println(Thread.currentThread().getName() + " " + job.getJobName()
				+ " the task has executed successfully " + new Date());

	}

	public static void main(String[] args) {
		Job emailJob = new Job(JobName.STREAM_FILE, JobPriority.LOW);
		ScheduledJob task = new ScheduledJob(emailJob);
		Timer timer = new Timer();
		timer.scheduleAtFixedRate(task, 0, 5 * 1000);
	}
}
