package com.txb.queue.test;

import java.util.Random;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

import com.txb.queue.util.ArrayQueue;
import com.txb.queue.util.LinkedListQueue;
import com.txb.queue.util.LoopQueue;
import com.txb.queue.util.Queue;

public class Main {
	
	public static double testQueue(Queue<Integer> q, int opCount) {
		
		long startTime = System.nanoTime();
		
		Random random = new Random();
		
		for(int i = 0; i < opCount; i++) {
			q.enqueue(random.nextInt(Integer.MAX_VALUE));
		}
		
		for(int i = 0; i < opCount; i ++) {
			q.dequeue();
		}
		long endTime = System.nanoTime();
		
		return (endTime-startTime)/1000000000.0;
		
	}
	public static void main2(String []args) {
	     LinkedListQueue<Integer> queue = new LinkedListQueue<Integer>();
			
			for(int i = 0 ; i < 10; i ++) {
				queue.enqueue(i);
				System.out.println(queue);
				if(i%3==2) {
					queue.dequeue();
					System.out.println(queue);
				}
			}
			
		}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		ArrayQueue<Integer> queue = new ArrayQueue<Integer>(10);
		
		for(int i = 0 ; i < 10; i ++) {
			queue.enqueue(i);
			System.out.println("add:"+queue);
			if(i%3==2) {
				queue.dequeue();
				System.out.println("del:"+queue);
			}
		}
		
		
		
		LoopQueue<Integer> loopqueue = new LoopQueue<Integer>();
		
		for(int i = 0 ; i < 10; i ++) {
			loopqueue.enqueue(i);
			System.out.println("add:"+loopqueue);
			if(i%3==2) {
				
				loopqueue.dequeue();
				System.out.println("del:"+loopqueue);
			}
		}
		*/
		int opCount = 100000;
		
		ArrayQueue<Integer> array = new ArrayQueue<>();
		double time1 = testQueue(array,opCount);
		System.out.println(time1);
		
		LoopQueue<Integer> loop = new LoopQueue<>();
		double time2 = testQueue(loop,opCount);
		System.out.println(time2);
		
		LinkedListQueue<Integer> linked = new LinkedListQueue<>();
		double time3 = testQueue(linked,opCount);
		System.out.println(time3);
		
	}

}
