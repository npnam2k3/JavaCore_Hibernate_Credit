package hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class AppMain {

	static User userObj;
	static Session sessionObj;
	static SessionFactory sessionFactoryObj;

	public static void selectUser() {
		try {
			sessionObj = HibernateUtil.getSessionFactory().openSession();
			sessionObj.beginTransaction();
			List<User> userList = sessionObj.createQuery("FROM User").list();
			for (User user : userList) {
				System.out.println(user);
				System.out.println("-----------------");
			}
			sessionObj.getTransaction().commit();
		} catch (Exception sqlException) {
			if (null != sessionObj.getTransaction()) {
				System.out.println("\n.......Transaction Is Being Rolled Back.......");
				sessionObj.getTransaction().rollback();
			}
			sqlException.printStackTrace();
		} finally {
			if (sessionObj != null) {
				sessionObj.close();
			}
		}
	}

	public static void deleteUser(int userId) {
		try {
			sessionObj = HibernateUtil.getSessionFactory().openSession();
			sessionObj.beginTransaction();
			User user = sessionObj.load(User.class, userId);
			sessionObj.delete(user);
			sessionObj.getTransaction().commit();
			System.out.println("Xoa thanh cong");
		} catch (Exception sqlException) {
			if (null != sessionObj.getTransaction()) {
				System.out.println("\n.......Transaction Is Being Rolled Back.......");
				sessionObj.getTransaction().rollback();
			}
			sqlException.printStackTrace();
		} finally {
			if (sessionObj != null) {
				sessionObj.close();
			}
		}
	}

	public static void updateUser(int userid, String username) {
		Session sessionObj = null;
		try {
			sessionObj = HibernateUtil.getSessionFactory().openSession();
			sessionObj.beginTransaction();

			String hql = "UPDATE User SET username = :newName WHERE userid = :userid";
			int updatedEntities = sessionObj.createQuery(hql).setParameter("newName", username)
					.setParameter("userid", userid).executeUpdate();

			sessionObj.getTransaction().commit();

			System.out.println("Updated " + updatedEntities + " entities");
		} catch (Exception sqlException) {
			if (null != sessionObj.getTransaction() && sessionObj.getTransaction().isActive()) {
				System.out.println("\n.......Transaction Is Being Rolled Back.......");
				sessionObj.getTransaction().rollback();
			}
			sqlException.printStackTrace();
		} finally {
			if (sessionObj != null) {
				sessionObj.close();
			}
		}
	}

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		System.out.println(".......Hibernate Maven Example.......\n");
		try {
			sessionObj = HibernateUtil.getSessionFactory().openSession();
			sessionObj.beginTransaction();

//			for (int i = 101; i <= 105; i++) {
//				userObj = new User();
//				userObj.setId(i);
//				userObj.setUsername("Editor " + i);
//				userObj.setCreatedBy("Administrator");
//				// userObj.setCreatedDate(new Date());
//
//				sessionObj.save(userObj);
//			}
//			userObj = new User();
//			userObj.setUsername("Duc Hoang");
//			userObj.setFullname("Phạm Đức Hoàng");
//			userObj.setCreatedAt(Instant.now(Clock.systemDefaultZone()));
//			userObj.setModifiedAt(null);
//			sessionObj.save(userObj);

			System.out.println("\n.......Records Saved Successfully To The Database.......\n");

			// Committing The Transactions To The Database
			sessionObj.getTransaction().commit();
		} catch (Exception sqlException) {
			if (null != sessionObj.getTransaction()) {
				System.out.println("\n.......Transaction Is Being Rolled Back.......");
				sessionObj.getTransaction().rollback();
			}
			sqlException.printStackTrace();
		} finally {
			if (sessionObj != null) {
				sessionObj.close();
			}
		}
		selectUser();
//		updateUser(102, "Nguyen Phuong Nam");
//		System.out.println("Danh sach sau khi sua: \n");
//		selectUser();
//		deleteUser(105);
	}
}
