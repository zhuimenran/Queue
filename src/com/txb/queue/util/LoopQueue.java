package com.txb.queue.util;

/**
 * 循环队列
 * @author 13125
 *
 * @param <E>
 */
public class LoopQueue<E> implements Queue<E> {

	private E []data;
	private int front;//队首
	private int tail;//队尾
	private int size;
	
	//构造函数
	public LoopQueue(int capacity) {
		data = (E[]) new Object[capacity+1];
		
		size = 0;
		front = 0;
		tail = 0;
	}
	
	public LoopQueue() {
		this(10);
	}
	
	//得到容量
	public int getCapacity() {
		return data.length-1;
	}
	
	@Override
	//得到数量大小
	public int getSize() {
		
		return size;
	}

	@Override
	//是否为空
	public boolean isEmpty() {
		
		return front == tail;
	}

	@Override
	//入队
	public void enqueue(E e) {
		
		if((tail+1)%data.length == front) {
			resize(2*getCapacity());
		}
		
		data[tail] = e;
		size++;
		tail = (tail+1) % data.length;//出现了bug
	}

	//扩容操作
	private void resize(int newCapacity) {
		
		E[]	newData = (E[]) new Object[newCapacity+1];
		
		for(int i = 0; i  < size ; i ++) {
			newData[i] = data[(front+i)%data.length];
		}
	
		data = newData;
		tail = size;
		front = 0;
	}

	
	@Override
	//出队
	public E dequeue() {
		
		if(isEmpty()) {
			throw new IllegalArgumentException("队列为空");
		}
		
		 E ret = data[front];
		 
		 data[front] = null;
		 front = (front+1) % data.length;
		 size--;
		 
		 if(size == getCapacity()/4 && (getCapacity()/2) != 0) {
			 resize(getCapacity()/2);
		 }
		return ret;
	}

	@Override
	//查看队首
	public E getFront() {
		if(isEmpty()) {
			throw new IllegalArgumentException("队列为空");
		}
		
		return data[front];
	}
	
	
	//to String
	@Override
	public String toString() {
		StringBuilder res = new StringBuilder();
		res.append(String.format("loopQueue: size = %d , capacity = %d\n",  size , getCapacity()));
		res.append("front[");
		
		for(int i = front; i != tail ; i = (i+1)%data.length) {
			res.append(data[i]);
			if((i+1)%data.length != tail) {
				res.append(",");
			}
		}
		
		res.append("]tail");
		
		return res.toString();
	}

}
