package pl.sda.hibernate.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Formula;

import java.util.Set;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String imie;

    @Column(nullable = false)
    private String nazwisko;

    // @Column(nullable = false)
    private int rokRozpoczeciaStiudiow;

    //    nie chcemy, aby to była kolumna
    @Formula("(SELECT AVG(o.wartosc) FROM ocena o WHERE o.uczen_id=id)")
    private Double sredniaOcen;

    @ToString.Exclude // łamie infinity loop
    @EqualsAndHashCode.Exclude // zawsze przy Set
    @OneToMany(mappedBy = "uczen") // uczen, to nie jest nazwa klasy, a nazwa pola
    private Set<Ocena> oceny;




}
