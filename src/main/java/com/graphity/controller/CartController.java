package com.graphity.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.graphity.dao.AdminProductDao;
import com.graphity.dao.CartDao;
import com.graphity.model.AdminProduct;
import com.graphity.model.Cart;

@Controller
public class CartController
{
	int countup=0;
	int totprice=0;
	int i=1;
	
	@Autowired
	AdminProductDao aprod;

	@Autowired
	CartDao cartdao;
	
	@RequestMapping(value = "/AddToCart", method = RequestMethod.GET)
	public String AddToCart(@RequestParam("adpid") int pid,@RequestParam("d") int quant, HttpSession session,Model m) {

		AdminProduct ad = aprod.DispRecord(pid);
		Cart c = new Cart();
	
		countup++;
		session.setAttribute("cartcnt",countup);
		
		c.setPid(""+ad.getAproductId());
		c.setCartuser(session.getId().substring(25));
		c.setItemname(ad.getAprodName());
		c.setPrice(ad.getAprice());
		c.setTotal(quant*ad.getAprice());
		c.setQty(quant);
		totprice=totprice+quant*ad.getAprice();
		session.setAttribute("cartTot",totprice);
		cartdao.insertCart(c);
		
		List<Cart> mycartitem=cartdao.get(session.getId().substring(25));
		if(mycartitem!=null)
		{
		
		m.addAttribute("CartList",mycartitem);
		
		System.out.println("proid" + ad.getAproductId());
		}
		return "ShowCart";

	}
	
	
	@RequestMapping(value = "/ShowCart",method = RequestMethod.GET)
	   public String cartLogo( HttpSession session,Model m)
	   {
		
		List<Cart> mycartitem=cartdao.get(session.getId().substring(25));
		if(mycartitem!=null)
		{
		
		m.addAttribute("CartList",mycartitem);
		
		}

		return "ShowCart";
	   }

}
