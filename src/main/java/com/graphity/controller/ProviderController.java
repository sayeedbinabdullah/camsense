package com.graphity.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.graphity.dao.ProviderDao;
import com.graphity.model.Provider;


@Controller
public class ProviderController {

	@Autowired
	ProviderDao prvDao;
	
	@RequestMapping(value="/ProviderView" , method=RequestMethod.GET )
	public ModelAndView ViewProvider()
	{
		
		String prvjsonlist=prvDao.listProvider();
		ModelAndView mv = new ModelAndView("AdminProvid","Provider",new Provider());
		
		mv.addObject("data",prvjsonlist);
		mv.addObject("check", true);
		
		return mv;
		
	}
	
	@RequestMapping(value="/ProviderView" , method=RequestMethod.POST )
	public ModelAndView insertProvider(Provider prv)
	{
		prvDao.saveProvider(prv);
		String prvjsonlist=prvDao.listProvider();
		ModelAndView mv = new ModelAndView("AdminProvid","Provider",new Provider());
		mv.addObject("data",prvjsonlist);
		mv.addObject("check",true);
		
		return mv;
	
	}
	
	@RequestMapping(value="/delprovider",method = RequestMethod.GET)
	public ModelAndView deleteProvider(@RequestParam("provId")int pid)
	{
		prvDao.deleteProvider(pid);
		String prvjsonlist=prvDao.listProvider();
		ModelAndView m = new ModelAndView("AdminProvid","Provider",new Provider());
		m.addObject("check",true);
		m.addObject("data",prvjsonlist);
	
		return m;
		
	}
	

	@RequestMapping(value="/UpdateProvider",method=RequestMethod.GET)
	public ModelAndView updateProvider(@RequestParam("provId")int pid)
	{
		Provider prv =prvDao.DispRecord(pid);
		ModelAndView m = new ModelAndView("AdminProvid","Provider",prv);
		m.addObject("check",false);
		return m;
	
		
	}
	@RequestMapping(value="/UpdateProvider",method=RequestMethod.POST)
	public ModelAndView updateprov(Provider p)
	{

		prvDao.UpRecord(p);
		String prvjsonlist=prvDao.listProvider();
		ModelAndView m = new ModelAndView("AdminProvid","Provider",new Provider());
		m.addObject("check",true);
		m.addObject("data",prvjsonlist);
	
		return m;
		
	}
	
}
