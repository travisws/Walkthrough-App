package woodworth.travis.walkthrough.model;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by travisws on 8/1/15.
 */
public class Sunday extends RealmObject {

    @PrimaryKey
    private String          date;
    private String          b201;
    private String          b518;
    private String          amber;
    private String          b302;
    private String          b702;
    private String          b601;
    private long            ga405;
    private String          b404;
    private String          initials;


    // Standard getters & setters...

    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public String getB201() {
        return b201;
    }
    public void  setB201(String b201) {
        this.b201 = b201;
    }
    public String getB518() {
        return b518;
    }
    public void   setB518(String b518) {
        this.b518 = b518;
    }
    public String getAmber() {
        return amber;
    }
    public void   setAmber(String amber) {
        this.amber = amber;
    }
    public String    getB302() {
        return b302;
    }
    public void   setB302(String b302) {
        this.b302 = b302;
    }
    public String getB702() {
        return b702;
    }
    public void   setB702(String b702) {
        this.b702 = b702;
    }
    public String  getB601() {
        return b601;
    }
    public void  setB601(String b601) {
        this.b601 = b601;
    }
    public long getGa405() {
        return ga405;
    }
    public void setGa405(long ga405) {
        this.ga405 = ga405;
    }
    public String getB404(){
        return b404;
    }
    public void setB404(String b404){
        this.b404 = b404;
    }
    public String getInitials(){
        return initials;
    }
    public void setInitials(String initials){
        this.initials = initials;
    }
}
