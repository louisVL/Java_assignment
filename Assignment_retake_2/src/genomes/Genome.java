package genomes;

import java.io.BufferedWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Genome {

	private String genStructure;
	private String genName;
	//private ArrayList<Genome> genomeList;

	public Genome(String genName, String genStructure) {

		this.genName = genName;
		this.genStructure = genStructure;
	}

	public String getGenStructure() {
		return genStructure;
	}

	public void setGenStructure(String genStructure) {
		this.genStructure = genStructure;
	}

	public String getGenName() {
		return genName;
	}

	public void setGenName(String genName) {
		this.genName = genName;
	}

	public ArrayList<Genome> getGenomeList() {
		return getGenomeList();
	}

//	public void setGenomeList(ArrayList<Genome> genomeList) {
//		this.genomeList = genomeList;
//	}

	public static void printGenomeList(ArrayList<Genome> genomeList) {
		for (int i = 0; i < genomeList.size(); i++) {
			System.out.println(genomeList.get(i));
		}

	}

	public String toString() {
		return String.format("%s", this.getGenName() + " has the following structure " + this.getGenStructure());
	}

}
