package lenovo.example.com.shashe20181105.greendao;

import java.util.Map;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import lenovo.example.com.shashe20181105.CacheCar;

import lenovo.example.com.shashe20181105.greendao.CacheCarDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see org.greenrobot.greendao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig cacheCarDaoConfig;

    private final CacheCarDao cacheCarDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        cacheCarDaoConfig = daoConfigMap.get(CacheCarDao.class).clone();
        cacheCarDaoConfig.initIdentityScope(type);

        cacheCarDao = new CacheCarDao(cacheCarDaoConfig, this);

        registerDao(CacheCar.class, cacheCarDao);
    }
    
    public void clear() {
        cacheCarDaoConfig.clearIdentityScope();
    }

    public CacheCarDao getCacheCarDao() {
        return cacheCarDao;
    }

}