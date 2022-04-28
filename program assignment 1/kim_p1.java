class kim_p1 {
    public kim_p1() {
    }
    
    public int[] selectionSort(int[] values, int lowerBound, int upperBound) {
        for(int i = lowerBound - 1; i <= upperBound; i++) {
            int min = i;
            for(int j = i + 1; j < upperBound + 1; j++)
                if(values[j] < values[min])
                    min = j;
            int temp = values[i];
            values[i] = values[min];
            values[min] = temp;
        }
        return values;
    }

    public int forLoopTest(int lowerBound, int upperBound, int testValue, int[] values) {
        int counter = 0;
        for(int i = lowerBound; i <= upperBound; i++)
            if(values[i] >= testValue)
                counter++;
        return counter;
    }
    
    public int whileLoopTest(int lowerBound, int upperBound, int testValue, int[] values) {
        int counter = 0;
        int i = 0;
        while(i < lowerBound) {
            if(values[i] <= testValue)
                counter++;
            i++;
        }
        i = upperBound + 1;
        while(i < values.length) {
            if(values[i] <= testValue)
                counter++;
            i++;
        }
        return counter;
    }
    
    public int doWhileLoopTest(int lowerBound, int upperBound, int testValue1, int testValue2, int[]
    values) {
        int counter = 0;
        do {
            int test = values[lowerBound];
            if(testValue1 < testValue2) {
                if(test >= testValue1 && test <= testValue2)
                    counter++;
                lowerBound++;
            }
            else {
                if(test >= testValue2 && test <= testValue1)
                    counter++;
                lowerBound++;
            }
        }
        while(lowerBound <= upperBound);
        return counter;
    }
    
    public int[] switchTest(int lowerBound, int upperBound, int[] values) {
        int[] result = new int[11];
        for(int i = lowerBound; i <= upperBound; i++) {
            switch(values[i]) {
                case 0:
                    result[0]++;
                    break;
                case 1:
                    result[1]++;
                    break;
                case 2:
                    result[2]++;
                    break;
                case 3:
                    result[3]++;
                    break;
                case 4:
                    result[4]++;
                    break;
                case 5:
                    result[5]++;
                    break;
                case 6:
                    result[6]++;
                    break;
                case 7:
                    result[7]++;
                    break;
                case 8:
                    result[8]++;
                    break;
                case 10:
                case 11:
                case 12:
                case 13:
                case 14:
                case 15:
                    result[9]++;
                    break;
                default:
                    result[10]++;
                    break;
            }
        }
        return result;
    }
}