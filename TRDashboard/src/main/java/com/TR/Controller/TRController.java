package com.TR.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.TR.TRDashboard.DataModel;
import com.TR.service.TRService;
import com.TR.service.TrDataService;

@RestController
public class TRController {
	
	@Autowired
	public TRService service;
	
	@Autowired
	private TrDataService dataService;
	
	@RequestMapping("/jira/getprojects")
	public List<String> getProjects(){
		return dataService.getProject();
	}
	
	@RequestMapping("/jira/{project}")
	public List<String> getSprint(@PathVariable ("project") String project){
		return dataService.getSprintByProject(project);
	}
	
	@RequestMapping("/jira/{project}/{sprint}")
	public List<DataModel> getData(@PathVariable ("project") String project, @PathVariable ("sprint") String sprint){
		return dataService.getDataModel(project, sprint);
	}
	
	@GetMapping("/getData")
	public String getDashboardData() {
		
	String response =	service.getDashBoardData();
	
	service.responseParser(response);
	
		return response;
	}

}
