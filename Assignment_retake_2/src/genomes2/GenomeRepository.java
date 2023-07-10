package genomes2;

import java.util.ArrayList;
import java.util.List;

import genomes2.Genome;
import genomes2.GenomeReader;
import genomes2.GenomeRepository;

public class GenomeRepository {

	private ArrayList<Genome> genomeList;
	private String referenceSequence;
	private List<String> bioinformaticians;
	private ArrayList<String> snpAlignments;

	public GenomeRepository(ArrayList<Genome> genomeList) {
		this.genomeList = genomeList;
		this.bioinformaticians = new ArrayList<>();
		this.snpAlignments = new ArrayList<>();

	}

	public Genome getSpecificGenome(int index) {
		try {
			System.out.println("index 0 " + genomeList.get(0));
			System.out.println("index 1 " + genomeList.get(1));
			System.out.println("index given " + index + " " + genomeList.get(index));

			return genomeList.get(index);

		} catch (IndexOutOfBoundsException e) {
			System.out.println("Error: Index is out of bounds.");
			return null;
		}
	}

	public String displaySNPAlignment() {
		StringBuilder sb = new StringBuilder();

		if (!genomeList.isEmpty()) {
			Genome referenceGenome = genomeList.get(0);
			referenceSequence = referenceGenome.getGenStructure();
			System.out.println("referencegenome: " + referenceSequence);

			for (int i = 1; i < genomeList.size(); i++) {
				Genome genome = genomeList.get(i);
				String genomeSequence = genome.getGenStructure();
				String alignment = calculateSNPAlignment(referenceSequence, genomeSequence);
				sb.append(">Index: ").append(i).append("\n");
				sb.append(alignment).append("\n");
			}
		}

		return sb.toString();
	}

	public String calculateSNPAlignment(String referenceSequence, String genomeSequence) {
		StringBuilder sb = new StringBuilder();

		int refLength = referenceSequence.length();
		int genomeLength = genomeSequence.length();
		int length = Math.max(refLength, genomeLength);

		for (int i = 0; i < length; i++) {
			char referenceChar = (i < refLength) ? referenceSequence.charAt(i) : '.';
			char genomeChar = (i < genomeLength) ? genomeSequence.charAt(i) : '.';

			if (referenceChar == genomeChar) {
				sb.append(referenceChar);
			} else {
				sb.append(".");
			}
		}

		return sb.toString();
	}

	public String calculateSNPAlignmentForIndex(int index) {
		StringBuilder sb = new StringBuilder();

		if (index >= 0 && index < genomeList.size()) {
			Genome specificGenome = genomeList.get(index);
			String genomeSequence = specificGenome.getGenStructure();

			// Ensure referenceSequence is initialized
			if (referenceSequence == null) {
				Genome referenceGenome = genomeList.get(0);
				referenceSequence = referenceGenome.getGenStructure();
			}

			sb.append(">Index: ").append(index).append("\n");
			sb.append(calculateSNPAlignment(referenceSequence, genomeSequence)).append("\n");
		} else {
			sb.append("Error: Index is out of bounds.").append("\n");
		}

		return sb.toString();
	}

	public List<String> searchGenomesForSequence(String sequence) {
		List<String> matchingGenomes = new ArrayList<>();

		for (int i = 0; i < genomeList.size(); i++) {
			Genome genome = genomeList.get(i);
			String genomeSequence = genome.getGenStructure();

			if (genomeSequence.contains(sequence)) {
				matchingGenomes.add(genome.getGenName());
			}
		}

		return matchingGenomes;
	}

	public void replaceSequenceInGenome(int index, String oldSequence, String newSequence) {
		if (index >= 0 && index < genomeList.size()) {
			Genome genome = genomeList.get(index);
			String genomeSequence = genome.getGenStructure();

			if (genomeSequence.contains(oldSequence)) {
				String replacedSequence = genomeSequence.replace(oldSequence, newSequence);
				genome.setGenStructure(replacedSequence); // Assuming Genome class has a 'setGenStructure()' method
				genomeList.set(index, genome); // Update the genome in the genomeList
			}
		}
	}

	public void addGenomeToRepository(String name, String sequence) {
		Genome genome = new Genome(name, sequence);
		genomeList.add(genome);
	}

	public void removeGenomeFromRepository(int index) {
		if (index >= 0 && index < genomeList.size()) {
			genomeList.remove(index);
		}
	}

	public ArrayList<Genome> getGenomeList() {
		return genomeList;
	}

}
