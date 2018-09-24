package main;

// implemented by all concrete classes that provide a way to iterate through the collection of data
public class IteratorItem {

	public interface IterableItem {
		Iterator getIterator();
	}

}