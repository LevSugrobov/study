package studypro;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import studypro.ContactEntity;
import studypro.ContactService;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@Service("jpaContactService")
@Transactional
public class ContactServiceImpl implements ContactService {

    @PersistenceContext
    private EntityManager em;

    public List<ContactEntity> findAll() {
        return em.createNamedQuery("ContactEntity.findAll", ContactEntity.class).getResultList();
    }

    public List<ContactEntity> findAllWithDetail() {
        return em.createNamedQuery("ContactEntity.findAllWithDetail", ContactEntity.class).getResultList();
    }

    public ContactEntity findById(Integer id) {
        TypedQuery<ContactEntity> query = em.createNamedQuery("ContactEntity.findById", ContactEntity.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    public ContactEntity save(ContactEntity contact) {
        return null;
    }

    public void delete(ContactEntity contact) {
        return;
    }
}