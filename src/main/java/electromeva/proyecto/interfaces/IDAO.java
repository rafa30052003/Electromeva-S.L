package electromeva.proyecto.interfaces;

import java.sql.SQLException;
import java.util.List;


public interface IDAO<T,K> {
	
	
	boolean insert (T ob);
	
	T get(K id) throws SQLException;
	
	List<T> getall();
	
	int update(T ob);
	
	int delete(T ob) throws SQLException ;

	

	
	
}
