package com.group.cars.Entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Family_Group implements Serializable {
	@Id
	@NotNull
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	@Column(name = "Group_ID")
	private Long id;
	private String Group_Name;
	
	@Temporal(TemporalType.DATE)
	@PastOrPresent
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date DateOfCreation;
	
	@JsonIgnore
	@OneToMany (mappedBy="familyGroup")
	private List<Car> Cars;
	
	public Family_Group() {
		super();
	}

	public Family_Group(Long gid, String group_Name, Date dateOfCreation) {
		super();
		id = gid;
		Group_Name = group_Name;
		DateOfCreation = dateOfCreation;
	}
	public Family_Group( String group_Name, Date dateOfCreation) {
		super();
		Group_Name = group_Name;
		DateOfCreation = dateOfCreation;
	}

	@Override
	public String toString() {
		return "Family_Group{" +
				"id=" + id +
				", groupName='" + this.Group_Name + '\'' +
				", dateOfCreation='" + this.DateOfCreation + '\'' +
				'}';
	}


	
	
	
}
