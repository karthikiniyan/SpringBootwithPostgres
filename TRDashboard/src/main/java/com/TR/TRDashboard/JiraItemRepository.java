package com.TR.TRDashboard;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface JiraItemRepository extends CrudRepository<DataModel, String> {
	
	@Query("select distinct d.project from DataModel d")
	 List<String> getAllProjects();
	
	@Query("select d.sprint from DataModel d where d.project=:project")
	List<String> getSprintByProject(String project);
	
	@Query("select d from DataModel d where d.project=:project and d.sprint=:sprint")
	List<DataModel> getDataModel(String project, String sprint);
	

}
