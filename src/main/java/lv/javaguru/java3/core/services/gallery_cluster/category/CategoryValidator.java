package lv.javaguru.java3.core.services.gallery_cluster.category;

import java.sql.Date;

/**
 * Created by Aleksej_home on 2015.11.09..
 */
public interface CategoryValidator {

    void validate(long galleryId,
                  long imgId,
                  String label,
                  String description,
                  boolean isActive,
                  boolean allowRate,
                  boolean allowRateIcons,
                  Date modified);
    void validate(long imgId,
                  String label,
                  String description,
                  boolean isActive,
                  boolean allowRate,
                  boolean allowRateIcons,
                  Date modified);
}
