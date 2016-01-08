package lv.javaguru.java3.core.services.gallerycluster.reward;

/**
 * Created by Aleksej_home on 2015.12.30..
 */
import lv.javaguru.java3.core.convertor.RewardConverter;
import lv.javaguru.java3.core.database.gallerycluster.reward.RewardDAO;
import lv.javaguru.java3.core.domain.gallerycluster.reward.Reward;
import lv.javaguru.java3.core.dto.gallerycluster.RewardDTO;
import static lv.javaguru.java3.core.dto.gallerycluster.RewardDTOBuilder.aRewardDTO;
import static lv.javaguru.java3.core.domain.gallerycluster.reward.RewardBuilder.aReward;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;


@RunWith(MockitoJUnitRunner.class)
public class RewardServiceImplTest {

    @Mock private RewardValidator rewardValidator;
    @Mock private RewardDAO rewardDAO;
    @Mock private RewardConverter rewardConverter;


    @InjectMocks
    private RewardService rewardService = new RewardServiceImpl();


    private static final long ID = 10l;
    private static final String NAME = "vata";
    private static final String DESCRIPTION = "about vata";
    private static final String LABEL = "vata.jpg";
    private static final boolean IS_ACTIVE = true;
    private static final RewardDTO REWARD_DTO = rewardDTOBuild();
    private static final Reward REWARD = rewardBuild();


    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);

    }

    private static RewardDTO rewardDTOBuild(){
        return aRewardDTO()
                .withId(ID)
                .withName(NAME)
                .withDescription(DESCRIPTION)
                .withLabel(LABEL)
                .withIsActive(IS_ACTIVE)
                .build();

    }

    private static Reward rewardBuild(){
        return aReward()
                .withId(ID)
                .withDescription(DESCRIPTION)
                .withIsActive(IS_ACTIVE)
                .withLabel(LABEL)
                .withName(NAME)
                .build();
    }


    @Test
    public void updateShouldInvokeRewardValidator() {

        rewardService.update(REWARD_DTO);
        verify(rewardValidator).validate(REWARD_DTO);
    }

/*
    @Test(expected = IllegalArgumentException.class)
    public void updateShouldFailIfRewardValidationFail() {
        doThrow(new IllegalArgumentException())
                .when(rewardValidator).validate(REWARD_DTO);
        rewardService.update(REWARD_DTO);
    }


    @Test
    public void updateShouldPersistRewardAfterValidation() {
        Reward reward = rewardService.update(REWARD_DTO);
        InOrder inOrder = inOrder(rewardValidator, rewardDAO);
        inOrder.verify(rewardValidator).validate(REWARD_DTO);
        inOrder.verify(rewardDAO).create(reward);
    }

    @Test
    public void updateShouldReturnNewReward() {
        when(rewardConverter.convert(REWARD_DTO)).thenReturn(REWARD);
        Reward reward = rewardService.update(REWARD_DTO);
        assertNotNull(reward);
        assertThat(reward.getName(), is(NAME));
        assertThat(reward.getDescription(), is(DESCRIPTION));
        assertThat(reward.getLabel(), is(LABEL));
        assertThat(reward.isActive(), is(IS_ACTIVE));
    }

    @Test
    public void getShouldReturnReward(){
        when(rewardDAO.getRequired(ID)).thenReturn(REWARD);
        Reward reward = rewardService.get(ID);
        assertNotNull(reward);
        assertThat(reward.getName(), is(NAME));
        assertThat(reward.getDescription(), is(DESCRIPTION));
        assertThat(reward.getLabel(), is(LABEL));
        assertThat(reward.isActive(), is(IS_ACTIVE));
    }

    @Test
    public void deleteShouldInvokeGet(){
        when(rewardDAO.getRequired(ID)).thenReturn(REWARD);
        rewardService.delete(ID);
        verify(rewardDAO).getRequired(ID);

    }
    @Test
    public void deleteShouldInvokeDeleteFromDAO() {
        when(rewardDAO.getRequired(ID)).thenReturn(REWARD);
        rewardService.delete(ID);
        verify(rewardDAO).delete(REWARD);
    }
*/


}
