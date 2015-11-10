package lv.javaguru.java3.core.services.gallery_cluster.reward;

import lv.javaguru.java3.core.domain.gallery_cluster.reward.Reward;

/**
 * Created by Aleksej_home on 2015.11.09..
 */
public interface RewardFactory {
    Reward create( String name,
                    String label,
                    String description,
                    boolean isActive);
}
