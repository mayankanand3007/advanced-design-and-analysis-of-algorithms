
public class linkedList {

	static class Node {
		int data;
		int priority;
		Node next;
	}

	static Node node = new Node();
	static Node Insert(int data)
	{
			node = Insert(data,19);
			return node;
	}
	static Node Insert(int data, int priority)
	{
		Node start = node;
	    Node temp = new Node();
	    temp.data = data;
	    temp.priority = priority;
	    temp.next = null;
	    
	    if((node).priority > priority)
	    {
	    	temp.next = node;
	    	(node) = temp;
	    }
	    else
	    {
	    	while(start.next != null && start.next.priority < priority)
	    	{
	    		start = start.next;
	    	}
	    	temp.next = start.next;
	    	start.next = temp;
	    }
	    return node;
	}
	
	static int Del_Min() {
		int d = node.next.data;
		node = pop(node.next);
	    return d;
	}
	
	static void Decrease_Priority(int data,int k) {
		Node n = node;
		node = null;
		node = new Node();
		while(isEmpty(n)==0)
		{
			if((n).data == data) {
				Insert((n).data,(n).priority-k);
			}
			else
			{
				Insert((n).data,(n).priority);
			}
			n= pop(n);
		}
		
	}
	
	static Node pop(Node n)
	{
	    (n) = (n).next;
	    return n;
	}
	
	static int peek(Node n)
	{
	    return (n).data;
	}
	static int isEmpty(Node n)
	{
	    return ((n) == null)?1:0;
	}
	static void display()
	{
		node=pop(node);
		while (isEmpty(node)==0) {
	        System.out.printf("%d ", peek(node));
	        node=pop(node);
	    }
	}
	public static void main(String[] args)
	{
		Node pq =Insert(5,21);
		pq=Insert(4);
		pq=Insert(8,25);
		pq=Insert(19,22);
		pq=Insert(24,28);
		pq=pop(pq);
		System.out.println("After adding the values based on Priority");
		while (isEmpty(pq)==0) {
	        System.out.printf("%d ", peek(pq));
	        pq=pop(pq);
	    }
		System.out.println("\n\nRemoving the head of the linked list: "+Del_Min());
		System.out.println("\nDecreses the priority value with 5 for data 24 and displaying the Linked List");
		Decrease_Priority(24,5);
		display();
		
	}
}
