import java.util.NoSuchElementException;

public class MyStack<E> {
	private ListaEnlazada<E> stack;
	
	public MyStack() {
		this.stack = new ListaEnlazada<E>();
	}
	
	public int size() {
		return this.stack.size();
	}
	
	public boolean isEmpty() {
		return this.stack.isEmpty();
	}
	
	public void flush() {
		this.stack=new ListaEnlazada<E>();
		System.gc();
	}
	
	public void push(E valor) {
		this.stack.insertarInicio(valor);;
	}
	
	public E pop() {//Borra o saca el siguiente elemento en la cola
		try {
			return this.stack.borrarInicio();
		}catch(NoSuchElementException ex) {
			throw new NoSuchElementException("No se puede borrar de una cola vacía");
		}
		
	}
	
	public E top() {//Regresa el siguiente elemento en salir
		try {
			return this.stack.inicio();
		}catch(NoSuchElementException ex) {
			throw new NoSuchElementException("No se puede obtener el siguiente elemento de una cola vacía");
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyStack<String> stack = new MyStack<String>();
		String[] frase = {"J","o", "e" ,"l"};
		for(String f:frase) {
			stack.push(f);
		}
		while(!stack.isEmpty()) {
			System.out.print(stack.pop());
		}
	}
}
