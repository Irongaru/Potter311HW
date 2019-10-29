package DonutShop;

import java.util.Random;


public class DonutShop {

	public static void main(String args[]) 
	{
		SinglyLinkedList waitline = new SinglyLinkedList();
		SinglyLinkedList beingServed = new SinglyLinkedList();
		Random r = new Random(97);
		double cpt = 2; //customers per tick on average
		int servers = 4; //number of servers
		int maxS=3; //Max for req time to be served
		// the above three variables are what need to be changed in order to change the paramaters
		double beenS=0;	// # of customers who have been served
		double totalC=0; //total number of customers who have entered the wait line
		double totalW=0; //total wait time;
		int [] temp= new int[3]; //holds wait time data needed for print
		for (int i = 0; i < 20; i++) 
			{
				int numC=getPoissonRandom(cpt,r);
				totalC+=numC;
				for (int j=0; j<numC;j++)
					{
					waitline.addToHead(0,getWaitTime(r,maxS));
					}
				while(servers>0 && waitline.getS()!=0)
				{
					servers--;
					beingServed.addToHead(waitline.tail.mywt, waitline.tail.reqS);
					waitline.deleteFromTail();
				}
				beingServed.reqSd();
				waitline.mywtUP();
				int avg=0;
				if(waitline.getS()!=0)
				{
					temp = waitline.twtPlus();
					totalW+=waitline.getS();
					avg = temp[1]/waitline.getS();
				}
				else
				{
				temp[0]=0; temp[1]=0; temp[2]=0;	
				}
				int temp2 =beingServed.clean();
				beenS+=temp2;
				servers+=temp2;
				printout(i,beingServed.getS(),beenS,waitline.getS(),temp[1],temp[0],avg ,temp[2]);
			}
			System.out.println("Diagnostics:");
			System.out.println("\tAvg wait time: "+ totalW/totalC);
			System.out.println("\tPercent of Customers Served: "+ beenS/totalC);
	}

	private static int getPoissonRandom(double mean, Random r) {
		 double L = Math.exp(-mean);
		 int k = 0;
		 double p = 1.0;
		 do {
			 p = p * r.nextDouble();
			 k++;
		 } while (p > L);
		 return k - 1;
		}

	private static void printout(int tick, int cis, double cwcs, int ciq, int twt, int wtmin, int wtavg, int wtmax)
	{
		System.out.println("Tick #: " + tick);
		System.out.println("\t# Customers in service: " + cis);
		System.out.println("\t# Customers with completed service: " + cwcs);
		System.out.println("\t# Customers with in queue: " + ciq);
		System.out.println("\tTotal wait time: " + twt);
		System.out.println("\tWait time: " + wtmin +", "+wtavg+", "+wtmax +"\n");
	}
	private static int getWaitTime(Random r, int max)
	{
		return r.nextInt((max))+1;
	}
}