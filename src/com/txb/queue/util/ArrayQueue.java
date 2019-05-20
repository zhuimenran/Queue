package com.txb.queue.util;

public class ArrayQueue<E> implements Queue<E> {

	Array<E> array;
	
	//构造函数
	public ArrayQueue(int capacity) {
		array = new Array<E>(capacity);
	}
	
	public ArrayQueue() {
		array = new Array<E>(10);
	}
	
	@Override
	public int getSize() {
		
		return array.getSize();
	}

	@Override
	public boolean isEmpty() {
		
		return array.isEmpty();
	}

	@Override
	//入队，添加数组尾
	public void enqueue(E e) {
		array.addLast(e);
	}

	@Override
	//出队，删除数组头
	public E dequeue() {
		return array.removeFirst();
	}

	@Override
	//查看队首元素
	public E getFront() {
		return array.getFirst();
	}

	public int getCapacity() {
		return array.getCapacity();
	}
	
	//to String
			@Override
			public String toString() {
				StringBuilder res = new StringBuilder();
				res.append(String.format("Queue: size = %d , capacity = %d\n",  array.getSize() , array.getCapacity()));
				res.append("front[");
				
				for(int i = 0; i < array.getSize(); i ++) {
					res.append(array.get(i));
					if(i != array.getSize()-1) {
						res.append(",");
					}
				}
				
				res.append("]tail");
				
				return res.toString();
			}
}
