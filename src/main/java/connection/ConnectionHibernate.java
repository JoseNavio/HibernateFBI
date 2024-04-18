package connection;

import data.hibernate.Delito;
import data.hibernate.Estado;
import data.hibernate.Sospechoso;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/**
 * ConnectionHibernate
 *
 * @author Jose L. Navío Mendoza
 */

public class ConnectionHibernate {

    private static StandardServiceRegistry registry;
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                // Crear registro
                registry = new StandardServiceRegistryBuilder()
                        .configure()
                        .build();

                // Crear MetadataSources
                MetadataSources sources = new MetadataSources(registry);
                sources.addAnnotatedClass(Delito.class);
                sources.addAnnotatedClass(Estado.class);
                sources.addAnnotatedClass(Sospechoso.class);

                // Crear Metadata
                Metadata metadata = sources.getMetadataBuilder().build();

                // Crear SessionFactory
                sessionFactory = metadata.getSessionFactoryBuilder().build();

            } catch (Exception e) {
                e.printStackTrace();
                if (registry != null) {
                    StandardServiceRegistryBuilder.destroy(registry);
                }
            }
        }
        return sessionFactory;
    }

    public static void shutdown() {
        if (registry != null) {
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }
}
