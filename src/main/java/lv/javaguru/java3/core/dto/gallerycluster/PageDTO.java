package lv.javaguru.java3.core.dto.gallerycluster;

import java.io.Serializable;

/**
 * Created by Aleksej_home on 2016.02.16..
 */
public class PageDTO implements Serializable {

    private Long page;
    private Long pageCount;
    private Object pagedEntity;

    public Object getPagedEntity() {
        return pagedEntity;
    }

    public void setPagedEntity(Object pagedEntity) {
        this.pagedEntity = pagedEntity;
    }

    public Long getPage() {
        return page;
    }

    public void setPage(Long page) {
        this.page = page;
    }

    public long getPageCount() {
        return pageCount;
    }

    public void setPageCount(Long pageCount) {
        this.pageCount = pageCount;
    }
}
