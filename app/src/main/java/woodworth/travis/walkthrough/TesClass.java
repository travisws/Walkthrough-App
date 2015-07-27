package woodworth.travis.walkthrough;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by travisws on 7/25/15.
 */
public class TesClass extends RealmObject {

    @PrimaryKey
    private String          name;
    private int             age;


    // Standard getters & setters generated by your IDE…
    public String getName() {
        return name;
    }
    public void   setName(String name) {
        this.name = name;
    }
    public int    getAge() {
        return age;
    }
    public void   setAge(int age) {
        this.age = age;
    }

}
