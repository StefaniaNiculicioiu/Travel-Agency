import java.util.ArrayList;
import java.util.List;

public class Clienti {
	public List<Client> clientiAgentie;
	//int nr;
	
	public Clienti(int nr_clienti) {
		this.clientiAgentie = new ArrayList<Client>(nr_clienti);
	}

	public void addClient(Client a) {
		this.clientiAgentie.add(a);
		//nr++;
	}

	public List<Client> getClientiAgentie() {
		return clientiAgentie;
	}

	public void setClientiAgentie(List<Client> clientiAgentie) {
		this.clientiAgentie = clientiAgentie;
	}
	
	public int getClientiDimensiune() {
		return clientiAgentie.size();
	}
	
/*	public int getClientidupaStatiune (String s, List<Client> c){
		int n=0;
		for(int i=0; i<nr; i++) {
			if(clientiAgentie.get(i).getStatiune().compareTo(s)==0)
				{c.add(clientiAgentie.get(i));
				n++;
				}
		}
		return n;
	}}*/
	
}

class Client{
	private String nume;
	private String prenume;
	private String telefon;
	private String email;
	private String statiune;
	private String dataPlecare;
	private String dataIntoarcere;
	private int perioada;
	
	public String getNume() {
		return nume;
	}

	public void setNume(String nume) {
		this.nume = nume;
	}

	public String getPrenume() {
		return prenume;
	}

	public void setPrenume(String prenume) {
		this.prenume = prenume;
	}

	public String getTelefon() {
		return telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getStatiune() {
		return statiune;
	}

	public void setStatiune(String statiune) {
		this.statiune = statiune;
	}
	
	public String getDataPlecare() {
		return dataPlecare;
	}

	public void setDataPlecare(String dataPlecare) {
		this.dataPlecare = dataPlecare;
	}

	public String getDataIntoarcere() {
		return dataIntoarcere;
	}

	public void setDataIntoarcere(String dataIntoarcere) {
		this.dataIntoarcere = dataIntoarcere;
	}

	public int getPrioada() {
		return perioada;
	}

	public void setPerioada(int prioada) {
		this.perioada = prioada;
	}

	public Client(String nume, String prenume, String telefon, String email, String statiune, String dataPlecare, String dataIntoarcere, int prioada) {
		this.nume = nume;
		this.prenume = prenume;
		this.telefon = telefon;
		this.email = email;
		this.statiune = statiune;
		this.dataPlecare = dataPlecare;
		this.dataIntoarcere = dataIntoarcere;
		this.perioada = prioada;
	}
}
	
