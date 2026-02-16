package cat.udl.eps.softarch.demo.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "team")
public class Team {
	@Id
	@Column(name = "name", length = 50)
	private String name;

	private String city;
	private String educationalCenter;
	private String category;
	private int foundationYear;
	private LocalDate inscriptionDate;

	@OneToMany(mappedBy = "team", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<TeamMember> members = new ArrayList<>();

	public Team(String name) {
		this.name = name;
	}

	public void addMember(TeamMember member) {
		members.add(member);
		member.setTeam(this);
	}
}
