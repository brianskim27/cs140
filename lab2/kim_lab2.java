class kim_lab2 {
	public static void main(String[] args) {
        if(args.length < 3) {
            System.out.println("Three commandline arguments required");
            System.exit(0);
        }
		if(args[0].startsWith("b")) {
			convertBinaryToText(args[1], args[2]);
		}
		else if(args[0].startsWith("t")) {
			convertTextToBinary(args[1], args[2]);
		} 
		else {
			System.out.println("Incorrect commandline argument");
            System.exit(0);
		}
	}
	
	private static void convertBinaryToText(String inputFilename, String outputFilename) {
		System.out.println("convertBinaryToText");
		try {
            java.io.FileInputStream input = new java.io.FileInputStream(inputFilename);
			java.io.PrintWriter writer = new java.io.PrintWriter(outputFilename);
            java.io.File file = new java.io.File(inputFilename);
			byte[] byteRead = new byte[(int)file.length()];
            input.read(byteRead);	
			String string = new String(byteRead);
			writer.print(string);
			input.close();
			writer.close();
        }
		catch(Exception e) {
			System.out.println(e.toString());
			System.exit(0);
		}
	}
	
	private static void convertTextToBinary(String inputFilename, String outputFilename) {
		System.out.println("convertTextToBinary");
		try {
            java.io.BufferedReader input = new java.io.BufferedReader(new java.io.InputStreamReader(new java.io.FileInputStream(inputFilename)));
			java.io.BufferedOutputStream output = new java.io.BufferedOutputStream(new java.io.FileOutputStream(outputFilename));
            String inn;
            while ((inn = input.readLine()) != null) {
                if(inn.length() > 0) {
				output.write(inn.getBytes());
				output.write("\n".getBytes());
				}
			}
			input.close();
			output.close();
		}
		catch(Exception e) {
			System.out.println(e.toString());
			System.exit(0);
		}
	}
}

