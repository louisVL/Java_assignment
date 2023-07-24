package genomes;

import assignment.FileType;
import assignment.Reader;
import genomes.Genome;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class GenomeReader implements Reader {
	private String fileName;
	private ArrayList<Genome> genomeList = new ArrayList<Genome>();

	public GenomeReader(String fileName) {
		this.fileName = fileName;
	}

	@Override
	public ArrayList<Genome> readFileToList() {

		Path currentRelativePath = Paths.get("");
		String absolutePath = currentRelativePath.toAbsolutePath().toString();
		String fileLocation = absolutePath + File.separator + "src" + File.separator + fileName;

		File inputFile = new File(fileLocation + "." + FileType.fasta.name().toLowerCase());
		Scanner scanner = null; // Declare the scanner outside the try block

		try {
			scanner = new Scanner(inputFile);

			while (scanner.hasNextLine()) {
				String genomeDescription = scanner.nextLine();
				String genomeSequence = scanner.nextLine();
				Genome genome = new Genome(genomeDescription, genomeSequence);
				if (!genomeList.contains(genome)) {
					genomeList.add(genome);// Print using toString() method

				}
			}

		} catch (FileNotFoundException e) {
			System.out.println("Error: File not found.");
		} catch (SecurityException e) {
			System.out.println("Security exception: " + e.getMessage());
		} catch (NoSuchElementException e) {
			System.out.println("No such element exception: " + e.getMessage());
		} catch (IllegalStateException e) {
			System.out.println("Illegal state exception: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("An unexpected error occurred: " + e.getMessage());
		}
		// System.out.println("\"output from GenomeReader\" " + genomeList.toString());
		// System.out.println("\"output from genomeReader\" " + genomeList);
		finally {
			// Close the Scanner here in the finally block.
			// This ensures the Scanner is always closed, even if an exception occurs.
			if (scanner != null) {
				scanner.close();
			}
		}
		System.out.println("size of list should be (100): " + genomeList.size());
		return genomeList;

	}

	public String getFilePath() {
		return fileName;
	}

	public void setFilePath(String filePath) {
		this.fileName = filePath;
	}

	public ArrayList<Genome> getGenomeList() {
		return genomeList;
	}

	public void setGenomeList(ArrayList<Genome> genomeList) {
		this.genomeList = genomeList;

	}

}
