import java.util.ArrayList;

public class lab13 {
	public java.util.ArrayList<Integer> list;
	
	public lab13() {
		list = new java.util.ArrayList<>();
	}
	public void readData(String filename) {
		try {	
			java.io.BufferedReader input = new java.io.BufferedReader(new java.io.InputStreamReader(new java.io.FileInputStream(filename)));
			String inn;
			while((inn = input.readLine()) != null) {
				if(inn.length() > 0) {
					list.add(Integer.parseInt(inn.trim()));
				}
				else {
					break;
				}
			}
			input.close();
		}
		catch(Exception e) {
			System.out.println(e.toString());
		}
	}
	
	public long getTotalCount() {
		return list.stream().count();
	}
	
	public long getOddCount() {
		return list.stream().filter(x -> x % 2 != 0).count();
	}
	
	public long getEvenCount() {
		return list.stream().filter(x -> x % 2 == 0).count();
	}
	
	public long getDistinctGreaterThanFiveCount() {
		return list.stream().filter(x -> x > 5)
				.distinct()
				.filter(x -> x > 5)
				.count();
	}
	
	public Integer[] getResult1() {
		return list.stream().sorted()
				.filter(x -> x % 2 == 0 && x > 5 && x < 50)
				.toArray(Integer[]::new);
	}
	
	public Integer[] getResult2() {
		return list.stream().limit(50)
				.map(x -> x*x*3)
				.toArray(Integer[]::new);
	}
	
	public Integer[] getResult3() {
		return list.stream().filter(x -> x % 2 != 0)
				.map(x -> x*2)
				.sorted()
				.skip(20)
				.distinct()
				.toArray(Integer[]::new);
	}
}
