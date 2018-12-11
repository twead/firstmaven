package hu.javadummy.repositories;

import hu.javadummy.entities.Tank;

import java.util.Date;
import java.util.List;

public class TankRepository extends AbstractRepository {

    public Tank findById(Long id){
        return (Tank) getSession().get(Tank.class,id);
    }
    public List<Tank> selectAll() {
        return getSession().createQuery("from Tank").list();
    }

    public void save(Tank tank) {
        getSession().beginTransaction();
        tank.setCreatedDate(new Date());
        tank.setLastModifiedDate(new Date());
        getSession().save(tank);
        getSession().getTransaction().commit();
    }


    public void update(Tank tank) {
        getSession().beginTransaction();
        tank.setLastModifiedDate(new Date());
        getSession().update(tank);
        getSession().getTransaction().commit();
    }

}