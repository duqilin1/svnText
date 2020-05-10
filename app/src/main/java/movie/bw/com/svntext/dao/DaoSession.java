package movie.bw.com.svntext.dao;

import java.util.Map;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import movie.bw.com.svntext.Bean;
import movie.bw.com.svntext.ResultBean;

import movie.bw.com.svntext.dao.BeanDao;
import movie.bw.com.svntext.dao.ResultBeanDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see org.greenrobot.greendao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig beanDaoConfig;
    private final DaoConfig resultBeanDaoConfig;

    private final BeanDao beanDao;
    private final ResultBeanDao resultBeanDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        beanDaoConfig = daoConfigMap.get(BeanDao.class).clone();
        beanDaoConfig.initIdentityScope(type);

        resultBeanDaoConfig = daoConfigMap.get(ResultBeanDao.class).clone();
        resultBeanDaoConfig.initIdentityScope(type);

        beanDao = new BeanDao(beanDaoConfig, this);
        resultBeanDao = new ResultBeanDao(resultBeanDaoConfig, this);

        registerDao(Bean.class, beanDao);
        registerDao(ResultBean.class, resultBeanDao);
    }
    
    public void clear() {
        beanDaoConfig.clearIdentityScope();
        resultBeanDaoConfig.clearIdentityScope();
    }

    public BeanDao getBeanDao() {
        return beanDao;
    }

    public ResultBeanDao getResultBeanDao() {
        return resultBeanDao;
    }

}
