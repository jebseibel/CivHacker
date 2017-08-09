package com.seibel.tools;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;

//import org.apache.log4j.Logger;

/**
 * A collection of various tools to deal with reading and writing file contents.
 * 
 * @author SeibelJ
 *
 */
public class FileTools {
	//private static final Logger log = Logger.getLogger(FileTools.class);

	private FileTools() {
	}

	public static final ArrayList<String> loadFileToArray(File file) {
		System.out.println("loadFileToArray");
		// setup
		ArrayList<String> lines = new ArrayList<String>();

		try
		{
			// open file
			FileInputStream fs = new FileInputStream(file);
			BufferedReader in = new BufferedReader(new InputStreamReader(fs));
			String line = in.readLine();

			// loop to extract the entire file
			while (line != null)
			{
				lines.add(line);
				line = in.readLine();
			}
			in.close();
			fs.close();
		}
		catch (FileNotFoundException e)
		{
			System.out.println(e.getStackTrace());
		}
		catch (IOException e)
		{
			System.out.println(e.getStackTrace());
		}
		return (lines);
	}

	/*
	 * This method loads a configuration file.
	 */
	public static String loadResourceFile(String config_file) {
		String contents = "Error! File not found!";
		String filelocation = config_file;

		try
		{
			InputStream input = FileTools.class.getResourceAsStream(filelocation);
			if (input == null)
			{
				System.out.println("Sorry, unable to find " + config_file);
				return contents;
			}

			StringBuffer stb = new StringBuffer(500);
			// InputStream in = Files.newInputStream(file);
			BufferedReader reader = new BufferedReader(new InputStreamReader(input));
			String line = null;
			while ((line = reader.readLine()) != null)
			{
				stb.append(line + "\n");
			}
			contents = stb.toString();

		}
		catch (Exception e)
		{
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return contents;
	}

	public static final ArrayList<String> loadTextFileToArray(String filename) {
		// System.out.println("loadTextFileToArray");
		// setup
		ArrayList<String> lines = new ArrayList<String>();

		try
		{
			File file = new File(filename);

			// open file
			FileInputStream fs = new FileInputStream(file);
			BufferedReader in = new BufferedReader(new InputStreamReader(fs));
			String line = in.readLine();

			// loop to extract the entire file
			while (line != null)
			{
				lines.add(line);
				line = in.readLine();
			}
			in.close();
			fs.close();
		}
		catch (FileNotFoundException e)
		{
			System.out.println(e.getStackTrace());
		}
		catch (IOException e)
		{
			System.out.println(e.getStackTrace());
		}
		return (lines);
	}

	/**
	 * Loads the file specified and returns the file contents as a String
	 * 
	 * @param filename
	 * @return
	 */
	public static final String loadFileAsString(String filename) {
		// System.out.println("loadFileAsString (String)");
		File file = new File(filename);
		return loadFileAsString(file);
	}

	/**
	 * Loads the file specified and returns the file contents as a String
	 * 
	 * @param file
	 * @return
	 */
	public static final String loadFileAsString(File file) {
		// System.out.println("loadFileAsString (File)");
		StringBuilder stb = new StringBuilder(1000);

		try
		{
			// open file
			FileInputStream fs = new FileInputStream(file);
			BufferedReader in = new BufferedReader(new InputStreamReader(fs));
			String line = in.readLine();

			// loop to extract the entire file
			while (line != null)
			{
				stb.append(line + "\n");
				line = in.readLine();
			}
			in.close();
			fs.close();

		}
		catch (FileNotFoundException e)
		{
			System.out.println(e.getStackTrace());
		}
		catch (IOException e)
		{
			System.out.println(e.getStackTrace());
		}
		return stb.toString();
	}

	/**
	 * Loads the file specified and returns the file contents as an ArrayList.
	 * It uses Charset.forName("utf-16le") to load.
	 * 
	 * @param file
	 * @return
	 */
	public static final ArrayList<String> loadSCFileToArray(String filename) {
		// setup
		ArrayList<String> lines = new ArrayList<String>();

		try
		{
			File file = new File(filename);

			// open file
			FileInputStream fs = new FileInputStream(file);
			BufferedReader in = new BufferedReader(new InputStreamReader(fs, Charset.forName("utf-16le")));

			String line = in.readLine();

			// loop to extract the entire file
			while (line != null)
			{
				lines.add(line);
				line = in.readLine();
			}
			in.close();
			fs.close();
		}
		catch (FileNotFoundException e)
		{
			System.out.println(e.getStackTrace());
		}
		catch (IOException e)
		{
			System.out.println(e.getStackTrace());
		}
		return (lines);
	}

	public static final String loadFile(File file) {
		// System.out.println("loadFile " + file.getName());
		// setup
		StringBuilder stb = new StringBuilder(1000);

		try
		{
			// open file
			FileInputStream fs = new FileInputStream(file);
			BufferedReader in = new BufferedReader(new InputStreamReader(fs));
			String line = in.readLine();

			// loop to extract the entire file
			while (line != null)
			{
				stb.append(line);
				line = in.readLine();
			}
			in.close();
			fs.close();

		}
		catch (FileNotFoundException e)
		{
			System.out.println(e.getStackTrace());
		}
		catch (IOException e)
		{
			System.out.println(e.getStackTrace());
		}
		return stb.toString();
	}

	/**
	 * This method gets the names of all the files in the path sent in.
	 * 
	 * @param path
	 *            - an absolute path.
	 * @param ext
	 *            - pass null if you dont want to limit the extension
	 * @return
	 */
	public static ArrayList<String> getFiles(String path, String ext) {
		String file;
		File folder = new File(path);
		File[] files = folder.listFiles();

		ArrayList<String> result = new ArrayList<String>();

		// early exit if no files
		if (files == null)
		{
			return result;
		}

		// set flag to ignore/watch for extension
		boolean ignoreExt = true;
		if (ext != null)
			ignoreExt = false;

		try
		{
			for (int i = 0; i < files.length; i++)
			{
				if (files[i].isFile())
				{
					file = files[i].getCanonicalPath();

					if (ignoreExt)
					{
						result.add(file);
					}
					else if (file.endsWith(ext))
					{
						result.add(file);
					}
				}
			}
		}
		catch (IOException e)
		{
			System.out.println(e.getStackTrace());
		}
		return result;
	}

	/**
	 * Gets all the filenames for the passed directory path
	 * 
	 * @param path
	 * @return
	 */
	public static ArrayList<String> getDirectories(String directoryPath) {
		String directory;
		File folder = new File(directoryPath);
		File[] dirs = folder.listFiles();

		ArrayList<String> result = new ArrayList<String>();
		if (dirs == null)
			return result;
		try
		{
			// System.out.println("dirs [" + dirs.length + "]");
			for (int i = 0; i < dirs.length; i++)
			{
				if (dirs[i].isDirectory())
				{
					directory = dirs[i].getCanonicalPath();
					// System.out.println("directory " + directory);
					result.add(directory);
				}
			}
		}
		catch (IOException e)
		{
			System.out.println(e.getStackTrace());
		}
		return result;
	}

	/**
	 * Writes the String passed to a file as specified in the passed file
	 * location. The file location should include file path and the filename
	 * 
	 * @param filename
	 * @param data
	 * @return boolean
	 * @throws IOException
	 *             if it cant write the file
	 */
	public static void writeFile(String file_location, String data) {
		try
		{
			// first fix slashes to be the right way for the os
			File dirfile = new File(file_location);
			String str_osdirfile = dirfile.toString();

			// create a new file with the correct slashes
			File osdirfile = new File(str_osdirfile);
			String str_parent = osdirfile.getParent();

			// create the parent directories
			File osdirectory = new File(str_parent);
			osdirectory.mkdirs();

			// now write the file
			FileWriter fileout = new FileWriter(osdirfile);
			fileout.write(data);
			fileout.close();
		}
		catch (IOException e)
		{
			System.out.println(e.getStackTrace());
		}
		return;
	}

}
