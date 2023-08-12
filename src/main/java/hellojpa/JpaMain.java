package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {    //psvm으로 간편하게 main메소드 생성 가능
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();   //데이터베이스 커넥션을 하나 받았다 생각

        EntityTransaction tx = em.getTransaction(); //JPA는 트랜잭션이 꼭 필요하다.
        tx.begin(); //트랜잭션 시작

        try {   //try catch finally 사용하는 게 정석이긴 하나, 실제로는 스프링이 다 해준다.

/*insert
            Member member = new Member();

            member.setId(2L);
            member.setName("HelloB");
            em.persist(member); //데이터베이스 저장
*/
/*select
            Member findMember = em.find(Member.class, 1L);
            System.out.println("findMember.id = " + findMember.getId());
            System.out.println("findMember.name = " + findMember.getName());
*/
/*delete
            Member findMember = em.find(Member.class, 1L);
            em.remove(findMember);
*/

/*update-> 마지막에 em.persist("객체") 해야할 것이라고 사람들이 생각하나, 그럴 필요가 없다.
            Member findMember = em.find(Member.class, 1L);
            findMember.setName("HelloJPA");
*/
            //JPQL
            List<Member> result = em.createQuery("select m from Member as m", Member.class)
                    .getResultList();

/*JPQL로 페이징 처리하는 방법
            List<Member> result2 = em.createQuery("select m from Member as m", Member.class)
                    .setFirstResult(1)
                    .setMaxResults(10)
                    .getResultList();
*/


            for (Member member : result) {  //iter 자동완성으로 간단하게 상향된 for문 사용 가능
                System.out.println("member.getName() = " + member.getName());   //soutv 자동완성으로 간단하게 작성 가능
            }

            tx.commit();    //커밋까지 완료

        } catch (Exception e){
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }
}