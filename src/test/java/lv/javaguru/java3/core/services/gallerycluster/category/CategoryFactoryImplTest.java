package lv.javaguru.java3.core.services.gallerycluster.category;

import lv.javaguru.java3.core.convertor.CategoryConverter;
import lv.javaguru.java3.core.database.gallerycluster.category.CategoryDAO;
import lv.javaguru.java3.core.domain.gallerycluster.category.Category;
import lv.javaguru.java3.core.dto.gallerycluster.CategoryDTO;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import java.sql.Date;

import static lv.javaguru.java3.core.domain.gallerycluster.category.CategoryBuilder.aCategory;
import static lv.javaguru.java3.core.dto.gallerycluster.CategoryDTOBuilder.aCategoryDTO;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

/**
 * Created by Aleksej_home on 2015.12.30..
 */
@RunWith(MockitoJUnitRunner.class)
public class CategoryFactoryImplTest {
    @Mock
    private CategoryValidator categoryValidator;
    @Mock private CategoryDAO categoryDAO;
    @Mock private CategoryConverter categoryConverter;


    @InjectMocks
    private CategoryFactory categoryFactory = new CategoryFactoryImpl();


    private static final boolean ALLOW_RATE = true;
    private static final boolean ALLOW_RATE_ICONS = true;
    private static final String DESCRIPTION = "about vata";
    private static final String LABEL = "vata.jpg";
    private static final boolean IS_ACTIVE = true;
    private static final CategoryDTO CATEGORY_DTO = categoryDTOBuild();
    private static final Category CATEGORY = categoryBuild();


    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);

    }

    private static CategoryDTO categoryDTOBuild(){
        return aCategoryDTO()
                .withAllowRate(ALLOW_RATE)
                .withAllowRateIcons(ALLOW_RATE_ICONS)
                .withDescription(DESCRIPTION)
                .withIsActive(IS_ACTIVE)
                .withLabel(LABEL)
                .withModified(new Date(System.currentTimeMillis()))
                .build();

    }

    private static Category categoryBuild(){
        return aCategory()
                .withAllowRate(ALLOW_RATE)
                .withAllowRateIcons(ALLOW_RATE_ICONS)
                .withDescription(DESCRIPTION)
                .withIsActive(IS_ACTIVE)
                .withLabel(LABEL)
                .withModified(new Date(System.currentTimeMillis()))
                .build();
    }


    @Test
    public void createShouldInvokeCategoryValidator() {

        categoryFactory.create(CATEGORY_DTO);
        verify(categoryValidator).validate(CATEGORY_DTO);
    }


    @Test(expected = IllegalArgumentException.class)
    public void createShouldFailIfCategoryValidationFail() {
        doThrow(new IllegalArgumentException())
                .when(categoryValidator).validate(CATEGORY_DTO);
        categoryFactory.create(CATEGORY_DTO);
    }


    @Test
    public void createShouldPersistCategoryAfterValidation() {
        Category category = categoryFactory.create(CATEGORY_DTO);
        InOrder inOrder = inOrder(categoryValidator, categoryDAO);
        inOrder.verify(categoryValidator).validate(CATEGORY_DTO);
        inOrder.verify(categoryDAO).create(category);
    }

    @Test
    public void createShouldReturnNewCategory() {
        when(categoryConverter.convert(CATEGORY_DTO)).thenReturn(CATEGORY);
        Category category = categoryFactory.create(CATEGORY_DTO);
        assertNotNull(category);
        assertThat(category.getAllowRate(), is(ALLOW_RATE));
        assertThat(category.getAllowRateIcons(), is(ALLOW_RATE_ICONS));
        assertThat(category.getDescription(), is(DESCRIPTION));
        assertThat(category.getLabel(), is(LABEL));
        assertThat(category.isActive(), is(IS_ACTIVE));
    }
}
