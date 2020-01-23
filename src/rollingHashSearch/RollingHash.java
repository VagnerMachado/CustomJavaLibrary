package rollingHashSearch;

public class RollingHash
{
	String hayStack;
	String needle;

	public RollingHash(String h, String n)
	{
		hayStack = h;
		needle = n; 
	}

	public int find()
	{
		int result = -1;
		int needleHash = 0;

		//the Needle Hash
		for( int i = 0; i < needle.length(); i++)
			needleHash += (int)needle.charAt(i);
		System.out.println("Needle Hash: " + needleHash);


		int rollingHash = 0;

		//initial Rolling Hash
		for(int j = 0; j < needle.length(); j++)
		{
			rollingHash += (int)hayStack.charAt(j);	
		}

		//iterate thrugh the hayStack
		for (int i = 0; i < hayStack.length() - needle.length() + 1; i ++)
		{
			System.out.println("Rolling Hash for " + hayStack.substring(i, i + needle.length()) + " is " + rollingHash);
			//System.out.println("Needle Hash for " + needle + " is " + needleHash);

			//if hash matches, compare strings
			if(rollingHash == needleHash)
				if(needle.equals(hayStack.substring(i, i + needle.length())))
					return i;
			int pos = i + needle.length();
			
			if (pos > hayStack.length() -1)
				return -1;
			rollingHash = rollingHash - hayStack.charAt(i) + hayStack.charAt(pos);

		}

		return result;
	}
}

