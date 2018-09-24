package main;

import java.util.HashMap;
import java.util.Map;

import main.IteratorItem.IterableItem;
import model.Cookie;

// implements hashtable that stores cookie information. 
// integer numItems is used as reference to store the key value map inside the cookieMap

public class CustomHashTableImpl implements IterableItem {

	Map<Integer, Cookie> cookieMap = new HashMap<>();
	
	int numItems;
	
	@Override
	public Iterator getIterator() {
		return new CustomHashTableIterator();
	}
	
	private class CustomHashTableIterator implements Iterator {

		int current;
		
		@Override
		public boolean hasNext() {
	
			if(current < numItems)
				return true;
			return false;
		}

		@Override
		public Object next() {

			if(this.hasNext()) {
				return cookieMap.get(current++);
			}
			
			current++;
			return null;
		}

	}
	
	public void addCookie(Cookie cookie) {
		this.cookieMap.put((numItems++) , cookie);
	}
	
	public void removeCookie(int index) {
		this.cookieMap.remove(index);
	}

}