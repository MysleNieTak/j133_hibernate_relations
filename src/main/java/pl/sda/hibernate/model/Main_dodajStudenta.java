package pl.sda.hibernate.model;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Scanner;

public class Main_dodajStudenta {

    public static void main(String[] args) {
        // dodaj studenta,
        // zapytaj użytkownika o:
        // imie, nazwisko, rok rozpoczecia studiow, dodaj do bazy


        Scanner scanner = new Scanner(System.in);

        try(Session session = HibernateUtil.INSTANCE.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();


        System.out.println("Żeby dodać studenta, podaj imię:");
        String imie = scanner.nextLine();

        System.out.println("Podaj nazwisko:");
        String nazwisko = scanner.nextLine();

        System.out.println("Podaj rok rozpoczęcia studiów:");
        String rokRozpoczeciaStudiow1 = scanner.nextLine();
        Integer rokRoczpoczeciaStudiow = Integer.parseInt(rokRozpoczeciaStudiow1);

        Student student = Student.builder()
                .imie(imie)
                .nazwisko(nazwisko)
                .rokRozpoczeciaStiudiow(rokRoczpoczeciaStudiow)
                .build();

                session.persist(student);
            transaction.commit();

        }  catch (Exception ioe){

    }

    }
}
