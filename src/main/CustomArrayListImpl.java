package main;

import java.util.ArrayList;
import java.util.List;

import main.IteratorItem.IterableItem;
import model.Icecream;

// custom ArrayList implementation that gives the iterator for arraylist of ice cream flavors
public class CustomArrayListImpl implements IterableItem {
	
	List<Icecream> customList = new ArrayList<>();
	
	@Override
	public Iterator getIterator() {
		return new CustomArrayListIterator();
	}
	
	private class CustomArrayListIterator implements Iterator {

		int current;
		
		@Override
		public boolean hasNext() {
	
			if(current < customList.size())
				return true;
			return false;
		}

		@Override
		public Object next() {

			if(this.hasNext()) {
				return customList.get(current++);
			}
			
			return null;
		}

	}
	
	// the following returns true if the new flavor is added successfully to the list of flavors
	public boolean addFlavor(Icecream icecream) {
		return this.customList.add(icecream);
	}
	
	public boolean removeFlavor(Icecream icecream) {
		return this.customList.remove(icecream);
	}
	
}