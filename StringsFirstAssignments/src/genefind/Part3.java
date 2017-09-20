package genefind;

public class Part3 {
	public boolean twoOccurrences(String stringa,String stringb)
	{
		int ind = stringb.indexOf(stringa);
		if(ind!=-1)
			if(stringb.indexOf(stringa,ind)!=-1)
				return true;
		return false;
	}
	public static void main(String[] args) {
		

	}

}
