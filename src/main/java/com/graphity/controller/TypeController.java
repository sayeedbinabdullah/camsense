package com.graphity.controller;

import org.springframework.stereotype.Controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.graphity.dao.TypeDao;
import com.graphity.model.Type;

@Controller

public class TypeController {
	
	@Autowired	
	TypeDao typeDao;


	@RequestMapping(value="/typegson")
	@ResponseBody
	public String CategoryGson()
	{
		String  list=typeDao.list();
		
		return list;
	}


	@RequestMapping(value = { "type"})
	public ModelAndView TypePage(Model model) 
	{
		model.addAttribute("type", new Type());
		model.addAttribute("typeList", typeDao.list());
		model.addAttribute("TypePageClicked", "true");
		
		String list=typeDao.list();
	 
		return new ModelAndView("Admintyp","data",list);
	}

	@RequestMapping(value = { "addtype", "edittype/addtype" }, method = RequestMethod.POST)
	public String addType(@ModelAttribute("type") Type type) {
		typeDao.saveOrUpdate(type);
		return "redirect:/type";
	}
	@RequestMapping("edittype/{id}")
	public String editCategory(@PathVariable("id") String id, Model model) {
		System.out.println("editType");
		model.addAttribute("type", this.typeDao.get(id));
		model.addAttribute("typeList", typeDao.list());
		model.addAttribute("TypePageClicked", "true");
		model.addAttribute("EditType", "true");
		return "redirect:/type";
	}
	@RequestMapping(value = { "removetype/{id}", "edittype/removetype/{id}" })
	public String removeCategory(@PathVariable("id") String id, Model model) throws Exception {
		typeDao.delete(id);
		model.addAttribute("message", "Successfully Deleted");
		return "redirect:/type";
	}


}
