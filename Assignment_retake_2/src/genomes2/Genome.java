package genomes2;

import java.io.BufferedWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Genome {

	private String genStructure;
	private String genName;

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

	@Override
	public String toString() {
	    return String.format("%s has the following structure: %s", genName, genStructure);
	}

}
