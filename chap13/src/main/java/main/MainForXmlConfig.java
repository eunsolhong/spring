package main;

import org.springframework.context.support.GenericXmlApplicationContext;

import service.PlaceOrderService;
import service.PurchaseOrderRequest;
import service.PurchaseOrderResult;

public class MainForXmlConfig {

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext(
				"classpath:/dataSource.xml", "classpath:/store.xml");
        System.out.println("==============1");
		PlaceOrderService orderService = ctx.getBean(PlaceOrderService.class);
		PurchaseOrderRequest orderRequest = new PurchaseOrderRequest();
		orderRequest.setItemId(1);
		orderRequest.setAddress("주소=====");

		PurchaseOrderResult orderResult = orderService.order(orderRequest);
		System.out.println(orderResult.getOrder().getId());
		 System.out.println("==============2");
		ctx.close();
	}
 
}
