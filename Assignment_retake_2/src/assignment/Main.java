package assignment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import alignments.GenomeRepoPerEmployee;
import alignments.SNPalignment;
import employees.Employee;
import employees.EmployeeReader;
import genomes.Genome;
import genomes.GenomeReader;

public class Main {

    public static void main(String[] args) {

        ArrayList<Employee> employeeList = new EmployeeReader("team").readFileToList();
        ArrayList<Genome> genomeList = new GenomeReader("hiv").readFileToList();

        GenomeRepoPerEmployee genomeRepoPerEmployee = new GenomeRepoPerEmployee(genomeList, employeeList);

        // Create a map to store personal alignments for each bioinformatician
        Map<String, ArrayList<Genome>> bioinformaticianAlignments = new HashMap<>();

        // Iterate through the employeeList
        for (Employee employee : employeeList) {
            if (employee.getJobTitle().equalsIgnoreCase("Bioinformatician")) {
                // Get the genome list for the current bioinformatician
                ArrayList<Genome> bioinformaticianGenomeList = genomeRepoPerEmployee.getGenomeListForBioinformatician(employee);

                // Store the personal alignment in the map
                bioinformaticianAlignments.put(employee.getFirstName() + " " + employee.getLastName(), bioinformaticianGenomeList);
            }
        }

        // Specify the bioinformatician's name or identifier here
        String bioinformaticianName = "Marc"; // Replace with the actual name or identifier

        // Find the bioinformatician based on the specified name or identifier
        Employee bioinformatician = genomeRepoPerEmployee.getBioinformaticianByName(bioinformaticianName);

        if (bioinformatician != null) {
            // Get the genome list for the bioinformatician
            ArrayList<Genome> personalAlignment = genomeRepoPerEmployee.getGenomeListForBioinformatician(bioinformatician);

            System.out.println("Bioinformatician found: " + bioinformaticianName);

            // Retrieve and display their first personal alignment
            int numGenomesToPrint = Math.min(5, personalAlignment.size());
            for (int i = 0; i < numGenomesToPrint; i++) {
                Genome genome = personalAlignment.get(i);
                System.out.println(genome.getGenName() + ": " + genome.getGenStructure());
                System.out.println("------------------------");
            }

            // Calculate SNP alignment for the specific bioinformatician
            SNPalignment snpAlignment = new SNPalignment(personalAlignment);

            List<String> alignments = snpAlignment.calculateSNPAlignment();

            // Print SNP alignments
            for (String alignment : alignments) {
                System.out.println(alignment);
            }

            // Call the searchGenomesForSequence method and print the matching genomes
            String sequenceToSearch = "AACA"; // Replace with the desired sequence
            List<String> matchingGenomes = snpAlignment.searchGenomesForSequence(sequenceToSearch);

            if (!matchingGenomes.isEmpty()) {
                System.out.println("Genomes containing the sequence " + sequenceToSearch + ": ");
                for (String genomeName : matchingGenomes) {
                    System.out.println(genomeName);
                }
            } else {
                System.out.println("No genomes contain the sequence " + sequenceToSearch);
            }

            // Add a new genome for the specific bioinformatician
            String genomeNameToAdd = "NewGenome";
            String sequenceToAdd = "ACGTACGT";
            boolean genomeAdded = snpAlignment.addGenomeToAlignment(bioinformaticianName, genomeNameToAdd, sequenceToAdd);

            if (genomeAdded) {
                System.out.println("New genome added for " + bioinformaticianName);

                personalAlignment = genomeRepoPerEmployee.getGenomeListForBioinformatician(bioinformatician);
                
                System.out.println("Updated Personal Alignment for " + bioinformaticianName + ": ");
                int startIndex = personalAlignment.size() - numGenomesToPrint;
                for (int i = startIndex; i < personalAlignment.size(); i++) {
                    Genome genome = personalAlignment.get(i);
                    System.out.println(genome.getGenName() + ": " + genome.getGenStructure());
                }

                // Remove the genome from the alignment for Marc
                String genomeNameToRemove = "NewGenome"; // Replace with the genome name to remove
                boolean genomeRemoved = snpAlignment.removeGenomeFromAlignment(bioinformaticianName, genomeNameToRemove);

                if (genomeRemoved) {
                    System.out.println("Genome " + genomeNameToRemove + " removed from the alignment for " + bioinformaticianName);
                } else {
                    System.out.println("Genome " + genomeNameToRemove + " not found in the alignment for " + bioinformaticianName);
                }

                // Specify the bioinformatician's name or identifier here
                String bioinformaticianName2 = "Yves"; // Replace with the actual name or identifier
                // Find the bioinformatician based on the specified name or identifier
                Employee bioinformatician2 = genomeRepoPerEmployee.getBioinformaticianByName(bioinformaticianName2);

                if (bioinformatician2 != null) {
                    // Get the genome list for the bioinformatician
                    ArrayList<Genome> personalAlignment2 = genomeRepoPerEmployee.getGenomeListForBioinformatician(bioinformatician2);
                    
                    // WORK TILL HERE System.out.println("perso " + personalAlignment2 );
                    System.out.println("Bioinformatician found: " + bioinformaticianName2);

                    // ... (previous code)

                    // Add a new genome for the specific bioinformatician
                    String genomeNameToAdd2 = "NewGenome";
                    String sequenceToAdd2 = "ACGTACGT";
                    boolean genomeAdded2 = snpAlignment.addGenomeToAlignment(bioinformaticianName2, genomeNameToAdd2, sequenceToAdd2);

                    if (genomeAdded2) {
                        System.out.println("New genome added for " + bioinformaticianName2);

                        // Retrieve the updated personal alignment for Yves Colpaert
                        personalAlignment2 = genomeRepoPerEmployee.getGenomeListForBioinformatician(bioinformatician2);
                        System.out.println("Updated Personal Alignment for " + bioinformaticianName2 + ": ");
                        startIndex = personalAlignment2.size() - numGenomesToPrint;
                        for (int i = startIndex; i < personalAlignment2.size(); i++) {
                            Genome genome = personalAlignment2.get(i);
                            System.out.println(genome.getGenName() + ": " + genome.getGenStructure());
                        }

                        // Update the map with the new personalAlignment2 for Yves
                        bioinformaticianAlignments.put(bioinformaticianName2, personalAlignment2);

                        // ... (rest of the code)

                        // Display the size of Personal Alignment for each bioinformatician after adding a new genome
                        for (String name2 : bioinformaticianAlignments.keySet()) {
                            personalAlignment2 = bioinformaticianAlignments.get(name2);
                            System.out.println(name2 + "'s Personal Alignment Size: " + personalAlignment2.size());
                        }
                    } else {
                        System.out.println("Genome with the same name already exists for " + bioinformaticianName2);
                    }
                } else {
                    System.out.println("Bioinformatician " + bioinformaticianName2 + " not found.");
                }
            } else {
                System.out.println("Genome with the same name already exists for " + bioinformaticianName);
            }
        } else {
            System.out.println("Bioinformatician " + bioinformaticianName + " not found.");
        }
    }
}
