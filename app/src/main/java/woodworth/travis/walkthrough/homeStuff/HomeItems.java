package woodworth.travis.walkthrough.homeStuff;

import io.realm.RealmObject;

/**
 * Created by travisws on 8/8/15.
 */
public class HomeItems extends RealmObject {

    private String title;

    public String getTitle() {

        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
