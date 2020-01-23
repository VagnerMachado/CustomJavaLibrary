package rollingHashSearch;

public class RollingSearch 
{
	String hayStack;
	String needle;

	public RollingSearch(String h, String n)
	{
		hayStack = h;
		needle = n; 
	}

	public int find()
	{
		int result = -1;
		char lastNeedle = needle.charAt(needle.length() - 1);

		//figure a starting point
		int index = hayStack.indexOf(lastNeedle, needle.length() - 1);
		if(index == -1)
			return -1;
		System.out.println("Chunk: " + hayStack.substring(index + 1 - needle.length(), index + 1));
		if(needle.equals(hayStack.substring(index + 1 - needle.length(), index + 1)))
			return index - needle.length() + 1;

		//loop through the rest
		for(int i =  index; i < hayStack.length(); i ++)
		{
			index = hayStack.indexOf(lastNeedle,index + 1);
			if(index == -1)
				return -1;
			System.out.println("Chunk: " + hayStack.substring(index + 1 - needle.length(), index + 1));
			if(needle.equals(hayStack.substring(index + 1 - needle.length(), index + 1)))
				return index - needle.length() + 1;
		}

		return result;
	}
}