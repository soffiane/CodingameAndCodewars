package interviewTests.flaminem;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @author soffiane boudissa
 * This class is meant to simulate the behavior of the ball clock
 *
 */
public class BallClock {

	/* the queue of balls */
	private static Deque<Integer> balls = new ArrayDeque<>();
	/* a copy of the initial queue of balls */
	private static Deque<Integer> initialStack = new ArrayDeque<>();
	/* the minutes indicator tack */
	private static Deque<Integer> minutes = new ArrayDeque<>();
	/* the five minutes indicator track */
	private static Deque<Integer> fiveMinutes = new ArrayDeque<>();
	/* the hour indicator track */
	private static Deque<Integer> hours = new ArrayDeque<>();
	/* the first parameter for the first computation mode */
	private static int ballStackSize = 0;
	/* the second parameter for the second computation mode */
	private static int minutesLimit = 0;

	public static void main(String[] args) {

		/* check args */
		if (args.length != 1 && args.length != 2) {
			throw new IllegalArgumentException("At least one parameter (max two parameters)");
		}
		try {
			/* retrieving values from args */
			if (Integer.valueOf(args[0]) < 27 || Integer.valueOf(args[0]) > 127) {
				throw new IllegalArgumentException("Queue size needs to be between 27 and 127");
			}
			if(args[0] != null && Integer.valueOf(args[0]) > 0) {
				ballStackSize = Integer.valueOf(args[0]);
			}
			if(args.length > 1 && args[1] != null && Integer.valueOf(args[1]) > 0) {
				minutesLimit = Integer.valueOf(args[1]);
			}
			for (int i = 2; i <= Integer.valueOf(args[0]); i++) {
				balls.add(i);
				initialStack.add(i);
			}
			/*always a ball in the hours stack*/
			hours.add(1);
			/* the thread */
			Runnable runnable = new BallClockThread();
			Thread thread = new Thread(runnable);
			thread.start();
			
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("Args need to be numbers");
		}
	}

	/**
	 * Emptying min, fiveMin or hours stack when full
	 * @param queue the indicator track to empty
	 * @param nbElements the size of the indicator track
	 */
	public static void emptyStack(Deque<Integer> queue, int nbElements) {
		for (int i = 0; i < nbElements; i++) {
			balls.add(queue.removeLast());
		}
	}

	/**
	 * Display current time on the ball clock
	 */
	public static void displayTime() {
		System.out.println("{\"Min\" :" + minutes.toString() + ",\"FiveMin\" :" + fiveMinutes.toString() + ",\"Hours\" :"
				+ hours.toString() + ",\"Main\" :" + balls.toString() + "}");
	}

	/**
	 * @author soffiane
	 * The ball clock algorithm
	 *
	 */
	public static class BallClockThread extends Thread {
		private volatile boolean running = true;

		/**
		 * method to stop current thread
		 */
		public void stopThread() {
			this.running = false;
		}

		@Override
		public void run() {
			/* counter for minutes elapse during the program */
			int numberOfminutes = 0;
			while (running) {
				displayTime();
				numberOfminutes++;
				/* if the minute indicator track has already 4 balls */
				if (minutes.size() == 4) {
					/* we put balls from the minute indicator track back to the queue of balls */
					emptyStack(minutes, 4);
					/* if the fiveMin indicator track has already 11 balls */
					if (fiveMinutes.size() == 11) {
						/* we remove balls from the fiveMin indicator track back to the queue of balls */
						emptyStack(fiveMinutes, 11);
						/* if the hour indicator track has already 12 balls */
						if (hours.size() == 12) {
							/* we remove balls from the hours indicator track back to the queue of balls except the first one */
							emptyStack(hours, 11);
						/* else we move the ball to the hour indicator track */
						} else {
							hours.add(balls.removeFirst());
						}
					/* else we move the ball to the fiveMin indicator track */
					} else {
						fiveMinutes.add(balls.removeFirst());
					}
				/* else we move the ball to the minute indicator track */
				} else {
					minutes.add(balls.removeFirst());
				}
				try {
					Thread.sleep(100);
				} catch (InterruptedException ex) {
					Thread.currentThread().interrupt();
				}
				/* the program stops if the limit is reached */ 
				if(minutesLimit > 0 && minutesLimit == numberOfminutes ) {
					System.out.println("Output for the Sample Input");
					displayTime();
					stopThread();
				}
				/* or the clock stops when the ball stack returns to its initial ordering */
				if(Arrays.equals(balls.toArray(), initialStack.toArray())) {
					System.out.println(ballStackSize+" balls cycle after "+numberOfminutes/1440+" days.");
					stopThread();
				}
				System.out.println("elapsed time : "+numberOfminutes+" minutes");
			}
		}
	}
}
