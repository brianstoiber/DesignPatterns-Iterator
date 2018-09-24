package main;

// iterator interface, concrete classes implement the hasNext and next methods
public interface Iterator {
	boolean hasNext();
	Object next(); 
}