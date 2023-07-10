package assignment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import alignments.AlignmentRepository;
import employees.EmployeeReader;
import employees.EmployeeRepository;
import employees.Employee;
import genomes2.Genome;
import genomes2.GenomeReader;
import genomes2.GenomeReader2;
import genomes2.GenomeRepository;
import genomes2.GenomeRepository2;
import assignment.FileType;
import assignment.Reader;

public class Main {

	public static void main(String[] args) {
	


		ArrayList<Employee> employeeList = new EmployeeReader("team").readFileToList();
		ArrayList<Genome> genomeList = new GenomeReader("hiv").readFileToList();
		ArrayList<String> bioinformaticians;
		System.out.println("genomeList: " + genomeList.toString());

//		GenomeReader2 genomeReader = new GenomeReader2("hiv");
//		HashMap<String, Genome> genomeMap = genomeReader.readFileToMap();
//
//		for (Map.Entry<String, Genome> entry : genomeMap.entrySet()) {
//			String genomeDescription = entry.getKey();
//			Genome genome = entry.getValue();
//
//			System.out.println("Genome Description: " + genomeDescription);
//			System.out.println("Genome Sequence: " + genome.getGenName());
//			System.out.println();
//		}
//		
//		   // Call the getGenomeDescriptionAtIndex() and getGenomeNameAtIndex() methods
//        int index = 0;
//        String genomeDescription = genomeReader.getGenomeDescriptionAtIndex(index);
//        String genomeName = genomeReader.getGenomeNameAtIndex(index);

//        System.out.println("Genome at index " + index + " : ");
//        System.out.println("Description of index  " + index + " : "  + genomeDescription);
//        System.out.println("Name: " +  index + " " + genomeName);
//		
		
		
		// Create an instance of EmployeeRepository and retrieve the bioinformaticians
		EmployeeRepository employeeRepository = new EmployeeRepository(employeeList);
		bioinformaticians = employeeRepository.getBioinformaticians();
		System.out.println(bioinformaticians);
		
		GenomeRepository genomeRepo = new GenomeRepository(genomeList);
		genomeRepo.getSpecificGenome(1);
		System.out.println("specific genome at index 0: " + genomeRepo.getSpecificGenome(0));
		
		

		String alignment_at_index = genomeRepo.calculateSNPAlignmentForIndex(2);
		System.out.println(alignment_at_index);
		
		List<String> matchingGenomes = genomeRepo.searchGenomesForSequence("AA");
		System.out.println("Matching Genomes" + matchingGenomes);
		
		genomeRepo.replaceSequenceInGenome(0, "TTTCCTGC", "TTTGGGAA");

		// Access the updated genome
		Genome updatedGenome = genomeRepo.getSpecificGenome(0);
		String updatedSequence = updatedGenome.getGenStructure();
		System.out.println(updatedSequence);
		
		
		genomeRepo.addGenomeToRepository("GenomeC", "TACGTAGC");

		// Access the updated genomeList
		ArrayList<Genome> updatedGenomeList = genomeRepo.getGenomeList();
		for (Genome genome : updatedGenomeList) {
		    System.out.println(genome.getGenName() + ": " + genome.getGenStructure());
		    
		}
		System.out.println("size after adding:  " + updatedGenomeList.size());
		
	//	repository.removeGenomeFromRepository(0);
	//	for (Genome genome : updatedGenomeList) {
	//	    System.out.println(genome.getGenStructure() + ": " + genome.getGenStructure());
		}
//		System.out.println("size after removing: " + updatedGenomeList.size());


	
}