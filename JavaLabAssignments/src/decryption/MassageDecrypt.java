package decryption;

public class MassageDecrypt {
	public static void decryptAMassage(String string,int key)
	{
		char character;
		int tmp;
		for(int i=0;i<string.length();i++)
		{
			character = string.charAt(i);
			tmp = (int)character;
			if(tmp<90)
			{
				tmp = tmp-65+key;
			}
			else
			{
				tmp = tmp-97+key;
			}
			//System.out.print(tmp);
			tmp = tmp%26;
			if((int)character<=90 && (int)character>=65)
				System.out.print((char)(65+tmp));
			else if((int)character<=122 && (int)character>=97)
				System.out.print((char)(97+tmp));
			else
				System.out.print(character);
		}
	}
	public static void main(String[] args)
	{
			String string = "abCDX./yz/";
		MassageDecrypt object = new MassageDecrypt();
		MassageDecrypt.decryptAMassage(string,3);
	}
}
