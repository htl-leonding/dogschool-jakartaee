package at.htl.dogschool.control;

import at.htl.dogschool.entity.CourseType;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

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

}
