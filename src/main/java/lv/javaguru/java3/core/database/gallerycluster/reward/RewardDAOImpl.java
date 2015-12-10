package lv.javaguru.java3.core.database.gallerycluster.reward;

import lv.javaguru.java3.core.database.CRUDOperationDAOImpl;
import lv.javaguru.java3.core.domain.gallerycluster.reward.Reward;
import org.springframework.stereotype.Component;

/**
 * Created by Aleksej_home on 2015.11.09..
 */
@Component
public class RewardDAOImpl extends CRUDOperationDAOImpl<Reward, Long> implements RewardDAO {
}
