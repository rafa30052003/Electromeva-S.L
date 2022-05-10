package electromeva.proyecto.interfaces;

import java.util.List;


public interface IDAO<T,K> {
	
	
	boolean insert (T ob);
	
	T get(K id);
	
	List<T> getall();
	
	int update(T ob);
	
	int delete(T ob);

	

	
	
}
