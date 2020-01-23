package unorderedListArray;

public class TestClass 
{
public static void main (String [] args) throws IndexOutOfBoundsException, ListEmptyException
{
	UnorderedList<String> a = new UnorderedList<String>(37);
	
	a.add("pop");
	System.out.println(a.get(0));
	System.out.println(a.find("pop"));
	System.out.println(a.getSize());
	System.out.println(a.remove("pp"));
	
}
}
