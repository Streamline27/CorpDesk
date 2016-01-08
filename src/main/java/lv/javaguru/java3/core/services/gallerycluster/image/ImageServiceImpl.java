package lv.javaguru.java3.core.services.gallerycluster.image;

import lv.javaguru.java3.core.convertor.ImageConverter;
import lv.javaguru.java3.core.database.gallerycluster.image.ImageDAO;
import lv.javaguru.java3.core.domain.gallerycluster.image.Image;
import lv.javaguru.java3.core.dto.gallerycluster.ImageDTO;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Date;

/**
 * Created by Aleksej_home on 2015.11.09..
 */
public class ImageServiceImpl implements ImageService{

    @Autowired private ImageValidator imageValidator;
    @Autowired private ImageDAO imageDAO;
    @Autowired private ImageConverter imageConverter;

    @Override
    public Image update(Long id,
                        int newRate,
                        String newLabel,
                        String newThumb,
                        String newMiddle,
                        String newOrig,
                        String newDescription,
                        boolean newIsActive,
                        boolean newAllowRate,
                        boolean newAllowRateIcons,
                        Date newModified) {
        imageValidator.validate(newRate,
                newLabel,
                newThumb,
                newMiddle,
                newOrig,
                newDescription,
                newIsActive,
                newAllowRate,
                newAllowRateIcons,
                newModified);
        Image image = get(id);
        image.setRate(newRate);
        image.setLabel(newLabel);
        image.setThumb(newThumb);
        image.setMiddle(newMiddle);
        image.setOrig(newOrig);
        image.setDescription(newDescription);
        image.setIsActive(newIsActive);
        image.setAllowRate(newAllowRate);
        image.setAllowRateIcons(newAllowRateIcons);
        image.setModifed(newModified);
        return image;
    }

    @Override
    public Image get(Long id) {
        return imageDAO.getRequired(id);
    }

    @Override
    public Image update(Image image) {
        imageValidator.validate(imageConverter.convert(image));
        imageDAO.update(image);
        return image;
    }

    @Override
    public ImageDTO updateDTO(ImageDTO imageDTO) {
        imageValidator.validate(imageDTO);
        imageDAO.update(imageConverter.convert(imageDTO));
        return imageDTO;
    }
    @Override
    public Image update(ImageDTO imageDTO) {
        imageValidator.validate(imageDTO);
        Image image = imageConverter.convert(imageDTO);
        imageDAO.update(image);
        return image;
    }

    @Override
    public void delete(long id) {
        Image image = imageDAO.getRequired(id);
        imageDAO.delete(image);
    }
}
