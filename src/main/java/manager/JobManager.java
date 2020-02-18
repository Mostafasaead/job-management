package manager;

import java.util.Comparator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.PriorityBlockingQueue;

import service.Job;

public class JobManager {
	private ExecutorService priorityJobPoolExecutor;
	private ExecutorService priorityJobScheduler = Executors.newSingleThreadExecutor();
	private PriorityBlockingQueue<Job> priorityQueue;

	public JobManager(Integer poolSize, Integer queueSize) {
		priorityJobPoolExecutor = Executors.newFixedThreadPool(poolSize);
		priorityQueue = new PriorityBlockingQueue<Job>(queueSize, Comparator.comparing(Job::getJobPriority));
		priorityJobScheduler.execute(() -> {
			while (true) {
				try {
					priorityJobPoolExecutor.execute(priorityQueue.take());
				} catch (InterruptedException e) {
					// exception needs special handling
					break;
				}
			}
		});
	}

	public void scheduleJob(Job job) {
		priorityQueue.add(job);
	}
}
