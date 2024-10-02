package j.haianh.service;

import java.util.List;

import j.haianh.models.CatergoryModel;

public interface IcatergoryService {
	List<CatergoryModel> findAll();
	CatergoryModel findById (int id);
	void insert (CatergoryModel category);
	void update (CatergoryModel category);
	void delete (int id);
	List<CatergoryModel> findByName(String keyword);
	void softdelete(CatergoryModel category);

}
