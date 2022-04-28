class kim_lab0b
{
    public static void main (String[] args)
    {
        System.out.println("yo i am here, and below are the command line arguments you gave me");
        for( int i = 0; i < args.length; i++)
        //for( int i = 0; i <= args.length; i++) //There is an error because arg[0] is inclusive through <=, and index 6 does not exist in the argument (0-5).
        //for( int i = 0; i < args.length; ++i) //Nothing changed
        //for( int i = 0; i++ < args.length;) //"arg[0] = 0" is not printed because the argument takes i++. There is an error because index 6 is still out of bounds.
        //for( int i = 0; ++i < args.length;) //"arg[0] = 0" is not printed because the iteration starts at 1. The integers are printed because i is iterated before the command, so index 6 is inbound.
        {
            System.out.println("\t arg[" + i + "] = " + args[i]);
        }
        for( int i = 0; i < args.length; i++)
        {
            int intValue = Integer.parseInt(args[i]);
            System.out.println("\t arg[" + i + ") as an int = " + intValue);
        }
    }
}