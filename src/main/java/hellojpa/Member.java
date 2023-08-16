package hellojpa;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Member {

    //JPA는 생성자 만들 때, 기본 생성자도 만들어줘야한다.
    public Member() {
    }

    public Member(long id, String name) {
        this.id = id;
        this.name = name;
    }

    @Id
    private long id;
    private String name;

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