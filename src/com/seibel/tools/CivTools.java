package com.seibel.tools;

public class CivTools {


	
	public static String calculate(String input, String startXml, float percent) {
		
		StringBuilder stb = new StringBuilder();
		if (!input.isEmpty()) {
			int startIn = input.indexOf("<"+startXml+">");
			int closeIn = input.indexOf("</"+startXml+">");
			
			stb.append(input.substring(0, startIn));
			
			String data = input.substring(startIn, closeIn);
			if (data.isEmpty()) return stb.toString();
			
			String[] items = data.split("Cost=\"");
			stb.append(items[0]);
			
			for (int i=1; i < items.length; i++) 
			{
				String item = items[i];
				int start = 1;
				int close = item.indexOf("\"");
				
				String sValue = item.substring(0, close);
				float fValue = Float.parseFloat(sValue);
				
				int iValue = 1;
				if (fValue != 1F)
					iValue = (int) (fValue * percent);
				
				stb.append("Cost=\"");
				stb.append(Integer.toString(iValue));
				stb.append(item.substring(close));
			}
			stb.append(input.substring(closeIn));
		}
		return stb.toString();
	}
}
