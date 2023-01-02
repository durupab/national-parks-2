package proje3;

public class Heap
{
   public HeapNode[] heapArray; //elemanlari tutmak icin Node sinifi tipinde liste degiskeni
   private int maxSize; 
   private int currentSize; 

   public Heap(int mx) //yapilandirici metot
   {
      maxSize = mx;
      currentSize = 0;
      heapArray = new HeapNode[maxSize]; 
   }
   
   public void yaz() {
	   for(int i = 0;i<currentSize;i++) {
		   System.out.println(heapArray[i]);
	   }
   }

   //Heap e eleman ekleme metotu
   public boolean insert(milliPark key)
   {
	   if(currentSize==maxSize) // if array is full,
		   return false; 
	   HeapNode newNode = new HeapNode(key);
	   heapArray[currentSize] = newNode; // put it at the end
	   trickleUp(currentSize++); // trickle it up
	   return true; // success
   } // end insert()
   
   public void trickleUp(int index)
   {
	   int parent = (index-1) / 2;    //STRINGLERI INT CEVIR
	   HeapNode bottom = heapArray[index];
	   while( index > 0 && Integer.valueOf(heapArray[parent].getKey().getYuz_Olcumu()) < Integer.valueOf(bottom.getKey().getYuz_Olcumu())){
	   heapArray[index] = heapArray[parent]; // move node down
	   index = parent; // move index up
	   parent = (parent-1) / 2; // parent <- its parent
	   } // end while
	   heapArray[index] = bottom;
   } // end trickleUp()
   
   public HeapNode remove() // delete item with max key
   { // (assumes non-empty list)
	   HeapNode root = heapArray[0];
	   System.out.println(heapArray[0]); // save the root
	   heapArray[0] = heapArray[--currentSize]; // root <- last
	   trickleDown(0); // trickle down the root
	   
	   return root; // return removed node
   } // end remove()

   public void trickleDown(int index)
   {
	   int largerChild;
	   HeapNode top = heapArray[index]; // save root
	   while(index < currentSize/2) // while node has at
	   { // least one child,
		   int leftChild = 2*index+1;
		   int rightChild = leftChild+1;
	   
		   if( rightChild < currentSize && Integer.valueOf(heapArray[leftChild].getKey().getYuz_Olcumu()) == Integer.valueOf(heapArray[rightChild].getKey().getYuz_Olcumu()))
			   largerChild = rightChild;
		   else
			   largerChild = leftChild;
		  
		   if(Integer.valueOf(top.getKey().getYuz_Olcumu()) >= Integer.valueOf(heapArray[largerChild].getKey().getYuz_Olcumu()))
			   break;
		   
		   heapArray[index] = heapArray[largerChild];
		   index = largerChild;
	   } 
	   heapArray[index] = top; // index <- root
   }

}