package connection;

import org.hibernate.SessionFactory;
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

//    public static SessionFactory getSessionFactory() {
//        if (sessionFactory == null) {
//            try {
//                //Crear registro
//                registry = new StandardServiceRegistryBuilder()
//                        .configure() //This line loads the hibernate.cfg.xml file
//                        .build();
//
//                // Crear MetadataSources
//                MetadataSources sources = new MetadataSources(registry);
//                sources.addAnnotatedClass(Departamento.class);
//                sources.addAnnotatedClass(Profesor.class);
//                sources.addAnnotatedClass(Asignatura.class);
//                sources.addAnnotatedClass(Docencia.class);
//                sources.addAnnotatedClass(DocenciaId.class);
//
//                // Crear Metadata
//                Metadata metadata = sources.getMetadataBuilder().build();
//
//                // Crear SessionFactory
//                sessionFactory = metadata.getSessionFactoryBuilder().build();
//
//            } catch (Exception e) {
//                e.printStackTrace();
//                if (registry != null) {
//                    StandardServiceRegistryBuilder.destroy(registry);
//                }
//            }
//        }
//        return sessionFactory;
//    }

}
