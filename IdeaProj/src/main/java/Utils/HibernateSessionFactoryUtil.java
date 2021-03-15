package Utils;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import javax.persistence.Entity;
import java.util.List;

public class HibernateSessionFactoryUtil {
    private static SessionFactory sessionFactory;
    private static Configuration configuration = new Configuration().configure();
    private static EntryHelper entryHelper = new EntryHelper();
    private HibernateSessionFactoryUtil() {}

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                List<String> classList = entryHelper.getClassListFromDirectory();
                classList.forEach(x-> loadClass(x));
                StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
                            .applySettings(configuration.getProperties());
                sessionFactory = configuration.buildSessionFactory(builder.build());
            }
            catch (Exception e) {
            }
        }
        return sessionFactory;
    }

    private static void loadClass(String name) {
        try {
                Class<?> clazz = Class.forName(name);
                if(clazz.isAnnotationPresent(Entity.class)) {
                    System.out.println(String.format("Loading class %s", clazz.getName()));
                    configuration.addAnnotatedClass(clazz);
                }
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
