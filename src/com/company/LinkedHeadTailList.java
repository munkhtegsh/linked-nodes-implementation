package com.company;

import org.w3c.dom.Node;

import java.util.ArrayList;
import java.util.List;

public class LinkedHeadTailList<T> implements HeadTailListInterface<T> {

	private Node head, tail;

	public LinkedHeadTailList() {
	    this(null,null);
	}

	public LinkedHeadTailList(Node head, Node last) {
		this.head = head;
		this.tail = last;
	}

	@Override
	public void addFront(T newEntry) {
		Node newNode = new Node(newEntry);

		if (isEmpty()) {
			head = newNode;
			tail = newNode;
		} else {
		    newNode.next = head;
		    head.prev = new Node(newEntry);
		    head = newNode;
		}
	}

	@Override
	public void addBack(T newEntry) {
		Node newNode = new Node(newEntry);
		if (isEmpty()) {
			head = newNode;
			tail = newNode;
		} else {
			tail.next = newNode;
			newNode.prev = tail;
			tail = newNode;
		}
	}

	@Override
	public T removeFront() {
		return null;
	}

	@Override
	public T removeBack() {
		return null;
	}

	@Override
	public void clear() {
		head = null;
		tail = null;
	}

	@Override
	public T getEntry(int givenPosition) {
		return null;
	}

	@Override
	public void display() {
	    if (head == null) {
	        System.out.println("[]");
		} else {
			List<T> data = new ArrayList<>();

			if (head != null) {
				Node current = head;
				while (current != null) {
					data.add(current.data);
					current = current.next;
				}
			}

	    	System.out.println(data + "   head="+head.data + " tail="+tail.data );
		}
	}

	@Override
	public int indexOf(T anEntry) {
		Node current = head;
	    int idx = 0; // is it ==>> Note: For full credit, do not add any additional instance data variables. In particular, do not add a counter variable! (The purpose of this project is to get more practice with  nodes, not keeping count!)
	    while (current != null) {
	    	if (current.data.equals(anEntry)) {
	    		return idx;
			}
	    	current = current.next;
			idx++;
		}
		return -1;
	}

	@Override
	public int lastIndexOf(T anEntry) {
	    
		return 0;
	}

	@Override
	public boolean contains(T anEntry) {
		Node current = head;
		while (current != null) {
			if (current.data.equals(anEntry)) {
				return true;
			}
			current = current.next;
		}
		return false;
	}

	@Override
	public int size() {
		return 0;
	}

	@Override
	public boolean isEmpty() {
	    if (head == null) {
			return true;
		} else {
	    	return false;
		}
	}

	// YOUR CLASS HERE!


	private class Node {
		private T data; 
		private Node next;
		private Node prev;

		private Node(T dataPortion) {
			data = dataPortion;
			next = null;
			prev = null;
		}

		private Node(T dataPortion, Node nextNode, Node prevNode) {
			data = dataPortion;
			next = nextNode;
			prev = prevNode;
		}

		private T getData() {
			return data;
		}

		private void setData(T newData) {
			data = newData;
		}

		private Node getNextNode() {
			return next;
		}

		private void setNextNode(Node nextNode) {
			next = nextNode;
		}

		private Node getPrevNode() {
			return prev;
		}

		private void setPrevNode(Node prevNode) {
			prev = prevNode;
		}
	}
}
