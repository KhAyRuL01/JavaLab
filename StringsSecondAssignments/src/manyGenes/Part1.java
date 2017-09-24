package manyGenes;

public class Part1 {
	public int findStopCodon(String dna,int startIndex,String stopCodon)
	{
		int indx;
		indx = dna.indexOf(stopCodon,startIndex);
		if(indx==-1)
			return dna.length();
		if((indx-startIndex+stopCodon.length())%3==0)
			return indx+3;
		return dna.length();
	}
	public void testFindSopCodon()
	{
		String dna = "ATGCGTAGATGCTGA";
		int index = findStopCodon(dna,dna.indexOf("ATG"),"TGA");
		System.out.println(index);
		dna = "GCGATGCGTACATGCGATGCGGGT";
		index = findStopCodon(dna,dna.indexOf("ATG"),"GAT");
		System.out.println(index);
		index = findStopCodon(dna,dna.indexOf("ATG"),"TAA");
		System.out.println(index);
		dna = "GCGATGCGATGATGCGGGT";
		index = findStopCodon(dna,dna.indexOf("ATG"),"GAT");
		System.out.println(index);
	}
	public String findGene(String dna)
	{
		int startIndex,stopIndex,min = -1;
		startIndex = dna.indexOf("ATG");
		if(startIndex==-1)
			return "";
		stopIndex = dna.indexOf("TAA",startIndex);
		if(stopIndex!=-1 && (stopIndex-startIndex)%3==0)
			min = stopIndex;
		stopIndex = dna.indexOf("TAG",startIndex);
		if(stopIndex!=-1 && (stopIndex-startIndex)%3==0)
		{
			if(min==-1)
				min = stopIndex;
			else
			{
				if(stopIndex<min)
					min = stopIndex;
			}
		}
		stopIndex = dna.indexOf("TGA",startIndex);
		if(stopIndex!=-1 && (stopIndex-startIndex)%3==0)
		{
			if(min==-1)
				min = stopIndex;
			else
			{
				if(stopIndex<min)
					min = stopIndex;
			}
		}
		if(min!=-1)
			return dna.substring(startIndex,min+3);
		return "";
	}
	
	public void testFindGene()
	{
		String dna = "ATTAGTCGCGGGGCCC";
		System.out.println(dna);
		System.out.println(findGene(dna));
		dna = "CGTATGCCGTAAGGCC";
		System.out.println(dna);
		System.out.println(findGene(dna));
		dna = "CGGATGGGCTAATTTCCCGATGTAGG";
		System.out.println(dna);
		System.out.println(findGene(dna));
		dna = "GTTGATGCCCCCTTTTGGGGAAA";
		System.out.println(dna);
		System.out.println(findGene(dna));
	}
	public static void main(String[] args)
	{
		Part1 findManyGene = new Part1();
		findManyGene.testFindSopCodon();
		findManyGene.testFindGene();
	}
}
