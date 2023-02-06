package ibf2022.ssf.day11exercise.controller;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = { "/", "/index.html" }, produces = MediaType.TEXT_HTML_VALUE)
public class RandomNumController {

    private Logger logger = Logger.getLogger(RandomNumController.class.getName());

    // GET /, GET /index.html
    @GetMapping
    public String randomNum(Model model) {

        Random random = new Random();
        int randomNum = random.nextInt(31);
        System.out.println("The randomNum is: " + randomNum); // testing purposes
        String imgURL = "/images/number%d.jpg".formatted(randomNum); // format the int into string

        logger.log(Level.INFO, imgURL);

        // Binds the value to the model
        model.addAttribute("imgURL", imgURL);
        model.addAttribute("randomNum", randomNum);

        return "index"; // Render the template with the model
    }
}

// @Controller
// @RequestMapping(path = "/")
// public class RandomNumController {

// @GetMapping
// public String getRandom(Model model) {

// File folder = new File("src/main/resources/static/images"); // create a path
// where the program can find the images
// File[] listOfFiles = folder.listFiles();

// Random random = new Random(); // generate a random int
// int randomIndex = random.nextInt(listOfFiles.length); // generate a random
// int and limit to size of File array

// String randomImage = listOfFiles[randomIndex].getName(); // randomly selects
// the name of the file inside the folder
// String fileName = "/images/";
// model.addAttribute("fileName", fileName);
// model.addAttribute("randomImage", randomImage);

// return "image";

// }
// }