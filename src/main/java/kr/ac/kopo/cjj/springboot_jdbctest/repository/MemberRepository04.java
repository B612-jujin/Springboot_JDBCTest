package kr.ac.kopo.cjj.springboot_jdbctest.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import kr.ac.kopo.cjj.springboot_jdbctest.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.List;
//EntityManager를 사용할 때는 JPARepository를 상속받지 않는다.
//@PersistenceContext를 사용하여 EntityManager를 주입받는다.


@Repository
public class MemberRepository04 {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Member> selectMethod() {
        String jpql = "select entity from Member entity";
        Query query = entityManager.createQuery(jpql);
        List<Member> member = query.getResultList();
        return member;
    }



        @Transactional
    public void insertMethod(Member member) {
        String jpql = "insert into Member(name, age, email) values(:e_name, :e_age, :e_email)";
        Query query = entityManager.createQuery(jpql);
        query.setParameter("e_name", member.getName());
        query.setParameter("e_age", member.getAge());
        query.setParameter("e_email", member.getEmail());
        query.executeUpdate();
    }

    public Member selectMethodById(int id) {
        String jpql = "select entity from Member entity where entity.id = :e_id";
        Query query = entityManager.createQuery(jpql);
        query.setParameter("e_id", id);
        Member member = (Member) query.getSingleResult();
        return member;
    }

    @Transactional
     public void updateMethod(Member member) {
            String jpql = "update Member set name = :e_name, age = :e_age, email = :e_email where id = :e_id";
            Query query = entityManager.createQuery(jpql);
            query.setParameter("e_name", member.getName());
            query.setParameter("e_age", member.getAge());
            query.setParameter("e_email", member.getEmail());
            query.setParameter("e_id", member.getId());
            query.executeUpdate();
        }

    @Transactional
    public void deleteMethod(int id) {
        String jpql = "delete from Member where id = :e_id";
        Query query = entityManager.createQuery(jpql);
        query.setParameter("e_id", id);
        query.executeUpdate();
    }
}






