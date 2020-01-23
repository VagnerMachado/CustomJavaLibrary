package priorityQueueThreeWays;

/**
 * This class was provided to us. I made a few changes to the compareTo method since I was getting 
 * random errors in ordering. Since I decided not to set a range for the random values for the
 * priority instance data, I was either getting an integer overflow or a number that was misbehaving when
 * sorting or ordering the Priority Queue holding the task. For example, lets say that I am comparing two
 * priorities and that 'this' task has Interger.MIN_VALUE value and the 'other' Task has a priority 
 * value Integer.MAX_VALUE; Returning this.priority - other.priority will be an overflow and will generate errors.
 * That is why I decided to recode the method to return -1, 0 or 1.
 * 
 * 
 * @author Adolfas Lapsys 
 * 
 * *********************************************************************************
 *   Commented by VagnerMachado  - QCID 23651127  - Queens College - Spring 2018 
 * **********************************************************************************
 * 
 */
class Task implements Comparable<Task> 
{
	public int id;
	public int priority;

	/**
	 * Task constructor - instantiates a new Task Object with random id and priorities
	 * @param j 
	 * @param i 
	 */
	public Task(int i, int p)
	{
		id = i;
		priority = p;
	}


	@Override
	/**
	 * compareTo - compares this Task to other task
	 * @return -1, 0 and 1 if this item has lower priority *VALUE*, same priority or greater priority *VALUE*
	 */
	public int compareTo(Task other)
	{
		if(priority < other.priority)
			return -1;
		else if(priority > other.priority)
			return 1;
		return 0;
	}
}

