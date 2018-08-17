package com.revature.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity 
@Table(name="BatchAnnotation")

public class BatchAnnotation {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqname")
	@SequenceGenerator(initialValue = 1, sequenceName = "seqname", allocationSize = 1, name = "seqname")
	
	@Column(name="BATCH_ID", nullable = false, precision = 10)
	private int batchid;
	
	@Column(name="CORE", length = 40)
	private String core;
	
	@Column(name="STARTDATE")
	private Date startDate;
	
	@Column(name="TRAINER", length = 40)
	private String trainer;

	@Column(name="LOCATION", length = 40)
	private String location;

	@Column(name="BUILDING", length = 40)
	private String building;

	@Column(name="ROOM", nullable = false, precision = 10)
	private int room;

	public int getBatchid() {
		return batchid;
	}

	public void setBatchid(int batchid) {
		this.batchid = batchid;
	}

	public String getCore() {
		return core;
	}

	public void setCore(String core) {
		this.core = core;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public String getTrainer() {
		return trainer;
	}

	public void setTrainer(String trainer) {
		this.trainer = trainer;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getBuilding() {
		return building;
	}

	public void setBuilding(String building) {
		this.building = building;
	}

	public int getRoom() {
		return room;
	}

	public void setRoom(int room) {
		this.room = room;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + batchid;
		result = prime * result + ((building == null) ? 0 : building.hashCode());
		result = prime * result + ((core == null) ? 0 : core.hashCode());
		result = prime * result + ((location == null) ? 0 : location.hashCode());
		result = prime * result + room;
		result = prime * result + ((startDate == null) ? 0 : startDate.hashCode());
		result = prime * result + ((trainer == null) ? 0 : trainer.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BatchAnnotation other = (BatchAnnotation) obj;
		if (batchid != other.batchid)
			return false;
		if (building == null) {
			if (other.building != null)
				return false;
		} else if (!building.equals(other.building))
			return false;
		if (core == null) {
			if (other.core != null)
				return false;
		} else if (!core.equals(other.core))
			return false;
		if (location == null) {
			if (other.location != null)
				return false;
		} else if (!location.equals(other.location))
			return false;
		if (room != other.room)
			return false;
		if (startDate == null) {
			if (other.startDate != null)
				return false;
		} else if (!startDate.equals(other.startDate))
			return false;
		if (trainer == null) {
			if (other.trainer != null)
				return false;
		} else if (!trainer.equals(other.trainer))
			return false;
		return true;
	}

	public BatchAnnotation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BatchAnnotation(int batchid, String core, Date startDate, String trainer, String location, String building,
			int room) {
		super();
		this.batchid = batchid;
		this.core = core;
		this.startDate = startDate;
		this.trainer = trainer;
		this.location = location;
		this.building = building;
		this.room = room;
	}

	@Override
	public String toString() {
		return "BatchAnnotation [batchid=" + batchid + ", core=" + core + ", startDate=" + startDate + ", trainer="
				+ trainer + ", location=" + location + ", building=" + building + ", room=" + room + "]";
	}
	
	
}
