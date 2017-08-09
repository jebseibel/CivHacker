package com.seibel.tools;

import java.util.StringTokenizer;

public class CivFile {

	//files in the location
	//C:\Program Files (x86)\Steam\steamapps\common\Sid Meier's Civilization VI\Base\Assets\Gameplay\Data
	public static final String baseInputFolder = "C:/Projects/CivHacker/input/";
	public static final String baseOutputFolder = "C:/Projects/CivHacker/output/";
	
	private String fileName = "";
	private String startXml = "";
	private String inputData = "";
	private String outputData = "";
	
	public CivFile(String fileName, String startXml) {
		this.fileName = fileName;
		this.startXml = startXml;
		
		this.readFile();
	}
		
	private boolean readFile () {	
		System.out.println(" . . . Read the file ["+baseInputFolder+this.fileName+"]");
		this.inputData = FileTools.loadFileAsString(baseInputFolder+this.fileName);
		if (inputData.isEmpty()) return false;
		else return true;
	}
	
	private void writeFile () {
		System.out.println(" . . . Writing the file ["+baseOutputFolder+this.fileName+"]");
		FileTools.writeFile(baseOutputFolder+this.fileName, this.outputData);
	}
	
	public void processAndWrite( float percent) {
		outputData = CivTools.calculate(inputData, startXml, percent);
		writeFile();
	}

}
