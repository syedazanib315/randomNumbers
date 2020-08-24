package doesfileexist;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class FileExist {

	    public static boolean doesFileExist(String path){
	    	
	        File f = new File(relativepathToAbsolute(path));
	        if(f.exists() && !f.isDirectory()){
	            return true;
	        }
	        return false;
	    }

	    public static void printDictionary(String dictPath){
	        if(!doesFileExist(dictPath)){
	            System.err.println("File does not exist.");
	        }
	        String currentLine;
	        try{
	            String absolutePath = relativepathToAbsolute(dictPath);
	            BufferedReader dictReader = new BufferedReader(new FileReader(absolutePath));

	            while ((currentLine = dictReader.readLine()) != null) {
	                String[] splitLine = currentLine.split("-");
	                String[] meanings = splitLine[1].split(",");
	                System.out.println("Word:" + splitLine[0].trim());
	                for(String s: meanings){
	                    System.out.println("Meaning:"+ s.trim());
	                }
	                System.out.println("");
	            }
	            dictReader.close();
	        }
	        catch(Exception e){
	            e.printStackTrace();
	        }
	    }

	    private static String relativepathToAbsolute(String relPath){
	        File file1 = new File(".");
	        File file2 = new File(file1, relPath);
	        return file2.getAbsolutePath();
	    }

	    public static void main(String[] args) {
	        if(args.length<1){
	            System.err.println("Not enough arguments. Please provide the path to the dictionary file");
	            return;
	        }

	        String path = args[0];

	        if(doesFileExist(path)){
	            System.out.println("The file exists.\n");
	        }else{
	            System.out.println("The file doesn't exist");
	            return;
	        }

	        printDictionary(path);
	    }
	

}
