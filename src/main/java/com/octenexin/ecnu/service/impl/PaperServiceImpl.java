package com.octenexin.ecnu.service.impl;

import com.octenexin.ecnu.dao.PaperDao;
import com.octenexin.ecnu.pojo.Paper;
import com.octenexin.ecnu.service.PaperService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Tofweod
 */
@Service("paperService")
public class PaperServiceImpl implements PaperService {
	
	@Resource
	PaperDao paperDao;
	
	@Override
	public int addPaper(Paper paper) {
		return paperDao.addPaper(paper);
	}
	
	@Override
	public int updatePaper(Paper paper) {
		return paperDao.updatePaper(paper);
	}
	
	@Override
	public int deletePaper(Paper paper) {
		return paperDao.deletePaper(paper);
	}
	
	
	@Override
	public List<Paper> getPapers(List<Paper> papers) {
		return paperDao.getPapers(papers);
	}
	
	
	@Override
	public List<Paper> getPaperPage(int start, int nums) {
		return paperDao.getPaperPage(start,nums);
	}
	
	@Override
	public Paper getPaper(Paper paper) {
		return paperDao.getPaper(paper);
	}
	
}
