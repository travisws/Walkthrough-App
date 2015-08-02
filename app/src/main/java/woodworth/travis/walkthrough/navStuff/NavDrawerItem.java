package woodworth.travis.walkthrough.navStuff;

/**
 * Created by travis on 7/19/15.
 */
public class NavDrawerItem {
    //private boolean showNotify; I commit this out, because I believe that I don't need it.
    private String title;


    public NavDrawerItem() {

    }
    /*
    public NavDrawerItem(boolean showNotify, String title) {
        this.showNotify = showNotify;
        this.title = title;
    }

    public boolean isShowNotify() {

        return showNotify;
    }

    public void setShowNotify(boolean showNotify) {

        this.showNotify = showNotify;
    }*/

    public String getTitle() {

        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}