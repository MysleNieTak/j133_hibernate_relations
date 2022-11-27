package pl.sda.hibernate.model;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Scanner;

public class Main_dodajOcene {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Dodaj studenta
        // zapytaj użytkownica o:
        // id studentka, któremu chce dodać ocenę

        System.out.println("Podaj ID studenta:");
        String idStudenta = scanner.nextLine();
        Long id = Long.parseLong(idStudenta);

        try (Session session = HibernateUtil.INSTANCE.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            // znajdź tego studentia i, jeśli istnieje, zwróć komunikat
            Student szukanyStudent = session.get(Student.class, id);

            // jeśli istnieje, to zapytaj o wartość oceny
            if(szukanyStudent!=null){
                System.out.println("Podaj ocenę:");
                String dodawanaOcena = scanner.nextLine();
                double wartoscOceny = Double.parseDouble(dodawanaOcena);

                // stwórz obiekt oceny i przypisz do oceny studenta
                Ocena nowaOcena = Ocena.builder()
                        .uczen(szukanyStudent)
                        .wartosc(wartoscOceny)
                        .build();

                // zapisz ocenę
                session.persist(nowaOcena);

             } else {
                System.out.println("Taki student nie istnieje.");
            }


            transaction.commit();
        }catch (Exception e){
            System.err.println("Błąd dodawania studenta do bazy");
        }
    }
}