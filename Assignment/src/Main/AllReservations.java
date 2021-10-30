package Main;

public class AllReservations {

	private Reservation[] array = new Reservation[32]; //32 = maximum amount of reservations; change it later prob
	private int numReservations;

	public AllReservations() {
		this.numReservations = 0;
	}

	public void createNewReservation(){
		//print dialog to ask for name, time, pax etc. 
		//check for table availability
		//create a new Reservation object and insert it into this.array

	}

	public void checkReservation(){//must program option to remove reservation as well
		//print dialog to ask for name under which to check reservation for
		//iterate through this.array to find matching name
		//display information through print dialog [reservation.printDetails() or smn]
		//ask if reservation should be removed
	}
}
