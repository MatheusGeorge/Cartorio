package br.com.cartorio.controller;

import br.com.cartorio.dao.CartorioDAO;
import br.com.cartorio.model.Cartorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;

@Controller
@RequestMapping("/cartorio")
public class CartorioController {

    @Autowired
    private CartorioDAO cartorioDAO;

    @RequestMapping("/form")
    public ModelAndView form(){
        return new ModelAndView("cartorios/form");
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView gravar(@ModelAttribute("cartorio") Cartorio cartorio, RedirectAttributes redirectAttributes){
        cartorioDAO.salvar(cartorio);
        redirectAttributes.addFlashAttribute("sucesso", "Cartorio cadastrado com sucesso");
        return new ModelAndView("redirect:cartorio");
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView listar() {
        ModelAndView modelAndView = new ModelAndView("cartorios/lista");
        modelAndView.addObject("cartorios", new ArrayList<>(cartorioDAO.encontrarTodos()));

        return modelAndView;
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public ModelAndView deletar(@ModelAttribute ("cartorio") Cartorio cartorio){
        cartorioDAO.deletar(((long) cartorio.getId()));
        return new ModelAndView("redirect:cartorio");
    }

}
