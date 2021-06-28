package tai.spring.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthoritiesService {
	
	@Autowired
	AuthoritiesRepository AuthDAO;

}
