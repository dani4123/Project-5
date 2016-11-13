package project5;

import java.util.Iterator;

public class StudentCollection {

	private LinkedList<Student> studentList;
	
	public StudentCollection()
	{
		studentList = new LinkedList<Student>();
	}
	
	public void addstudent(Student student)
	{
		studentList.add(student);
	}
	
	public int[] heardAndLikedAccordingTo(String title, RepresentationEnum rep)
	{
		Iterator<Student> iter = studentList.iterator();
		int[] returnArray = new int[8];
		
		switch (rep)
		{
		case HOBBY:
			
			while (iter.hasNext())
			{
				Student current = iter.next();
				if (current.hasHeard(title))
				{
					int position = 0;
					switch (current.getHobby())
					{
					case "first":
						returnArray[0]++;
						position = 1;
						break;
					case "second":
						returnArray[2]++;
						position = 3;
						break;
					case "third":
						returnArray[4]++;
						position = 5;
						break;
					case "fourth":
						returnArray[6]++;
						position = 7;
						break;
					}
					if (current.doesLike(title))
					{
						returnArray[position]++;
					}
				}
			}
			
			break;
		case MAJOR:
			
			while (iter.hasNext())
			{
				Student current = iter.next();
				if (current.hasHeard(title))
				{
					int position = 0;
					switch (current.getHobby())
					{
					case "first":
						returnArray[0]++;
						position = 1;
						break;
					case "second":
						returnArray[2]++;
						position = 3;
						break;
					case "third":
						returnArray[4]++;
						position = 5;
						break;
					case "fourth":
						returnArray[6]++;
						position = 7;
						break;
					}
					if (current.doesLike(title))
					{
						returnArray[position]++;
					}
				}
			}
			
			break;
		case REGION:
			
			while (iter.hasNext())
			{
				Student current = iter.next();
				if (current.hasHeard(title))
				{
					int position = 0;
					switch (current.getHobby())
					{
					case "first":
						returnArray[0]++;
						position = 1;
						break;
					case "second":
						returnArray[2]++;
						position = 3;
						break;
					case "third":
						returnArray[4]++;
						position = 5;
						break;
					case "fourth":
						returnArray[6]++;
						position = 7;
						break;
					}
					if (current.doesLike(title))
					{
						returnArray[position]++;
					}
				}
			}
			
			break;
		}
		
		return returnArray;
	}
}
