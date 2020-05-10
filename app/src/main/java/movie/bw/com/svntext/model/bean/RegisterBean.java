package movie.bw.com.svntext.model.bean;

/*
 *@auther:杜其林
 *@Date: 2020/4/20
 *@Time:15:05
 *@Description:${DESCRIPTION}
 * */
public class RegisterBean {

    /**
     * message : 验证码已过期
     * status : 1001
     */

    private String message;
    private String status;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
