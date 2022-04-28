class kim_lab3 {
	public static void main(String[] args) {
		if(args.length > 2)
			encode(args[0], args[1], args[2].equals("y"));
		else
			encode(args[0], args[1], false);
	}

	public static void encode(String inputFilename, String outputFilename, boolean correct) {
		try {
			java.io.BufferedReader input = new java.io.BufferedReader(new java.io.InputStreamReader(new java.io.FileInputStream(inputFilename)));
			java.io.PrintWriter output = new java.io.PrintWriter(new java.io.BufferedWriter(new java.io.FileWriter(outputFilename)));
			int lineCounter = 0;
			int wordCounter = 0;
			int charsCounter = 0;
			java.util.ArrayDeque<String> stack = new java.util.ArrayDeque<>();
			java.util.TreeSet<String> uniqueStrings = new java.util.TreeSet<>();
			String inn;

			while((inn = input.readLine()) != null) {
				String[] words = inn.split("\\s+");
				for(String word : words) {
					uniqueStrings.add(word);
					String reverse = "";
					for(int i = word.length() - 1; i >= 0; i--) {
						reverse += word.charAt(i);
						charsCounter++;
					}
					stack.push(reverse);
					wordCounter++;
				}
			
				String sub = "";
				while(stack.size() > 0) {
					sub += stack.remove();
					sub += " ";
				}
				sub = sub.substring(0, sub.length() - 1);
				output.println(sub);
				lineCounter++;
			}
			input.close();
			output.close();
			System.out.println("lines = " + lineCounter);
			System.out.println("words = " + wordCounter);
			System.out.println("character in words = " + charsCounter);
			System.out.println("unique words = " + uniqueStrings.size());
			if(correct)
				for(String word : uniqueStrings)
					System.out.println(word);
		}
		catch (Exception e) {
			System.out.println(e.toString());
		}
	}
}