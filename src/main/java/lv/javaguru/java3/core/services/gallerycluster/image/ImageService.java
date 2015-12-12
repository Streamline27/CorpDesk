package lv.javaguru.java3.core.services.gallerycluster.image;

import lv.javaguru.java3.core.domain.gallerycluster.image.Image;
import lv.javaguru.java3.core.dto.gallerycluster.ImageDTO;

import java.sql.Date;

/**
 * Created by Aleksej_home on 2015.11.09..
 */
public interface ImageService {
    Image update(Long id,
                    int newRate,
                    String newLabel,
                    String newThumb,
                    String newMiddle,
                    String newOrig,
                    String newDescription,
                    boolean newIsActive,
                    boolean newAllowRate,
                    boolean newAllowRateIcons,
                    Date newModified);

    Image get(Long id);

    Image update(Image image);

    ImageDTO update(ImageDTO imageDTO);

    void delete(long id);
}
