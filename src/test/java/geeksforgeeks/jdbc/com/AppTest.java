package geeksforgeeks.jdbc.com;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.List;

import org.junit.Test;

public class AppTest {
	FreelancerQueries freelancerQueriesObject = new FreelancerQueries();	
	@Test
	public void listFreelancerDetails_positive() {
		 List<Freelancer> listFreelancerDetails = freelancerQueriesObject.listFreelancerDetails();
		 //Checking whether totally 2 freelancers are available
		 assertEquals(listFreelancerDetails.size(), 2);
		 //Checking whether first freelancer id is 1
		 assertEquals(listFreelancerDetails.get(0).getFreelancerId(),1);
		//Checking whether first freelancer name is Freelancer A
		 assertEquals(listFreelancerDetails.get(0).getFreelancerName(),"Freelancer A");
		//Checking whether second  freelancer age is 20
		 assertEquals(listFreelancerDetails.get(1).getFreelancerAge(),20);
		//Checking whether second  freelancer price per hour  is 2000
		 assertEquals(listFreelancerDetails.get(1).getPricePerHour(),20000);
	}

	@Test
	public void listFreelancerDetails_negative() {
		 List<Freelancer> listFreelancerDetails = freelancerQueriesObject.listFreelancerDetails();
		 //As this is negative testing we need to check with assertNotEquals
		 assertNotEquals(listFreelancerDetails.size(), 11);
		//Checking whether first freelancer id is not 10
		 assertNotEquals(listFreelancerDetails.get(0).getFreelancerId(),10);
		//Checking whether first freelancer name is not Rachel
		 assertNotEquals(listFreelancerDetails.get(0).getFreelancerName(),"Rachel");
		//Checking whether second  freelancer age is not 30
		 assertNotEquals(listFreelancerDetails.get(1).getFreelancerAge(),30);
		//Checking whether second  freelancer price per hour  is not 4000
		 assertNotEquals(listFreelancerDetails.get(0).getPricePerHour(),4000);
	}
	
	@Test
	public void getFreelancerName_PositiveTestCase() {
		 String freelancerName = freelancerQueriesObject.getFreelancerNameById(1);
		 assertEquals(freelancerName, "Freelancer A");
		 freelancerName = freelancerQueriesObject.getFreelancerNameById(2);
		 assertEquals(freelancerName, "Freelancer B");
		
	}
	
	@Test
	public void getdFreelancerName_NegativeTestCase() {
		 String freelancerName = freelancerQueriesObject.getFreelancerNameById(2);
		 assertNotEquals(freelancerName, "Phoebe");
		
	}
	
	@Test
	public void getFirstFreelancerPricePerHour_PositiveTestCase() {
		 int pricePerHour = freelancerQueriesObject.getFreelancerPricePerHour(1);
		 assertEquals(pricePerHour, 1000);
		
	}
	
	@Test
	public void getSecondFreelancerPricePerHour_NegativeTestCase() {
		int pricePerHour = freelancerQueriesObject.getFreelancerPricePerHour(2);
		 assertNotEquals(pricePerHour, 5000);
		
	}


}
