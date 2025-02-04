package com.uptc.frmw.conf;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class PersistenceUtil {
    private static final EntityManagerFactory ENTITY_MANAGER_FACTORY;
    static {
        ENTITY_MANAGER_FACTORY= Persistence.createEntityManagerFactory("feriaUnit");
    }
    public static EntityManager getEntityManager() {
        return ENTITY_MANAGER_FACTORY.createEntityManager();
    }

}
