package pl.sda.hibernate.model;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Scanner;

public class Main_usunOcene {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try(Session session = HibernateUtil.INSTANCE.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();

        System.out.println("Chcesz usunąć ocenę, czy studenta? (ocena/student");
        String odpowiedz = scanner.nextLine();

        if (odpowiedz.equalsIgnoreCase("ocena")) {
            System.out.println("Podaj ID:");
            String idPodany = scanner.nextLine();
            Long id = Long.parseLong(idPodany);

            Ocena ocena = session.get(Ocena.class, id);

            if (ocena != null) {
                session.remove(ocena);
            } else {
                System.err.println("Ocena nie istnieje");
            }
        } else if (odpowiedz.equalsIgnoreCase("student")) {
            System.out.println("Podaj ID: ");
            String idPodany = scanner.nextLine();
            Long id = Long.parseLong(idPodany);

            Student student = session.get(Student.class, id);

            if (student !=null){
                //jeśli nie ma ocen, to go usuwamy
                if(!student.getOceny().isEmpty()){
                    // jeśli mamy oceny, to usuwamy najpierw oceny...
                    for (Ocena ocena : student.getOceny()){
                        session.remove(ocena);
                    }
                }
                // ... potem studenta
                session.remove(student);
            } else {
                System.out.println("Student nie istnieje.");
            }

        }


            transaction.commit();
            } catch (Exception ioe){
                System.err.println("Błąd bazy: "+ioe);
            }

        }
}
