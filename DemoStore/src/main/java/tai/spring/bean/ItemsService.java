package tai.spring.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemsService {

	@Autowired
	ItemsRepository itemRepo;
	
	public Items putItem(Items item) {
		Items result = itemRepo.save(item);
		return result;
	}

}
