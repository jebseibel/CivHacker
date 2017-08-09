package com.seibel.tools;

import static org.junit.Assert.*;

import org.junit.Test;

public class CivToolsTest {

	@Test
	public void percent50() {
	
		StringBuilder stb = new StringBuilder(500);
		stb.append("<file>");
		stb.append("<Technologies>");
		stb.append("<!-- Ancient Era-->");
		stb.append("<Row TechnologyType=\"TECH_POTTERY\" Cost=\"5\" UITreeRow=\"0\"/>");
		stb.append("<Row TechnologyType=\"TECH_ANIMAL\"  Cost=\"50\" UITreeRow=\"1\"/>");
		stb.append("<Row TechnologyType=\"TECH_ANIMAL\"  Cost=\"150\" UITreeRow=\"1\"/>");
		stb.append("</Technologies>");
		stb.append("<file>");
		
		String result = CivTools.calculate(stb.toString(), "Technologies", .5F);
		System.out.println(result);
	}

	@Test
	public void percent33() {
	
		StringBuilder stb = new StringBuilder(500);
		stb.append("<file>");
		stb.append("<Technologies>");
		stb.append("<!-- Ancient Era-->");
		stb.append("<Row TechnologyType=\"TECH_POTTERY\" Cost=\"5\" UITreeRow=\"0\"/>");
		stb.append("<Row TechnologyType=\"TECH_ANIMAL\"  Cost=\"50\" UITreeRow=\"1\"/>");
		stb.append("<Row TechnologyType=\"TECH_ANIMAL\"  Cost=\"150\" UITreeRow=\"1\"/>");
		stb.append("</Technologies>");
		stb.append("<file>");
		
		String result = CivTools.calculate(stb.toString(), "Technologies", .33F);
		System.out.println(result);
	}
	
	@Test
	public void percent150() {
	
		StringBuilder stb = new StringBuilder(500);
		stb.append("<file>");
		stb.append("<Technologies>");
		stb.append("<!-- Ancient Era-->");
		stb.append("<Row TechnologyType=\"TECH_POTTERY\" Cost=\"5\" UITreeRow=\"0\"/>");
		stb.append("<Row TechnologyType=\"TECH_ANIMAL\"  Cost=\"50\" UITreeRow=\"1\"/>");
		stb.append("<Row TechnologyType=\"TECH_ANIMAL\"  Cost=\"150\" UITreeRow=\"1\"/>");
		stb.append("</Technologies>");
		stb.append("<file>");
		
		String result = CivTools.calculate(stb.toString(), "Technologies", 1.5F);
		System.out.println(result);
	}
}
