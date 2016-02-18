package lv.javaguru.java3.core.dto.gallerycluster;

/**
 * Created by Aleksej_home on 2016.02.16..
 */
public class PageDTOBuilder {
    private Long page;
    private Long pageCount;
    private Object pagedEntity;

    private PageDTOBuilder() {
    }

    public static PageDTOBuilder aPageDTO() {
        return new PageDTOBuilder();
    }

    public PageDTOBuilder withPage(Long page) {
        this.page = page;
        return this;
    }

    public PageDTOBuilder withPageCount(Long pageCount) {
        this.pageCount = pageCount;
        return this;
    }

    public PageDTOBuilder withPagedEntity(Object pagedEntity) {
        this.pagedEntity = pagedEntity;
        return this;
    }

    public PageDTOBuilder but() {
        return aPageDTO().withPage(page).withPageCount(pageCount);
    }

    public PageDTO build() {
        PageDTO pageDTO = new PageDTO();
        pageDTO.setPage(page);
        pageDTO.setPageCount(pageCount);
        pageDTO.setPagedEntity(pagedEntity);
        return pageDTO;
    }
}
