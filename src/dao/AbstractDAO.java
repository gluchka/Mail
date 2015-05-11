package dao;

import java.util.List;



public interface AbstractDAO <K,T extends Entity>{
	

	public abstract  List<T> selectQuery();
	public abstract boolean deleteQuery();

	

}
