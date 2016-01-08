package lv.javaguru.java3.core.services.gallerycluster.image;

/**
 * Created by Aleksej_home on 2015.12.30..
 */
import lv.javaguru.java3.core.convertor.ImageConverter;
import lv.javaguru.java3.core.database.gallerycluster.image.ImageDAO;
import lv.javaguru.java3.core.domain.gallerycluster.image.Image;
import lv.javaguru.java3.core.dto.gallerycluster.ImageDTO;
import static lv.javaguru.java3.core.dto.gallerycluster.ImageDTOBuilder.anImageDTO;
import static lv.javaguru.java3.core.domain.gallerycluster.image.ImageBuilder.anImage;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import java.sql.Date;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;


@RunWith(MockitoJUnitRunner.class)
public class ImageFactoryImplTest {

    @Mock private ImageValidator imageValidator;
    @Mock private ImageDAO imageDAO;
    @Mock private ImageConverter imageConverter;


    @InjectMocks
    private ImageFactory imageFactory = new ImageFactoryImpl();


    private static final boolean ALLOW_RATE = true;
    private static final boolean ALLOW_RATE_ICONS = true;
    private static final String DESCRIPTION = "vata image";
    private static final boolean IS_ACTIVE = true;
    private static final String LABEL = "vata image";
    private static final String MIDDLE = "middle";
    private static final String ORIG = "orig";
    private static final String THUMB = "thumb";
    private static final int RATE = 3;
    private static final ImageDTO IMAGE_DTO = imageDTOBuild();
    private static final Image IMAGE = imageBuild();


    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);

    }

    private static ImageDTO imageDTOBuild(){
        return anImageDTO()
                .withAllowRate(ALLOW_RATE)
                .withAllowRateIcons(ALLOW_RATE_ICONS)
                .withDescription(DESCRIPTION)
                .withIsActive(IS_ACTIVE)
                .withLabel(LABEL)
                .withMiddle(MIDDLE)
                .withModified(new Date(System.currentTimeMillis()))
                .withOrig(ORIG)
                .withRate(RATE)
                .withThumb(THUMB)
                .build();

    }

    private static Image imageBuild(){
        return anImage()
                .withAllowRate(ALLOW_RATE)
                .withAllowRateIcons(ALLOW_RATE_ICONS)
                .withDescription(DESCRIPTION)
                .withIsActive(IS_ACTIVE)
                .withLabel(LABEL)
                .withMiddle(MIDDLE)
                .withModified(new Date(System.currentTimeMillis()))
                .withOrig(ORIG)
                .withRate(RATE)
                .withThumb(THUMB)
                .build();
    }


    @Test
    public void createShouldInvokeImageValidator() {

        imageFactory.create(IMAGE_DTO);
        verify(imageValidator).validate(IMAGE_DTO);
    }


    @Test(expected = IllegalArgumentException.class)
    public void createShouldFailIfImageValidationFail() {
        doThrow(new IllegalArgumentException())
                .when(imageValidator).validate(IMAGE_DTO);
        imageFactory.create(IMAGE_DTO);
    }


    @Test
    public void createShouldPersistImageAfterValidation() {
        Image image = imageFactory.create(IMAGE_DTO);
        InOrder inOrder = inOrder(imageValidator, imageDAO);
        inOrder.verify(imageValidator).validate(IMAGE_DTO);
        inOrder.verify(imageDAO).create(image);
    }

    @Test
    public void createShouldReturnNewImage() {
        when(imageConverter.convert(IMAGE_DTO)).thenReturn(IMAGE);
        Image image = imageFactory.create(IMAGE_DTO);
        assertNotNull(image);
        assertThat(image.getAllowRate(), is(ALLOW_RATE));
        assertThat(image.getAllowRateIcons(), is(ALLOW_RATE_ICONS));
        assertThat(image.getMiddle(), is(MIDDLE));
        assertThat(image.getOrig(), is(ORIG));
        assertThat(image.getRate(), is(RATE));
        assertThat(image.getThumb(), is(THUMB));
        assertThat(image.getDescription(), is(DESCRIPTION));
        assertThat(image.getLabel(), is(LABEL));
        assertThat(image.isActive(), is(IS_ACTIVE));
    }
}
