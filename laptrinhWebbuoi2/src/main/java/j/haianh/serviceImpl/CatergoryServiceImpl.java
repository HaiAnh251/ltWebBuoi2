package j.haianh.serviceImpl;

import java.util.List;

import j.haianh.dao.ICatergoryDao;
import j.haianh.dao.impl.CatergorydaoImpl;
import j.haianh.models.CatergoryModel;
import j.haianh.service.IcatergoryService;

public class CatergoryServiceImpl implements IcatergoryService{

	public ICatergoryDao catedao=new CatergorydaoImpl();
	
	@Override
	public List<CatergoryModel> findAll() {
		
		return catedao.findAll();
	}

	@Override
	public CatergoryModel findById(int id) {
		
		return catedao.findById(id);
	}

	@Override
	public void insert(CatergoryModel category) {
		catedao.insert(category);
		
	}

	@Override
	public void update(CatergoryModel category) {
		catedao.update(category);
		
	}

	@Override
	public void delete(int id) {
		catedao.delete(id);
		
	}

	@Override
	public List<CatergoryModel> findByName(String keyword) {
		return catedao.findByName(keyword);
	}

	@Override
	public void softdelete(CatergoryModel category) {
		catedao.softdelete(category);
		
	}

}
