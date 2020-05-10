package movie.bw.com.svntext;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.JoinProperty;
import org.greenrobot.greendao.annotation.ToMany;

import java.util.List;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.DaoException;
import movie.bw.com.svntext.dao.DaoSession;
import movie.bw.com.svntext.dao.ResultBeanDao;
import movie.bw.com.svntext.dao.BeanDao;

/*
 *@auther:杜其林
 *@Date: 2020/4/29
 *@Time:23:39
 *@Description:${DESCRIPTION}
 * */
@Entity
public class Bean {
    @Id(autoincrement = true)
    long id;
    private String beanName;
    private String message;
    private String status;
    @ToMany(joinProperties = {@JoinProperty(name = "beanName", referencedName = "name")})
    private List<ResultBean> result;
    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;
    /** Used for active entity operations. */
    @Generated(hash = 1282940134)
    private transient BeanDao myDao;
    @Generated(hash = 1565041058)
    public Bean(long id, String beanName, String message, String status) {
        this.id = id;
        this.beanName = beanName;
        this.message = message;
        this.status = status;
    }
    @Generated(hash = 80546095)
    public Bean() {
    }
    public long getId() {
        return this.id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getBeanName() {
        return this.beanName;
    }
    public void setBeanName(String beanName) {
        this.beanName = beanName;
    }
    public String getMessage() {
        return this.message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public String getStatus() {
        return this.status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    /**
     * To-many relationship, resolved on first access (and after reset).
     * Changes to to-many relations are not persisted, make changes to the target entity.
     */
    @Generated(hash = 1670210234)
    public List<ResultBean> getResult() {
        if (result == null) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            ResultBeanDao targetDao = daoSession.getResultBeanDao();
            List<ResultBean> resultNew = targetDao._queryBean_Result(beanName);
            synchronized (this) {
                if (result == null) {
                    result = resultNew;
                }
            }
        }
        return result;
    }
    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    @Generated(hash = 750945346)
    public synchronized void resetResult() {
        result = null;
    }
    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#delete(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 128553479)
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.delete(this);
    }
    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#refresh(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 1942392019)
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.refresh(this);
    }
    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#update(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 713229351)
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.update(this);
    }
    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 1858291965)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getBeanDao() : null;
    }
}
