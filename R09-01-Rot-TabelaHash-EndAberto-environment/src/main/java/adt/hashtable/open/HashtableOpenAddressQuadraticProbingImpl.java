package adt.hashtable.open;

import adt.hashtable.hashfunction.HashFunctionClosedAddressMethod;
import adt.hashtable.hashfunction.HashFunctionLinearProbing;
import adt.hashtable.hashfunction.HashFunctionQuadraticProbing;

public class HashtableOpenAddressQuadraticProbingImpl<T extends Storable>
		extends AbstractHashtableOpenAddress<T> {

	public HashtableOpenAddressQuadraticProbingImpl(int size,
			HashFunctionClosedAddressMethod method, int c1, int c2) {
		super(size);
		hashFunction = new HashFunctionQuadraticProbing<T>(size, method, c1, c2);
		this.initiateInternalTable(size);
	}

	@Override
	public void insert(T element) {
		if(element != null) {
			
			if(!isFull()) {
				
				int probe = 0;
				int index;
				boolean adicionou = false;
				
				while(probe < this.table.length && !adicionou) {
					
					index = ((HashFunctionQuadraticProbing<T>)this.hashFunction).hash(element, probe++);
					
					if(this.table[index] == null || this.table[index] instanceof DELETED) {
						this.table[index] = element;
						this.elements++;
						adicionou = true;
					} else {
						this.COLLISIONS++;
					}	
				}
				
			} else {
				throw new HashtableOverflowException();
			}
		}
	}

	@Override
	public void remove(T element) {
		if(element != null) {
			int index = indexOf(element);
			if(index != -1) {
				this.table[index] = new DELETED();
				this.elements--;
			}
		}
	}

	@Override
	public T search(T element) {
		T retorno = null;
		if(element != null) {
			if(indexOf(element) != -1) {
				retorno = element;
			}
		}
		return retorno;
	}

	@Override
	public int indexOf(T element) {
		int retorno = -1;
		if(element != null) {
			
			int probe = 0;
			int index;
			boolean encontrou = false;
			
			while(probe < this.table.length && !encontrou) {
				
				index = ((HashFunctionQuadraticProbing<T>)this.hashFunction).hash(element, probe++);
				
				if(this.table[index] != null && !(this.table[index] instanceof DELETED)) {
					
					if(this.table[index].equals(element)) {
						retorno = index;
						encontrou = true;
					}
				}
			}
			
			
		}
		
		return retorno;
	}
}
