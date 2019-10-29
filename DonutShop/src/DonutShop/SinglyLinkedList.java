package DonutShop;

public class SinglyLinkedList {
	   public class Node {
		   
		   
		      int mywt;
		      int reqS;
		      Node  next;
		      
		      public Node () {
		         this  (0, 0, null);
		      }
		      
		      public Node ( int mywt, int reqS) {
		         this( 0, reqS, null);
		      }
		      
		      public Node( int mywt, int reqS, Node next) {
		         this.mywt = mywt;
		         this.reqS = reqS;
		         this.next = next;
		      }
		   }
		   
		   Node  head, tail;
		   int size;
		   public SinglyLinkedList() {
		      head = tail = null;
		      size=0;
		   }
		   
		   public void addToHead(int mywt, int reqS) {
		      head = new Node(mywt, reqS, head);
		      size++;
		      if ( tail == null )
		         tail = head;
		   }
		   
		   public void addToTail( int mywt, int reqS) {
		      if ( !isEmpty() ) {
		         tail.next =new Node( mywt, reqS, head);
		         tail = tail.next;
		      }
		      else head = tail = new Node( mywt, reqS, head);
		      size++;
		   }
		   
	
		   
		   public void deleteFromHead() {
		      if ( !isEmpty() )
		      {
		      if ( head == tail )
		         head = tail = null;
		      else head = head.next;
		      size--;
		      }
		   }
		   
		   public void deleteFromTail() {
		      if ( !isEmpty() )
		      {
		      if ( head == tail )
		         head = tail = null;
		      else {
		         Node p;
		         for (p = head; p.next != tail; p = p.next) ;
		         tail = p;
		         tail.next = null; 
		      }
		      size--;
		      }
		   }
		   
		   public boolean isEmpty() {
		      return head == null;
		   }
		   
		   public void  mywtUP() {
			      for (Node p = head; p != null; p = p.next) 
			    	  p.mywt++;
			   }
		   public void  reqSd() {
			      for (Node p = head; p != null; p = p.next) 
			    	  p.reqS--;
			   }
		   public int clean()
		   {
			   Node temp=null;
			   int serviced=0;
			   for (Node p = head; p != null; p = p.next) 
			   {
				   if(p.reqS==0)
				   {
					   serviced++;
					   if(head==tail)
					   {
						   head = tail = null;
						   size--;
					   }
					   else if (p==head)
					   {
						   head=head.next;
						   size--;
					   }
					   else
					   {
						  temp.next= p.next;
						  size--;
					   }
				   }
			temp=p;
			
			   }
			   return serviced;
		   }
		   
		 public int getS()
		 {
			 return size;
		 }
		 public int [] twtPlus()
		 {
			 int [] temp = new int [3];
			 temp [0]=head.mywt;
			 temp [1]=0;
			 temp [2]=head.mywt;
			 for (Node p = head; p != null; p = p.next) 
			   {
				 if(p.mywt<temp[0])
				 {
					 temp[0]=p.mywt;
				 }
				 temp[1]+=p.mywt;
				 if(p.mywt>temp[2])
				 {
					 temp[2]=p.mywt;
				 }
				 
			   }
			 return temp;
		 }
		   public static void main(String[] args) {
			      SinglyLinkedList list = new SinglyLinkedList();
			      
			      System.out.println("Execution begun");
			      System.out.println("initial list: " + list );
			      
			      // Sample run
			      list.addToHead(2,2);
			      list.addToHead(2,2);
			      list.addToTail(2,2);
			      System.out.println("1: " + list);
			      
			      System.out.println("2: " + list);
			      System.out.println("Execution terminated");
			   }

}
