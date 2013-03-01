package com.dreamdom.tutorials.shoppingcart;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import android.content.res.Resources;

public class ShoppingCartHelper {
	
	public static final String PRODUCT_INDEX = "PRODUCT_INDEX";
	
	private static List<Product> catalog;
	private static Map<Product, ShoppingCartEntry> cartMap = new HashMap<Product, ShoppingCartEntry>();
	
	public static List<Product> getCatalog(Resources res){
		if(catalog == null) {
			catalog = new Vector<Product>();
			catalog.add(new Product("Mouse", res
					.getDrawable(R.drawable.mouse),
					"A4Tech Mouse", 250.00));
			catalog.add(new Product("Keyboard", res
					.getDrawable(R.drawable.keyboard),
					"A4Tech Keyboard", 300.00));
			catalog.add(new Product("CD-ROM", res
					.getDrawable(R.drawable.cdrom),
					"Samsung CD-ROM", 3000.00));
			catalog.add(new Product("CPU Case", res
					.getDrawable(R.drawable.cpucase),
					"Black CPU Case", 8000.00));
			catalog.add(new Product("Hard Drive", res
					.getDrawable(R.drawable.harddrive),
					"WD 500gb Hard Drive", 2000.00));
			catalog.add(new Product("Mouse Pad", res
					.getDrawable(R.drawable.mousepad),
					"Logitech Mouse Pad", 150.00));
			catalog.add(new Product("Memory", res
					.getDrawable(R.drawable.ddr3),
					"4gb DDR3 Memory Stick", 8000.00));
			catalog.add(new Product("Monitor", res
					.getDrawable(R.drawable.ledmonitor),
					"Samsung LED Monitor", 8000.00));
			catalog.add(new Product("Motherboard", res
					.getDrawable(R.drawable.motherboard),
					"Foxconn Motherboard", 2500.00));
			catalog.add(new Product("Power Supply", res
					.getDrawable(R.drawable.powersupply),
					"Power Supply", 600.00));
			catalog.add(new Product("Processor", res
					.getDrawable(R.drawable.amdprocessor),
					"AMD FX-8 Core Processor", 5000.00));
			catalog.add(new Product("Speakers", res
					.getDrawable(R.drawable.genius_speaker),
					"Genius Speakers", 250.00));
			catalog.add(new Product("Video Card", res
					.getDrawable(R.drawable.atividcard),
					"ATI HD 5870 Video Card", 2500.00));
			catalog.add(new Product("External Hard Drive", res
					.getDrawable(R.drawable.wdexternal),
					"WD External Hard Drive", 4000.00));
			
			
		}
		
		return catalog;
	}
	
	public static void setQuantity(Product product, int quantity) {
		// Get the current cart entry
		ShoppingCartEntry curEntry = cartMap.get(product);
		
		// If the quantity is zero or less, remove the products
		if(quantity <= 0) {
			if(curEntry != null)
				removeProduct(product);
			return;
		}
		
		// If a current cart entry doesn't exist, create one
		if(curEntry == null) {
			curEntry = new ShoppingCartEntry(product, quantity);
			cartMap.put(product, curEntry);
			return;
		}
		
		// Update the quantity
		curEntry.setQuantity(quantity);
	}
	
	public static int getProductQuantity(Product product) {
		// Get the current cart entry
		ShoppingCartEntry curEntry = cartMap.get(product);
		
		if(curEntry != null)
			return curEntry.getQuantity();
		
		return 0;
	}
	
	public static void removeProduct(Product product) {
		cartMap.remove(product);
	}
	
	public static List<Product> getCartList() {
		List<Product> cartList = new Vector<Product>(cartMap.keySet().size());
		for(Product p : cartMap.keySet()) {
			cartList.add(p);
		}
		
		return cartList;
	}
	

}
