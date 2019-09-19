package singlylinkedlist;

/**
 * Modified from Drozdek, Data Structures and Algorithms in Java
 */

public class singlylinkedlist {

	public class Node {
		int data;
		Node next;

		public Node() {
			this(0, null);
		}

		public Node(int data) {
			this(data, null);
		}

		public Node(int data, Node next) {
			this.data = data;
			this.next = next;
		}
	}

	Node head, tail, tempA, tempB;

	public singlylinkedlist() {
		head = tail = null;
	}

	public void addToHead(int data) {
		head = new Node(data, head);
		if (tail == null)
			tail = head;
	}

	public void addToTail(int data) {
		if (!isEmpty()) {
			tail.next = new Node(data);
			tail = tail.next;
		} else
			head = tail = new Node(data);
	}

	public void delete(int el) {
		if (!isEmpty())
			if (head == tail && el == head.data)
				head = tail = null;
			else if (el == head.data)
				head = head.next;
			else {
				Node p, q;
				for (p = head, q = head.next; q != null && !(q.data == el); p = p.next, q = q.next)
					;
				if (q != null) {
					p.next = q.next;
					if (q == tail)
						tail = p;
				}
			}
	}

	public void insert(int d) {
		if (!isEmpty()) {
			if (head.next == null) {
				if (d > head.data) {
					tail = new Node(d);
					head.next = tail;
					System.out.println(d);
				} else {
					tail = head;
					head = new Node(d);
					head.next = tail;

				}
			} else {
				tempA = head;
				tempB = head.next;
				boolean run = true;
				if (d < head.data) {
					addToHead(d);

				} else {
					if (d > tail.data) {
						addToTail(d);
					} else {
						do {
							if (d >= tempA.data && d <= tempB.data) {
								tempA.next = new Node(d);
								tempA.next.next = tempB;
								run = false;

							} else {
								tempA = tempB;
								tempB = tempB.next;
								if (tempB == null) {
									run = false;
								}

							}
						} while (run);
					}
				}

				if (d >= tempA.data && d <= tempB.data) {
					tempA.next = new Node(d);
					tempA.next.next = tempB;

				}

			}
		} else {
			head = new Node(d, head);
		}
	}

	public int deleteFromHead() {
		if (isEmpty())
			return Integer.MIN_VALUE;
		int x = head.data;
		if (head == tail)
			head = tail = null;
		else
			head = head.next;

		return x;
	}

	public int deleteFromTail() {
		if (isEmpty())
			return Integer.MIN_VALUE;
		int x = tail.data;
		if (head == tail)
			head = tail = null;
		else {
			Node p;
			for (p = head; p.next != tail; p = p.next)
				;
			tail = p;
			tail.next = null;
		}

		return x;
	}

	public boolean isEmpty() {
		return head == null;
	}

	public String toString() {
		String s = "";
		if (head == null) {
			return "Empty String";
		}
		for (Node p = head; p != null; p = p.next)
			s += p.data + " ";
		return s;
	}

	public static void main(String[] args) {
		singlylinkedlist list = new singlylinkedlist();

		System.out.println("Execution begun");
		System.out.println("initial list: " + list);

		// Sample run
		list.addToHead(1);
		list.addToTail(10);
		list.addToTail(15);
		list.addToTail(20);
		list.insert(14);
		System.out.println(list.head.next);
		System.out.println("1: " + list);

		list.delete(1);
		list.delete(10);
		System.out.println("2: " + list);
		System.out.println("Execution terminated");
	}
}
