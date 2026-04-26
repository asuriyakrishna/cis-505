package Module_6.ComposerApp;

import java.util.List;

/*
Interface named GenericDao to represent the operations in a data persistence layer. 
 */
public interface GenericDao<E, K> {
    List<E> findAll();
    E findBy(K key);
    void insert(E entity);
}
