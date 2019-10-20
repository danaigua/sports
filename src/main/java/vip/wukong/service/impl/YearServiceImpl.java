package vip.wukong.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import vip.wukong.entity.Year;
import vip.wukong.repository.YearRepository;
import vip.wukong.service.YearService;

@Service("yearService")
public class YearServiceImpl implements YearService {

	@Resource
	private YearRepository yearRepository;

	@Override
	public void save(Year year) {
		yearRepository.save(year);
	}

	@Override
	public List<Year>  combobox() {
		return yearRepository.findAll(new Sort(Direction.DESC, "id"));
	}

	@Override
	public Year getByName(String year) {
		return yearRepository.getByName(year);
	}
	
	
}
