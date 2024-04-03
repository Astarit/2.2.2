package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HelloController {

	@GetMapping(value = "/")
	public String printWelcome(ModelMap model) {
		List<String> messages = new ArrayList<>();
		messages.add("Hello!");
		messages.add("I'm Spring MVC application");
		messages.add("5.2.0 version by sep'19 ");
		model.addAttribute("messages", messages);
		return "index";
	}

	@GetMapping(value = "/cars")
	public String printCars(ModelMap model, @RequestParam(value = "count", defaultValue = "5") int count) {
		List<Car> cars = new ArrayList<>();
		cars.add(new Car("Gaz", 1231, "red"));
		cars.add(new Car("Vaz", 27545, "blue"));
		cars.add(new Car("Maz", 2345, "green"));
		cars.add(new Car("Liaz", 4455, "brown"));
		cars.add(new Car("Kraz", 1001, "grey"));
		model.addAttribute("cars", cars.subList(0, count));
		return "cars";
	}
	
}