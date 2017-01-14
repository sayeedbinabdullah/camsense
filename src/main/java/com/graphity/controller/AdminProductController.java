package com.graphity.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import com.google.gson.Gson;
import com.graphity.dao.AdminProductDao;
import com.graphity.dao.TypeDao;
import com.graphity.dao.ProviderDao;
import com.graphity.model.AdminProduct;

@Controller

public class AdminProductController {

	@Autowired
	TypeDao typdao;
	
	@Autowired
	ProviderDao provdao;

	@Autowired
	AdminProductDao aproddao;
	
	@RequestMapping(value="/AdminProducts",method = RequestMethod.GET)
	public ModelAndView showAdminProduct() 
	{
		
		ModelAndView mv = new ModelAndView("AdminProd","AdminProductt",new AdminProduct());
		String typjsonlist=typdao.list();
		
		
		mv.addObject("data",typjsonlist);
		
		String prvjsonlist=provdao.listProvider();
		mv.addObject("data2",prvjsonlist);
		String adprod=aproddao.listAdProd();
		mv.addObject("data3",adprod);
	//int id=adProdDAO.sortId();
		//mv.addObject("adpid",id);
		mv.addObject("check",true);
		return mv;
	}
	@RequestMapping(value="/AdminProducts",method=RequestMethod.POST)
	public ModelAndView addAdminProduct(AdminProduct aprod)
	{
		System.out.println("in addAdminProduct post1");
		System.out.println(aprod.getAproductId());
		System.out.println(aprod.getAprice());
		System.out.println(aprod.getAdesciption());
		System.out.println(aprod.getAprodName());
		aproddao.addProdSave(aprod); 
		System.out.println("in addAdminProduct post2");
		String adprd=aproddao.listAdProd();
		ModelAndView mv = new ModelAndView("AdminProd","AdminProductt",new AdminProduct());
		mv.addObject("data3",adprd);
		String typjsonlist=typdao.list();
		
		mv.addObject("data",typjsonlist);
		System.out.println("in addAdminProduct post3");
		String prvjsonlist=provdao.listProvider();
		System.out.println("in addAdminProduct post4");
		mv.addObject("data2",prvjsonlist);
		mv.addObject("check",true);
		System.out.println("in addAdminProduct post5");
		int id=aproddao.sortId();
		
		System.out.println("in addAdminProduct post6"+id);
		mv.addObject("adpid",id);
		System.out.println("in addAdminProduct post7");
		
		String path="C:\\Users\\sayeed\\workspace\\CamsenseFront\\src\\main\\webapp\\resources\\images\\";
		path=path+String.valueOf(aprod.getAproductId())+".jpg";
		System.out.println("in addAdminProduct post8");
		File f=new File(path);
		System.out.println("in addAdminProduct post9");
		System.out.println("in addAdminProduct post9"+aprod);
		MultipartFile filedet=aprod.getPimage();
		System.out.println("in addAdminProduct post10"+filedet);
		if(!filedet.isEmpty())
		{
			System.out.println("in addAdminProduct post10");
			try
			{
			  byte[] bytes=filedet.getBytes();
			  System.out.println(bytes.length);
			  FileOutputStream fos=new FileOutputStream(f);
              			BufferedOutputStream bs=new BufferedOutputStream(fos);
              			bs.write(bytes);
              			bs.close();
             			 System.out.println("File Uploaded Successfully");
			}
			catch(Exception e)
			{
				System.out.println("Exception Arised"+e);
			}
		}
		else
		{
			System.out.println("File is Empty not Uploaded");
			
		}

		return mv;
		
	}

	
	@RequestMapping(value="/deladprod",method = RequestMethod.GET)
	public ModelAndView delAdProd(@RequestParam("adpid")int adpid) 
	{
		
		aproddao.deleteAdProd(adpid);
		
		String adpjson=aproddao.listAdProd();
			ModelAndView m = new ModelAndView("AdminProd","AdminProductt",new AdminProduct());
		m.addObject("check",true);
		m.addObject("data3",adpjson);
		int id=aproddao.sortId();
		m.addObject("adpid",id);
		String typjsonlist=typdao.list();
		
		m.addObject("data",typjsonlist);
		String prvjsonlist=provdao.listProvider();
		m.addObject("data2",prvjsonlist);
		return m;
	}
	@RequestMapping(value="/UpdateAdmprod",method=RequestMethod.GET)
	public ModelAndView updateProd(@RequestParam("adpid")int pid)
	{
		
		
		AdminProduct ad =aproddao.DispRecord(pid);
		ModelAndView m = new ModelAndView("AdminProd","AdminProductt",ad);
		
		System.out.println("proid"+ad.getAproductId());
		m.addObject("check",false);
		String typjsonlist=typdao.list();
		
		
		m.addObject("data",typjsonlist);
		String prvjsonlist=provdao.listProvider();
		m.addObject("data2",prvjsonlist);
		String apdjsonlist=aproddao.listAdProd();
		m.addObject("data3",apdjsonlist);
		System.out.println(prvjsonlist);
		return m;
		
	}

	@RequestMapping(value="/UpdateAdmprod",method=RequestMethod.POST)
	public ModelAndView updateProd(AdminProduct ap)
	{

		aproddao.upAdProd(ap);
		String apdjsonlist=aproddao.listAdProd();
		ModelAndView m = new ModelAndView("AdminProd","AdminProductt",new AdminProduct());
		m.addObject("check",true);
		m.addObject("data3",apdjsonlist);
		String typjsonlist=typdao.list();
		
		
		
		m.addObject("data",typjsonlist);
		String prvjsonlist=provdao.listProvider();
		m.addObject("data2",prvjsonlist);
	
		int id=aproddao.sortId();
		m.addObject("adpid",id);
		return m;
		
	}


	

}
