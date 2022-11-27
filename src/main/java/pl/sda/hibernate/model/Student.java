package pl.sda.hibernate.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    // nie chcemy, aby to była kolumna (nie chcemy, żeby to co było wyliczalne było w kolumnnie)
    private double sredniaOcen;



}
