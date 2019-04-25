package org.camunda.bpm.getstarted.loanapproval;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

public class Repository implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String name;
	private String description;
	private String homepage;
	@SerializedName("private")
	private Boolean privateVar = false;
	@SerializedName("has_issues")
	private Boolean hasIssues = true;
	@SerializedName("has_projects")
	private Boolean hasProjects = true;
	@SerializedName("has_wiki")
	private Boolean hasWiki = true;
	@SerializedName("gitignore_template")
	private String gitIgnore = "Java";

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getHomepage() {
		return homepage;
	}

	public void setHomepage(String homepage) {
		this.homepage = homepage;
	}

	public Boolean getPrivateVar() {
		return privateVar;
	}

	public void setPrivateVar(Boolean privateVar) {
		this.privateVar = privateVar;
	}

	public Boolean getHasIssues() {
		return hasIssues;
	}

	public void setHasIssues(Boolean hasIssues) {
		this.hasIssues = hasIssues;
	}

	public Boolean getHasProjects() {
		return hasProjects;
	}

	public void setHasProjects(Boolean hasProjects) {
		this.hasProjects = hasProjects;
	}

	public Boolean getHasWiki() {
		return hasWiki;
	}

	public void setHasWiki(Boolean hasWiki) {
		this.hasWiki = hasWiki;
	}

}
