package lv.javaguru.java3.core.services.gallery_cluster.image;

import lv.javaguru.java3.core.dto.gallery_cluster.ImageDTO;

import java.sql.Date;

/**
 * Created by Aleksej_home on 2015.11.09..
 */
public interface ImageValidator {
    void validate(int rate,
                  String label,
                  String thumb,
                  String middle,
                  String orig,
                  String description,
                  boolean isActive,
                  boolean allowRate,
                  boolean allowRateIcons,
                  Date modified);
    void validate(ImageDTO imageDTO);
}
