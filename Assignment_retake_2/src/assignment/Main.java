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
	
//		Employee emp1 = new Employee("Frank", "De Tank", "Bioinformaticion", 9);
//		System.out.println(emp1);
//
//		Genome gen1 = new Genome("GenL", "AAAGAGAGAAAATTTGAAAA");
//		System.out.println(gen1);

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

		//ArrayList<String> bioinformaticians = employeeRepository.getBioinformaticians();
		// ArrayList<String> technicalSupport =
		// employeeRepository.getTechnicalSupport();
		// ArrayList<String> teamLeads = employeeRepository.getTeamlead();
		//
		GenomeRepository GenomeRepo = new GenomeRepository(genomeList);
		GenomeRepo.getSpecificGenome(1);
		System.out.println("specific genome at index 0: " + GenomeRepo.getSpecificGenome(0));
		
		
		String snpAlignment2 = GenomeRepo.displaySNPAlignment();
	// Uncomment to get the full SNP Alignment	
	//	System.out.println("SNP Alignment:\n" + snpAlignment2);
		
		GenomeRepository repository = new GenomeRepository(genomeList);
		String alignment_at_index = repository.calculateSNPAlignmentForIndex(2);
		System.out.println(alignment_at_index);
		
		List<String> matchingGenomes = repository.searchGenomesForSequence("AA");
		System.out.println("Matching Genomes" + matchingGenomes);

		
		
        // Call the calculateSNPAlignment() method
	//	GenomeRepository2 GenomeRepo2 = new GenomeRepository2(genomeMap);
    //    String snpAlignment = GenomeRepo2.calculateSNPAlignment();
    //    System.out.println("SNP Alignment:");
    //    System.out.println(snpAlignment);
		//
		// System.out.println(GenomeRepo.toString());

		// AlignmentRepository alRepo = new AlignmentRepository(GenomeRepo, null);

	}

}