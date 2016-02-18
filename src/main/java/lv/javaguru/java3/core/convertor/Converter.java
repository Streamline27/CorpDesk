package lv.javaguru.java3.core.convertor;

import org.hibernate.Hibernate;
import org.hibernate.proxy.HibernateProxy;

/**
 * Created by Aleksej_home on 2016.02.18..
 */
public abstract class Converter {

    protected Object ifProxyDoNotInitialize(Object entity){
         return Hibernate.isInitialized(entity)?entity:null;
    }

}
