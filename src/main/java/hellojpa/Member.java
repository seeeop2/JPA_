package hellojpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Member {

    @Id
    private long id;
//    @Column(name = "USERNAME") DB 컬럼명 지정할 수 있다.
    @Column(unique = true, length = 10)  //컬럼에 unique 제약조건 추가, 길이는 10자 까지
    private String name;
    private int age;
//    private int gogo2;

    //JPA는 생성자 만들 때, 기본 생성자도 만들어줘야한다.
    public Member() {
    }

    public Member(long id, String name) {
        this.id = id;
        this.name = name;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}