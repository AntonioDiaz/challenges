import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

//import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * http://www.spotify.com/es/jobs/tech/bilateral-projects/
 * @author antonio.diaz.arroyo
 *
 */

public class Bilateral {

	private Map<Integer, List<Integer>> stockholm;
	private Map<Integer, List<Integer>> london;
	private int teamsCount;
	public static final Integer MY_FRIEND = 1009;
	
	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		InputStream inputStream = System.in;
		InputStreamReader in = new InputStreamReader (inputStream);
		Bilateral bilateral = new Bilateral(in);
		List<Integer> participans = bilateral.calculateMinimalList();
		System.out.println(participans.size());
		for (int i = participans.size()-1; i>=0 ; i--) {
			System.out.println(participans.get(i));
		}
		in.close();
	}
	
	/**
	 * 
	 * @param inputStreamReader
	 * @throws IOException 
	 */
	public Bilateral (InputStreamReader inputStreamReader) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
		teamsCount = Integer.parseInt(bufferedReader.readLine());
		stockholm = new HashMap<Integer, List<Integer>>();
		london = new HashMap<Integer, List<Integer>>();
		for (int i = 0; i < teamsCount; i++) {
			String[] split = bufferedReader.readLine().split(" ");
			addElement(stockholm, Integer.valueOf(split[0]), Integer.valueOf(split[1]));
			addElement(london, Integer.valueOf(split[1]), Integer.valueOf(split[0]));
		}
	}
	
	/**
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Integer> calculateMinimalList() {
		List<Integer> participants = new ArrayList<Integer>();
		/** clone the list of teams to avoid modify them. */
		Map<Integer, List<Integer>> stockholmCopy = new HashMap<Integer, List<Integer>>(); 
		stockholmCopy = (Map<Integer, List<Integer>>)((HashMap<Integer, List<Integer>>) stockholm).clone();
		
		Map<Integer, List<Integer>> londonCopy = new HashMap<Integer, List<Integer>>(); 
		londonCopy = (Map<Integer, List<Integer>>)((HashMap<Integer, List<Integer>>) london).clone();
		
		int count = 0;
		while (this.teamsCount>count) {
			Integer maxStockholm = Bilateral.maxProjects(stockholmCopy);
			Integer maxLondon = Bilateral.maxProjects(londonCopy);
			if (stockholmCopy.get(maxStockholm).size()>londonCopy.get(maxLondon).size() 
					|| (stockholmCopy.get(maxStockholm).size()==londonCopy.get(maxLondon).size() && maxStockholm.equals(MY_FRIEND))) {
				count += stockholmCopy.get(maxStockholm).size();
				participants.add(maxStockholm);
				Bilateral.updateMapProjects(maxStockholm, stockholmCopy, londonCopy);
			} else {
				count += londonCopy.get(maxLondon).size();
				participants.add(maxLondon);
				Bilateral.updateMapProjects(maxLondon, londonCopy, stockholmCopy);
			}
		}
		return participants;
	}
	
	/**
	 * 
	 * @param key
	 * @param originalMap
	 * @param destinationMap
	 */
	private static void updateMapProjects(Integer key, Map<Integer, List<Integer>> originalMap, Map<Integer, List<Integer>> destinationMap) {
		List<Integer> list = originalMap.get(key);
		for (Integer integer : list) {
			destinationMap.get(integer).remove(key);
		}
		originalMap.remove(key);
	}
	
	private static Integer maxProjects(Map<Integer, List<Integer>> copyMap) {
		Integer maxProjects = 0;
		Integer maxProjectEmployee = 0;
		for (Entry<Integer, List<Integer>> entry : copyMap.entrySet()) {
			if (entry.getValue().size()>maxProjects 
					|| (entry.getValue().size()==maxProjects && entry.getKey().equals(MY_FRIEND))) {
				maxProjectEmployee = entry.getKey();
				maxProjects = entry.getValue().size();
			}
		}
		return maxProjectEmployee;
	}
	
	/**
	 * Add a element to the list of employees
	 * @param myMap
	 * @param key
	 * @param value
	 */
	private void addElement(Map<Integer, List<Integer>> myMap, Integer key, Integer value) {
		if (!myMap.containsKey(key)) {
			myMap.put(key, new ArrayList<Integer>());
		}
		myMap.get(key).add(value);
	}

	public Map<Integer, List<Integer>> getStockholm() {
		return stockholm;
	}

	public void setStockholm(Map<Integer, List<Integer>> stockholm) {
		this.stockholm = stockholm;
	}

	public Map<Integer, List<Integer>> getLondon() {
		return london;
	}

	public void setLondon(Map<Integer, List<Integer>> london) {
		this.london = london;
	}

	public int getTeamsCount() {
		return teamsCount;
	}

	public void setTeamsCount(int teamsCount) {
		this.teamsCount = teamsCount;
	}
	
//	@Override
//	public String toString() {
//		return ToStringBuilder.reflectionToString(this);
//	}
}
