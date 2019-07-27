package com.TR.service;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.StringJoiner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.TR.TRDashboard.DataModel;

@Service
public class TRService {
	
	
	@Autowired
	private RestTemplate restTemplate;
	
	
	public String getDashBoardData() {
		
		
		 final String uri = "http://ent.jira.int.thomsonreuters.com/rest/api/2/search?jql=project=IAM and sprint in openSprints()&fields=project,issuekey,issuetype,priority,reporter,assignee,resolution,labels,status,created,timeestimate,timespent,timeoriginalestimate,customfield_23700,customfield_10102,customfield_13500,customfield_11500,created,updated,duedate";
	     
		 
		    String result = restTemplate.getForObject(uri, String.class);
		     
		    System.out.println(result);
		
		return result;
		
		
	}
	

	public  String getSprintName(String details) {
		
	String name = null ;	
    String[] words = details.split(",");
        
        for(String  s  : words) {
         System.out.println(s);
         if(s.startsWith("name"))
         name= s.substring(5);
         
        }
        System.out.println(name);
		return name;
		
	}
	
	public String getLabels(JSONArray labelArray) {
		
		StringJoiner rgbJoiner = new StringJoiner(
			      ",", "", "");
		for(int j=0;j< labelArray.size() ;j++) {
			
			JSONObject jobj2 =   (JSONObject) labelArray.get(j);
			
			
			String label = (String) jobj2.get(String.valueOf(j));
			
			System.out.println(label.toString());
			
			rgbJoiner.add(label.toString());
		}
		return  rgbJoiner.toString();
	}
	
	public DataModel responseParser(String response) {
		
		JSONParser parser = new JSONParser();
		
		DataModel data = new DataModel();
	    
	    JSONObject jobj;
		try {
			jobj = (JSONObject)parser.parse(response);

			JSONArray jArr = (JSONArray)jobj.get("issues");
			
			System.out.println(jArr);
			System.out.println(jArr.get(0));
			
			//for(int i=0;i<jArr.size();i++) {
			
			JSONObject obj1 = (JSONObject) jArr.get(0);
		    
			String issueId = (String) obj1.get("key");
			
			System.out.println("key " +issueId);
			
		data.setIssueId(issueId);
			
			Object obj = obj1.get("fields");
			
			JSONObject jobj1 = (JSONObject)parser.parse(obj.toString());
			
			String timeestimate = (String) jobj1.get("timeestimate");
			
			String timespent = (String)jobj1.get("timespent");
			
			String Bussinessunit = (String)jobj1.get("customfield_23700");
			
			String Storypoints = (String)jobj1.get("customfield_10102");
			
			String EpicLink = (String)jobj1.get("customfield_13500");
			
			String createDate = (String)jobj1.get("created");
			
			String updateDate = (String)jobj1.get("updated");
			
			String dueDate = (String)jobj1.get("duedate");
			
			Timestamp createTimestamp = null;
			Timestamp updateTimestamp = null;
			Timestamp duedateTimestamp = null;
			
			 SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss:SSS");
			 // "2014-08-22 15:02:51:580"
			    Date parsedTimeStamp;
				try {
					parsedTimeStamp = (Date) dateFormat.parse(createDate);
					createTimestamp = new Timestamp(parsedTimeStamp.getTime());
					
					parsedTimeStamp = (Date) dateFormat.parse(updateDate);
					updateTimestamp = new Timestamp(parsedTimeStamp.getTime());
					
					parsedTimeStamp = (Date) dateFormat.parse(dueDate);
					duedateTimestamp = new Timestamp(parsedTimeStamp.getTime());
					
					
				} catch (java.text.ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			data.setTimeestimate(timeestimate);
			data.setTimespent(timespent);
			data.setBussinessUnit(Bussinessunit);
			data.setStorypoints(Storypoints);
			data.setEpicLink(EpicLink);
			if(createTimestamp != null)
				data.setCreated(createTimestamp);
			if(updateTimestamp != null)
				data.setUpdated(updateTimestamp);
			if(duedateTimestamp != null)
				data.setDuedate(duedateTimestamp);
			
			
			
			//Sprint
			JSONArray SprintArray = (JSONArray)  jobj1.get("customfield_11500");
			
			if(SprintArray != null) {		
				
				int size = SprintArray.size()-1;
				
				System.out.println("Size " +size);
				
			JSONObject jobj2 =   (JSONObject) SprintArray.get(size);
			
			
			String sprintdetails = (String) jobj2.get(String.valueOf(size));
			
			String sprintname  =  getSprintName(sprintdetails);
				data.setSprint(sprintname);
			}
			
			//labels
			JSONArray LabelArray = (JSONArray)  jobj1.get("labels");
			
			if(LabelArray != null) {
			int size1 = LabelArray.size()-1;
			
			System.out.println("Size1 " +size1);
			
			String labels = getLabels(LabelArray);
			
			data.setLabel(labels);
			}
			
			// 
			Object obj2 = jobj1.get("Project");
			
			JSONObject jobj3 = (JSONObject) parser.parse(obj2.toString());
			
			String Project = (String) jobj3.get("key");
			
			//issuetype
			Object obj3 = jobj1.get("issuetype");
			
			JSONObject jobj4 = (JSONObject) parser.parse(obj3.toString());
			
			String IssueType = (String) jobj4.get("name");
			
			//priority
			Object obj4 = jobj1.get("priority");
			
			JSONObject jobj5 = (JSONObject) parser.parse(obj4.toString());
			
			String priority = (String) jobj5.get("name");
			
			//reporter
			Object obj5 = jobj1.get("reporter");
			
			JSONObject jobj6 = (JSONObject) parser.parse(obj5.toString());
			
			String reporter = (String) jobj6.get("name");
			
			//assignee
			Object obj6 = jobj1.get("assignee");
			
			JSONObject jobj7 = (JSONObject) parser.parse(obj6.toString());
			
			String assignee = (String) jobj7.get("name");
			
			//resolution
			Object obj7 = jobj1.get("resolution");
			
			JSONObject jobj8 = (JSONObject) parser.parse(obj7.toString());
			
			String resolution = (String) jobj8.get("name");
			
			//status
			Object obj8 = jobj1.get("status");
			
			JSONObject jobj9 = (JSONObject) parser.parse(obj8.toString());
			
			String status = (String) jobj9.get("name");
			
			//}
			//labels
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		
		
		return null;
		
	}
	

}
