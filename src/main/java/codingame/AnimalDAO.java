package codingame;
import java.util.*;
import javax.persistence.*;
import org.hibernate.*;
import org.hibernate.cfg.*;

public class AnimalDAO {

	public List<Animal> getAllAnimals(Session session) {
		return session.createQuery("SELECT a FROM Animal a", Animal.class).getResultList();
	}

	@Entity(name = "Animal")
	public static class Animal {
		@Id
		public Integer id;
		@Column
		public String name;
	}

	public static void main(String[] args) {
		Properties prop = new Properties();
		prop.setProperty("hibernate.connection.url", "jdbc:h2:mem:db1");
		prop.setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		prop.setProperty("hibernate.hbm2ddl.auto", "create");

		SessionFactory sessionFactory = new Configuration().addProperties(prop)
				.addAnnotatedClass(Animal.class).buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		Animal animal = new Animal();
		animal.id = 0;
		animal.name ="Mr. Rabbit";

		session.save(animal);
		session.flush();

		AnimalDAO animalDAO = new AnimalDAO();
		List<Animal> animals = animalDAO.getAllAnimals(session);
		for(Animal an : animals) {
			System.out.println(an.id + " - " + an.name);
		}
	}
}