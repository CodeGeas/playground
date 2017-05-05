package com.jitesh.threads;



class MyTestThread extends Thread{
	int next;
	MySequenceThread mySequenceThread;
		
	
	public MyTestThread(int next,MySequenceThread mySequenceThread) {
	super();
	this.next = next;
	this.mySequenceThread=mySequenceThread;
}
public void run(){
	while(true){
		boolean lock=false;
		synchronized(mySequenceThread){
			
	//		if(mySequenceThread.getCount()!=next || !isFirst){
				
			
			
			while(mySequenceThread.getCount()!=next ){
			//	System.out.println(currentThread().getName()+",next="+next+",isFirst="+isFirst+",diff="+(mySequenceThread.getCount()-next));
				//mySequenceThread.notifyAll();
				try {
					mySequenceThread.wait();
} catch (InterruptedException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
			
			}
		//	}
		
		//	if(mySequenceThread.getCount()-next==10 || mySequenceThread.getCount()==next){
				System.out.println(currentThread().getName()+" prints::"+mySequenceThread.getCount());
				next=mySequenceThread.getCount()+5;
				mySequenceThread.setCount(mySequenceThread.getCount()+1);
				//if(lock)
					mySequenceThread.notifyAll();
		//	}
			//else
			//{}
		}
		//System.out.println(mySequenceThread.getCount());
		if(mySequenceThread.getCount()>15){
			System.exit(0);
		}
	}
	
	}
	
}
public class MySequenceThread {
	
	int count;
	
	
	public static void main(String args[]){
		
		int noOfthreads=10;
		MySequenceThread mySequenceThread=new MySequenceThread();
		mySequenceThread.setCount(1);
		
		for(int i=1;i<=5;i++)
		{
		new MyTestThread(i, mySequenceThread).start();
		}

	}
	public int getCount() {
		return count;
	}


	public void setCount(int count) {
		this.count = count;
	}
	
}
