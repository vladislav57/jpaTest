package ru.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Controller
@EnableJpaRepositories
public class MainController {

    @Autowired
    EntityManagerFactory emf;

    @RequestMapping("/test")
    public String index() {
        return "index";
    }

    @RequestMapping("/index")
    public ModelAndView hello() {
        Entity entity = new Entity(1L, "testName");
        Entity entity2 = new Entity(2L, "testName2");

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(entity);
        em.merge(entity2);
        Long id = entity.getId();
        em.getTransaction().commit();

        em.getTransaction().begin();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Entity> cq = cb.createQuery(Entity.class);

        Root<Entity> entityRoot = cq.from(Entity.class);
        cq.select(entityRoot);
        List<Entity> list = em.createQuery(cq).getResultList();

        em.getTransaction().commit();
        return new ModelAndView("index", "list", list);
    }
}
