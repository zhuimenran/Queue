package com.txb.queue.util;

public class LinkedListQueue<E> implements Queue<E> {

	private class Node{
		public E e;
		public Node next;
		
		public Node(E e, Node next) {
			this.e = e;
			this.next = next;
		}
		
		public Node(E e) {
			this.e = e;
			this.next = null;
		}
		
		public Node(){
			this.e = null;
			this.next = null;
		}
	}

	private Node head;//头节点
	private Node tail;//尾节点
	private int size;
	
	public LinkedListQueue() {
		head = null;
		tail = null;
		size = 0;
	}
	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return size==0;
	}

	/**
	 * 入队，添加在链表尾，tail为尾指针
	 */
	@Override
	public void enqueue(E e) {
		if(tail == null) {
			tail = new Node(e);
			head = tail;
		}else {
			tail.next = new Node(e);
			tail = tail.next;
		}
		size++;
	}
/**
 * 出队，删除头节点
 */
	@Override
	public E dequeue() {
		if(isEmpty()) {
			throw new IllegalArgumentException("无元素出队");
		}
	  
		Node retNode = head;
		head = head.next;
		if(head == null) {
			tail = null;//维护一下Tail
		}
		retNode.next  = null;
		
		return retNode.e;
	}

	@Override
	public E getFront() {
		if(isEmpty()) {
			throw new IllegalArgumentException("无元素出队");
		}
		
		return head.e;
	}
	
	@Override
	public String toString() {
		StringBuilder res = new StringBuilder();
		res.append("Queeu:front" );
		
		Node cur = head;
		while(cur != null) {
			res.append(cur.e+"->");
			cur = cur.next;
		}
		res.append("NULL tail");
		return res.toString();
	}
	
}
