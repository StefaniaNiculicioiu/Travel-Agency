import java.util.ArrayList;
import java.util.List;

public class Sejur implements Comparable{
	private String numeStatiune;
	private String locatie;
	private String dataPlecare;
	private String dataIntoarcere;
	private int perioada;
	
	public Sejur(String numeStatiune, String locatie, String dataPlecare, String dataIntoarcere, int prioada) {
		this.numeStatiune = numeStatiune;
		this.locatie = locatie;
		this.dataPlecare = dataPlecare;
		this.dataIntoarcere = dataIntoarcere;
		this.perioada = prioada;
	}
	
	public String getNumeStatiune() {
		return numeStatiune;
	}

	public void setNumeStatiune(String numeStatiune) {
		this.numeStatiune = numeStatiune;
	}

	public String getLocatie() {
		return locatie;
	}

	public void setLocatie(String locatie) {
		this.locatie = locatie;
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

	@Override
	public int compareTo(Object s) {
		// TODO Auto-generated method stub
		
		return this.getNumeStatiune().compareTo(((Sejur) s).getNumeStatiune());

	}

}

class Sejururi {
	public List <Sejur> sejururiAgentie;

	public Sejururi(int nr_sejururi) {

		this.sejururiAgentie = new ArrayList <Sejur>(nr_sejururi);
	}
	
	public void addSejur(Sejur s) {
		this.sejururiAgentie.add(s);
	}

	
}