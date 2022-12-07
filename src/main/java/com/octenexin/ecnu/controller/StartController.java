package com.octenexin.ecnu.controller;

import com.octenexin.ecnu.pojo.ProjectClass;
import com.octenexin.ecnu.pojo.ProjectState;
import com.octenexin.ecnu.pojo.ProjectType;
import com.octenexin.ecnu.service.MessageService;
import com.octenexin.ecnu.util.IdManageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Tofweod
 * 启动设置，开启某些服务
 */
@Controller
public class StartController {
	@Autowired
	MessageService messageService;
	
	@Resource
	private JdbcTemplate jdbcTemplate;

	@RequestMapping("/")
	public String start(HttpSession session){
		// 添加邮件服务至会话
		if(session.getAttribute("messageService") == null)
			session.setAttribute("messageService",messageService);
		
		Map<Integer, ProjectClass> classMap = new HashMap<>();
		String sql1 = "select * from project_classes";
		List<ProjectClass> classes = jdbcTemplate.query(sql1, new BeanPropertyRowMapper<>(ProjectClass.class));
		for (ProjectClass aClass : classes) {
			classMap.put(aClass.getProjectClassId(),aClass);
		}
		IdManageUtils.setClassMap(classMap);
		
		Map<Integer, ProjectState> stateMap = new HashMap<>();
		String sql2 = "select * from project_states";
		List<ProjectState> states = jdbcTemplate.query(sql2, new BeanPropertyRowMapper<>(ProjectState.class));
		for (ProjectState state : states) {
			stateMap.put(state.getProjectStateId(),state);
		}
		IdManageUtils.setStateMap(stateMap);
		
		Map<Integer, ProjectType> typeMap = new HashMap<>();
		String sql3 = "select * from project_types";
		List<ProjectType> types = jdbcTemplate.query(sql3, new BeanPropertyRowMapper<>(ProjectType.class));
		for (ProjectType type : types) {
			typeMap.put(type.getProjectTypeId(),type);
		}
		IdManageUtils.setTypeMap(typeMap);
		
		
		return "/login";
	}
}
