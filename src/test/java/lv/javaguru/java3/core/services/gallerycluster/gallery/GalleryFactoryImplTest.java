package lv.javaguru.java3.core.services.gallerycluster.gallery;

import lv.javaguru.java3.core.convertor.GalleryConverter;
import lv.javaguru.java3.core.database.gallerycluster.gallery.GalleryDAO;
import lv.javaguru.java3.core.domain.gallerycluster.gallery.Gallery;
import lv.javaguru.java3.core.dto.gallerycluster.GalleryDTO;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import static lv.javaguru.java3.core.domain.gallerycluster.gallery.GalleryBuilder.aGallery;
import static lv.javaguru.java3.core.dto.gallerycluster.GalleryDTOBuilder.aGalleryDTO;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

/**
 * Created by Aleksej_home on 2015.12.30..
 */
@RunWith(MockitoJUnitRunner.class)
public class GalleryFactoryImplTest {
    @Mock
    private GalleryValidator galleryValidator;
    @Mock private GalleryDAO galleryDAO;
    @Mock private GalleryConverter galleryConverter;


    @InjectMocks
    private GalleryFactory galleryFactory = new GalleryFactoryImpl();


    private static final boolean ALLOW_RATE = true;
    private static final boolean ALLOW_RATE_ICONS = true;
    private static final String DESCRIPTION = "about vata";
    private static final String LABEL = "vata.jpg";
    private static final boolean IS_ACTIVE = true;
    private static final GalleryDTO GALLERY_DTO = galleryDTOBuild();
    private static final Gallery GALLERY = galleryBuild();


    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);

    }

    private static GalleryDTO galleryDTOBuild(){
        return aGalleryDTO()
                .withAllowRate(ALLOW_RATE)
                .withAllowRateIcons(ALLOW_RATE_ICONS)
                .withDescription(DESCRIPTION)
                .withIsActive(IS_ACTIVE)
                .withLabel(LABEL)
                .build();

    }

    private static Gallery galleryBuild(){
        return aGallery()
                .withAllowRate(ALLOW_RATE)
                .withAllowRateIcons(ALLOW_RATE_ICONS)
                .withDescription(DESCRIPTION)
                .withIsActive(IS_ACTIVE)
                .withLabel(LABEL)
                .build();
    }


    @Test
    public void createShouldInvokeGalleryValidator() {

        galleryFactory.create(GALLERY_DTO);
        verify(galleryValidator).validate(GALLERY_DTO);
    }


    @Test(expected = IllegalArgumentException.class)
    public void createShouldFailIfGalleryValidationFail() {
        doThrow(new IllegalArgumentException())
                .when(galleryValidator).validate(GALLERY_DTO);
        galleryFactory.create(GALLERY_DTO);
    }


    @Test
    public void createShouldPersistGalleryAfterValidation() {
        Gallery gallery = galleryFactory.create(GALLERY_DTO);
        InOrder inOrder = inOrder(galleryValidator, galleryDAO);
        inOrder.verify(galleryValidator).validate(GALLERY_DTO);
        inOrder.verify(galleryDAO).create(gallery);
    }

    @Test
    public void createShouldReturnNewGallery() {
        when(galleryConverter.convert(GALLERY_DTO)).thenReturn(GALLERY);
        Gallery gallery = galleryFactory.create(GALLERY_DTO);
        assertNotNull(gallery);
        assertThat(gallery.getAllowRate(), is(ALLOW_RATE));
        assertThat(gallery.getAllowRateIcons(), is(ALLOW_RATE_ICONS));
        assertThat(gallery.getDescription(), is(DESCRIPTION));
        assertThat(gallery.getLabel(), is(LABEL));
        assertThat(gallery.isActive(), is(IS_ACTIVE));
    }
}
