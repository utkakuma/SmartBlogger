package com.smartblogger.dao;

import java.io.Serializable;
import java.util.List;

public interface DaoImpl<MyObj, Id extends Serializable> {
	public List<MyObj> getAll();
	public MyObj getById(Id id);
	public void create(MyObj myobj);
	public void update(MyObj myobj);
	public void delete(MyObj myobj);
	public void deleteAll();
}
