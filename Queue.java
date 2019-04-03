import java.util.*;
import java.io.*;

class Event {
	private String status, name;
	private double cgpa;
	private int token;

	Event(String status, String name, double cgpa, int token) {
		setStatus(status);
		setName(name);
		setCGPA(cgpa);
		setToken(token);
	}

	String getStatus() { return this.status; }
	String getName() { return this.name; }
	double getCGPA() { return this.cgpa; }
	int getToken() { return this.token; }
	
	void setStatus(String status) { this.status = status; }
	void setName(String name) { this.name = name; }
	void setCGPA(double cgpa) { this.cgpa = cgpa; }
	void setToken(int token) { this.token = token; }


	@Override
    public String toString() { return name; }
}

class Queue
{
	public static class StudentComparator implements Comparator<Event>{ 
		@Override
        public int compare(Event s1, Event s2)
		{
			if(s1.getCGPA() < s2.getCGPA())
			{
				return 1;
			}
			else if(s1.getCGPA() == s2.getCGPA())
			{
				if(s1.getName().equals(s2.getName()))
				{
					if(s1.getToken() > s2.getToken())
					{
						return 1;
					}
					else
					{
						return -1;
					}
				}
				else
				{
					return 0;
				}
			}
			else
			{
				return -1;
			}
        }
    }

	public static void main(String[] args) throws IOException 
	{
		BufferedReader br = new BufferedReader(new InputStreamReader (System.in));
		int n = Integer.parseInt(br.readLine());
		String task[][] = new String[n][4];
		PriorityQueue<Event> student_queue = new PriorityQueue<Event>(n, new StudentComparator());

		for (int i=0; i<n; i++)
		{
			task[i] = br.readLine().split(" ");
			if (task[i][0].equals("ENTER")) 
			{
				student_queue.add(new Event(task[i][0], task[i][1], Double.parseDouble(task[i][2]), Integer.parseInt(task[i][3])));
			}
			else 
			{
				student_queue.poll();
			}
		}

		if (!student_queue.isEmpty()) 
		{
			while (!student_queue.isEmpty()) 
			{ 
				System.out.println(student_queue.poll());
			}
		}
		else
		{
			System.out.println("EMPTY");
		}
	}
}