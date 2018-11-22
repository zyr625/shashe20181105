package lenovo.example.com.shashe20181105;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * author：shashe
 * 日期：2018/11/5
 */
@Entity
public class CacheCar {
    @Id(autoincrement = true)
    private Long id;
    private String title;
    private String image;
    @Generated(hash = 389439212)
    public CacheCar(Long id, String title, String image) {
        this.id = id;
        this.title = title;
        this.image = image;
    }
    @Generated(hash = 1835476732)
    public CacheCar() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTitle() {
        return this.title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getImage() {
        return this.image;
    }
    public void setImage(String image) {
        this.image = image;
    }
    
}
