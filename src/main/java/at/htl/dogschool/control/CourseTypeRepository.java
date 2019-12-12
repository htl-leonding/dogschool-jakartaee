package at.htl.dogschool.control;

import at.htl.dogschool.entity.CourseType;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class CourseTypeRepository {

    @PersistenceContext
    private EntityManager em;

    public CourseType findByAbbr(String abbr) {
        return em
                .createNamedQuery("CourseType.findByAbbr", CourseType.class)
                .setParameter("ABBR", abbr)
                .getSingleResult();
    }

    public List<CourseType> findAll() {
        return em.createNamedQuery("CourseType.findAll", CourseType.class)
                .getResultList();
    }

    public CourseType save(CourseType courseType) {
        return em.merge(courseType);
    }

    public CourseType findById(long id) {
        return em.find(CourseType.class, id);
    }

    public void delete(long id) {
        CourseType courseType = em.find(CourseType.class, id);
        if (courseType == null) {
            throw new EntityNotFoundException();
        }
        em.remove(courseType);
    }

}
