package lv.javaguru.java3.core.services.gallery_cluster.image;

import lv.javaguru.java3.core.database.gallery_cluster.image.ImageDAO;
import lv.javaguru.java3.core.domain.gallery_cluster.image.Image;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Date;

/**
 * Created by Aleksej_home on 2015.11.09..
 */
public class ImageServiceImpl implements ImageService{

    @Autowired private ImageValidator imageValidator;
    @Autowired private ImageDAO imageDAO;

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
}
