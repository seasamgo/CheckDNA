import java.util.regex.*;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class nucleotides {

	private static Scanner sc, scName; //one for file name, one for file
	private static String name;

	private static void fileName(String n) {
		try {
			File f = new File(n);
			sc = new Scanner(f);
		}
		catch (FileNotFoundException e) {
			System.out.println("File not found, try again...");
		}
	}

	public static void main(String [] args) {

		System.out.println("Type text file name: ");
        	Scanner scName = new Scanner(System.in);
		String name = scName.nextLine();
		fileName(name);
		scName.close();

		while(sc != null && sc.hasNext()) {
			String r = sc.nextLine();
			String R = r.toUpperCase();
			String trans = "";
			String strand = "";
			boolean invalid = false;	

			for(int i=0; i < R.length(); i++) {
				char L = R.charAt(i);
				String l = String.valueOf(L);
				if(l.matches("[^ACGT]")) {
					invalid = true;
				}
			}

			if(!invalid) {
				System.out.println("");
				for(int i=0; i<R.length(); i++) {
					char L = R.charAt(i);
					String l = String.valueOf(L);
					if(l.endsWith("A")) {
						trans+="T";
					}
					else if(l.endsWith("C")) {
						trans+="G";
					}
					else if(l.endsWith("G")) {
						trans+="C";
					}
					else if(l.endsWith("T")) {
						trans+="A";
					}
					strand+="|";
				}
				System.out.println(R);
				System.out.println(strand);
				System.out.println(trans);
				System.out.println("");
			}
			else {
				System.out.println("");
				System.out.println(r+" is not a valid sequence");
				System.out.println("");
			}

		}

	}

}

