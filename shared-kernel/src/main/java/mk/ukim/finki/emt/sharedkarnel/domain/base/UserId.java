package mk.ukim.finki.emt.sharedkarnel.domain.base;

public class UserId extends DomainObjectId{

    private UserId(){
        super(UserId.randomId(UserId.class).getId());
    }

    protected UserId( String uuid) {
        super(uuid);
    }
}
