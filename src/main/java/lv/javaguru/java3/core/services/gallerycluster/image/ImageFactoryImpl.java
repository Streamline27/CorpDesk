package lv.javaguru.java3.core.services.gallerycluster.image;

import lv.javaguru.java3.core.convertor.ImageConverter;
import lv.javaguru.java3.core.database.gallerycluster.image.ImageDAO;
import lv.javaguru.java3.core.domain.gallerycluster.image.Image;
import lv.javaguru.java3.core.dto.gallerycluster.ImageDTO;
import org.springframework.beans.factory.annotation.Autowired;

import static lv.javaguru.java3.core.domain.gallerycluster.image.ImageBuilder.anImage;

import java.sql.Date;

/**
 * Created by Aleksej_home on 2015.11.09..
 */
public class ImageFactoryImpl implements ImageFactory {

    @Autowired private ImageValidator imageValidator;
    @Autowired private ImageDAO imageDAO;
    @Autowired private ImageConverter imageConverter;

    @Override
    public Image create(int rate,
                        String label,
                        String thumb,
                        String middle,
                        String orig,
                        String description,
                        boolean isActive,
                        boolean allowRate,
                        boolean allowRateIcons,
                        Date modified) {
        imageValidator.validate(rate,
                label,
                thumb,
                middle,
                orig,
                description,
                isActive,
                allowRate,
                allowRateIcons,
                modified);

        Image image = anImage()
                .withRate(rate)
                .withLabel(label)
                .withThumb(thumb)
                .withMiddle(middle)
                .withOrig(orig)
                .withDescription(description)
                .withIsActive(isActive)
                .withAllowRate(allowRate)
                .withAllowRateIcons(allowRateIcons)
                .withModified(modified)
                .build();
        imageDAO.create(image);
        return image;
    }

    @Override
    public ImageDTO createDTO(ImageDTO imageDTO) {
        imageValidator.validate(imageDTO);
        imageDAO.create(imageConverter.convert(imageDTO));
        return imageDTO;
    }
    @Override
    public Image create(ImageDTO imageDTO) {
        imageValidator.validate(imageDTO);
        Image image = imageConverter.convert(imageDTO);
        imageDAO.create(image);
        return image;
    }
}
