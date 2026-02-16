package cat.udl.eps.softarch.demo.domain;

import java.time.LocalDate;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "team_member")
public class TeamMember {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;
	private LocalDate birthDate;
	private String gender;
	private String tShirtSize;
	private String role;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "team_name", nullable = false)
	private Team team;
}
