package movie.bw.com.svntext;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/*
 *@auther:杜其林
 *@Date: 2020/4/29
 *@Time:23:45
 *@Description:${DESCRIPTION}
 * */
@Entity
public class ResultBean {
    @Id()
    private int movieId;
    private String director;
    private String horizontalImage;
    private String imageUrl;
    private String name;
    private double score;
    private String starring;
    @Generated(hash = 1462099505)
    public ResultBean(int movieId, String director, String horizontalImage,
            String imageUrl, String name, double score, String starring) {
        this.movieId = movieId;
        this.director = director;
        this.horizontalImage = horizontalImage;
        this.imageUrl = imageUrl;
        this.name = name;
        this.score = score;
        this.starring = starring;
    }
    @Generated(hash = 2137771703)
    public ResultBean() {
    }
    public int getMovieId() {
        return this.movieId;
    }
    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }
    public String getDirector() {
        return this.director;
    }
    public void setDirector(String director) {
        this.director = director;
    }
    public String getHorizontalImage() {
        return this.horizontalImage;
    }
    public void setHorizontalImage(String horizontalImage) {
        this.horizontalImage = horizontalImage;
    }
    public String getImageUrl() {
        return this.imageUrl;
    }
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getScore() {
        return this.score;
    }
    public void setScore(double score) {
        this.score = score;
    }
    public String getStarring() {
        return this.starring;
    }
    public void setStarring(String starring) {
        this.starring = starring;
    }
}
