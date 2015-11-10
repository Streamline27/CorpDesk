package lv.javaguru.java3.core.services.gallery_cluster.gallery;

import lv.javaguru.java3.core.domain.gallery_cluster.gallery.Gallery;

import java.sql.Date;

/**
 * Created by Aleksej_home on 2015.11.09..
 */
public interface GalleryFactory {
    Gallery create( String label,
                    String description,
                    boolean isActive,
                    boolean allowRate,
                    boolean allowRateIcons);
}
