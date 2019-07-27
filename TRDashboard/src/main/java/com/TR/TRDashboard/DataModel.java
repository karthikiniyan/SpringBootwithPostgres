package com.TR.TRDashboard;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Jira_item",schema="trdata")
public class DataModel {
	@Id
	@Column(name="issueid")
	private String issueId = null;
	
	@Column(name="project")
	private String project = null;
	@Column(name="issuetype")
	private String issueType = null;
	@Column(name="priority")
	private String priority = null;
	@Column(name="reporter")
	private String reporter = null;
	@Column(name="assignee")
	private String assignee = null;
	@Column(name="resolution")
	private String resolution = null;
	@Column(name="label")
	private String label = null;
	@Column(name="status")
	private String status = null;
	@Column(name="bussinessUnit")
	private String bussinessUnit = null;
	@Column(name="storypoints")
	private String storypoints = null;
	@Column(name="epiclink")
	private String epicLink = null;
	@Column(name="sprint")
	private String sprint = null;
	@Column(name="timeestimate")
	private String timeestimate = null;
	@Column(name="timespent")
	private String timespent = null;
	@Column(name="timeorignalEstimate")
	private String timeorignalEstimate = null;
	@Column(name="created")
	private Timestamp created ;
	@Column(name="updated")
	private Timestamp updated ;
	@Column(name="duedate")
	private Timestamp duedate ;
	
	public String getIssueId() {
		return issueId;
	}
	public void setIssueId(String issueId) {
		this.issueId = issueId;
	}
	
	public String getProject() {
		return project;
	}
	public void setProject(String project) {
		this.project = project;
	}
	public String getIssueType() {
		return issueType;
	}
	public void setIssueType(String issueType) {
		this.issueType = issueType;
	}
	public String getPriority() {
		return priority;
	}
	public void setPriority(String priority) {
		this.priority = priority;
	}
	public String getReporter() {
		return reporter;
	}
	public void setReporter(String reporter) {
		this.reporter = reporter;
	}
	public String getAssignee() {
		return assignee;
	}
	public void setAssignee(String assignee) {
		this.assignee = assignee;
	}
	public String getResolution() {
		return resolution;
	}
	public void setResolution(String resolution) {
		this.resolution = resolution;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getBussinessUnit() {
		return bussinessUnit;
	}
	public void setBussinessUnit(String bussinessUnit) {
		this.bussinessUnit = bussinessUnit;
	}
	public String getStorypoints() {
		return storypoints;
	}
	public void setStorypoints(String storypoints) {
		this.storypoints = storypoints;
	}
	public String getEpicLink() {
		return epicLink;
	}
	public void setEpicLink(String epicLink) {
		this.epicLink = epicLink;
	}
	public String getSprint() {
		return sprint;
	}
	public void setSprint(String sprint) {
		this.sprint = sprint;
	}
	public String getTimeestimate() {
		return timeestimate;
	}
	public void setTimeestimate(String timeestimate) {
		this.timeestimate = timeestimate;
	}
	public String getTimespent() {
		return timespent;
	}
	public void setTimespent(String timespent) {
		this.timespent = timespent;
	}
	public String getTimeorignalEstimate() {
		return timeorignalEstimate;
	}
	public void setTimeorignalEstimate(String timeorignalEstimate) {
		this.timeorignalEstimate = timeorignalEstimate;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Timestamp created) {
		this.created = created;
	}
	public Date getUpdated() {
		return updated;
	}
	public void setUpdated(Timestamp updated) {
		this.updated = updated;
	}
	public Date getDuedate() {
		return duedate;
	}
	public void setDuedate(Timestamp duedate) {
		this.duedate = duedate;
	}
	
	
	
	
	

}
