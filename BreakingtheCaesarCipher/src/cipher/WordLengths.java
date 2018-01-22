package cipher;
import edu.duke.*;
public class WordLengths 
{
	public static void main(String[] args)
	{
		WordLengths ob = new WordLengths();
		ob.testCountWordLengths();
	}
	
	public void countWordLengths(FileResource file, int[] counts)
	{
		int lenW, lenInt;
		lenInt = counts.length;
		for (String s : file.words()) 
		{
			lenW = s.length();
			if(!Character.isLetter(s.charAt(lenW-1)))
				lenW--;
			if(!Character.isLetter(s.charAt(0)))
				lenW--;
			if(lenW <= lenInt)
				counts[lenW]++;
			else
				counts[lenInt]++;
		}
	}
	
	public void testCountWordLengths()
	{
		String word[] = new String[100];
		int len;
		int counts[] = new int[32];
		FileResource fr = new FileResource("smallHamlet.txt");
		countWordLengths(fr, counts);
		for(int i = 1; i <= 31; i++)
		{
			if(counts[i] == 0)
				continue;
			if(counts[i]>1)
				System.out.print(counts[i] + " words of length " + i + ": ");
			else
				System.out.print(counts[i] + " word of length " + i + ": ");
			for (String s : fr.words()) 
			{
				len = s.length();
				if(!Character.isLetter(s.charAt(len-1)))
				{
					len--;
					s = s.substring(0,len);
				}
				if(!Character.isLetter(s.charAt(0)))
				{
					s = s.substring(1,len);
					len--;
				}
				if(len == i)
					System.out.print(s + " ");
			}
			System.out.println();
		}
		System.out.println("Most common word length is : " + indexOfMax(counts));
		
	}
	
	public int indexOfMax(int[] values)
	{
		int max = 0, indx = 0;
		for(int i = 1; i < values.length; i++)
		{
			if(values[i] > max)
			{
				indx = i;
				max = values[i];
			}
		}
		return indx;
	}

}
