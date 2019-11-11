package adt.skipList;

public class SkipListImpl<T> implements SkipList<T> {

	protected SkipListNode<T> root;
	protected SkipListNode<T> NIL;

	protected int maxHeight;

	protected double PROBABILITY = 0.5;

	public SkipListImpl(int maxHeight) {
		this.maxHeight = maxHeight;
		root = new SkipListNode(Integer.MIN_VALUE, maxHeight, null);
		NIL = new SkipListNode(Integer.MAX_VALUE, maxHeight, null);
		connectRootToNil();
	}

	/**
	 * Faz a ligacao inicial entre os apontadores forward do ROOT e o NIL Caso
	 * esteja-se usando o level do ROOT igual ao maxLevel esse metodo deve
	 * conectar todos os forward. Senao o ROOT eh inicializado com level=1 e o
	 * metodo deve conectar apenas o forward[0].
	 */
	private void connectRootToNil() {
		for (int i = 0; i < maxHeight; i++) {
			root.forward[i] = NIL;
		}
	}

	
	@Override
	public void insert(int key, T newValue, int height) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public void remove(int key) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public int height() {
		int maiorAltura = 0;
		
		SkipListNode<T> aux = this.root.forward[0];

		
		while(aux.getKey() != Integer.MAX_VALUE) {
			
			if(aux.getForward().length > maiorAltura) {
				maiorAltura = aux.getForward().length;
			}
			aux = aux.getForward(0);
		}
		
		return maiorAltura;
	}

	@Override
	public SkipListNode<T> search(int key) {
		SkipListNode<T> retorno = null;
		
		SkipListNode<T> aux = this.root.getForward(0);
		boolean encontrou = false;
		
		while(aux.getKey() != Integer.MAX_VALUE && !encontrou) {
			if(aux.getKey() == key) {
				retorno = aux;
				encontrou = true;
			}
			
			aux = aux.getForward(0);
		}
		
		return retorno;
	}

	@Override
	public int size() {
		int size = 0;
		
		SkipListNode<T> aux = this.root.getForward(0);
		
		while(aux.getKey() != Integer.MAX_VALUE) {
			size++;
			aux = aux.getForward(0);
		}
		
		return size;
		
	}

	@Override
	public SkipListNode<T>[] toArray() {
		SkipListNode<T>[] array = (SkipListNode<T>[]) new Object[size()];
		
		SkipListNode<T> aux = this.root.getForward(0);
		int index = 0;
		boolean terminou = false;
		
		while(!terminou) {
			array[index++] = aux;
			aux = aux.getForward(0);
			
			if (aux.getKey() == Integer.MAX_VALUE) {
				terminou = true;
			}
		}
		
		return array;
	}

}
