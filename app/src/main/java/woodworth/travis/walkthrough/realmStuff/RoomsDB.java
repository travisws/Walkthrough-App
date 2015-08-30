package woodworth.travis.walkthrough.realmStuff;

import io.realm.RealmObject;
import io.realm.annotations.Ignore;
import io.realm.annotations.PrimaryKey;

/**
 * Created by travisws on 7/25/15.
 */
public class RoomsDB extends RealmObject {


    @PrimaryKey
    private String          date_time;
    private String          b201;
    private String          b518;
    private String          amber;
    private String          b302;
    private String          b702;
    private String          b601;
    private String          ga405;
    private String          jet;
    private String          b404;
    private String          initials;

    @Ignore
    private int             id;

    // Standard getters & setters...
    public String getDate_time() {
        return date_time;
    }
    public void setDate_time(String date_time) {
        this.date_time = date_time;
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
    public String getAmber(){
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
    public String getGa405() {
        return ga405;
    }
    public void setGa405(String ga405) {
        this.ga405 = ga405;
    }
    public String getJet() {
        return jet;
    }
    public void setJet(String jet) {
        this.jet = jet;
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
    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}