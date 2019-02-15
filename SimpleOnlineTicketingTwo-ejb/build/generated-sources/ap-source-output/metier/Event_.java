package metier;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Event.class)
public abstract class Event_ {

	public static volatile CollectionAttribute<Event, Ticket> tickets;
	public static volatile CollectionAttribute<Event, Keyword> keywords;
	public static volatile SingularAttribute<Event, Integer> price;
	public static volatile SingularAttribute<Event, String> name;
	public static volatile SingularAttribute<Event, String> description;
	public static volatile SingularAttribute<Event, Integer> id;
	public static volatile SingularAttribute<Event, String> place;
	public static volatile SingularAttribute<Event, Category> category;
	public static volatile SingularAttribute<Event, Date> eventDate;

}

