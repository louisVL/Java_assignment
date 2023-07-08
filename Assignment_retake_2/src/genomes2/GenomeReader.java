package genomes2;

import assignment.FileType;
import assignment.Reader;
import genomes2.Genome;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;


public class GenomeReader implements Reader {
	private String filePath;
	private ArrayList<Genome> genomeList = new ArrayList<Genome>();
	private String genomeDescription;
	private String genomeSequence;

	public GenomeReader(String filePath) {
		this.filePath = filePath;
	}

	@Override
	public ArrayList<Genome> readFileToList() {

		try {
			Path currentRelativePath = Paths.get("");
			String s = currentRelativePath.toAbsolutePath().toString();
			String fileLocation1 = s + File.separator + "src" + File.separator + filePath;

			File file1 = new File(fileLocation1 + "." + "fasta");
			Scanner sc1 = new Scanner(file1);
			// System.out.println(fileLocation1);

			while (sc1.hasNextLine()) {
				genomeDescription = sc1.nextLine();
				genomeSequence = sc1.nextLine();
				Genome genome = new Genome(genomeDescription, genomeSequence);
				if (!genomeList.contains(genome)) {
			        System.out.println(genome.toString());
			        genomeList.add(genome);// Print using toString() method

				}
			}


		} catch (FileNotFoundException e) {
			// Handle the error if the file is not found
			System.out.println("Error: File not found.");

		} catch (SecurityException e) {
			System.out.println("Security exception: " + e.getMessage());
		} catch (IOException e) {
			System.out.println("IO exception: " + e.getMessage());
		} catch (NoSuchElementException e) {
			System.out.println("No such element exception: " + e.getMessage());
		} catch (IllegalStateException e) {
			System.out.println("Illegal state exception: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("An unexpected error occurred: " + e.getMessage());
		}
		// System.out.println("\"output from GenomeReader\" " + genomeList.toString());
		//System.out.println("\"output from genomeReader\" " + genomeList);

		return genomeList;

	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public ArrayList<Genome> getGenomeList() {
		return genomeList;
	}

	public void setGenomeList(ArrayList<Genome> genomeList) {
		this.genomeList = genomeList;
	}

	public String getGenomeDescription() {
		return genomeDescription;
	}

	public void setGenomeDescription(String genomeDescription) {
		this.genomeDescription = genomeDescription;
	}

	public String getGenomeSequence() {
		return genomeSequence;
	}

	public void setGenomeSequence(String genomeSequence) {
		this.genomeSequence = genomeSequence;
	}
	
	@Override
	public String toString() {
	    return String.format("%s has the following structure: %s", genomeDescription, genomeSequence);
	}


}
