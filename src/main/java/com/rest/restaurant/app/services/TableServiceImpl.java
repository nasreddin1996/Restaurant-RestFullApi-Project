package com.rest.restaurant.app.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.restaurant.app.models.TableEntity;
import com.rest.restaurant.app.repositories.TableRepository;

@Service
public class TableServiceImpl implements TableService {
	
	@Autowired
	private TableRepository tableRepo;

	@Override
	public List<TableEntity> findAll() {
		return tableRepo.findAll();
	}

	@Override
	public TableEntity save(TableEntity table) {
		return tableRepo.save(table);
	}

	@Override
	public TableEntity finById(long number) {
		Optional<TableEntity> table=tableRepo.findById(number);
		if(table.isPresent())
			return table.get();
		else
			return null;
	}

	@Override
	public TableEntity edit(TableEntity table, long number) {
		TableEntity oldTable=this.finById(number);
		if(oldTable!=null) {
			oldTable.setCoverNumber(table.getCoverNumber());
			oldTable.setType(table.getType());
			return oldTable;
		}
		return null;
	}

	@Override
	public Boolean delete(long number) {
		TableEntity table=this.finById(number);
		if(table!=null) {
			tableRepo.delete(table);
			return true;
		}
		return false;
	}

}