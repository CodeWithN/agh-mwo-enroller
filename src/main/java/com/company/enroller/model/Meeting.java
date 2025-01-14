package com.company.enroller.model;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "meeting")

public class Meeting {

	@Id
	private long id;

	@Column
	private String title;

	@Column
	private String description;

	@Column
	private String date;



	@JsonIgnore
	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "meeting_participant", joinColumns = { @JoinColumn(name = "meeting_id") }, inverseJoinColumns = {
			@JoinColumn(name = "participant_login") })
	Set<Participant> participants = new HashSet<>();


	public long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getDate() {
		return date;
	}

	public String getDescription() {
		return description;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	public Collection<Participant> getParticipants() {
		return participants;
	}

	public void addParticipant(Participant participant) {
		this.participants.add(participant);
	}
}