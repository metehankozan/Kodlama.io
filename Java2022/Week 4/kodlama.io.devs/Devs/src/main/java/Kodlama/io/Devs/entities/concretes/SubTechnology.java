package Kodlama.io.Devs.entities.concretes;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name = "subTechnologies")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class SubTechnology {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "language_id")
    @JsonManagedReference
    private Language language;

}
