package org.literacyapp.web.content.module;

import org.apache.log4j.Logger;
import org.literacyapp.dao.ImageDao;
import org.literacyapp.model.Image;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/content/module/activities")
public class ModuleActivityController {
    
    private final Logger logger = Logger.getLogger(getClass());
    
    @Autowired
    private ImageDao imageDao;

    @RequestMapping(value = "/{activityId}", method = RequestMethod.GET)
    public String handleRequest(Model model, @PathVariable Long activityId) {
    	logger.info("handleRequest");
        
        Image imageLion = imageDao.read("Lion");
        Image imageTiger = imageDao.read("Tiger");
        Image imageCat = imageDao.read("Cat");
        int random = (int) (Math.random() * 3);
        if (random == 0) {
            model.addAttribute("image1", imageLion);
            model.addAttribute("image2", imageTiger);
            model.addAttribute("image3", imageCat);
        } else if (random == 1) {
            model.addAttribute("image1", imageTiger);
            model.addAttribute("image2", imageCat);
            model.addAttribute("image3", imageLion);
        } else if (random == 2) {
            model.addAttribute("image1", imageCat);
            model.addAttribute("image2", imageTiger);
            model.addAttribute("image3", imageLion);
        }

        return "content/module/activity";
    }
}
