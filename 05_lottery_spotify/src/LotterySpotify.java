import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

/**
 * http://www.spotify.com/es/jobs/tech/ticket-lottery/
 * 
 * @author antonio.diaz.arroyo
 *
 */

public class LotterySpotify {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String myLine = in.readLine();
		String[] s = myLine.split(" ");
		LotterySpotify lottery = new LotterySpotify(Integer.parseInt(s[0]), Integer.parseInt(s[1]), Integer.parseInt(s[2]), Integer.parseInt(s[3]));	
		System.out.println(lottery.calculateProbability());		
	}
	
	private int participants;
	private int winners;
	private int tickets;
	private int peopleGroup;
	
	
	
	public LotterySpotify(int participants, int winners, int tickets, int peopleGroup) {
		super();
		this.participants = participants;
		this.winners = winners;
		this.tickets = tickets;
		this.peopleGroup = peopleGroup;
	}

	/**
	 * Calculate the probabilities to get a ticket for all member of the group.
	 * @return
	 */
	public String calculateProbability () {
		double probabilities = 0;
		for (int i=0; i<peopleGroup; i++) {
			probabilities += ((double)winners - i) / ((double)participants - i);
		}
		DecimalFormatSymbols simbolos = new DecimalFormatSymbols();
		simbolos.setDecimalSeparator('.');
		DecimalFormat formateador = new DecimalFormat("#.##########", simbolos);
		return probabilities==1?"1.0000000000":formateador.format(probabilities);
	}
	
	public int getParticipants() {
		return participants;
	}
	
	public void setParticipants(int participants) {
		this.participants = participants;
	}
	
	public int getWinners() {
		return winners;
	}
	
	public void setWinners(int winners) {
		this.winners = winners;
	}
	
	public int getTickets() {
		return tickets;
	}
	
	public void setTickets(int tickets) {
		this.tickets = tickets;
	}
	
	public int getPeopleGroup() {
		return peopleGroup;
	}
	
	public void setPeopleGroup(int peopleGroup) {
		this.peopleGroup = peopleGroup;
	}
}
