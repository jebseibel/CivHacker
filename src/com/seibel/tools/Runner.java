package com.seibel.tools;

public class Runner {

	public static final void process(String fileName, String startXml, float percent) {
		System.out.println("");
		CivFile civFile = new CivFile(fileName, startXml);
		civFile.processAndWrite(percent);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		process("Units.xml", "Units", .25F);
		process("Buildings.xml", "Buildings", .75F);
		process("Civics.xml", "Civics", 2F);
		process("Technologies.xml", "Technologies", 3F);
		
		
		System.out.println("Done!");
	}

}
