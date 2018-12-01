import cit360hibernatetest.PetsEntity;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final SessionFactory ourSessionFactory;

    static {
        try {
            Configuration configuration = new Configuration();
            configuration.configure();

            ourSessionFactory = configuration.buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static void main(final String[] args) throws Exception {

        System.out.println("CIT 360 Java Collections Test");
        boolean exit;
        exit = false;

        Scanner userInput = new Scanner(System.in);
        String choice;

        while (!exit) {
            System.out.println("Select option by entering the corresponding number");
            System.out.println("1 - Add Pet to Database");
            System.out.println("2 - Delete Pet from Database");
            System.out.println("3 - Show Database entries");
            System.out.println("4 - Exit Program");

            choice = userInput.nextLine();

            switch (choice) {
                case "1":
                    createPet();
                    break;
                case "2":
                    deletePet();
                    break;
                case "3":
                    listPets();
                    break;
                case "4":
                    exit = true;
                    break;
                default:
                    System.out.println("Input did not match any options. Try again\n");
                    break;
            }
        }
    }

    private static Session getSession() throws HibernateException {
        return ourSessionFactory.openSession();
    }

    private static void createPet() {
        System.out.println("Create a Pet\n");

        System.out.print("Enter Pet Name:");
        Scanner pet_name = new Scanner(System.in);
        String name;
        name = pet_name.nextLine();

        System.out.print("Enter Pet Species:");
        Scanner pet_species = new Scanner(System.in);
        String species;
        species = pet_species.nextLine();

        System.out.print("Enter Pet Owner:");
        Scanner pet_owner = new Scanner(System.in);
        String owner;
        owner = pet_owner.nextLine();

        addPet(name,species,owner);
    }

    private static void addPet(String p_name, String p_species, String p_owner) {
        Session session = getSession();
        Transaction tx = null;
        Integer petID = null;

        try {
            tx = session.beginTransaction();
            PetsEntity pet = new PetsEntity(p_name,p_species,p_owner);
            petID = (Integer) session.save(pet);
            tx.commit();

            System.out.print("New pet \"" + p_name + "\" has been added!\n");
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    private static void deletePet() {
        Session session = getSession();
        Transaction tx = null;

        System.out.print("Enter Pet ID of the pet to delete:");
        Scanner pet_id = new Scanner(System.in);
        String id;
        id = pet_id.nextLine();
        int result = Integer.parseInt(id);

        try {
            tx = session.beginTransaction();
            PetsEntity pet = (PetsEntity) session.get(PetsEntity.class, result);
            session.delete(pet);
            tx.commit();

            System.out.print("Pet with ID " + id + " has been deleted\n");
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    private static void listPets() {
        Session session = getSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();

            Criteria criteria = session.createCriteria(PetsEntity.class);
            List<PetsEntity> pets = criteria.list();

            for (Iterator iterator = pets.iterator(); iterator.hasNext();) {
                PetsEntity pet = (PetsEntity) iterator.next();
                System.out.println("Pet ID: " + pet.getId() +
                        "| Pet Name: " + pet.getName() +
                        "| Pet Species: " + pet.getSpecies() +
                        "| Owner: " + pet.getOwner());
            }
            System.out.println();

            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}