package rollingHashSearch;

public class MainTest 
{

	public static void main(String[] args) 
	{
		RollingHash r = new RollingHash("lordcaljkddmfialslordsddcatrisidnfhcarpooling,", "lords");
		System.out.println("Rolling Hash: " + r.find());

		RollingSearch R = new RollingSearch("lordorcalordjkddmfialsslordssssddlcatriidnfhcarpooling,lords", "lords");
		System.out.println("Rolling Search: " + R.find());
	}

}
