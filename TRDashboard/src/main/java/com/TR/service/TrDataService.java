package com.TR.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TR.TRDashboard.DataModel;
import com.TR.TRDashboard.JiraItemRepository;

@Service
public class TrDataService {

	@Autowired 
	private JiraItemRepository jiraRepo;
	
	public List<String> getProject(){
		List<String> projectList = jiraRepo.getAllProjects();
		return projectList;
	}
	
	public List<String> getSprintByProject(String project){
		List<String> sprintList = jiraRepo.getSprintByProject(project);
		return sprintList;
	}
	
	public List<DataModel> getDataModel(String project, String sprint){
		List<DataModel> dataList = jiraRepo.getDataModel(project, sprint);
		return dataList;
	}
	
	public void SaveData (ArrayList<DataModel> data) {
		
		jiraRepo.saveAll(data);
		
	}
}
