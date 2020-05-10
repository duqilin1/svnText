package movie.bw.com.svntext.model.bean;

/*
 *@auther:杜其林
 *@Date: 2020/5/7
 *@Time:16:45
 * 附近影院信息
 *@Description:${DESCRIPTION}
 * */
public class NearbyBean {

    /**
     * address : 建国门外大街1号国贸商城区域三地下一层3B120
     * commentTotal : 11
     * distance : 0
     * followCinema : 2
     * id : 7
     * logo : http://mobile.bwstudent.com/images/movie/logo/blg.jpg
     * name : 北京百丽宫影城
     */

    private String address;
    private int commentTotal;
    private int distance;
    private int followCinema;
    private int id;
    private String logo;
    private String name;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCommentTotal() {
        return commentTotal;
    }

    public void setCommentTotal(int commentTotal) {
        this.commentTotal = commentTotal;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public int getFollowCinema() {
        return followCinema;
    }

    public void setFollowCinema(int followCinema) {
        this.followCinema = followCinema;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
