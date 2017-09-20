package genefind;

public class Part2 {

	 public String findSimpleGene(String dna,String startCodon,String stopCodon)
	    {
	        String result = "" ;
	        int startIndex = dna.indexOf(startCodon);
	        if(startIndex==-1)
	            return "" ;
	        int stopIndex = dna.indexOf(stopCodon,startIndex+3)+3;
	        if(stopIndex==-1)
	            return "" ;
	        else
	        {
	            if((stopIndex-startIndex)%3==0)
	                result = dna.substring(startIndex,stopIndex);
	        }
	        return result;
	    }
	    void testSimpleGene()
	    {
	    	
	        String dna = "CGTAAATGTAATCAT";
	        String gene = findSimpleGene(dna,"ATG","TAA") ;
	        System.out.println("DNA Strand: "+dna+"\nGene: "+gene);
	        dna = "CGTATGTCAT";
	        gene = findSimpleGene(dna,"ATG","TAA") ;
	        System.out.println("DNA Strand: "+dna+"\nGene: "+gene);
	        dna = "CGAAAGTATCAT";
	        gene = findSimpleGene(dna,"ATG","TAA") ;
	        System.out.println("DNA Strand: "+dna+"\nGene: "+gene);
	        dna = "CGTATGTAATCATAACG";
	        gene = findSimpleGene(dna,"ATG","TAA") ;
	        System.out.println("DNA Strand: "+dna+"\nGene: "+gene);
	        dna = "CGTATGAATAACACG";
	        gene = findSimpleGene(dna,"ATG","TAA") ;
	        System.out.println("DNA Strand: "+dna+"\nGene: "+gene);
	    }
	public static void main(String[] args) {
		Part1 gene = new Part1();
    	gene.testSimpleGene();
	}

}
