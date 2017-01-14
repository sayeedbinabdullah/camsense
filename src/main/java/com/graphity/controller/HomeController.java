package com.graphity.controller;

import javax.servlet.http.HttpSession;

import org.hibernate.boot.spi.AdditionalJaxbMappingProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.graphity.dao.AdminProductDao;
import com.graphity.dao.AdminProductDaoImpl;

import com.graphity.dao.CartDao;
import com.graphity.dao.TypeDao;
import com.graphity.dao.MemberDao;
import com.graphity.model.AdminProduct;
import com.graphity.model.MemberDetail;
import java.util.*;

@Controller
public class HomeController 
{
	
	@Autowired
	MemberDao memdao;

	@RequestMapping("/")
	public ModelAndView Home()
	{
		return new ModelAndView("Landingpage");
	}
	
	
	@RequestMapping("/reg")
	public ModelAndView SignUp()
	{
		MemberDetail memberDetail=new MemberDetail();
		return new ModelAndView("Signup","MemberDetails",memberDetail);
	}
	
	@RequestMapping("/register")
	public ModelAndView Reg(@ModelAttribute("MemberDetails") MemberDetail mem , BindingResult result)
	{
		System.out.println("i am in reg controller");
		if(result.hasErrors())
		{
		return new ModelAndView("Signup");
		}
		
		memdao.saveorupdate(mem);
		return new ModelAndView("Signup");
	}
	
	@RequestMapping("contactme")
	public ModelAndView Contact()
	{
		return new ModelAndView("ContactUs");
	}
	
	@RequestMapping("/Admin")
	public ModelAndView AdminPage()
	{
		return new ModelAndView("AdminHome");
	}
	
	@Autowired
	TypeDao typdao;
	
	@Autowired
	AdminProductDao apdao;
	
	@RequestMapping("/memberproducts")
	public String ShowProduct(Model m)
	{
		String prod = apdao.listAdProd();
		m.addAttribute("pdata",prod);
		System.out.println("Memberproductdetails");
		return "MemberProdPage";
	}
	
	@RequestMapping(value="/Pdetails", method=RequestMethod.GET)
	public ModelAndView PDetailsPage()
	{
	
		return new ModelAndView("ProdDetailsPage");
	}
	
	@Autowired
	CartDao cartdao;
	
	@RequestMapping(value = "/ProdDetailsPage",method = RequestMethod.GET)
	public String Single(@RequestParam("adpid") int pid, HttpSession session,Model m)
	   {
		List <AdminProduct>list = cartdao.getParticularProd(pid);
		AdminProduct c=list.get(0);
		System.out.println(c.getAproductId());
		 System.out.println(c.getAprodName());
			m.addAttribute("data3",list);

			  System.out.println("ProductDetailsPage");
			  return "ProdDetailsPage";
	   }
}
