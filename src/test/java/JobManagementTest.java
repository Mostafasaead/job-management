import org.junit.jupiter.api.Test;

import dto.JobName;
import dto.JobPriority;
import manager.JobManager;
import service.Job;

class JobManagementTest {

	private static int POOL_SIZE = 1;
	private static int QUEUE_SIZE = 10;

	@Test
	public void testJobManagerWithPriority() throws InterruptedException {
		Job emailJob_1 = new Job(JobName.SEND_EMAIL, JobPriority.LOW);
		Job emailJob_2 = new Job(JobName.SEND_EMAIL, JobPriority.MEDIUM);
		Job streamJob_1 = new Job(JobName.STREAM_FILE, JobPriority.HIGH);
		Job streamJob_2 = new Job(JobName.STREAM_FILE, JobPriority.HIGH);
		Job streamJob_3 = new Job(JobName.STREAM_FILE, JobPriority.LOW);
		Job streamJob_4 = new Job(JobName.STREAM_FILE, JobPriority.HIGH);
		Job streamJob_5 = new Job(JobName.STREAM_FILE, JobPriority.HIGH);
		JobManager pjs = new JobManager(POOL_SIZE, QUEUE_SIZE);
		pjs.scheduleJob(streamJob_1);
		pjs.scheduleJob(emailJob_1);
		pjs.scheduleJob(streamJob_2);
		pjs.scheduleJob(streamJob_3);
		pjs.scheduleJob(streamJob_4);
		pjs.scheduleJob(emailJob_2);
		pjs.scheduleJob(streamJob_5);
		Thread.sleep(10000);
		// clean up
	}

}
