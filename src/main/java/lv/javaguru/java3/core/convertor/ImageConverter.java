package lv.javaguru.java3.core.convertor;

import lv.javaguru.java3.core.domain.gallerycluster.image.Image;
import lv.javaguru.java3.core.dto.gallerycluster.ImageDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static lv.javaguru.java3.core.domain.gallerycluster.image.ImageBuilder.anImage;
import static lv.javaguru.java3.core.dto.gallerycluster.ImageDTOBuilder.anImageDTO;

/**
 * Created by Aleksej_home on 2015.11.17..
 */
@Component
public class ImageConverter extends Converter{

    public ImageDTO convert(Image image){
        if (image == null) return null;
        return anImageDTO()
                .withId(image.getId())
                .withThumb(image.getThumb())
                .withAllowRate(image.getAllowRate())
                .withAllowRateIcons(image.getAllowRateIcons())
                .withCreated(image.getCreated())
                .withDescription(image.getDescription())
                .withIsActive(image.isActive())
                .withLabel(image.getLabel())
                .withMiddle(image.getMiddle())
                .withModified(image.getModifed())
                .withOrig(image.getOrig())
                .withRate(image.getRate())
                .build();
    }
    public  Image convert(ImageDTO imageDTO){
        if (imageDTO == null) return null;
        return anImage()
                .withId(imageDTO.getId())
                .withThumb(imageDTO.getThumb())
                .withAllowRate(imageDTO.getAllowRate())
                .withAllowRateIcons(imageDTO.getAllowRateIcons())
                .withCreated(imageDTO.getCreated())
                .withDescription(imageDTO.getDescription())
                .withIsActive(imageDTO.isActive())
                .withLabel(imageDTO.getLabel())
                .withMiddle(imageDTO.getMiddle())
                .withModified(imageDTO.getModifed())
                .withOrig(imageDTO.getOrig())
                .withRate(imageDTO.getRate())
                .build();

    }

    public List<ImageDTO> convert(List<Image> images) {
        List<ImageDTO> result = new ArrayList<>();
        if (images!=null)
            for (Image image: images)
                result.add(convert(image));
        return result;
    }
    public List<Image> convertDTO(List<ImageDTO> imageDTOs) {
        List<Image> result = new ArrayList<>();
        if (imageDTOs!=null)
            for (ImageDTO imageDTO: imageDTOs)
                result.add(convert(imageDTO));
        return result;
    }

}
