package Reader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FastaReader {
    
    public static List<String> readGenomesFromFile(String filename) {
        List<String> genomes = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("C:/Users/louis.vanlooy_publiq/eclipse-workspace/Assignment_retake_2/src/hiv.fasta"))) {
            String line;
            StringBuilder genomeBuilder = new StringBuilder();
            while ((line = br.readLine()) != null) {
                if (line.startsWith(">")) {
                    // If the line starts with ">", it is a genome identifier line
                    // Add the previous genome to the list and start building a new one
                    if (genomeBuilder.length() > 0) {
                        genomes.add(genomeBuilder.toString());
                        genomeBuilder = new StringBuilder();
                    }
                } else {
                    // Otherwise, it is a nucleotide sequence line
                    genomeBuilder.append(line);
                }
            }
            // Add the last genome to the list
            if (genomeBuilder.length() > 0) {
                genomes.add(genomeBuilder.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return genomes;
    }

//    public static void main(String[] args) {
//        List<String> genomes = readGenomesFromFile("C:/Users/louis.vanlooy_publiq/eclipse-workspace/Assignment_retake_2/src/hiv.fasta\"");
//        // Do something with the genomes
//        System.out.println(genomes); 
//        System.out.println(genomes); 

  //  }
    
}