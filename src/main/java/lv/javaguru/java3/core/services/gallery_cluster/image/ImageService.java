package lv.javaguru.java3.core.services.gallery_cluster.image;

import lv.javaguru.java3.core.domain.gallery_cluster.image.Image;

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
}
