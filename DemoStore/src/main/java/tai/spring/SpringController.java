package tai.spring;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import tai.spring.bean.Authorities;
import tai.spring.bean.AuthoritiesService;
import tai.spring.bean.Items;
import tai.spring.bean.ItemsService;
import tai.spring.bean.OrderDetails;
import tai.spring.bean.OrderDetailsService;
import tai.spring.bean.OrderList;
import tai.spring.bean.OrderListService;
import tai.spring.bean.User;
import tai.spring.bean.UserService;

@Controller
@ConfigurationProperties(prefix = "test.properties")
public class SpringController {
	
	private String test = "0";
	public void setTest(String test) {
		this.test = test;
	}
//	@Autowired
//	HouseService houseService;
	@Autowired
	private UserService userService;
	
	@Autowired
	private AuthoritiesService authService;
//	@Autowired
//	private AuthorizationContext authcontext;
	
	@Autowired
	private ItemsService itemsService;
	
	@Autowired
	private OrderDetailsService orderDetailsService;
	
	@Autowired
	private OrderListService orderListService;
	
	@GetMapping("test2")
	public String gotoTest2() {
		return "test2.html";
	}
//	@GetMapping("/home")
//	public String goIndex(HttpServletResponse response,Model model) throws IOException {
//		System.out.println("start home");
//		System.out.println(test);
//		List<House> houselist = houseService.getAllHouse();
//		for(House house: houselist) {
//			System.out.println(house.getId());
//			System.out.println(house.getName());
//			System.out.println(house.getPrice());
//		}
//		House house2 = houseService.getHouseById(2).get();
//		System.out.println("house2:" + house2.getName());
//		house2.setName("block house");
//		houseService.addHouse(house2);
//		House house3 = new House();
//		house3.setName("green house");
//		house3.setPrice(1200);
//		houseService.addHouse(house3);
//		String[] stringlist = {"mark","john","andy","yen","varian"};
//		model.addAttribute("user","mark");
//		model.addAttribute("list",stringlist);
//		User user = userService.getUser("admin");
//		model.addAttribute("userbean",user);
//		return "/index.html";
//	}
	
	@GetMapping("index")
	public String home() {
		return "index.html";
	}
	
	@GetMapping("/login")
	public String toLogin(Model model) {
		model.addAttribute("loginTitle","歡迎來到 Tai小的窩");
		model.addAttribute("username","使用者帳號");
		model.addAttribute("pwd","使用者密碼");
		model.addAttribute("loginBtn","登入");
		model.addAttribute("copyRight","H.J.T版權所有 (c) Tai Personal All Rights Reserved");
		return "/login.html";
	}
	
//	@PostMapping("/login.do")
//	public String processLogin(@RequestParam String userid,
//								@RequestParam String pwd,Model model) {
//		User user = userService.getUser(userid);
//		model.addAttribute("userbean",user);
//		return "/SuccessLogin.html";
//	}
	
	@GetMapping("/register")
	public String toRegister() {
		return "/register.html";
	}
	
	@PostMapping("/register.do")
	public String processRegister(
			@RequestParam String username,
			@RequestParam String pwd,
			@RequestParam(defaultValue = "Normal") String role,
			@RequestParam(defaultValue = "level1") String groupid,
			Model model) {
		User user = new User();
		Authorities authorities = new Authorities();
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		authorities.setGroupid(groupid);
		authorities.setRole(role);
		authorities.setUser(user);
		user.setUsername(username);
		user.setPassword(encoder.encode(pwd));
		user.setEnable(true);
		user.setAuthorities(authorities);
		userService.putUser(user);
		model.addAttribute("userbean",user);
		return "/SuccessRegister.html";
	}
	
	@GetMapping("/login.success")
	public String toLoginSuccess(Model model) {
		Authentication authent = SecurityContextHolder.getContext().getAuthentication();
		model.addAttribute("content","99999");
		model.addAttribute("username",authent.getName());
		return "/SuccessLogin.html";
	}
	
	@GetMapping("/register.success")
	public String toRegisterSuccess() {
		return "/SuccessRegister.html";
	}
	
	@GetMapping("/testjpa.do")
	public String toTestJpa(Model model, 
			@QuerydslPredicate(root = User.class)String username,
			String password) {
			
		return "/testJpaOut.html";
	}
	
	@GetMapping("/putItems")
	public String putItems() {
		return "/putItems.html";
	}
	@PostMapping("/putItems.do")
	public String doPutItems(Model model,
			@RequestParam String item_name,
			@RequestParam String description,
			@RequestParam String price) {
		
		Items item = new Items();
		item.setItem_name(item_name);
		item.setItem_description(description);
		item.setPrice(new BigDecimal(price));
		
		itemsService.putItem(item);
		
		return "/success.html";
	}
	
	@GetMapping("/putOrderList")
	public String putOrderList() {
		return "/putOrderList.html";
	}
	@PostMapping("/putOrderList.do")
	public String doputOrderList(Model model,
			@RequestParam String userNo,
			@RequestParam String itemNo,
			@RequestParam String count) {
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyyMMddhhmmss");
		
		OrderList orderList = new OrderList();
		OrderDetails orderDetails = new OrderDetails();
		try {
			orderList.setUserNo(Integer.valueOf(userNo));
			orderList.setDatetime(dateformat.format(new Date().getTime()));
			orderDetails.setCount(Integer.valueOf(count));
			orderDetails.setItemNo(Integer.valueOf(itemNo));
			
		}catch(Exception e) {
			return "/error.html";
		}
		orderListService.putOrderList(orderList);
		
		return "/success.html";
	}
	
	@RequestMapping("/getOrderByUser/{userNo}")
	public String getOrderByUser(@PathVariable String userNo, Model model) {
		List<OrderList> resultList = orderListService.getOrderListByUserNo(Integer.valueOf(userNo));
		OrderList result = resultList.get(0);
		model.addAttribute("orderList", result);
		return "/orderList.html";
	}
	
	@GetMapping("/putOrderDetails")
	public String putOrderDetails() {
		return "/putOrderDetails.html";
	}
	@PostMapping("/putOrderDetails.do")
	public String doputOrderDetails(Model model,
			@RequestParam String order_no,
			@RequestParam String item_no,
			@RequestParam String count) {
		
		OrderDetails orderDetail = new OrderDetails();
		try {
			orderDetail.setItemNo(Integer.valueOf(item_no));
			orderDetail.setOrderNo(order_no);
			orderDetail.setCount(Integer.valueOf(count));
		}catch(Exception e) {
			return "/error.html";
		}
		
		orderDetailsService.putOrderDetails(orderDetail);
		
		return "/success.html";
	}
}
