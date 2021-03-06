package org.kniftosoft.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the maschine database table.
 * 
 */
@Entity
@NamedQuery(name="Maschine.findAll", query="SELECT m FROM Maschine m")
public class Maschine implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idmaschine;

	private double maximumspeed;

	private String name;

	private String standort;

	//bi-directional many-to-one association to Log
	@OneToMany(mappedBy="maschineBean")
	private List<Log> logs;

	//bi-directional many-to-one association to Useraccess
	@OneToMany(mappedBy="maschineBean")
	private List<Useraccess> useraccesses;

	public Maschine() {
	}

	public int getIdmaschine() {
		return this.idmaschine;
	}

	public void setIdmaschine(int idmaschine) {
		this.idmaschine = idmaschine;
	}

	public double getMaximumspeed() {
		return this.maximumspeed;
	}

	public void setMaximumspeed(double maximumspeed) {
		this.maximumspeed = maximumspeed;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStandort() {
		return this.standort;
	}

	public void setStandort(String standort) {
		this.standort = standort;
	}

	public List<Log> getLogs() {
		return this.logs;
	}

	public void setLogs(List<Log> logs) {
		this.logs = logs;
	}

	public Log addLog(Log log) {
		getLogs().add(log);
		log.setMaschineBean(this);

		return log;
	}

	public Log removeLog(Log log) {
		getLogs().remove(log);
		log.setMaschineBean(null);

		return log;
	}

	public List<Useraccess> getUseraccesses() {
		return this.useraccesses;
	}

	public void setUseraccesses(List<Useraccess> useraccesses) {
		this.useraccesses = useraccesses;
	}

	public Useraccess addUseraccess(Useraccess useraccess) {
		getUseraccesses().add(useraccess);
		useraccess.setMaschineBean(this);

		return useraccess;
	}

	public Useraccess removeUseraccess(Useraccess useraccess) {
		getUseraccesses().remove(useraccess);
		useraccess.setMaschineBean(null);

		return useraccess;
	}

}