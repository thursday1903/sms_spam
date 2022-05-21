package group.fly.hibernate.home;

import java.util.Date;

import group.fly.hibernate.entities.Group;

/**
 * Home object for domain model class Group.
 * @see .Group
 * @author Hibernate Tools
 */

public class GroupHome extends BaseHibernateHome{

	public static void main(String[] args) {
		new GroupHome().persist(new Group("xxx","xyz",new Date(), new Date(),System.currentTimeMillis()));
	}
}
