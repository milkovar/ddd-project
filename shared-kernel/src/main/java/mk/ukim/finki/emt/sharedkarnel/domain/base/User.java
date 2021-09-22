package mk.ukim.finki.emt.sharedkarnel.domain.base;

import javax.persistence.Embeddable;

@Embeddable
public class User extends AbstractEntity<UserId> implements ValueObject{
    private String name;
    private String password;
    private String email;
    private String phone;
}
