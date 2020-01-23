package Utilities;

public class vmHash<K extends Comparable<K>> {

	
	public int hashcode(K x) {
		String k = (String) x;
		int hash = 0;
		for(int i = 0; i < 4; i++)
		{
			hash |= (int)k.charAt(i);
			//System.out.println("LEtter " + k.charAt(i) + " is " + Integer.toBinaryString(k.charAt(i)));
			if(i != 3)
				hash <<= 7;
		}

		int shift = 0;
		for (int i = 4; i < k.length(); i++)
		{
			hash ^= ((int)k.charAt(i) << shift);
			if (shift > 28)
				shift = 0;
			else
				shift += 6; 
			if(i == k.length() - 1)
				break;
			i++;
			int temp = (int)k.charAt(i);
			temp <<= shift;
			hash ^= temp;
			if (shift > 28)
				shift = 0;
			else
				shift += 7;
			hash >>= 1;
		}
		
		//System.out.println(Integer.toBinaryString(hash)  + "\n" + Integer.toBinaryString((Integer.MAX_VALUE << 31)));
		hash = (hash ^= Integer.MAX_VALUE << 31);
		//System.out.println(Integer.toBinaryString(hash));
		//System.out.println((int)(0xFFFFFFFF));
		//System.out.println("hash is " + hash);
		//System.out.println(Integer.toBinaryString((int)(0xFFFFFFFF)));
		//System.out.println(Integer.toBinaryString(hash));
		//System.out.println(Integer.toBinaryString(hash)  + " is \n" + Integer.toBinaryString((hash ^= Integer.MAX_VALUE << 31)));
		//System.out.println(" Final " + hash);
		return hash < 0 ? hash * -1 : hash;
		
	}

}
