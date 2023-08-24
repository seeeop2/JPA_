package jpabook.jpashop;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.domain.Order;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain2 {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {

/*주문id를 가지고 주문entity를 조회 후, 찾아낸 주문한 memberid를 이용하여 member객체를 가져오는 아래의 과정은
객체지향적이지 못하다.
이와 같은 방식은 객체를 관계형DB에 맞춰서 설계했다고 볼 수 있다.
            Order order = em.find(Order.class, 1L);
            Long memberId = order.getMemberId();
            Member member = em.find(Member.class, memberId);
*/

/*이게 훨씬 더 객체지향적으로 보인다.
            Order order = em.find(Order.class, 1L);
            Member member = order.getMember();
*/



            tx.commit();

        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
        }
        emf.close();

    }

}
