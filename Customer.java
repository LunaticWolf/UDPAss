import java.io.Serializable;


public class Customer implements Serializable
{
	
	private String clientID;
	private int pinNumber;
	private boolean status;
	private int numberOfTravels;
	private double totalCost;

	
	public Customer(){}
	
	
	
	public Customer(String clientID, int pinNumber) {
		super();
		this.clientID = clientID;
		this.pinNumber = pinNumber;
	}



	public Customer(String clientID, int pinNumber, boolean status, int numberOfTravels) {
		super();
		this.clientID = clientID;
		this.pinNumber = pinNumber;
		this.status = status;
		this.numberOfTravels = numberOfTravels;
	}

	public String getClientID() {
		return clientID;
	}

	public void setClientID(String clientID) {
		this.clientID = clientID;
	}

	public int getPinNumber() {
		return pinNumber;
	}

	public void setPinNumber(int pinNumber) {
		this.pinNumber = pinNumber;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public int getNumberOfTravels() {
		return numberOfTravels;
	}

	public void setNumberOfTravels(int numberOfTravels) {
		this.numberOfTravels = numberOfTravels;
	}

	public double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}
	
	
	
	public void calculateCost()
	{}

	
	
	@Override
	public String toString() {
		return "Customer [clientID=" + clientID + ", pinNumber=" + pinNumber + ", status=" + status
				+ ", numberOfTravels=" + numberOfTravels + ", totalCost=" + totalCost + "]";
	}
	
	
	
	
	 
	

}
