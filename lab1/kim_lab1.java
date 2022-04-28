class kim_lab1 {   
    public static void main(String[] args) {
        if(args.length == 0) {
            System.out.println("No commandline argument");
            System.exit(0);
        }
        else {
        java.text.DecimalFormat df = new java.text.DecimalFormat("###, ###, ###, ###, ###");
            try {
                java.io.BufferedReader input = new java.io.BufferedReader(new java.io.InputStreamReader(new java.io.FileInputStream(args[0])));
                String inn;
                int lineCount = 0;
                int tokenCount = 0;
                int intCount = 0;
                long intSum = 0;
                int[] stringCount = new int[args.length];
                
                while ((inn = input.readLine()) != null) {
                    lineCount += 1;
                    java.util.StringTokenizer st = new java.util.StringTokenizer(inn);
                    
                    while (st.hasMoreTokens()) {
                        String token = st.nextToken();
                        tokenCount += 1;
                        try {
                            int value = Integer.parseInt(token);
                            intCount += 1;
                            intSum += value;
                        }
                        catch(Exception e) {
                        }
                        
                        for(int i = 1; i < args.length; i++)
                            if(token.equalsIgnoreCase(args[i])) {
                                stringCount[i] += 1;
                            }
                    }
                }
                input.close();
                System.out.println("lineCount = " + df.format(lineCount));
                System.out.println("tokenCount = " + df.format(tokenCount));
                System.out.println("intCount = " + df.format(intCount));
                System.out.println("intSum = " + df.format(intSum));
                for(int i = 1; i < stringCount.length; i++)
                    System.out.println(args[i] + " Count = " + stringCount[i]);
            }
            catch(Exception e) {
            System.out.println(e.toString());
            System.exit(0);
            }
        }
    }
}
