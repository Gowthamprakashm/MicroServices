package controller;

import java.util.List;
import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import model.Item;
import repository.ItemRepository;

@RestController
@RequestMapping("ekart")
public class ItemController {

	@Autowired
	ItemRepository itemRepo;
	
	@PostMapping("/")
	@ResponseBody
	public Item addItem(Item item) {
		return itemRepo.save(item);
	}

	@GetMapping("item/{itemId}")
	public Item getItemById(@PathVariable("itemId") Integer itemId){
		Optional<Item> item= itemRepo.findById(itemId);
		return item.orElse(new Item());
	}
	
	@GetMapping("items")
	public List<Item> getAllItems(){
		return itemRepo.findAll();
	}
	
	@DeleteMapping("item/{itemId}")
	public void deleteItem(@PathVariable("itemId") Integer itemId){
		itemRepo.deleteById(itemId);
	}

	
}
